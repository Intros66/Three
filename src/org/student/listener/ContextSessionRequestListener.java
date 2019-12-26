package org.student.listener;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;
import javax.servlet.ServletRequestEvent;
import javax.servlet.ServletRequestListener;
import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class ContextSessionRequestListener implements ServletContextListener, ServletRequestListener, HttpSessionListener {

    //appplication(ServletContext)
    @Override
    public void contextInitialized(ServletContextEvent servletContextEvent) {
        System.out.println("监听ServletContext,创建ServletContext对象.."+servletContextEvent);
    }

    @Override
    public void contextDestroyed(ServletContextEvent servletContextEvent) {
        System.out.println("监听ServletContext，销毁ServletContext对象"+servletContextEvent);
    }

    //request
    @Override
    public void requestDestroyed(ServletRequestEvent servletRequestEvent) {
        System.out.println("监听request,销毁request对象.."+servletRequestEvent);

    }

    @Override
    public void requestInitialized(ServletRequestEvent servletRequestEvent) {
        System.out.println("监听request,创建request对象.."+servletRequestEvent);

    }


    //session
    @Override
    public void sessionCreated(HttpSessionEvent httpSessionEvent) {
        System.out.println("监听session,创建session对象.."+httpSessionEvent);
    }

    @Override
    public void sessionDestroyed(HttpSessionEvent httpSessionEvent) {
        System.out.println("监听session,销毁session对象.."+httpSessionEvent);

    }
}
