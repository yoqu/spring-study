package com.iflytek.cbg.study.spring.ioc;

/**
 * Created by yoqu on 2017/12/4.
 */
public class HelloService implements IHelloService {

    @Override
    public void sayHello() {
        System.out.println("Hello Service");
    }
}
