package gic.itc.coffee_shop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gic.itc.coffee_shop.Entity.user;
import gic.itc.coffee_shop.Repository.UserRepo;

@Service
public class UserService {
    @Autowired
    public UserRepo Repo;

    public void createUser(user users){
        // System.out.println(users.getEmail());
        // user users = new user();
        Repo.save(users);
    }

}
