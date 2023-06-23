package com.KLA.Orbotech.Framework.Services.User;

import com.KLA.Orbotech.Framework.Entity.User;

import java.util.List;

public interface IUserService {
    List<User> Get();

    User Get(Integer id);

    void Create(User newUser);

    void Delete(Integer id);
}
