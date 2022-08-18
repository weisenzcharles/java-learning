package org.charles.springcloud.zuul.filter;

//public class ErrorFilter extends ZuulFilter {
//
//    private static final Logger logger = LoggerFactory.getLogger(ErrorFilter.class);
//
//    @Override
//    public String filterType() {
//        return "error";
//    }
//
//    @Override
//    public int filterOrder() {
//        return 1;
//    }
//
//    @Override
//    public boolean shouldFilter() {
//        return true;
//    }
//
//    @Override
//    public Object run() {
//        try {
//            RequestContext context = RequestContext.getCurrentContext();
//            ZuulException exception = (ZuulException)context.getThrowable();
//
//            logger.error("进入系统异常拦截：", exception);
//
//            HttpServletResponse response = context.getResponse();
//            response.setContentType("application/json; charset=utf8");
//            response.setStatus(exception.nStatusCode);
//
//            PrintWriter writer = null;
//            try {
//                writer = response.getWriter();
//                writer.print("{ code : "+ exception.nStatusCode +", message:\""+ exception.getMessage() +"\"}");
//            } catch (IOException e) {
//                e.printStackTrace();
//            } finally {
//                if(writer!=null){
//                    writer.close();
//                }
//            }
//        } catch (Exception e) {
//            ReflectionUtils.rethrowRuntimeException(e);
//        }
//        return null;
//    }
//}
