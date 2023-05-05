package gic.itc.coffee_shop.Services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import gic.itc.coffee_shop.Entity.user;
import gic.itc.coffee_shop.Repository.UserRepo;

@Service
public class UserService {
    @Autowired
    public UserRepo Repo;

<<<<<<< HEAD
    // public void createUser(user users){
    //     // Repo.save(users);
    //     try{
            
    //     }
    // }

=======
    public void createUser(user users){
        // System.out.println(users.getEmail());
        // user users = new user();
        Repo.save(users);
    }
>>>>>>> 7681c7ffe033f02a37635d7420811a21774344f0

}
