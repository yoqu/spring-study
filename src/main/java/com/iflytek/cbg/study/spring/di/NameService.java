package com.iflytek.cbg.study.spring.di;

import com.iflytek.cbg.study.spring.ioc.HelloService;

/**
 * Created by yoqu on 2017/12/4.
 */
public class NameService {

    private HelloService helloService;

    public void setHelloService(HelloService helloService) {
        this.helloService = helloService;
    }

    public void sayHello(String name) {
        System.out.print(name + " : ");
        helloService.sayHello();
    }

}
