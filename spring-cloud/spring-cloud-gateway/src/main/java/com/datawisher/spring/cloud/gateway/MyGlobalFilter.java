package com.datawisher.spring.cloud.gateway;

import java.nio.charset.StandardCharsets;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.gateway.filter.GatewayFilterChain;
import org.springframework.cloud.gateway.filter.GlobalFilter;
import org.springframework.core.Ordered;
import org.springframework.core.io.buffer.DataBuffer;
import org.springframework.core.io.buffer.DataBufferUtils;
import org.springframework.http.server.RequestPath;
import org.springframework.stereotype.Component;
import org.springframework.web.server.ServerWebExchange;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

/**
 * @author h407644
 * @date 2021-04-23
 */
@Component
@Slf4j
public class MyGlobalFilter implements GlobalFilter, Ordered {

    @Override
    public Mono<Void> filter(ServerWebExchange exchange, GatewayFilterChain chain) {
        RequestPath path = exchange.getRequest().getPath();
        Flux<DataBuffer> body = exchange.getRequest().getBody();
        Mono<String> stringMono = DataBufferUtils.join(body).map(buffer -> {
            byte[] result = new byte[buffer.readableByteCount()];
            buffer.read(result);
            DataBufferUtils.release(buffer);
            return new String(result, StandardCharsets.UTF_8);
        });
        return stringMono.doOnNext(p -> System.out.println("p = " + p.replaceAll("\\s*|\t|\r|\n", "" ))).then();
    }

    @Override
    public int getOrder() {
        return -1;
    }
}
