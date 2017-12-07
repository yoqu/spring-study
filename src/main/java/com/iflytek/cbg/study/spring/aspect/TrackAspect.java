package com.iflytek.cbg.study.spring.aspect;


import org.aspectj.lang.JoinPoint;

/**
 * Created by yoqu on 2017/12/7.
 */
public class TrackAspect {

    public void myadvice(JoinPoint joinpoint){
        System.out.println("aop");
    }
}
