package com.KLA.Orbotech.Framework.Controllers;

import com.KLA.Orbotech.Framework.Entity.AuthUser;
import com.KLA.Orbotech.Framework.Entity.Order;
import com.KLA.Orbotech.Framework.Entity.User;
import com.KLA.Orbotech.Framework.Services.User.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping()
public class AuthController {

    @Autowired
    private UserService userService;

    @PostMapping("/login")
    public HttpStatus Login(@RequestBody AuthUser userObj) {
        return userService.Login(userObj);
    }

    @PostMapping("/signup")
    public HttpStatus SignUp(@RequestBody User userObj) {
        return userService.SignUp(userObj);
    }
}
