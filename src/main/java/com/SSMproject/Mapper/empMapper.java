package com.SSMproject.Mapper;


import com.SSMproject.entity.Emp;
import com.SSMproject.entity.EmpQuaryParam;
import org.apache.ibatis.annotations.*;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.web.multipart.MultipartFile;

import java.util.List;

@Mapper
public interface empMapper {

    @Select("select * from empssm.emp")
    List<Emp> findAll();

    @Select("select * from empssm.emp where id = #{id}")
    Emp findById(Integer id);

    @Insert("insert into empssm.emp(name,age,gender,job,salary,phone) values(#{name},#{age},#{gender},#{job},#{salary},#{phone})")
    void addEmp(Emp emp);

    @Update("update empssm.emp set age = #{age}, job=#{job}, salary = #{salary},phone = #{salary}")
    void updateEmp(Emp emp);

    String deleteByIds(List<Integer> ids);

    List<Emp> search(
            @Param("name")String name,
            @Param("job")String job,
            @Param("salary")double salary);

    // 即使没有分页查询 PageHelper.startPage自动开启limit分页查询
    @Select("select id,name,age,gender,job,salary,phone from empssm.emp ")
    List<Emp> page(EmpQuaryParam empQuaryParam);

    @Update("update emp set image = #{image} where id = #{id}")
    void upload(String image,Integer id);

}