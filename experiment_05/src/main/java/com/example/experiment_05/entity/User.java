package com.example.experiment_05.entity;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor  //无参构造函数注解
public class User {
    private int id;
    private String userName;
    @JsonProperty(access = JsonProperty.Access.WRITE_ONLY)
    private String password;  //为密码添加序列化忽略注解
    private String detail;

    public User(int id, String userName, String password, String detail) {
        this.id = id;
        this.userName = userName;
        this.password = password;
        this.detail = detail;
    }
}
