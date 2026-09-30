package com.SSMproject.Controller;

import com.SSMproject.Service.Impl.empServiceImpl;
import com.SSMproject.entity.Result;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import java.io.File;


// Lombok提供的日志注解可以使用log.info log.error等纪录日志
@Slf4j
@RestController
@RequestMapping("/emp")
public class uploadController {


    @Autowired
    private empServiceImpl empServiceImpl;

    @PostMapping("/{id}/upload")
    public Result upload(@RequestParam("file") MultipartFile file,@PathVariable Integer id) throws Exception{
        log.info("开始上传文件");
        // 将文件保存到该路径下
        empServiceImpl.upload(file.getOriginalFilename(),id);

        file.transferTo(new File("D:/upload/"+file.getOriginalFilename()));
        return Result.success();
    }

}
