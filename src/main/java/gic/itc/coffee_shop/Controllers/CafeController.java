package gic.itc.coffee_shop.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import gic.itc.coffee_shop.Entity.drink_categories;
import gic.itc.coffee_shop.Entity.user;
import gic.itc.coffee_shop.Repository.DrinkCategoriesRepo;
import gic.itc.coffee_shop.Repository.UserRepo;
import gic.itc.coffee_shop.Services.UserService;

@RestController
public class CafeController {
    @Autowired
    UserRepo Repository;

    @GetMapping("/login")
    public Object index() {
        return new ModelAndView("loginform");
    }

    @PostMapping("/login")
    public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {
        // use email as refrence to retrive every row by email or not
        Optional<user> User = Repository.findByEmail(email);
        if (User.isPresent()) {
            // retrieve a row of data from database
            user optionalUser = User.get();
            String Password = optionalUser.getPassword();
            if (Password.equals(password)) {
                ModelAndView mav = new ModelAndView("welcome");
                mav.addObject("email", email);
                return mav;
            } else {
                ModelAndView mav = new ModelAndView("loginform");
                mav.addObject("errorMessage", "Invalid password");
                return mav;
            }
        } else {
            ModelAndView mav = new ModelAndView("loginform");
            mav.addObject("errorMessage", "Invalid email");
            return mav;
        }
    }

    @GetMapping("/user")
    // ResponseEntity is HTTP resposne of user by server
    public ResponseEntity<List<user>> getAllUser() {
        try {
            List<user> User = new ArrayList<user>();
            // fetch all user from database and add a new user to a list
            Repository.findAll().forEach(User::add);
            if (User.isEmpty()) {
                return new ResponseEntity<List<user>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(User, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/{id}")
    public ResponseEntity<user> getUserByID(@PathVariable("id") int id) {
        try {
            Optional<user> User = Repository.findById(id);

            if (User.isPresent()) {
                return new ResponseEntity<>(User.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/email/{email}")
    public ResponseEntity<user> getUserByEmail(@PathVariable("email") String email) {
        try {
            Optional<user> User = Repository.findByEmail(email);
            // System.out.println(user.getEmail());

            if (User.isPresent()) {
                return new ResponseEntity<>(User.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping("/user/password/{password}")
    public ResponseEntity<user> getUserByPassword(@PathVariable("password") String password) {
        try {
            Optional<user> User = Repository.findByPassword(password);
            // System.out.println(user.getEmail());

            if (User.isPresent()) {
                return new ResponseEntity<>(User.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // PostMapping is another way of writing @RequestMapping(method=
    // RequestMethod.Post)
    @PostMapping("/user")
    public ResponseEntity<user> addUser(@RequestBody user users) {
        try {
            // userService.createUser(users);
            Repository.save(users);
            return new ResponseEntity<>(users, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // signup and go to welcome
    @PostMapping("/signup")
    @ResponseBody
    public Object task3(@ModelAttribute("User") user User, Model model) {
        Repository.save(User); // save into database
        if (User.getPassword() == null || User.getPassword().isEmpty()) {
            model.addAttribute("error", "Password field cannot be empty");
            return new RedirectView("/login");
        }
        return new ModelAndView("/welcome");
        // }
        // return new RedirectView("/login");
    }

    // @Autowired
    // DrinkCategoriesRepo Repo;

    // @PostMapping("/drinkCategories")
    // public ResponseEntity<drink_categories> addDrnkCategories(@RequestBody drink_categories dc) {
    //     try {
    //         // userService.createUser(users);
    //         System.out.println(dc.getName());
    //         Repo.save(dc);
    //         return new ResponseEntity<>(dc, HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // create drink categories
    // @PostMapping("/drinkCategories")
    // public ResponseEntity<drink_categories> addDrinkCategories(@RequestBody
    // drink_categories dc) {
    // try {
    // System.out.println(dc.getName());
    // Repo.save(dc);
    // return new ResponseEntity<>(dc, HttpStatus.CREATED);
    // } catch (Exception e) {
    // return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    // }
    // }

}
