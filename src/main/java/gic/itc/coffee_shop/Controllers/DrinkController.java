package gic.itc.coffee_shop.Controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

// import ch.qos.logback.core.model.Model;
import gic.itc.coffee_shop.Entity.drink;
import gic.itc.coffee_shop.Entity.drink_categories;
import gic.itc.coffee_shop.Entity.drink_size;
import gic.itc.coffee_shop.Repository.DrinkCategoriesRepo;
import gic.itc.coffee_shop.Repository.DrinkRepo;

@RestController
public class DrinkController {
    @Autowired
    DrinkRepo drinkRepo;

    @Autowired
    DrinkCategoriesRepo drinkCategoryRepo;

    @PostMapping("/addDrink")
    public ModelAndView addDrink(@RequestParam("name") String name, @RequestParam("categoryName") String categoryName,
            @RequestParam("description") String description, @RequestParam("image_url") String image_url) {
        try {
            drink drink = new drink();
            drink.setName(name);

        // Get the category ID based on the category name
            Optional<drink_categories> categoryOptional = drinkCategoryRepo.findByName(categoryName);
            if (categoryOptional.isPresent()) {
            drink_categories category = categoryOptional.get();
            drink.setCategory_id(category);
        } else {
            // Handle the case where the category does not exist
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("errorMessage", "Invalid category");
            return mav;
        }

        // Set the price of the drink
        drink.setDescription(description);
        drink.setImage_url(image_url);
        
        drinkRepo.save(drink);
        // return new ModelAndView("welcome");
        ModelAndView mav = new ModelAndView("welcome");
        mav.addObject("drink", drink); // Add the drink object to the model with the attribute name "drink"
        return mav;
        }catch (Exception e) {
            // Handle any exceptions that occur during database operation
            ModelAndView mav = new ModelAndView("error");
            mav.addObject("errorMessage", "Error saving drink category");
            return mav;
        }

        
    }
    @GetMapping("/drink/{category_id}")
    public ResponseEntity<List<drink>> findDrinkByCategoiesId(@PathVariable("category_id") int id){
        try{
            List<drink> Drink= new ArrayList<drink>();
            drinkRepo.findByCategory_id(id).forEach(Drink::add);
            if(Drink.isEmpty()){
                return new ResponseEntity<List<drink>>(HttpStatus.NO_CONTENT);

            }
            return new ResponseEntity<>(Drink, HttpStatus.OK);
        }catch(Exception e){
            return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    // @PostMapping("/signup")
    // @ResponseBody
    // public Object task3(@ModelAttribute("Drink") drink Drink, Model model) {
    // if (Drink.getName() == null ) {
    // // Handle case where required fields are missing
    // ModelAndView mav = new ModelAndView("error");
    // mav.addObject("errorMessage", "Name and description are required");
    // return mav;
    // }

    // try {
    // Repo.save(dc); // Save the drink category to the database
    // return new ModelAndView("welcome");
    // } catch (Exception e) {
    // // Handle any exceptions that occur during database operation
    // ModelAndView mav = new ModelAndView("error");
    // mav.addObject("errorMessage", "Error saving drink category");
    // return mav;
    // }
    // }
}
