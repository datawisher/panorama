package com.datawisher.springboot.filterchain;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author h407644
 * @date 2022-06-16
 */
public class FilterB implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        System.err.println("doFilter B");
        chain.doFilter(request, response);
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
