package com.SSMproject.logAspect;

import org.aspectj.lang.annotation.Around;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

// 创建日志 目的是在每个业务逻辑上增加日志记录一般在service层
@Aspect
@Component// 普通组件 类似于Controller Service Mapper 将该类交给IOC容器管理
public class myLog {
    @Around("(*com.SSMproject.Service.empService.*.*)") // 开启日志环绕在方法前后进行日志记录
    public void mylog(){

    }
}
