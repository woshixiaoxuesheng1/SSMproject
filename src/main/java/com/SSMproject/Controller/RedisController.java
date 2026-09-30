package com.SSMproject.Controller;

import com.SSMproject.entity.Result;
import jakarta.annotation.Resource;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/redis")
public class RedisController {

    @Resource
    private RedisTemplate<String, Object> redisTemplate;

    @GetMapping("/test")
    public Result test() {


        redisTemplate.opsForValue().set("test", "Hello Redis");

        Object value = redisTemplate.opsForValue().get("test");

        return Result.success(value);
    }
}
