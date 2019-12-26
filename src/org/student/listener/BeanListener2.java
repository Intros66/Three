package org.student.listener;

import javax.servlet.http.HttpSessionActivationListener;
import javax.servlet.http.HttpSessionEvent;
import java.io.Serializable;

//监听session对象的钝化和活化
public class BeanListener2 implements HttpSessionActivationListener, Serializable {

    //准备 被钝化、活化的数据
    private int num;
    private String user;

    public int getNum() {
        return num;
    }

    public void setNum(int num) {
        this.num = num;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    //监听时刻：即将钝化之前
    @Override
    public void sessionWillPassivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("即将钝化之前：BeanListener2对象将会随着session的钝化而钝化");

    }
    //监听时刻：刚刚进行了活化之后
    @Override
    public void sessionDidActivate(HttpSessionEvent httpSessionEvent) {
        System.out.println("活化之后：BeanListener2对象将会随着session的活化而活化");
    }
}
