// package gic.itc.coffee_shop.Controllers;

// import java.io.File;
// import java.io.IOException;
// import java.util.ArrayList;
// import java.util.Base64;
// import java.util.List;
// import java.util.Optional;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.http.HttpStatus;
// import org.springframework.http.ResponseEntity;
// import org.springframework.stereotype.Controller;
// import org.springframework.ui.Model;
// import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.PostMapping;
// import org.springframework.web.bind.annotation.RequestParam;
// import org.springframework.web.bind.annotation.ResponseBody;
// import org.springframework.web.bind.annotation.RestController;
// import org.springframework.web.multipart.MultipartFile;
// import org.springframework.web.servlet.ModelAndView;

// import gic.itc.coffee_shop.Entity.drink;
// import gic.itc.coffee_shop.Entity.drink_categories;
// import gic.itc.coffee_shop.Entity.drink_size;
// import gic.itc.coffee_shop.Repository.DrinkCategoriesRepo;
// import gic.itc.coffee_shop.Repository.DrinkRepo;

// @Controller
// public class DrinkController {
//     @Autowired
//     DrinkRepo drinkRepo;

//     @Autowired
//     DrinkCategoriesRepo drinkCategoryRepo;

//     @GetMapping("/addDrink")
//     public Object index() {
//         return new ModelAndView("cruddrink");
//     }

//     @PostMapping("/addDrink")
//     public ModelAndView addDrink(@RequestParam("name") String name, @RequestParam("categoryName") String categoryName,
//             @RequestParam("description") String description, @RequestParam("image") MultipartFile limage) {
//         try {
//             drink drink = new drink();
//             drink.setName(name);
//             String fileName = limage.getOriginalFilename();
//             // if fileName is "C:/path/to/my_image.jpg", then cleanFileName will contain
//             // "my_image.jpg", which is the extracted filename from the file path.
//             String cleanFileName = new File(fileName).getName();
//             if (cleanFileName.contains("..")) {
//                 System.out.println("not a valid file");
//             }
//             try {
//                 drink.setImage_url(Base64.getEncoder().encodeToString(limage.getBytes()));
//             } catch (IOException e) {
//                 e.printStackTrace();
//             }

//             // Get the category ID based on the category name
//             Optional<drink_categories> categoryOptional = drinkCategoryRepo.findByName(categoryName);
//             if (categoryOptional.isPresent()) {
//                 drink_categories category = categoryOptional.get();
//                 drink.setCategory_id(category);
//             } else {
//                 // Handle the case where the category does not exist
//                 ModelAndView mav = new ModelAndView("error");
//                 mav.addObject("errorMessage", "Invalid category");
//                 return mav;
//             }

//             // Set the price of the drink
//             drink.setDescription(description);
//             drinkRepo.save(drink);
//             // return new ModelAndView("welcome");
//             ModelAndView mav = new ModelAndView("welcome");
//             mav.addObject("drink", drink); // Add the drink object to the model with the attribute name "drink"
//             return mav;
//         } catch (Exception e) {
//             // Handle any exceptions that occur during database operation
//             ModelAndView mav = new ModelAndView("error");
//             mav.addObject("errorMessage", "Error saving drink category");
//             return mav;
//         }
//     }
//     @GetMapping("/drink/{category_id}")
//     public ResponseEntity<List<drink>> findDrinkByCategoiesId(@PathVariable("category_id") int id){
//         try{
//             List<drink> Drink= new ArrayList<drink>();
//             drinkRepo.findByCategory_id(id).forEach(Drink::add);
//             if(Drink.isEmpty()){
//                 return new ResponseEntity<List<drink>>(HttpStatus.NO_CONTENT);

//             }
//             return new ResponseEntity<>(Drink, HttpStatus.OK);
//         }catch(Exception e){
//             return new ResponseEntity<>(null,HttpStatus.INTERNAL_SERVER_ERROR);
//         }
//     }

//     // @GetMapping("/listDrink")
//     // public Object index1() {
//     //     return new ModelAndView("listDrink");
//     // }

//     @GetMapping("/listDrink")
//     public String getDrinksByCategory(@RequestParam("category") int categoryId, Model model) {
//     List<drink> drinks = drinkRepo.findByCategory_id(categoryId);
//     model.addAttribute("drinks", drinks);
//     List<drink_categories> categories = (List<drink_categories>) drinkCategoryRepo.findAll();
//     model.addAttribute("categories",categories);

//     return "listDrink";
// }


//     // display drink according to it's category
//     // @PostMapping("/listDrink")
//     // public String getDrinksByCategory(@RequestParam String category, Model model) {
//     //     int categoryId;
//     //     if (category.equalsIgnoreCase("hots")) {
//     //         drink_categories drinkCategory = drinkCategoryRepo.findByName("hots")
//     //                 .orElseThrow(() -> new IllegalArgumentException("Invalid category: " +
//     //                         category));
//     //         categoryId = drinkCategory.getId();
//     //     } else if (category.equalsIgnoreCase("cold")) {
//     //         drink_categories drinkCategory = drinkCategoryRepo.findByName("cold")
//     //                 .orElseThrow(() -> new IllegalArgumentException("Invalid category: " +
//     //                         category));
//     //         categoryId = drinkCategory.getId();
//     //     } else {
//     //         // Handle invalid category
//     //         throw new IllegalArgumentException("Invalid category: " + category);
//     //     }

//     //     List<drink> drinks = drinkRepo.findByCategory_id(categoryId);
//     //     model.addAttribute("drinks", drinks);

//     //     return "listDrink";
//     // }

//     // @PostMapping("/listDrink")
//     // public String getDrinksByCategory(@RequestParam String category, Model model)
//     // {
//     // drink_categories drinkCategory;
//     // if (category.equalsIgnoreCase("hots")) {
//     // drinkCategory = drinkCategoryRepo.findByName("hots")
//     // .orElseThrow(() -> new IllegalArgumentException("Invalid category: " +
//     // category));
//     // } else if (category.equalsIgnoreCase("cold")) {
//     // drinkCategory = drinkCategoryRepo.findByName("cold")
//     // .orElseThrow(() -> new IllegalArgumentException("Invalid category: " +
//     // category));
//     // } else {
//     // // Handle invalid category
//     // throw new IllegalArgumentException("Invalid category: " + category);
//     // }

//     // List<drink> drink = drinkRepo.findByCategory_id(drinkCategory.getId());
//     // model.addAttribute("drink", drink);

//     // return "listDrink";
//     // }

// }

