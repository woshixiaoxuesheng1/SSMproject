package com.SSMproject.Controller;


import com.SSMproject.Service.Impl.empServiceImpl;
import com.SSMproject.entity.Emp;
import com.SSMproject.entity.EmpQuaryParam;
import com.SSMproject.entity.Result;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.SQLOutput;
import java.util.List;


@RestController
@RequestMapping("/emp")
public class empController {


    @Autowired
    private empServiceImpl empServiceImpl;

    // 查找所有员工
    @GetMapping
    public Result findAll(){
        return Result.success(empServiceImpl.findAll());
    }

    // 根据Id查找员工
    @GetMapping("/{id}")//
    public Result findById(@PathVariable Integer id){
        return Result.success(empServiceImpl.findById(id));
    }

    // 新增员工数据
    @PostMapping
    public Result addEmp(@RequestBody @Valid Emp emp){
        empServiceImpl.addEmp(emp);
        return Result.success();
    }

    // 修改员工数据
    @PutMapping
    public Result updateEmp(@RequestBody Emp emp){
        empServiceImpl.updateEmp(emp);
        return Result.success();
    }

    // 根据Id批量删除员工数据
    @DeleteMapping
    public Result deleteById(@RequestParam List<Integer> ids){

        empServiceImpl.deleteByIds(ids);
        return Result.success();
    }

    //条件查询 根据前端传来的数据进行查询
    @GetMapping("/search")
    public Result search(
            @RequestParam("name") String name,
            @RequestParam("job") String job,
            @RequestParam("salary") double salary){
        return Result.success(empServiceImpl.search(name,job,salary));
    }

    // 分页条件查询
    @GetMapping("/page")
    public Result page( EmpQuaryParam empQuaryParam){
        return Result.success(empServiceImpl.page(empQuaryParam));
    }


}
