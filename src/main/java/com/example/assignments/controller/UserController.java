package com.example.assignments.controller;


import com.example.assignments.model.User;
import com.example.assignments.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
@RequestMapping(value = "/users")
public class UserController     {

    @Autowired
    UserService userService;

    @RequestMapping(method = RequestMethod.GET, value = "/getAllUsers")
    @ResponseBody
    public List<User> getUsers(){
        return userService.getAllUsers();
    }

    @RequestMapping(method = RequestMethod.GET, value = "/getUser")
    @ResponseBody
    public User getUser(@RequestParam(name = "id") Integer id){
        return userService.getUser(id);
    }

    @RequestMapping(method = RequestMethod.DELETE, value = "/deleteUser")
    @ResponseBody
    public String deleteUser(@RequestParam(name = "id") Integer id) {
        return userService.deleteUser(id);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/saveUser")
    @ResponseBody
    public User saveUser(@RequestBody User user) {
        return userService.saveUser(user);
    }

    @RequestMapping(method = RequestMethod.POST, value = "/banUser")
    @ResponseBody
    public User banUser(@RequestParam(name = "id") Integer id){
        return userService.banUser(id);
    }

    @RequestMapping(method = RequestMethod.PUT, value = "/updateUser")
    @ResponseBody
    public User updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }
}
