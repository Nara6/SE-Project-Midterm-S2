// package gic.itc.coffee_shop.Controllers;

// import java.math.BigDecimal;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.stereotype.Controller;
// import org.springframework.web.bind.annotation.ModelAttribute;
// import org.springframework.web.bind.annotation.PostMapping;

// import com.fasterxml.jackson.core.JsonParser;
// import com.fasterxml.jackson.core.JsonProcessingException;
// import com.fasterxml.jackson.databind.ObjectMapper;

// import gic.itc.coffee_shop.Entity.Save;
// import gic.itc.coffee_shop.Entity.temporary;
// import gic.itc.coffee_shop.Repository.DrinkCategoriesRepo;
// import gic.itc.coffee_shop.Repository.OrderRepo;
// import gic.itc.coffee_shop.Repository.TemporaryRepo;

// @Controller
// public class TemporaryController {

//     @Autowired
//     TemporaryRepo tmpRepo;

//     @Autowired
//     OrderRepo orderRepo;

//     @Autowired
//     DrinkCategoriesRepo drinkCategoriesRepo;

//     @PostMapping("/saveOrder")
//     public String saveOrder(@ModelAttribute("save") Save save) {
//         // Process the form data and save the order
//         // You can access the form fields using getter methods of the Save object

//         ObjectMapper objectMapper = new ObjectMapper();
//         try {
//             JsonParser json;
//             Save save = objectMapper.readValue(json, Save.class);
//             // Process the form data and save the order using the save object
            
//             String drinkName = save.getDrinkName();
//             int quantity = save.getQuantity();
//             String size = save.getSize();
//             BigDecimal price = save.getPrice();
    
//             temporary tmp = new temporary();
//             tmp.setDrink_name(drinkName);
//             tmp.setSize(size);
//             tmp.setQuantity(quantity);
//             tmp.setPrice(price);
    
//             // Save the temporary object to the database using tmpRepo
//             tmpRepo.save(tmp);
    
//             return "listDrink";
//         } catch (JsonProcessingException e) {
//             // Handle any JSON processing errors
//             e.printStackTrace();
//             return "error";
//         }

        

//         return "listDrink";
//     }

// }
