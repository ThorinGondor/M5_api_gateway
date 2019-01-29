package com.zuul_demo.api_gateway.zuul_filter;

import com.netflix.zuul.ZuulFilter;
import com.netflix.zuul.context.RequestContext;
import com.netflix.zuul.exception.ZuulException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.servlet.http.HttpServletRequest;

public class AccessFIlter extends ZuulFilter {

    private static Logger log = LoggerFactory.getLogger(AccessFIlter.class);

    @Override
    public String filterType(){
        return "pre"; //pre代表zuul过滤器会在路由之前执行
    }

    @Override
    public int filterOrder(){
        return 0; //决定了多个过滤器时的执行顺序
    }

    @Override
    public boolean shouldFilter() {
        return true;  //开启zuul filter
    }

    @Override
    public Object run() throws ZuulException {
        RequestContext ctx = RequestContext.getCurrentContext();
        HttpServletRequest request = ctx.getRequest();

        Object accessToken = request.getParameter("accessToken");
        if(!accessToken.equals("flyme")){
            log.warn("Param Access Token is Right!");
            ctx.setSendZuulResponse(false);
            ctx.setResponseStatusCode(505);
            return null;
        }
        log.info("Param Access Token Exist!");
        return null;
    }
}
