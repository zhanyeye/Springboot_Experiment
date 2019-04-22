package com.example.experiment_07.controller;


import com.example.experiment_07.component.EncryptorComponent;
import com.example.experiment_07.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import javax.servlet.http.HttpServletResponse;
import javax.swing.text.html.Option;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController   //声明为controller 组件，将返回对象转化为json
@RequestMapping("/api")
public class UserController {
    private Map<String, User> users = new HashMap<>();

    @Autowired
    private PasswordEncoder passwordEncoder;
    @Autowired
    private EncryptorComponent encryptorComponent;

    @PostMapping("/register")
    public Map register(@RequestBody User user) {
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        users.put(user.getUserName(), user);
        return Map.of("user", user);
    }

    @PostMapping("/login")
    public void login(@RequestBody User user, HttpServletResponse response) {
        Optional.ofNullable(users.get(user.getUserName()))
                .or(() -> {
                    throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户不存在");
                })
                .ifPresent(u -> {
                    if(!passwordEncoder.matches(user.getPassword(), u.getPassword())) {
                        throw new ResponseStatusException(HttpStatus.UNAUTHORIZED, "用户或密码错误");
                    }
                    Map map = Map.of("name", u.getUserName());
                    //生成token
                    String token = encryptorComponent.encrypt(map);
                    //在header创建自定义的权限
                    response.setHeader("Authorization", token);
                });
    }
    @GetMapping("/index")
    public Map getIndex(@RequestAttribute String name) {
        log.debug(name);
        return Map.of("真实用户名", name);
    }

}
