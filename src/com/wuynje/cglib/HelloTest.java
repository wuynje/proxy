package com.wuynje.cglib;

import com.wuynje.jdk.HelloImpl;
import com.wuynje.jdk.IHello;

/**
 * @author wuyjn
 * @date 2020-1-3 15:42
 * @description
 */
public class HelloTest {

    public static void main(String[] args) {
        IHello hello2 = (IHello) new CglibProxy().createCglibProxy(new HelloImpl());
        hello2.sayHello("cglib。。。");
    }

}
