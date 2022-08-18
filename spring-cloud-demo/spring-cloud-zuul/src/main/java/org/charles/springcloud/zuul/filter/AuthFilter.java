package org.charles.springcloud.zuul.filter;


//@Component
//public class AuthFilter extends ZuulFilter {
//
//    @Override
//    public String filterType() {
//        return "pre";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 0;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() {
//        RequestContext ctx = RequestContext.getCurrentContext();
//
//        // 构造了一个运行时异常
////        int a = 10 / 0;
//
////        HttpServletRequest request = ctx.getRequest();
////        String token = request.getParameter("token");
////        if (token == null) {
////            ctx.setSendZuulResponse(false);
////            ctx.setResponseStatusCode(401);
////            ctx.addZuulResponseHeader("content-type","text/html;charset=utf-8");
////            ctx.setResponseBody("非法访问");
////        }
//        return null;
//    }
//}