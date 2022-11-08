package com.example.ola_uber_lld.controller;

import com.example.ola_uber_lld.model.RUser;
import com.example.ola_uber_lld.model.enums.UserEnum;
import com.example.ola_uber_lld.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;

import java.security.PublicKey;
import java.util.List;

@Controller
@Slf4j
public class UserGraphController {
    @Autowired
    UserService userService;

    @QueryMapping
    public RUser project(@Argument Long id) {
        return userService.fetchUser(id).orElse(null);
    }

    @MutationMapping
    public RUser updateUser(@Argument Long id, @Argument String name,@Argument("userType") UserEnum type) {
        RUser user= userService.fetchUser(id).orElse(new RUser());
        log.info("User Obj input {} {}",type,user);
        user.setName(name);
        user.setUserType(type);
        userService.adduser(user);
        return user;
    }

}
