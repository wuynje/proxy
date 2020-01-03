package com.wuynje.jdk;

/**
 * @author wuyjn
 * @date 2020-1-3 10:13
 * @description
 */
public class HelloImpl implements IHello {
    @Override
    public void sayHello(String words) {
        System.out.println("hello "+words);
    }
}
