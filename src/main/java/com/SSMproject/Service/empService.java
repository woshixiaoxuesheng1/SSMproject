package com.SSMproject.Service;

import com.SSMproject.entity.Emp;
import com.SSMproject.entity.EmpQuaryParam;
import com.SSMproject.entity.PageResult;

import java.util.List;

public interface empService {
    public List<Emp> findAll();
    public Emp findById(Integer id);
    public void addEmp(Emp emp);
    public void updateEmp(Emp emp);
    public String deleteByIds(List<Integer> ids);
    public List<Emp> search(String name,String job,double salary);
    public PageResult page(EmpQuaryParam empQuaryParam);
    public void upload(String image,Integer id);
}
