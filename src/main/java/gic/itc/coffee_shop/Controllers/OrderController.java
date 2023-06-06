package gic.itc.coffee_shop.Controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.core.type.TypeReference;

// import aj.org.objectweb.asm.TypeReference;
import gic.itc.coffee_shop.Entity.OrderData;
import gic.itc.coffee_shop.Entity.OrderDataList;
import gic.itc.coffee_shop.Entity.drink;
import gic.itc.coffee_shop.Entity.drink_size;
import gic.itc.coffee_shop.Entity.orders;
import gic.itc.coffee_shop.Entity.temporary;
import gic.itc.coffee_shop.Repository.DrinkRepo;
import gic.itc.coffee_shop.Repository.OrderRepo;
import gic.itc.coffee_shop.Repository.SizeRepo;
import gic.itc.coffee_shop.Repository.TemporaryRepo;

@Controller
public class OrderController {
    @Autowired
    OrderRepo orderRepo;

    @Autowired
    DrinkRepo drinkRepo;

    @Autowired
    SizeRepo sizeRepo;

    @Autowired
    TemporaryRepo tmpRepo;

    // @GetMapping("/saveOrder")
    // public Object index() {
    //     return new ModelAndView("welcome");
    // }

    @PostMapping("/cashier/saveorder")
    public String saveOrder(@RequestParam("orderData") String orderDataString) {
        try {
            // Use ObjectMapper to convert the JSON string to a List<OrderData>
            System.out.println(orderDataString);
            ObjectMapper objectMapper = new ObjectMapper();
            List<OrderData> orderDataList = objectMapper.readValue(orderDataString,
                    new TypeReference<List<OrderData>>() {
                    });

            for (OrderData orderData : orderDataList) {
                // Create a new 'orders' object for each order item
                orders order = new orders();
                // temporary tmp = new temporary();
                System.out.println(orderData.getDrinkName());
                // Access individual OrderData object properties
                String drinkName = orderData.getDrinkName();
                String drinkSize = orderData.getSelectedSize();
                BigDecimal price = orderData.getPrice();
                int quantity = orderData.getQuantity();

                //retreive drink name id and size id based on names
                Optional<drink_size> drinkSizeOptional = sizeRepo.findByName(drinkSize);
                Optional<drink> drinkOptional = drinkRepo.findByName(drinkName);
                if (drinkSizeOptional.isPresent() && drinkOptional.isPresent()) {
                    
                    drink_size size = drinkSizeOptional.get();
                    order.setDrink_size_id(size);
                    // tmp.setDrink_size_id(size);

                    drink drink = drinkOptional.get();
                    order.setDrink_id(drink);
                    // tmp.setDrink_id(drink);

                } else {
                    // Handle the case where the category does not exist
                    ModelAndView mav = new ModelAndView("error");
                    mav.addObject("errorMessage", "Invalid category");
                    return "cashier";
                }
                

                order.setDrinkName(drinkName);
                order.setDrinkSize(drinkSize);
                order.setPrice(price);
                order.setQuantity(quantity);

                // tmp.setDrinkName(drinkName);
                // tmp.setDrinkSize(drinkSize);
                // tmp.setPrice(price);
                // tmp.setQuantity(quantity);

                orderRepo.save(order);
                // tmpRepo.save(tmp);
                
            }

            // Redirect to a success page or return a response
        } catch (Exception e) {
            // Handle any exceptions during deserialization
            e.printStackTrace();
            return "redirect:/errorPage";
        }
        
        return "redirect:/cashier/table";

    }
}