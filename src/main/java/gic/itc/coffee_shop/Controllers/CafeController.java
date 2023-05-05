package gic.itc.coffee_shop.Controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import gic.itc.coffee_shop.Entity.user;
import gic.itc.coffee_shop.Services.UserService;

@RestController
public class CafeController {
    @Autowired
    UserService userService;
    @GetMapping("/")
    public Object index(){
        return new ModelAndView("loginform");
    }

    //create an api to create user
    @PostMapping("/user")
    public void addUser(@RequestBody user users){
        // System.out.println(users.getEmail());
        // UserService userService = new UserService();
        userService.createUser(users);
    }
}
