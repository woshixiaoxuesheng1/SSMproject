package com.SSMproject.Service.Impl;


import com.SSMproject.Mapper.loginMapper;
import com.SSMproject.Service.loginService;
import com.SSMproject.Util.JwtUtils;
import com.SSMproject.entity.User;
import com.SSMproject.entity.loginRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class loginServiceImpl implements loginService {
    @Autowired
    private loginMapper loginMapper;

    public String login(loginRequest loginRequest){
        User user =  loginMapper.login(loginRequest);
        if(user == null){
            return "用户名或密码错误";
        }
        return JwtUtils.generateToken(user.getId());
    }
}
