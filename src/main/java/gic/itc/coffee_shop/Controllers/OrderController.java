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
        // orders order = new orders();
    try {
        ObjectMapper objectMapper = new ObjectMapper();
            OrderDataList orderDataList = objectMapper.readValue(orderDataString, OrderDataList.class);

            List<OrderData> orderList = orderDataList.getOrderList();
            for (OrderData orderData : orderList) {
                orders order = new orders(); // Create a new 'orders' object for each order item

                // Access individual OrderData object properties
                String drinkName = orderData.getDrinkName();
                String drinkSize = orderData.getDrinkSize();
                BigDecimal price = orderData.getPrice();
                int quantity = orderData.getQuantity();

                order.setPrice(price);
                order.setQuantity(quantity);

                orderRepo.save(order);
    // Process the OrderData object
    // ...
}
        // orderRepo.save(order);
        // Access the properties of the orderData object
        // String productName = orderData.getProductName();
        // int quantity = orderData.getQuantity();
        // ...

        // Process the order data and save it to the database
        // ...

        // Redirect to a success page or return a response
        return "redirect:/welcome";
    } catch (Exception e) {
        // Handle any exceptions during deserialization
        // ...
        return "redirect:/errorPage";
    }
}
}
