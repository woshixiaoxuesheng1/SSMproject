/*
package com.SSMproject.logAspect;

import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 创建日志 目的是在每个业务逻辑上增加日志记录一般在service层
@Aspect
@Component// 普通组件 类似于Controller Service Mapper 将该类交给IOC容器管理
@Mylog
public class logAspect {
    @Around("execution(* com.SSMproject.Service.*.*(..))") // 开启日志环绕在Service层中的方法前后进行日志记录
    public void mylog(ProceedingJoinPoint JoinPoint) throws Throwable {
        System.out.println("方法开始了");
        JoinPoint.proceed(); //继续原来的方法
        System.out.println("方法结束了");
    }
}
*/
