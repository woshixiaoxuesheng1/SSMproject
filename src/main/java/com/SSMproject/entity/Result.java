package com.SSMproject.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

// 后端统一返回结果
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Result {
    private Integer code; // 1成功 0失败
    private String msg;  // 存储信息
    private Object data;

    public static Result success(){
        Result result = new Result();
        result.code = 1;
        result.msg = "成功";
        return result;
    }

    public static Result success(Object object){
        Result result = new Result();
        result.data = object;
        result.code = 1;
        result.msg = "成功";
        return result;
    }

    public static Result error(String name){
        Result result = new Result();
        result.code = 0;
        result.setMsg(name);
        return result;
    }
}
