package gic.itc.coffee_shop.Controllers;

import java.util.Optional;

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

    @GetMapping("/cashier/table")
    public String getAllTables(Model model) {
        try {
            // List<tables> tables = new ArrayList<tables>();
            // // tables = tablesRepo.findAll();
            model.addAttribute("listtables", tablesRepo.findAll());
            return "table";
            // if(tables.isEmpty()){
            // return new ResponseEntity<List<tables>>(HttpStatus.NO_CONTENT);
            // }
            // return new ResponseEntity<>(tables, HttpStatus.OK);
        } catch (Exception e) {
            return "redirect:/";
        }
    }

    @GetMapping("/cashier/calculate")
    public String Calculate() {

        return "calculateprice";

    }

    @PostMapping("/cashier/calculate")
    public String index(@RequestParam(name = "confirm") String confirm,
            @RequestParam(name = "tableId") String selectedTableId) {
        // Handle form submission
        if (confirm.equalsIgnoreCase("OK")) {
            tables optionalTable = tablesRepo.findById(Integer.parseInt(selectedTableId));
            if (optionalTable != null) {
                tables table = optionalTable;
                table.setStatus(false);
                ;
                tablesRepo.save(table);
                // Perform calculations or other logic
                return "calculateprice";
            } else {
                // Handle table not found scenario
                return "redirect:/table";
            }
        } else {
            // Handle cancel action or other scenarios
            return "redirect:/table";
        }
    }

}
