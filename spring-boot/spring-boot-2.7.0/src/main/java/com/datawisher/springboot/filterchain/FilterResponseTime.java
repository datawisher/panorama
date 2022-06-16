package com.datawisher.springboot.filterchain;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author h407644
 * @date 2022-06-16
 */
public class FilterResponseTime implements Filter {
    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        Filter.super.init(filterConfig);
    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain) throws IOException, ServletException {
        long start = System.currentTimeMillis();
        try {
            chain.doFilter(request, response);
        } finally {
            long timeCost = System.currentTimeMillis() - start;
            System.out.println("耗时" + timeCost + "ms");
        }
    }

    @Override
    public void destroy() {
        Filter.super.destroy();
    }

}
