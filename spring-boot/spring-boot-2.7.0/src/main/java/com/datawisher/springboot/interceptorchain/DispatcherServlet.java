package com.datawisher.springboot.interceptorchain;


/**
 * @author h407644
 * @date 2022-06-18
 */
public class DispatcherServlet {

    public void doDispatch(HttpServletRequest request, HttpServletResponse response) throws Exception {

        HandlerExecutionChain handlerExecutionChain = getHandlerExecutionChain();

        //应用前置处理器
        if (!handlerExecutionChain.applyPreHandle(request, response)) {
            return;
        }

        //处理业务
        String helloResponse = handlerExecutionChain.getHandler().hello(request.getName());

        //应用后置处理器
        handlerExecutionChain.applyPostHandle(request, response, null);

        System.out.println("响应到前端:'"+helloResponse+"'");

        handlerExecutionChain.triggerAfterCompletion(request,response,null);

    }

    private HandlerExecutionChain getHandlerExecutionChain() {
        HandlerExecutionChain handlerExecutionChain = new HandlerExecutionChain();
        handlerExecutionChain.setHandler(new MyController());
        handlerExecutionChain.addInterceptor(new MyInterceptor1());
        handlerExecutionChain.addInterceptor(new MyInterceptor2());
        handlerExecutionChain.addInterceptor(new MyInterceptor3());
        return handlerExecutionChain;
    }
}
