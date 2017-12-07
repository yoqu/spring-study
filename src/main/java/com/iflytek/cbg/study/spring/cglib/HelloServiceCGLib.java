package com.iflytek.cbg.study.spring.cglib;

import com.iflytek.cbg.study.spring.ioc.HelloService;
import net.sf.cglib.proxy.Enhancer;
import net.sf.cglib.proxy.MethodInterceptor;
import net.sf.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

/**
 * Created by yoqu on 2017/12/7.
 */
public class HelloServiceCGLib {

    public static void main(String[] args) {
        HelloServiceCGLib serviceCGLib = new HelloServiceCGLib();

        //1.通过cglib动态代理获取代理后的实例
        HelloService service = serviceCGLib.getHelloService();
        //2.执行方法
        service.sayHello();
    }

    public HelloService getHelloService() {
        Enhancer enhancer = new Enhancer();
        enhancer.setSuperclass(HelloService.class);
        // 回调方法
        enhancer.setCallback(interceptor());
        // 创建代理对象
        HelloService helloService = (HelloService) enhancer.create();
        return helloService;
    }

    public MethodInterceptor interceptor() {
        final HelloService service = new HelloService();
        return new MethodInterceptor() {
            @Override
            public Object intercept(Object o, Method method, Object[] objects, MethodProxy methodProxy) throws Throwable {
                System.out.println("执行方法before");
                Object result = method.invoke(service, objects);
                System.out.println("执行方法after");
                return result;
            }
        };
    }
}
