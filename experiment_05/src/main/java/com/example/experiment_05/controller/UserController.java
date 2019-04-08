package com.example.experiment_05.controller;

import com.example.experiment_05.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@Slf4j
@RestController
@RequestMapping("/api")
public class UserController {
    @GetMapping("/index")
    public Map getIndex() {
        return Map.of("index", "mian");
    }

    @GetMapping("/users")
    public Map getUsers() {
        return Map.of("users", users);
    }

    @GetMapping("/users/{uid}")
    public Map getUsers(@PathVariable int uid) {
        log.debug("{}", uid);
        User user = users.stream()
                .filter(u -> u.getId() == uid)
                .findFirst()
                .orElse(null); //orElse 如果值存在则返回，否则返回参数中的东西

        return Optional.ofNullable(user)
                .map(u -> Map.of("user",u))
                .orElse(Map.of());
                //Map.of() : Returns an immutable map containing zero mappings.
    }

    @PostMapping("/users")
    public Map postUser(@RequestBody User user) { //@RequestBody : 指定controller方法参数绑定到请求体，自动基于jackson将请求数据反序列化为Java对象。
        users.add(user);
        return Map.of("users", users);
    }



    //在控制组件中模拟一个users集合，模拟封装若干user对象
    private static List<User> users = create();
    private static List<User> create() {
        users = new ArrayList<>();
        User u1 = new User(1, "zhanyeye", "123456", "115");
        User u2 = new User(2, "huahau", "123456", "749");
        User u3 = new User(3, "xiaoming", "123456", "777");
        users.add(u1);
        users.add(u2);
        users.add(u3);
        return users;
    }

}
