package com.KLA.Orbotech.Framework.Services.User;

import com.KLA.Orbotech.Framework.Entity.AuthUser;
import com.KLA.Orbotech.Framework.Entity.User;
import org.springframework.http.HttpStatus;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

public interface IUserService {
    HttpStatus Login(AuthUser User);

    HttpStatus SignUp(User newUser);

    List<User> Get();

    User Get(Integer id);

    void Create(User newUser);

    void Delete(Integer id);
}
