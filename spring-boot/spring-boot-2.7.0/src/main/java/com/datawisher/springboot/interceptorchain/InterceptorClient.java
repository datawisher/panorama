package com.datawisher.springboot.interceptorchain;

/**
 * @author h407644
 * @date 2022-06-19
 */
public class InterceptorClient {

    public static void main(String[] args) {
        HttpServletRequest httpServletRequest = new HttpServletRequest();
        HttpServletResponse httpServletResponse = new HttpServletResponse();

        DispatcherServlet dispatcherServlet = new DispatcherServlet();
        //拦截验证成功的例子
        try {
            httpServletRequest.setName("大黄鸭");
            dispatcherServlet.doDispatch(httpServletRequest,httpServletResponse);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("--------------------------------------------");

        //拦截验证失败的例子
        try {
            httpServletRequest.setName("小鸡崽");
            dispatcherServlet.doDispatch(httpServletRequest,httpServletResponse);

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
