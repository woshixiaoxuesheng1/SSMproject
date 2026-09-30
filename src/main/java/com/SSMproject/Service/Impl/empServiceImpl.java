package com.SSMproject.Service.Impl;


import ch.qos.logback.core.model.conditional.ElseModel;
import com.SSMproject.Mapper.empMapper;
import com.SSMproject.Service.empService;
import com.SSMproject.entity.Emp;
import com.SSMproject.entity.EmpQuaryParam;
import com.SSMproject.entity.PageResult;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.List;


@Service
public class empServiceImpl implements empService {
    @Autowired
    private empMapper empMapper;

    // 先查看redis缓存是否有数据在查询数据库
    @Autowired
    private RedisTemplate<String, Object> redisTemplate;

    @Override
    public List<Emp> findAll() {
        return empMapper.findAll();
    }

    @Override
    public Emp findById(Integer id){
        // 查看redis是否缓存数据
        Emp emp = (Emp) redisTemplate.opsForValue().get(id);
        if (emp != null){
            return emp;
        }
        // 将数据库的数据写入redis缓存
        redisTemplate.opsForValue().set("emp:0",empMapper.findById(id));
        return empMapper.findById(id);
    }

    @Override
    public void addEmp(Emp emp) {
        empMapper.addEmp(emp);
    }

    @Override
    public void updateEmp(Emp emp){
        empMapper.updateEmp(emp);
    }

    @Override
    public String deleteByIds(List<Integer> ids){
        empMapper.deleteByIds(ids);
        return "删除成功";
    }

    @Override
    public List<Emp> search(String name,String job,double salary){
        return empMapper.search(name,job,salary);
    }

    @Override
    public PageResult page(EmpQuaryParam empQuaryParam){
        // 设置分页参数 执行该语句时自动让Mapper接口中的方法进行分页查询 limit empQuaryParam.getPage(),empQuaryParam.getPagesize()
        PageHelper.startPage(empQuaryParam.getPage(),empQuaryParam.getPagesize());
        // 分页查询
        List<Emp> empList = empMapper.page(empQuaryParam);// 调用Mapper接口查询数据库的对象数组
        // System.out.println(empList);
        //封装查询结果
        Page<Emp> p = (Page<Emp>)empList; // 将数据库返回的数据封装成Page对象
        return new PageResult(p.getTotal(),p.getResult()); // 返回PageResult对象 装有总数据数和当前页数据
    }

    @Override
    public void upload(String image,Integer id) {
        empMapper.upload(image,id);
    }


}
