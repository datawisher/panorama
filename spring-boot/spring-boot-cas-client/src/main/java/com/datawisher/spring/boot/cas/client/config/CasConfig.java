package com.datawisher.spring.boot.cas.client.config;

import net.unicon.cas.client.configuration.CasClientConfigurerAdapter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Configuration;

/**
 * @author h407644
 * @date 2021-05-25
 */
@Configuration
public class CasConfig extends CasClientConfigurerAdapter {

    @Override
    public void configureValidationFilter(FilterRegistrationBean validationFilter) {
        validationFilter.getInitParameters().put("useSession","false");
    }
}
