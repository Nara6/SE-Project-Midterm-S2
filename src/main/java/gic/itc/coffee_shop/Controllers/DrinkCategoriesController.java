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

import gic.itc.coffee_shop.Entity.drink_categories;
import gic.itc.coffee_shop.Repository.DrinkCategoriesRepo;

@RestController
public class DrinkCategoriesController {
    @Autowired
    DrinkCategoriesRepo Repo;

    // @Autowired
    // DrinkCategoriesRepo Repo;
    
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

    @GetMapping("/drinkCategories/{id}")
    public ResponseEntity<drink_categories> getDrinkCategoriesByID(@PathVariable("id") int id) {
        try {
            Optional<drink_categories> dc = Repo.findById(id);

            if (dc.isPresent()) {
                return new ResponseEntity<>(dc.get(), HttpStatus.OK);
            } else {
                return new ResponseEntity<>(HttpStatus.NOT_FOUND);
            }
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }


    //create drink but it doesnt work when i uncomment the drink_categories entity list in getter setter 
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
}
