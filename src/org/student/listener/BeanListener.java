package org.student.listener;

import javax.servlet.http.HttpSessionBindingEvent;
import javax.servlet.http.HttpSessionBindingListener;

public class BeanListener implements HttpSessionBindingListener {
    @Override
    public void valueBound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("绑定：Bean对象（将Bean对象增加到session域），绑定的对象："+this+", sessionId："+httpSessionBindingEvent.getSession().getId());
    }

    @Override
    public void valueUnbound(HttpSessionBindingEvent httpSessionBindingEvent) {
        System.out.println("解绑：Bean对象（将Bean对象从session域中移除），解绑的对象："+this+"， sessionId："+httpSessionBindingEvent.getSession().getId());
    }
}
