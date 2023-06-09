package gic.itc.coffee_shop.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
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
import gic.itc.coffee_shop.Entity.user_type;
import gic.itc.coffee_shop.Repository.DrinkRepo;
import gic.itc.coffee_shop.Repository.UserRepo;
import gic.itc.coffee_shop.Repository.SaleRepo;
import gic.itc.coffee_shop.Repository.OrderRepo;
import gic.itc.coffee_shop.Repository.UserTypeRepo;
import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;

// @RestController
@Controller
public class CafeController {
    @Autowired
    UserRepo Repository;
    @Autowired
    SaleRepo SaleRepository;
    @Autowired
    DrinkRepo DrinkRepository;
    @Autowired
    OrderRepo OrderRepository;


    @GetMapping("/access-denied")
    public String getAccessDenied(){
        return "error/403";
    }
    @GetMapping("logout")
    public String getLogout(){
        return "redirect:/login";
    }

   
    @GetMapping("/admin")
    public String adminDashboard1(Model model) {
        int userDash = Repository.findAllUser();
        float totalSale = SaleRepository.findTotalSale();
        int totalDrink = DrinkRepository.totalDrink();
        int totalServe = OrderRepository.totalServe();
        List<user> findAllCashier = Repository.findAllCashier();
        List<Integer> findEachServe = Repository.getServeCount();


        model.addAttribute("countUser", userDash);
        model.addAttribute("totalSale", totalSale);
        model.addAttribute("totalDrink", totalDrink);
        model.addAttribute("totalServe", totalServe);
        model.addAttribute("findAllCashier", findAllCashier);
        model.addAttribute("findEachServe", findEachServe);


        return "admin";

    }

    // return new route ?
    // @PostMapping("/login")
    // public ModelAndView login(@RequestParam("email") String email, @RequestParam("password") String password) {
    //     // use email as refrence to retrive every row by email or not
    //     System.out.println(email);
    //     user User = Repository.findByEmail(email);
    //     if (User!=null) {
    //         // retrieve a row of data from database
    //         // user optionalUser = User.get();
    //         String Password = User.getPassword();
    //         user_type user_type = User.getUser_type_id();
    //         // user_type user_type = optionalUser.getUser_type();
    //         if (Password.equals(password) && user_type.getId() == 2) {

    //             ModelAndView mav = new ModelAndView("admin");
    //             mav.addObject("email", email);
    //             return mav;
    //         } else {
    //             ModelAndView mav = new ModelAndView("loginform");
    //             mav.addObject("errorMessage", "Invalid password");
    //             return mav;
    //         }
    //     } else {
    //         ModelAndView mav = new ModelAndView("loginform");
    //         mav.addObject("errorMessage", "Invalid email");
    //         return mav;
    //     }
    // }
    // // @GetMapping("/user/casheir")
    // // public Object home(){
    // //     return new ModelAndView("welcome");
    // // }

    // // login as admin
    // @PostMapping("/login/admin")
    // public String admin(@RequestParam("email") String email, @RequestParam("password") String password) {
    //     // use email as refrence to retrive every row by email or not
    //     System.out.println(email);
    //     user User = Repository.findByEmail(email);
    //     if (User!=null) {
    //         // retrieve a row of data from database
    //         // user optionalUser = User.get();
    //         String Password = User.getPassword();
    //         user_type user_type = User.getUser_type_id();
    //         System.out.println(Password);
    //         System.out.println(user_type.getId());

    //         // user_type user_type = optionalUser.getUser_type();
    //         if (Password.equals(password) && user_type.getId() == 1) {
    //             // ModelAndView mav = new ModelAndView("admin");
    //                 return "admin";
    //         } else {
    //             // ModelAndView mav = new ModelAndView("loginform");
    //             return "redirect:/login";

    //         }
    //     } else {
    //         System.out.println("hi");
    //         return "redirect:/login";
    //     }
    // }

    // @GetMapping("/user")
    // // ResponseEntity is HTTP resposne of user by server
    // public ResponseEntity<List<user>> getAllUser() {
    //     try {
    //         List<user> User = new ArrayList<user>();
    //         // fetch all user from database and add a new user to a list
    //         Repository.findAll().forEach(User::add);
    //         if (User.isEmpty()) {
    //             return new ResponseEntity<List<user>>(HttpStatus.NO_CONTENT);
    //         }
    //         return new ResponseEntity<>(User, HttpStatus.OK);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @GetMapping("/user/{id}")
    // public ResponseEntity<user> getUserByID(@PathVariable("id") int id) {
    //     try {
    //         Optional<user> User = Repository.findById(id);

    //         if (User.isPresent()) {
    //             return new ResponseEntity<>(User.get(), HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //         }
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @GetMapping("/user/email/{email}")
    // public ResponseEntity<user> getUserByEmail(@PathVariable("email") String email) {
    //     try {
    //         Optional<user> User = Repository.findByEmail(email);
    //         // System.out.println(user.getEmail());

    //         if (User.isPresent()) {
    //             return new ResponseEntity<>(User.get(), HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //         }
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // @GetMapping("/user/password/{password}")
    // public ResponseEntity<user> getUserByPassword(@PathVariable("password") String password) {
    //     try {
    //         Optional<user> User = Repository.findByPassword(password);
    //         // System.out.println(user.getEmail());

    //         if (User.isPresent()) {
    //             return new ResponseEntity<>(User.get(), HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //         }
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // PostMapping is another way of writing @RequestMapping(method=
    // RequestMethod.Post)
    // @PostMapping("/user")
    // public ResponseEntity<user> addUser(@RequestBody user users) {
    //     try {
    //         // userService.createUser(users);
    //         Repository.save(users);
    //         return new ResponseEntity<>(users, HttpStatus.CREATED);
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // add new cashier
    // @Autowired
    // UserTypeRepo userTypeRepo;

    // @PostMapping("/addCashier")
    // public ModelAndView addDrink(@RequestParam("name") String name, @RequestParam("role") String role,
    //          @RequestParam("email") String email, @RequestParam("password") String password,
    //          @RequestParam("image_url") String image_url) {
    //     try {
    //         user user = new user();
    //        user.setUsername(name);

    //     // Get the category ID based on the category name
    //         Optional<user_type> utOptional = userTypeRepo.findByName(role);
    //         if (utOptional.isPresent()) {
    //         user_type ut = utOptional.get();
    //         user.setUser_type_id(ut);
    //     } else {
    //         // Handle the case where the category does not exist
    //         ModelAndView mav = new ModelAndView("error");
    //         mav.addObject("errorMessage", "Invalid category");
    //         return mav;
    //     }
 
    //     // Set the price of the drink
    //     user.setEmail(email);
    //     user.setPassword(password);
    //     user.setImage_url(image_url);
        
    //     Repository.save(user);
    //     // return new ModelAndView("welcome");
    //     ModelAndView mav = new ModelAndView("welcome");
    //     mav.addObject("user", user); // Add the drink object to the model with the attribute name "drink"
    //     return mav;
    //     }catch (Exception e) {
    //         // Handle any exceptions that occur during database operation
    //         ModelAndView mav = new ModelAndView("error");
    //         mav.addObject("errorMessage", "Error saving drink category");
    //         return mav;
    //     }
    // }
    // @GetMapping("/calculate")
    // public String calculatePrice(){
    //         return "calculateprice";
    //     }

   

    

    

}
