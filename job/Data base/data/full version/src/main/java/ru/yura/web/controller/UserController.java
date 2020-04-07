package ru.yura.web.controller;

import org.springframework.web.bind.annotation.*;
import ru.yura.web.model.User;
import ru.yura.web.service.UserService;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@RestController
@RequestMapping("/")
public class UserController {


    final private
    UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }


    @GetMapping(value = "checkUser")
    public User seeUssdfer() {
        System.out.println("  @GetMapping(value = \"checkUser\")  SERVER");
        User user=userService.findAll().get(0);
       // Gson gson=new Gson();
        System.out.println(user.getEmail()+user.getId());
        return user;
    }

    @GetMapping(value = "admin/admin")
    public List<User> getAllUsers() {
        // modelMap.addAttribute("user", authentication.getPrincipal());
        // modelMap.addAttribute("user", new User());
        List<User> users= userService.findAll();
        System.out.println("@GetMapping(value = \"admin/admin\")       Server");
        return users;
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
    @PostMapping(value = "admin/delete")
    public User deleteUser(User user , HttpServletRequest request) {
        System.out.println(" @PostMapping(value = \"admin/delete\")");
       User user2=userService.findById(user.getId());
        userService.delete(user2);
        return user;
    }

    @PostMapping(value = "admin/update")
    public User postUpdateUser(User user, @RequestParam(required = false, name = "role_id") Long[] ids) {
        System.out.println(" @PostMapping(value = \"admin/update\")");
        User userUpdate= userService.update(user, ids);
        return userUpdate;
    }
}