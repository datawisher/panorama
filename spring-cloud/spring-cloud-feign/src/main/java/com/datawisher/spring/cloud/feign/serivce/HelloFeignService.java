package com.datawisher.spring.cloud.feign.serivce;

import com.datawisher.spring.cloud.feign.config.HelloFeignServiceConfig;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 *  path: 定义当前FeignClient的统一前缀
 *  url: 一般用于调试，可以手动指定@FeignClient调用的地址
 *  decode404: true会调用decoder进行解码，否则抛出FeignException
 */
@FeignClient(name = "github-client", url = "https://api.github.com", configuration = HelloFeignServiceConfig.class, decode404 = true)
public interface HelloFeignService {

    /**
     * content: {"message":"Validation Failed","errors":[{"resource":"Search","field":"q","code":"missing"}],
     * "documentation_url":"https://developer.github.com/v3/search"}
     *
     * @param queryStr
     * @return
     */
    @RequestMapping(value = "/search/repositories", method = RequestMethod.GET)
    String searchRepo(@RequestParam("q") String queryStr);
}
