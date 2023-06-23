package com.KLA.Orbotech.Framework.Services.User;

import com.KLA.Orbotech.Framework.Entity.User;
import com.KLA.Orbotech.Framework.Repositorys.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService{
    @Autowired
    private UserRepo userRepo;

    @Transactional
    @Override
    public List<User> Get() {
        return userRepo.Get();
    }

    @Transactional
    @Override
    public User Get(Integer id) {
        return userRepo.Get(id);
    }

    @Transactional
    @Override
    public void Create(User newUser) {
        userRepo.Create(newUser);
    }

    @Transactional
    @Override
    public void Delete(Integer id) {
        userRepo.Delete(id);
    }
}
