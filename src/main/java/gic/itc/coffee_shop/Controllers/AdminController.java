package gic.itc.coffee_shop.Controllers;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.servlet.ModelAndView;

import gic.itc.coffee_shop.Entity.drink;
import gic.itc.coffee_shop.Entity.drink_categories;
import gic.itc.coffee_shop.Entity.user;
import gic.itc.coffee_shop.Repository.DrinkCategoriesRepo;
import gic.itc.coffee_shop.Repository.DrinkRepo;
import gic.itc.coffee_shop.Repository.UserRepo;

@Controller
public class AdminController {
    @Autowired
    DrinkRepo repositoryDrink;
    @Autowired
    UserRepo repositoryUser;
    @Autowired
    DrinkCategoriesRepo repositoryDrinkCategory;
    @GetMapping("/admin")
    public String adminDashboard1(Model model) {
        // Retrieve drinks
        // List<drink> drinks = repositoryDrink.findAll();
    
        // Retrieve users
        List<user> users = (List<user>) repositoryUser.findAll();
        model.addAttribute("listuser", users);
        return "admin";
        // System.out.println(users);

        // List<drink_categories> drinkCategories = (List<drink_categories>) repositoryDrinkCategory.findAll();
    
        // // Create a class to hold both drinks and users
        // class DashboardData {
        //     private List<drink> drinks;
        //     private List<user> users;
        //     private List<drink_categories> drinkCategories;
    
        //     public DashboardData(List<drink> drinks, List<user> users, List<drink_categories> drinkCategories) {
        //         this.drinks = drinks;
        //         this.users = users;
        //         this.drinkCategories = drinkCategories;
        //     }
    
        //     public List<drink> getDrinks() {
        //         return drinks;
        //     }
    
        //     public List<user> getUsers() {
        //         return users;
        //     }

        //     public List<drink_categories> getDrinkCategories() {
        //         return drinkCategories;
        //     }
        // }
    
        // Create an instance of DashboardData and pass drinks and users to it
        // DashboardData dashboardData = new DashboardData(drinks, users, drinkCategories);
    
        // // Create a ModelAndView object and add the dashboardData object to it
        // ModelAndView modelAndView = new ModelAndView("/admin");
        // modelAndView.addObject("dashboardData", dashboardData);
    
        // return modelAndView;
    }
    @GetMapping("/admin/user/listing")
    public String listUser(Model model){
        List<user> users = (List<user>) repositoryUser.findAll();
        System.out.println(users);
        model.addAttribute("userlisting",users);
        return "listuser";
    }
    @GetMapping("/admin/drink/listing")
    public String listDrink(Model model){
        List<drink> drinks = (List<drink>) repositoryDrink.findAll();
        // System.out.println(drink);
        model.addAttribute("drinklisting",drinks);
        return "listdrink";
    }
    @GetMapping("/admin/user/listing/{id}")
    public String listUserByID(@PathVariable("id") int id, Model model){
        List<user> listuser= (List<user>) repositoryUser.findAll();
        user users = (user) repositoryUser.findById(id);
        model.addAttribute("listuser",listuser);
        model.addAttribute("userlistbyid", users);

        return "listuserbyid";

    }
}
