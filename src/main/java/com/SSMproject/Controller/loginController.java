package com.SSMproject.Controller;


import com.SSMproject.Service.Impl.loginServiceImpl;
import com.SSMproject.entity.Result;
import com.SSMproject.entity.loginRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RequestMapping("/login")
@RestController
public class loginController {
    @Autowired
    private loginServiceImpl loginServiceImpl;

    @PostMapping
    public Result login(@RequestBody loginRequest loginRequest){


        return Result.success(loginServiceImpl.login(loginRequest));
    }
}
