package com.katle.design.dto;

import lombok.Data;
import lombok.NoArgsConstructor;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Data
@NoArgsConstructor
public class UserDTO implements Serializable {
    private String usernum;
    @NotBlank(message = "名字不能为空")
    private String username;
    @Size(min = 4,max = 10)
    private String password;

    private String college;

    private String major;

    private String grade;

    private String position;
    @Email(message = "必须是xxx@xx.com")
    private String email;
}
