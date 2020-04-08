package ru.yura.web.controller;

import org.springframework.web.bind.annotation.*;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {


    final private
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "admin/findUser/{name}")
    public User findUserByName(@PathVariable String name , HttpServletRequest request) {
        System.out.println(" @PostMapping(value = \"admin/finduser\")");
        User user=userService.findModelByName(name);
        return user;
    }
    @GetMapping(value = "admin/admin")
    public List<User> getAllUsers() {
        List<User> users= userService.findAll();
        return users;
    }
    @PostMapping(value = "admin/delete")
    public User deleteUser(@RequestBody User user ) {
        user.setRoles(new ArrayList<>());
        userService.delete(user);
        return user;
    }












    @PostMapping(value = "admin/add")
    public User addUser(User user, @RequestParam(required = false, name = "role_id") Long id, HttpServletRequest req) {
        System.out.println(" @PostMapping(value = \"admin/add\")");
        userService.add(user, id);
        return user;
    }


//    @PostMapping(value = "admin/add")
//    public User addUser(User user, @RequestParam(required = false, name = "role_id") Long id, HttpServletRequest req) {
//        System.out.println(" @PostMapping(value = \"admin/add\")");
//
//        userService.add(user, id);
//        return user;
//    }
//


    @PostMapping(value = "admin/update")
    public User postUpdateUser(User user, @RequestParam(required = false, name = "role_id") Long[] ids) {
        System.out.println(" @PostMapping(value = \"admin/update\")");
        User userUpdate= userService.update(user, ids);
        return userUpdate;
    }


}