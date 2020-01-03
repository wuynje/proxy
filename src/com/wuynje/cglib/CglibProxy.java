package com.wuynje.cglib;

import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * @author wuyjn
 * @date 2020-1-3 15:17
 * @description
 */
public class CglibProxy implements MethodInterceptor {

    private Object targetObject;

    public Object createCglibProxy(Object obj){
        this.targetObject = obj;
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(obj.getClass());
        enhancer.setCallback(this);
        return enhancer.create();
    }

    @Override
    public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
        System.out.println("开始。。。");
        Object res = methodProxy.invoke(targetObject,objects);
        System.out.println("结束。。。");
        return res;
    }
}
