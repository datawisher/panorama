package com.datawisher.bee.gateway.service;

import com.alibaba.cloud.nacos.NacosConfigManager;
import com.alibaba.fastjson.JSON;
import com.alibaba.nacos.api.config.listener.Listener;
import com.google.common.collect.Lists;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.gateway.event.RefreshRoutesEvent;
import org.springframework.cloud.gateway.route.RouteDefinition;
import org.springframework.cloud.gateway.route.RouteDefinitionWriter;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.context.ApplicationEventPublisherAware;
import org.springframework.stereotype.Component;
import reactor.core.publisher.Mono;

import javax.annotation.PostConstruct;
import java.util.List;
import java.util.concurrent.Executor;

import static com.alibaba.nacos.api.common.Constants.DEFAULT_GROUP;

/**
 * @author h407644
 * @date 2022-12-09
 */
@Component
@Slf4j
public class NacosDynamicRouteService implements ApplicationEventPublisherAware {

    @Autowired
    private RouteDefinitionWriter routeDefinitionWriter;

    @Autowired
    private NacosConfigManager nacosConfigManager;

    private ApplicationEventPublisher applicationEventPublisher;

    public static final String ROUTE_DATA_ID = "dynamic-route.json";

    /** 路由id */
    private static List<String> routeIds = Lists.newArrayList();

    @Override
    public void setApplicationEventPublisher(ApplicationEventPublisher applicationEventPublisher) {
        this.applicationEventPublisher = applicationEventPublisher;
    }

    @PostConstruct
    public void init() throws Exception {
        // nacos配置监听器
        nacosConfigManager.getConfigService().addListener(ROUTE_DATA_ID, DEFAULT_GROUP, new Listener() {
            @Override
            public Executor getExecutor() {
                return null;
            }

            @Override
            public void receiveConfigInfo(String configInfo) {
                log.info("已经正确接收更新后的路由配置: {}", configInfo);
                routeConfigInfo(configInfo);
            }
        });

        // 启动获取路由配置并启用
        String config = nacosConfigManager.getConfigService().getConfig(ROUTE_DATA_ID, DEFAULT_GROUP, 30000);
        this.routeConfigInfo(config);

    }

    /**
     * 监听nacos路由配置，动态改变路由
     * @param configInfo
     */
    private void routeConfigInfo(String configInfo) {
        clearRoute();
        try {
            List<RouteDefinition> gatewayRouteDefinitions = JSON.parseArray(configInfo, RouteDefinition.class);
            for (RouteDefinition routeDefinition : gatewayRouteDefinitions) {
                addRoute(routeDefinition);
            }
            publish();
            log.info("Dynamic Routing Publish Success");
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 清空路由
     */
    private void clearRoute() {
        for (String id : routeIds) {
            routeDefinitionWriter.delete(Mono.just(id)).subscribe();
        }
        routeIds.clear();
    }

    /**
     * 添加路由
     * @param definition
     */
    private void addRoute(RouteDefinition definition) {
        try {
            routeDefinitionWriter.save(Mono.just(definition)).subscribe();
            routeIds.add(definition.getId());
        } catch (Exception e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * 发布路由，使路由生效
     */
    private void publish() {
        this.applicationEventPublisher.publishEvent(new RefreshRoutesEvent(this.routeDefinitionWriter));
    }
}
