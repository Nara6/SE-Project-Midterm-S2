package gic.itc.coffee_shop.Controllers;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import gic.itc.coffee_shop.Entity.OrderData;
import gic.itc.coffee_shop.Entity.orders;
import gic.itc.coffee_shop.Entity.tables;
import gic.itc.coffee_shop.Entity.temporary;
import gic.itc.coffee_shop.Repository.TablesRepo;

@Controller
public class TablesController {
    @Autowired
    TablesRepo tablesRepo;

    @GetMapping("/table")
    public String getAllTables(Model model) {
        try{
            // List<tables> tables = new ArrayList<tables>();
            // // tables = tablesRepo.findAll();
            model.addAttribute("listtables", tablesRepo.findAll());
            return "table";
        //     if(tables.isEmpty()){
        //         return new ResponseEntity<List<tables>>(HttpStatus.NO_CONTENT);
        //     }
        //     return new ResponseEntity<>(tables, HttpStatus.OK);
        }catch(Exception e){
            return "redirect:/";
        }
    }

    @GetMapping("/calculate")
    public String Calculate() {

        return "calculateprice";
       
    }

    @PostMapping("/calculate")
    public Object index(@RequestParam(name ="confirm") String confirm) {
        // Handle form submission
        if (confirm.equalsIgnoreCase("OK")) {
        // Perform calculations or other logic
        return new ModelAndView("calculateprice");
    } else {
        // Handle cancel action or other scenarios
        return new ModelAndView("redirect:/table");
    }
    }

    // @PostMapping("/sum")
    // public String saveOrder(@RequestParam("orderData") String orderDataString, Model model) {
    //     try {
    //         // Use ObjectMapper to convert the JSON string to a List<OrderData>
    //         ObjectMapper objectMapper = new ObjectMapper();
    //         List<OrderData> orderDataList = objectMapper.readValue(orderDataString,
    //                 new TypeReference<List<OrderData>>() {
    //                 });

            
    //         BigDecimal totalPrice = BigDecimal.ZERO;

    //         for (OrderData orderData : orderDataList) {
    //             // Access individual OrderData object properties
    //             BigDecimal price = orderData.getPrice();
    //             int quantity = orderData.getQuantity();

    //             // Calculate the total price for each order item
    //             BigDecimal itemTotal = price.multiply(BigDecimal.valueOf(quantity));
    //             totalPrice = totalPrice.add(itemTotal);
    //         }

    //         // Add the totalPrice as an attribute to the model
    //         model.addAttribute("totalPrice", totalPrice);

    //         // Redirect to a success page or return a response
    //         return "calculateprice";
    //     } catch (Exception e) {
    //         // Handle any exceptions during deserialization
    //         e.printStackTrace();
    //         return "tables";
    //     }
    // }

}

