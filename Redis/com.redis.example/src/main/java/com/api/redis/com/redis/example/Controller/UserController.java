package com.api.redis.com.redis.example.Controller;


import com.api.redis.com.redis.example.Dao.UserDao;
import com.api.redis.com.redis.example.Data.User;
import io.lettuce.core.dynamic.annotation.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.Map;
import java.util.UUID;

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserDao userDao;

    @PostMapping
    public User addUser(@RequestBody User user){
        user.setUserId(UUID.randomUUID().toString());
        return userDao.save(user);
    }

    @GetMapping("/{userId}")
    public User getUser(@PathVariable("userId") String userId) {

        return userDao.get(userId);
    }

    @GetMapping
    public Map<Object , Object> findAll(){

        return userDao.findAll();
    }

    @DeleteMapping("/{userId}")
    public void delete(@PathVariable("userId") String userId){

        userDao.delete(userId);
    }

}
