package gic.itc.coffee_shop.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import gic.itc.coffee_shop.Entity.user;
import gic.itc.coffee_shop.Repository.UserRepo;
import gic.itc.coffee_shop.Services.UserService;

@RestController
public class CafeController {
    @Autowired
    UserRepo Repository;
    @GetMapping("/")
    public Object index(){
        return new ModelAndView("loginform");
    }

<<<<<<< HEAD
    @GetMapping("/user")
    public ResponseEntity<List<user>> getAllUser(){
        try{
            List <user> User = new ArrayList<user>();
            Repository.findAll().forEach(User::add);
            if(User.isEmpty()){
                return new ResponseEntity<List<user>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(User,HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    @GetMapping("/user/{id}")
    public ResponseEntity<user> getUserByID(@PathVariable("id") int id){
        try{
            Optional<user> User = Repository.findById(id);
            
            if(User.isPresent()){
                return new ResponseEntity<>(User.get(),HttpStatus.OK);
            }else{
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    } 

    @PostMapping("/user")
    public ResponseEntity<user> addUser(@RequestBody user users){
        try{
            // userService.createUser(users);
            Repository.save(users);
            return new ResponseEntity<>(users,HttpStatus.CREATED);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
=======
    //create an api to create user
    @PostMapping("/user")
    public void addUser(@RequestBody user users){
        // System.out.println(users.getEmail());
        // UserService userService = new UserService();
        userService.createUser(users);
>>>>>>> 7681c7ffe033f02a37635d7420811a21774344f0
    }
}
