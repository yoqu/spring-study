package com.iflytek.cbg.study.spring;

import com.iflytek.cbg.study.spring.di.NameService;
import com.iflytek.cbg.study.spring.ioc.HelloService;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Hello world!
 */
public class App {
    public static void main(String[] args) {
        App app = new App();

//        app.iocService();
        app.aopService();
    }

    /**
     * ioc案例配置并使用HelloService
     */
    public void iocService() {
        // 1.根据参数找到classpath目录下的文件
        // 2.由xml的配置文件创建实例并初始化Spring IOC容器
        ApplicationContext context = createContext("1.1_ioc_beans.xml");
        // 3.从Spring上下文管理器拿到HelloService实例
        HelloService service = context.getBean(HelloService.class);
        service.sayHello();
    }


    /**
     * 依赖注入实例
     */
    public void diService() {
        ApplicationContext context = createContext("1.3_di_beans.xml");
        NameService service = context.getBean(NameService.class);
        service.sayHello("IFLYTEK");
    }

    public void aopService(){
        NameService service  =createContext("2.3_aop.xml").getBean(NameService.class);
        service.sayHello("PROXY IFLYTEK");
    }
    public ApplicationContext createContext(String path) {
        return new ClassPathXmlApplicationContext(path);
    }
}
