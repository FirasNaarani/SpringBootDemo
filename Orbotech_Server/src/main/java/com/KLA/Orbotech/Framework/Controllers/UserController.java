package com.KLA.Orbotech.Framework.Controllers;

import com.KLA.Orbotech.Framework.Entity.User;
import com.KLA.Orbotech.Framework.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {
    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public List<User> Get() {
        return userService.Get();
    }

    @GetMapping("/users/{id}")
    public User Get(@PathVariable Integer id) {
        User userObj = userService.Get(id);
        if (userObj != null) return userObj;

        else throw new RuntimeException("USER WITH ID " + id + " IS NOT FOUND");
    }

    @PostMapping("/users")
    public User Create(@RequestBody User userObj) {
        userService.Create(userObj);
        return userObj;
    }

    @PutMapping("/users")
    public User Update(@RequestBody User userObj){
        userService.Create(userObj);
        return userObj;
    }
    @DeleteMapping("/users/{id}")
    public String Delete(@PathVariable Integer id) {
        userService.Delete(id);
        return "USER HAS BEEN DELETED WITH ID :" + id;
    }
}
