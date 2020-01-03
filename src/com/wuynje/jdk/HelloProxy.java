package com.wuynje.jdk;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;

/**
 * @author wuyjn
 * @date 2020-1-3 10:17
 * @description
 */
public class HelloProxy implements InvocationHandler {
    private Object targetObj;//目标对象，被代理对象

    public HelloProxy(Object targetObj) {
        this.targetObj = targetObj;
    }

    //代理操作
    @Override
    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
        //增强
        System.out.println("我要说话了。。。");
        Object res = method.invoke(targetObj,args);
        System.out.println("我说完了。。。");
        return res;
    }



}
