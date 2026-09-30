package com.SSMproject.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp {

    private Integer id;
    private String name;
    private Integer age;
    private String gender;
    private String job;
    private Double salary;
    private Integer phone;

}
