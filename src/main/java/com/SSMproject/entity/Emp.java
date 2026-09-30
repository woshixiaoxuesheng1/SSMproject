package com.SSMproject.entity;


import jakarta.validation.constraints.Min;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class Emp implements Serializable {

    private static final long serialVersionUID = 1L;

    private Integer id;
    @NotBlank(message = "姓名不能为空")
    private String name;
    @Min(message = "年龄必须大于18", value = 18)
    private Integer age;
    private String gender;
    private String job;
    private Double salary;
    @Pattern(regexp = "^1[3-9]\\d{9}$", message = "手机号格式不正确")
    private String phone;

    private String image;
}
