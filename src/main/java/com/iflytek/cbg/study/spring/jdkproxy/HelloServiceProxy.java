package com.iflytek.cbg.study.spring.jdkproxy;

import com.iflytek.cbg.study.spring.ioc.HelloService;
import com.iflytek.cbg.study.spring.ioc.IHelloService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

/**
 * Created by yoqu on 2017/12/7.
 * 只能对实现了接口的类进行，没有实现接口的类不能使用JDK动态代理。
 */
public class HelloServiceProxy {

    public static void main(String[] args) {
        HelloServiceProxy proxy = new HelloServiceProxy();
        proxy.sayHello();
    }

    public void sayHello() {
        getHelloService().sayHello();
    }

    public IHelloService getHelloService() {
        final IHelloService helloService = new HelloService();

        /**
         * ClassLoader loader：类加载器
         * Class<?>[] interfaces：得到全部的接口
         * InvocationHandler h：得到InvocationHandler接口的子类实例
         */
        IHelloService IHelloService = (IHelloService) Proxy.newProxyInstance(this.getClass().getClassLoader(), new Class[]{IHelloService.class}, new InvocationHandler() {
            public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {
                System.out.println("代理方法执行before");
                Object result = method.invoke(helloService, args);
                System.out.println("代理方法执行after，执行结果: " + result);
                return result;
            }
        });
        return IHelloService;
    }
}
