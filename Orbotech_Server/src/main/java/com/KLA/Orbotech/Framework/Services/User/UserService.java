package com.KLA.Orbotech.Framework.Services.User;

import com.KLA.Orbotech.Framework.Entity.AuthUser;
import com.KLA.Orbotech.Framework.Entity.User;
import com.KLA.Orbotech.Framework.Repositorys.User.UserRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class UserService implements IUserService {
    @Autowired
    private UserRepo userRepo;

    @Transactional
    @Override
    public HttpStatus Login(AuthUser User) {
        boolean check = userRepo.Login(User);
        if (check)
            return HttpStatus.OK;
        return HttpStatus.NOT_FOUND;
    }

    @Transactional
    @Override
    public HttpStatus SignUp(User newUser) {
        userRepo.Create(newUser);
        boolean check = userRepo.Login(new AuthUser(newUser.getEmail(), newUser.getPassword()));
        if (check)
            return HttpStatus.OK;
        return HttpStatus.NOT_FOUND;
    }

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
