package com.datawisher.springboot.filterchain;

import javax.servlet.*;
import java.io.IOException;

/**
 * @author h407644
 * @date 2022-06-16
 */
public class ApplicationFilterChain implements FilterChain {

    /**
     * 过滤器数组
     */
    private Filter[] filters = new Filter[0];

    /**
     * 过滤器下标
     */
    private int pos = 0;

    /**
     * 过滤器数量
     */
    private int n = 0;

    /**
     * 过滤器数组扩容数量
     */
    public static final int INCREMENT = 10;

    /**
     * 目标servlet，过滤器链执行完毕后直接调
     */
    private Servlet servlet = null;


    @Override
    public void doFilter(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        internalDoFilter(request, response);
    }

    private void internalDoFilter(ServletRequest request, ServletResponse response)
            throws IOException, ServletException {
        if (pos < n) {
            Filter filter = filters[pos++];
            try {
                filter.doFilter(request, response, this);
            } catch (IOException | ServletException | RuntimeException e) {
                throw e;
            } catch (Throwable e) {
                throw new ServletException("filterChain.filter", e);
            }
            return;
        }

        try {
            //出了 过滤器链，向下调用servlet实例方法
            servlet.service(request, response);
        } catch (IOException | ServletException | RuntimeException e) {
            throw e;
        } catch (Throwable e) {
            throw new ServletException("filterChain.servlet", e);
        } finally {

        }
    }

    void addFilter(Filter filterAdd) {

        for (Filter filter : filters) {
            if (filter == filterAdd) {
                return;
            }
        }

        if (n == filters.length) {
            Filter[] newFilters =
                    new Filter[n + INCREMENT];
            System.arraycopy(filters, 0, newFilters, 0, n);
            filters = newFilters;
        }
        filters[n++] = filterAdd;

    }

    public void setServlet(Servlet servlet) {
        this.servlet = servlet;
    }
}
