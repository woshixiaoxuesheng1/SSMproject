package com.SSMproject.GlobalException;

import com.SSMproject.entity.Result;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice // 全局异常处理器处理controller层出现的异常
public class globalException {

    // 指定发生哪个异常后由哪个方法进行处理
    @ExceptionHandler(Exception.class)
    public Result handleException(Exception e){
        e.printStackTrace(); // 打印错误信息
        return Result.error("操作失败");
    }

    @ExceptionHandler(ArithmeticException.class)
    public Result handleArithemeticException(ArithmeticException ae){
        ae.printStackTrace();
        return Result.error("算数异常");
    }
}
