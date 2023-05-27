package gic.itc.coffee_shop.Controllers;

import java.math.BigDecimal;
import java.util.List;

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
import gic.itc.coffee_shop.Entity.orders;
import gic.itc.coffee_shop.Repository.OrderRepo;


@Controller
public class OrderController {
    @Autowired
    OrderRepo orderRepo;

    @GetMapping("/saveOrder")
    public Object index() {
        return new ModelAndView("welcome");
    }

    @PostMapping("/saveOrder")
    public String saveOrder(@RequestParam("orderData") String orderDataString) {
        try {
            // Use ObjectMapper to convert the JSON string to a List<OrderData>
            ObjectMapper objectMapper = new ObjectMapper();
            List<OrderData> orderDataList = objectMapper.readValue(orderDataString, new TypeReference<List<OrderData>>() {});
    
            for (OrderData orderData : orderDataList) {
                // Create a new 'orders' object for each order item
                orders order = new orders();
    
                // Access individual OrderData object properties
                String drinkName = orderData.getDrinkName();
                String drinkSize = orderData.getSelectedSize();
                BigDecimal price = orderData.getPrice();
                int quantity = orderData.getQuantity();
    
                order.setDrinkName(drinkName);
                order.setDrinkSize(drinkSize);
                order.setPrice(price);
                order.setQuantity(quantity);
    
                orderRepo.save(order);
            }
    
            // Redirect to a success page or return a response
            return "redirect:/welcome";
        } catch (Exception e) {
            // Handle any exceptions during deserialization
            e.printStackTrace();
            return "redirect:/errorPage";
        }
    }   
}