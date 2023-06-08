package gic.itc.coffee_shop.Controllers;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.util.Base64;
import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.hibernate.annotations.Tables;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AnonymousAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;


import gic.itc.coffee_shop.Entity.drink;
import gic.itc.coffee_shop.Entity.drink_categories;
import gic.itc.coffee_shop.Entity.tables;
import gic.itc.coffee_shop.Entity.user;
import gic.itc.coffee_shop.Entity.invoice;
import gic.itc.coffee_shop.Entity.user_type;
import gic.itc.coffee_shop.Repository.DrinkCategoriesRepo;
import gic.itc.coffee_shop.Repository.DrinkRepo;
import gic.itc.coffee_shop.Repository.TablesRepo;
import gic.itc.coffee_shop.Repository.UserRepo;
import gic.itc.coffee_shop.Repository.SaleRepo;


@Controller
public class AdminController {
    @Autowired
    DrinkRepo repositoryDrink;
    @Autowired
    UserRepo repositoryUser;
    @Autowired
    DrinkCategoriesRepo repositoryDrinkCategory;
    @Autowired 
    TablesRepo repositoryTable;
    @Autowired 
    SaleRepo repositorySale;

    @GetMapping("/login")
    public String login() {
        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        if(authentication == null || authentication instanceof AnonymousAuthenticationToken){
            return "login";
        }
        return "redirect:/";
    }

                        //User
    // <=========================================>

    // Retrieve allUser
    @GetMapping("/admin/user/listing")
    public String listUser(Model model){
        List<user> users = (List<user>) repositoryUser.findAll();
        System.out.println(users);
        model.addAttribute("listuser",users);
        return "listuser";
    }
    // Retrieve UserByID
    @GetMapping("/admin/user/listing/{id}")
    public String listUserByID(@PathVariable("id") int id, Model model){
        List<user> listuser= (List<user>) repositoryUser.findAll();
        user users = (user) repositoryUser.findById(id);
        model.addAttribute("listuser",listuser);
        model.addAttribute("userlistbyid", users);

        return "listuserbyid";

    }

        // Delete UserbyID
    @GetMapping("/admin/user/delete/{id}")
    public String deleteUserByID(@PathVariable("id") int id){
        repositoryUser.deleteById(id);
        return "redirect:/admin/user/listing";
    }

        // Edit UserByID
    @GetMapping("/admin/user/edit/{id}")
    public String getUserByID(@PathVariable("id") int id, Model model){
        user users = (user) repositoryUser.findById(id);
        model.addAttribute("user", users);

        return "edituser";

    }
    @PostMapping("/admin/user/edit/save/{id}")
    public String editUserByID(@PathVariable("id") int id, @RequestParam("email") String email,
                        @RequestParam("password") String password, 
                        @RequestParam("username") String username,
                        @RequestParam("age") int age, @RequestParam("dob") String dob,
                        @RequestParam("gender") int gender){
        user users = new user();
        // String date = new SimpleDateFormat ("yyyy-MM-dd HH:mm:ss").format(Calendar.getInstance().getTime());
        // LocalDateTime date;
        user findImage = repositoryUser.findById(id);

        LocalDateTime date1 = LocalDateTime.now();
        user_type type = new user_type();
        type.setId(2);
        type.setName("Cashier");
        users.setId(id);
        users.setEmail(email);
        users.setPassword(password);
        users.setUsername(username);
        users.setUser_type_id(type);
        users.setOrderTime(date1);
        users.setImage_url(findImage.getImage_url());
        users.setAge(age);
        users.setDob(dob);
        if(gender==0){
            users.setGender("Male");
        }else{
            users.setGender("Female");
        }

        repositoryUser.save(users);
        return "redirect:/admin/user/listing";
    }
    @GetMapping("/admin/user/create")
    public String createUser(){
        return "addCashier";
    }
    @PostMapping("/admin/user/creating")
    public String addDrink(@RequestParam("name") String name, 
             @RequestParam("email") String email, @RequestParam("password") String password
             ,@RequestParam("gender") int gender, @RequestParam("dob") String dob, @RequestParam("age") int age
             ,@RequestParam("image_url") MultipartFile image_url) {

        LocalDateTime date1 = LocalDateTime.now();
        // String filename = image_url.getOriginalFilename();
        // System.out.println(filename);
        user users = new user();
        user_type type = new user_type();
        type.setId(2);
        type.setName("Cashier");
        users.setEmail(email);
        users.setPassword(password);
        users.setUsername(name);
        users.setAge(age);
        // users.setGender(gender);
        if(gender==0){
            users.setGender("Male");
        }else{
            users.setGender("Female");

        }
        // users.setImage_url(image_url);
        users.setUser_type_id(type);
        users.setOrderTime(date1);
            users.setDob(dob);
        String fileName = StringUtils.cleanPath(image_url.getOriginalFilename());
		if(fileName.contains("..") || fileName.isEmpty())
		{
			System.out.println("not a a valid file");
		}

        try {
            // System.out.println(Base64.getEncoder().encodeToString(image_url.getBytes()));

            users.setImage_url(Base64.getEncoder().encodeToString(image_url.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        

        repositoryUser.save(users);
        return "redirect:/admin/user/listing";
    }


                        //Drink
    // <=========================================>

    // Retrieve allDrink
    @GetMapping("/admin/drink/listing")
    public String listDrink(Model model){
        List<drink> drinks = (List<drink>) repositoryDrink.findAll();
        // System.out.println(drink);
        model.addAttribute("drinklisting",drinks);
        return "listingdrink";
    }
    // Retrieve DrinkByID

    @GetMapping("/admin/drink/listing/{id}")
    public String listDrinkByID(@PathVariable("id") int id, Model model){
        List<drink> listdrink= (List<drink>) repositoryDrink.findAll();
        drink drinks = (drink) repositoryDrink.findById(id);
        model.addAttribute("drinklisting",listdrink);
        model.addAttribute("listdrinkbyid", drinks);

        return "listingdrinkbyid";
    }
    // Delete DrinkbyID
    @GetMapping("/admin/drink/delete/{id}")
    public String deleteDrinkByID(@PathVariable("id") int id){
        repositoryDrink.deleteById(id);
        return "redirect:/admin/drink/listing";
    }
    // Edit UserByID
    @GetMapping("/admin/drink/edit/{id}")
    public String getDrinkByID(@PathVariable("id") int id, Model model){
        List<drink_categories> categories = (List<drink_categories>) repositoryDrinkCategory.findAll();
        drink drink = (drink) repositoryDrink.findById(id);
        model.addAttribute("drink", drink);
        model.addAttribute("category", categories);



        return "editdrink";

    }
    @PostMapping("/admin/drink/edit/save/{id}")
    public String editDrinkByID(@PathVariable("id") int id, @RequestParam("category") int category, @RequestParam("name") String name, @RequestParam("description") String description){
        drink drinks = new drink();
        drink_categories categories = new drink_categories();
        drink findImage = repositoryDrink.findById(id);
        categories.setId(category);
        drinks.setId(id);
        drinks.setName(name);
        drinks.setImage_url(findImage.getImage_url());
        drinks.setDescription(description);
        drinks.setCategory_id(categories);
        repositoryDrink.save(drinks);


        System.out.println(category);
        // repositoryUser.save(users);
        return "redirect:/admin/drink/listing";
    }
    @GetMapping("/admin/drink/create")
    public String createDrink(Model model){
        List<drink_categories> category = (List<drink_categories>) repositoryDrinkCategory.findAll();
        model.addAttribute("category", category);
        return "adddrink";
    }
    @PostMapping("/admin/drink/creating")
    public String addDrink(@RequestParam("name") String name, @RequestParam("description") String description,@RequestParam("category") int category,
             @RequestParam("image_url") MultipartFile image_url) {

        drink drinks = new drink();
        drink_categories categories = new drink_categories();
        categories.setId(category);
        drinks.setName(name);
        drinks.setDescription(description);
        drinks.setCategory_id(categories);
        repositoryDrink.save(drinks);
        String fileName = StringUtils.cleanPath(image_url.getOriginalFilename());
		if(fileName.contains("..") || fileName.isEmpty())
		{
			System.out.println("not a a valid file");
		}
        try {
            // System.out.println(Base64.getEncoder().encodeToString(image_url.getBytes()));

            drinks.setImage_url(Base64.getEncoder().encodeToString(image_url.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        

        repositoryDrink.save(drinks);
        return "redirect:/admin/drink/listing";
    }


                    //Category
    // <=========================================>

    // Retrieve allCategory
    @GetMapping("/admin/category/listing")
    public String listCategory(Model model){
        List<drink_categories> categories = (List<drink_categories>) repositoryDrinkCategory.findAll();
        // System.out.println(users);
        model.addAttribute("listcategory",categories);
        return "listcategory";
    }
    // Retrieve CategoryByID
    @GetMapping("/admin/category/listing/{id}")
    public String listCategoryByID(@PathVariable("id") int id, Model model){
        List<drink_categories> categories = (List<drink_categories>) repositoryDrinkCategory.findAll();
        drink_categories drink_category = (drink_categories) repositoryDrinkCategory.findById(id);
        model.addAttribute("listcategory",categories);
        model.addAttribute("listcategorybyid", drink_category);

        return "listcategorybyid";
    }

    // Delete CategorybyID
    @GetMapping("/admin/category/delete/{id}")
    public String deleteCategoryByID(@PathVariable("id") int id){
        repositoryDrinkCategory.deleteById(id);
        return "redirect:/admin/category/listing";
    }
    // Edit UserByID
    @GetMapping("/admin/category/edit/{id}")
    public String getCategoryByID(@PathVariable("id") int id, Model model){
        drink_categories categories = (drink_categories) repositoryDrinkCategory.findById(id);
        model.addAttribute("category", categories);

        return "editcategory";

    }
    @PostMapping("/admin/category/edit/save/{id}")
    public String editCategoryByID(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("description") String description){
        drink_categories categories = new drink_categories();
        categories.setId(id);
        categories.setName(name);
        categories.setDescription(description);


        repositoryDrinkCategory.save(categories);
        return "redirect:/admin/category/listing";
    }
    @GetMapping("/admin/category/create")
    public String createDrink(){
        return "addcategory";
    }
    @PostMapping("/admin/category/creating")
    public String addCategory(@RequestParam("name") String name, @RequestParam("description") String description,
             @RequestParam("image_url") MultipartFile image_url) {

        drink_categories category = new drink_categories();
        category.setName(name);
        category.setDescription(description);
        String fileName = StringUtils.cleanPath(image_url.getOriginalFilename());
		if(fileName.contains("..") || fileName.isEmpty())
		{
			System.out.println("not a a valid file");
		}
        try {
            // System.out.println(Base64.getEncoder().encodeToString(image_url.getBytes()));

            category.setImage_url(Base64.getEncoder().encodeToString(image_url.getBytes()));
        } catch (IOException e) {
            e.printStackTrace();
        }

        

        repositoryDrinkCategory.save(category);
        return "redirect:/admin/category/listing";
    }


                        //Table
    // <=========================================>
    // Retrieve allTable
    @GetMapping("/admin/table/listing")
    public String listTable(Model model){
        List<tables> tables = (List<tables>) repositoryTable.findAll();
        // System.out.println(users);
        model.addAttribute("listtable",tables);
        return "listtable";
    }

    // Retrieve tableByID
    @GetMapping("/admin/table/listing/{id}")
    public String listTableByID(@PathVariable("id") int id, Model model){
        List<tables> tables = (List<tables>) repositoryTable.findAll();

        tables table = (tables) repositoryTable.findById(id);
        model.addAttribute("listtable",tables);
        model.addAttribute("listtablebyid", table);

        return "listtablebyid";
    }
    // Delete TablebyID
    @GetMapping("/admin/table/delete/{id}")
    public String deleteTableByID(@PathVariable("id") int id){
        repositoryTable.deleteById(id);
        return "redirect:/admin/table/listing";
    }
    // Edit TableByID
    @GetMapping("/admin/table/edit/{id}")
    public String getTableByID(@PathVariable("id") int id, Model model){
        tables table = (tables) repositoryTable.findById(id);
        model.addAttribute("table", table);

        return "edittable";

    }
    @PostMapping("/admin/table/edit/save/{id}")
    public String editTableByID(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("status") int status){
        tables table = new tables();
        table.setId(id);
        table.setName(name);
        System.out.println(status);
        if(status==1){
            table.setStatus(true);
        }else if(status==0){
            table.setStatus(false);
        }
        repositoryTable.save(table);
        return "redirect:/admin/table/listing";
    }
    @GetMapping("/admin/table/create")
    public String createTable(){
        return "addtable";
    }
    @PostMapping("/admin/table/creating")
    public String addCategory(@RequestParam("name") String name,@RequestParam("status") int status) {

        tables table = new tables();
        table.setName(name);
        System.out.println(status);
        if(status==1){
            table.setStatus(true);
        }else if(status==0){
            table.setStatus(false);
        }
        repositoryTable.save(table);

        return "redirect:/admin/table/listing";
    }
                       //Sales
    // <=========================================>
    // Retrieve allSale
    @GetMapping("/admin/sale/listing")
    public String listSale(Model model){
        List<invoice> sales = (List<invoice>) repositorySale.findAll();
        // System.out.println(users);
        model.addAttribute("listsale",sales);
        return "listsale";
    }
    // Retrieve saleByID
    @GetMapping("/admin/sale/listing/{id}")
    public String listSaleByID(@PathVariable("id") int id, Model model){
        List<invoice> sales = (List<invoice>) repositorySale.findAll();

        invoice sale = (invoice) repositorySale.findById(id);
        model.addAttribute("listsale",sales);
        model.addAttribute("listsalebyid", sale);

        return "listsalebyid";
    }
    // Delete SaleByID
    @GetMapping("/admin/sale/delete/{id}")
    public String deleteSaleByID(@PathVariable("id") int id){
        repositorySale.deleteById(id);
        return "redirect:/admin/sale/listing";
    }

}
