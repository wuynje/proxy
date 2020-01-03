package com.wuynje.jdk;

import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationHandler;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Proxy;

/**
 * @author wuyjn
 * @date 2020-1-3 10:56
 * @description
 */
public class HellTest {
    public static void main(String[] args) throws NoSuchMethodException, IllegalAccessException, InvocationTargetException, InstantiationException {


        //1、生成$proxy0的class文件
        System.getProperties().put("sun.misc.ProxyGenerator.saveGeneratedFiles", "true");
        //2、获取动态代理类
        Class proxyClazz = Proxy.getProxyClass(HelloImpl.class.getClassLoader(),HelloImpl.class.getInterfaces());
        //3、获取代理类的构造函数，并传入参数类型InvocationHandler.class(传入参数类型可使该类实例对象的时候必须传入一个继承自该接口的对象)
        Constructor constructor = proxyClazz.getConstructor(InvocationHandler.class);
        //4、构造代理对象
        IHello hello1 = (IHello) constructor.newInstance(new HelloProxy(new HelloImpl()));
        hello1.sayHello("world。。。。。");

        /**
         * 可以直接用Proxy.newProxyInstance代替上述代码也是一样的
         */
        IHello hello2 = (IHello) Proxy.newProxyInstance(HelloImpl.class.getClassLoader(), HelloImpl.class.getInterfaces(),new HelloProxy(new HelloImpl()));
        hello2.sayHello("world2。。。");

    }
}
