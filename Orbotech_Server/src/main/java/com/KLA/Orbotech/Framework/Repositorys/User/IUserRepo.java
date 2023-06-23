package com.KLA.Orbotech.Framework.Repositorys.User;

import com.KLA.Orbotech.Framework.Entity.AuthUser;
import com.KLA.Orbotech.Framework.Entity.User;

import java.util.List;

public interface IUserRepo {
    List<User> Get();

    boolean Login(AuthUser user);

    User Get(Integer id);

    void Create(User newUser);

    void Delete(Integer id);

}
