package com.datawisher.springboot.interceptorchain;


/**
 * @author h407644
 * @date 2022-06-18
 */
public class MyInterceptor2 implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        if ("大黄鸭".equals(request.getName())) {
            System.out.println("preHandle登录鉴权成功："+request.getName());
            return true;
        }else{
            System.out.println("preHandle登录鉴权失败："+request.getName());
            return false;
        }

    }

    @Override
    public void postHandle(HttpServletRequest request, HttpServletResponse response, Object handler, ModelAndView modelAndView) throws Exception {
        System.out.println("postHandle登录鉴权后置处理");
    }

    @Override
    public void afterCompletion(HttpServletRequest request, HttpServletResponse response, Object handler, Exception ex) throws Exception {
        System.out.println("afterCompletion登录鉴权结束后处理");
    }
}
