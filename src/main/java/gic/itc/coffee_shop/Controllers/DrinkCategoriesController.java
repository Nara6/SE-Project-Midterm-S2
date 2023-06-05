package gic.itc.coffee_shop.Controllers;

import java.io.File;
import java.util.ArrayList;
import java.util.Base64;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.view.RedirectView;

import ch.qos.logback.core.model.Model;
import gic.itc.coffee_shop.Entity.drink_categories;
import gic.itc.coffee_shop.Repository.DrinkCategoriesRepo;
import gic.itc.coffee_shop.Repository.DrinkRepo;

@Controller
public class DrinkCategoriesController {
    @Autowired
    DrinkCategoriesRepo Repo;

    @GetMapping("/addDrinkCategory")
    public Object index2() {
        return new ModelAndView("cruddrink");
    }

    // @PostMapping("/category")
    // public String category(Model model) {
    // List<drink_categories> categories = Repo.findAll();
    // model.addAttribute("categories", categories);

    // return "listDrink";
    // }

    // get all categories
    @GetMapping("/categories")
    public ModelAndView showCategories() {
        List<drink_categories> categories = (List<drink_categories>) Repo.findAll();
        ModelAndView mav = new ModelAndView("listDrink");
        mav.addObject("categories", categories);
        return mav;
    }

    @GetMapping("/drinkCategories")
    // ResponseEntity is HTTP resposne of user by server
    public ResponseEntity<List<drink_categories>> getAllDrinkCategories() {
        try {
            List<drink_categories> dc = new ArrayList<drink_categories>();
            // fetch all user from database and add a new user to a list
            Repo.findAll().forEach(dc::add);
            if (dc.isEmpty()) {
                return new ResponseEntity<List<drink_categories>>(HttpStatus.NO_CONTENT);
            }
            return new ResponseEntity<>(dc, HttpStatus.OK);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @GetMapping("/drinkCategories/{id}")
    // public ResponseEntity<drink_categories> getDrinkCategoriesByID(@PathVariable("id") int id) {
    //     try {
    //         Optional<drink_categories> dc = Repo.findById(id);

    //         if (dc.isPresent()) {
    //             return new ResponseEntity<>(dc.get(), HttpStatus.OK);
    //         } else {
    //             return new ResponseEntity<>(HttpStatus.NOT_FOUND);
    //         }
    //     } catch (Exception e) {
    //         return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
    //     }
    // }

    // create drink but it doesnt work when i uncomment the drink_categories entity
    // list in getter setter
    @PostMapping("/drinkCategories")
    public ResponseEntity<drink_categories> addDrnkCategories(@RequestBody drink_categories dc) {
        try {
            // userService.createUser(users);
            System.out.println(dc.getName());
            Repo.save(dc);
            return new ResponseEntity<>(dc, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // add new drink category interaction with UI
    @PostMapping("/addDrinkCategory")
    @ResponseBody
    public ModelAndView addDrinkCategory(@ModelAttribute("dc") drink_categories dc,
            @RequestParam("image1") MultipartFile limage) {
        if (dc.getName() == null) {
            // Handle case where required fields are missing
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("errorMessage", "Name and description are required");
            return mav;
        }

        try {

            String fileName = limage.getOriginalFilename();
            // if fileName is "C:/path/to/my_image.jpg", then cleanFileName will contain
            // "my_image.jpg", which is the extracted filename from the file path.
            String cleanFileName = new File(fileName).getName();
            if (cleanFileName.contains("..")) {
                System.out.println("not a valid file");
            }

            dc.setImage_url(Base64.getEncoder().encodeToString(limage.getBytes()));

            Repo.save(dc); // Save the drink category to the database
            return new ModelAndView("cruddrink");
        } catch (Exception e) {
            // Handle any exceptions that occur during database operation
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("errorMessage", "Error saving drink category");
            return mav;
        }
    }

    @PostMapping("/cancelAddDrinkCategory")
    @ResponseBody
    public Object cancelDrinkCategory() {
        return new ModelAndView("cruddrink");
    }

}
