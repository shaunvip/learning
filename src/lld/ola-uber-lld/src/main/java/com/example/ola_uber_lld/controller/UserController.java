package com.example.ola_uber_lld.controller;

import com.example.ola_uber_lld.model.Driver;
import com.example.ola_uber_lld.model.RUser;
import com.example.ola_uber_lld.model.book.Location;
import com.example.ola_uber_lld.service.CabServices;
import com.example.ola_uber_lld.service.DriverServices;
import com.example.ola_uber_lld.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.QueryMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@RestController
public class UserController {

    UserService userService;
    CabServices cabServices;
    DriverServices driverServices;
    public UserController(UserService us, CabServices cb, DriverServices ds){
        this.userService=us;
        this.cabServices=cb;
        this.driverServices=ds;
    }

    @PostMapping("/save")
    public RUser addUser(@RequestBody RUser user) {
       return userService.adduser(user);
    }
    @PostMapping("/updateCabLocation/{cabId}")
    public boolean updateCabLocation(@RequestBody Location location, @PathVariable Integer cabId){
       return cabServices.updateCabLocation(cabId,location);
    }
    @PutMapping("/driver/{id}/availability/{online}")
    public Driver updateDriverStatus(@PathVariable String online, @PathVariable Long id){
        return driverServices.updateDriverStatus(id,online);
    }


}
