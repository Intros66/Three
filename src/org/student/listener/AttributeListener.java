package org.student.listener;

import javax.servlet.ServletContextAttributeEvent;
import javax.servlet.ServletContextAttributeListener;
import javax.servlet.ServletRequestAttributeEvent;
import javax.servlet.ServletRequestAttributeListener;
import javax.servlet.http.HttpSessionAttributeListener;
import javax.servlet.http.HttpSessionBindingEvent;

public class AttributeListener implements ServletContextAttributeListener, HttpSessionAttributeListener, ServletRequestAttributeListener {
    @Override
    public void attributeAdded(ServletContextAttributeEvent servletContextAttributeEvent) {
        String attrName = servletContextAttributeEvent.getName();
        Object attrValue = servletContextAttributeEvent.getServletContext().getAttribute(attrName);
        System.out.println("servletContext【增加】属性: 属性名："+attrName+"属性值："+attrValue);
    }

    @Override
    public void attributeRemoved(ServletContextAttributeEvent servletContextAttributeEvent) {
        System.out.println("servletContext【移除】属性"+servletContextAttributeEvent.getName());

    }

    @Override
    public void attributeReplaced(ServletContextAttributeEvent servletContextAttributeEvent) {
        String attrName = servletContextAttributeEvent.getName();
        Object attrValue = servletContextAttributeEvent.getServletContext().getAttribute(attrName);
        System.out.println("servletContext【替换】属性 属性名："+attrName+"属性值："+attrValue);

    }

    @Override
    public void attributeAdded(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String attrName = servletRequestAttributeEvent.getName();
        Object attrValue = servletRequestAttributeEvent.getServletContext().getAttribute(attrName);
        System.out.println("servletRequest【增加】属性: 属性名："+attrName+"属性值："+attrValue);

    }

    @Override
    public void attributeRemoved(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        System.out.println("servletRequest【移除】属性"+servletRequestAttributeEvent);

    }

    @Override
    public void attributeReplaced(ServletRequestAttributeEvent servletRequestAttributeEvent) {
        String attrName = servletRequestAttributeEvent.getName();
        Object attrValue = servletRequestAttributeEvent.getServletContext().getAttribute(attrName);
        System.out.println("servletRequestAttributeEvent【替换】属性 属性名："+attrName+"属性值："+attrValue);


    }

    @Override
    public void attributeAdded(HttpSessionBindingEvent httpSessionBindingEvent) {
        String attrName = httpSessionBindingEvent.getName();
        Object attrValue = httpSessionBindingEvent.getSession().getAttribute(attrName);
        System.out.println("httpSessionBindingEvent【增加】属性: 属性名："+attrName+"属性值："+attrValue);


    }

    @Override
    public void attributeRemoved(HttpSessionBindingEvent httpSessionBindingEvent) {
        String attrName = httpSessionBindingEvent.getName();
        Object attrValue = httpSessionBindingEvent.getSession().getAttribute(attrName);
        System.out.println("httpSession【替换】属性: 属性名："+attrName+"属性值："+attrValue);

    }

    @Override
    public void attributeReplaced(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("HttpSession【移除】属性"+httpSessionBindingEvent.getName());

    }
}
