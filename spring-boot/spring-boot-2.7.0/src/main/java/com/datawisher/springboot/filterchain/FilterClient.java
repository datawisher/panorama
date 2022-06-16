package com.datawisher.springboot.filterchain;

import javax.servlet.ServletException;
import java.io.IOException;

/**
 * @author h407644
 * @date 2022-06-16
 */
public class FilterClient {

    public static void main(String[] args) throws ServletException, IOException {
        //准备过滤器链
        ApplicationFilterChain filterChain = new ApplicationFilterChain();
        //设置目标servlet
        filterChain.setServlet(new MyServlet());
        //设置过滤器集合
        filterChain.addFilter(new FilterA());
        filterChain.addFilter(new FilterB());
        filterChain.addFilter(new FilterC());
        filterChain.addFilter(new FilterResponseTime());
        //过滤请求
        System.out.println("-----request 开始----");
        filterChain.doFilter(null, null);
    }
}
