package com.SSMproject.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@NoArgsConstructor
@AllArgsConstructor
@Data
public class EmpQuaryParam {

    private int page = 1; // 页码
    private int pagesize = 10; //每页展示数据


    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String job;
    private Double salary;
    private Integer phone;
}
