package gic.itc.coffee_shop.Controllers;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import org.aspectj.apache.bcel.generic.InvokeInstruction;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;

import gic.itc.coffee_shop.Entity.OrderData;
import gic.itc.coffee_shop.Entity.drink;
import gic.itc.coffee_shop.Entity.drink_size;
import gic.itc.coffee_shop.Entity.invoice;
import gic.itc.coffee_shop.Entity.orders;
import gic.itc.coffee_shop.Entity.tables;
import gic.itc.coffee_shop.Entity.temporary;
import gic.itc.coffee_shop.Entity.user;
import gic.itc.coffee_shop.Repository.DrinkRepo;
import gic.itc.coffee_shop.Repository.InvoiceRepo;
import gic.itc.coffee_shop.Repository.SizeRepo;
import gic.itc.coffee_shop.Repository.TablesRepo;
import gic.itc.coffee_shop.Repository.TemporaryRepo;
import gic.itc.coffee_shop.Repository.UserRepo;

@Controller
public class InvoiceController {
    @Autowired
    InvoiceRepo invoiceRepo;

    @Autowired
    DrinkRepo drinkRepo;

    @Autowired
    SizeRepo sizeRepo;

    @Autowired
    TablesRepo tableRepo;

    @Autowired
    UserRepo userRepo;

    @Autowired
    TemporaryRepo tmpRepo;    

    @PostMapping("/cashier/invoice")
    public String saveOrder(@RequestParam("orderData") String orderDataString,
            @RequestParam("selectedTableId") String selectedTableId,
            @RequestParam("total") String total, @RequestParam("change") String change, @RequestParam("result") String result, @RequestParam("email") String email, Model model) {
        try {
            // Use ObjectMapper to convert the JSON string to a List<OrderData>
            ObjectMapper objectMapper = new ObjectMapper();
            List<OrderData> orderDataList = objectMapper.readValue(orderDataString,
                    new TypeReference<List<OrderData>>() {
                    });

            for (OrderData orderData : orderDataList) {
                // Create a new 'orders' object for each order item
                invoice invoices = new invoice();
                // orders order = new orders();
                temporary tmp = new temporary();

                // Access individual OrderData object properties
                String drinkName = orderData.getDrinkName();
                String drinkSize = orderData.getSelectedSize();
                BigDecimal price = orderData.getPrice();
                int quantity = orderData.getQuantity();

                // //retreive drink name id and size id based on names
                Optional<drink_size> drinkSizeOptional = sizeRepo.findByName(drinkSize);
                Optional<drink> drinkOptional = drinkRepo.findByName(drinkName);

                // Optional<user> userOptional = userRepo.findByEmail(email);

                if (drinkSizeOptional.isPresent() && drinkOptional.isPresent()) {

                    drink_size size = drinkSizeOptional.get();
                    invoices.setDrink_size_id(size);
                    // order.setDrink_size_id(size);
                    tmp.setDrink_size_id(size);

                    drink drink = drinkOptional.get();
                    invoices.setDrink_id(drink);
                    // order.setDrink_id(drink);
                    tmp.setDrink_id(drink);


                } else {
                    // Handle the case where the category does not exist
                    ModelAndView mav = new ModelAndView("error");
                    mav.addObject("errorMessage", "Invalid category");
                    return "table";
                }
                tables table = tableRepo.findById(Integer.parseInt(selectedTableId));
                Optional<user> userOptional = userRepo.findEmailByEmail(email);
                if(userOptional.isPresent()){
                    user users = userOptional.get();
                    invoices.setUser_id(users);;
                }
               


                BigDecimal totalValue = new BigDecimal(total);
                BigDecimal changeValue = new BigDecimal(change);
                BigDecimal cashValue = new BigDecimal(result); //recieved cash from customer

                // Optional<user> userOptional = userRepo.findByEmail("test1@gamil.com");
                // if(userOptional.isPresent()){
                // user users = userOptional.get();

                // invoices.setUsername(users);
                // }

                invoices.setTable_id(table);
                invoices.setDrinkName(drinkName);
                invoices.setDrinkSize(drinkSize);
                invoices.setQuantity(quantity);
                invoices.setPrice(price);
                invoices.setChanged(changeValue);
                invoices.setTotal(totalValue);
                // invoices.setUsername(userOptional.getUsername());
                DateTimeFormatter CUSTOM_FORMATTER = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
                LocalDateTime ldt = LocalDateTime.now();
                String formattedString = ldt.format(CUSTOM_FORMATTER);  
                invoices.setDate(formattedString);

                tmp.setTable_id(table);
                tmp.setDrinkName(drinkName);
                tmp.setDrinkSize(drinkSize);
                tmp.setQuantity(quantity);
                tmp.setChanged(changeValue);
                tmp.setTotal(totalValue);
                tmp.setPrice(price);
                tmp.setCash_received(cashValue);
                

                invoiceRepo.save(invoices);
                tmpRepo.save(tmp);

            }
            // model.addAttribute("invoices", invoices);
            // Redirect to a success page or return a response
            return "redirect:/cashier/receipt";
        } catch (Exception e) {
            // Handle any exceptions during deserialization
            e.printStackTrace();
            return "redirect:/errorPage";
        }
    }

    @GetMapping("/cashier/receipt")
    public String receipt( Model model) {

        List<invoice> invoices = (List<invoice>) invoiceRepo.findAll();
        List<temporary> tmp =  (List<temporary>) tmpRepo.findAll();
        model.addAttribute("receipt", invoices);
        model.addAttribute("invoices", tmp);
        return "receipt";

    
    }

    @PostMapping("/cashier/clearInvoice")
    public String clearTable() {
        // Logic to clear the table in the database
        tmpRepo.deleteAll();
        // tableRepository.clearTable(); // Replace `clearTable()` with the appropriate method in your repository
        
        return "redirect:/cashier/listDrink?category=1"; // Redirect to a success page after clearing the table
    }
    

    

    

}
