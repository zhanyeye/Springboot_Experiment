package com.example.experiment_06.controller;

import com.example.experiment_06.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.validation.constraints.Size;
import java.util.Map;

@Slf4j
@RestController
//声明为支持REST的控制组件，基于Jackson自动完成，将java对象序列化为json返回，
// 以及将传入的json反序列化为java对象(整合@ResponseBody/@Controller注解)
@RequestMapping("/api")   //请求映射，类型级方法级注释
@Validated
public class UserController {
    @PostMapping("/users")
    public Map postUser(@Valid @RequestBody User user) {
        return Map.of("user", user);
    }

    @GetMapping("/users/{username}")
    public void getViolationException(@Size(min = 2, max = 6, message = "用户参数信息错误")
            @PathVariable String username) {

    }
}
