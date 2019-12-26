package org.student.filter;


import javax.servlet.*;
import java.io.IOException;

/**
 * 要想将一个普通的class，变成一个具有特定功能的类（拦截、过滤...），继承、实现接口、注解
 */
public class MyFilter implements Filter {


    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        System.out.println("filter init....");
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        System.out.println("拦截请求...");
//        filterChain.doFilter(servletRequest,servletResponse);//放行
        System.out.println("拦截相应...");
    }

    @Override
    public void destroy() {
        System.out.println("filter destroy...");
    }
}
