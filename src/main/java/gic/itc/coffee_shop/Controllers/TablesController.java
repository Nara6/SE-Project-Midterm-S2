package gic.itc.coffee_shop.Controllers;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import gic.itc.coffee_shop.Entity.tables;
import gic.itc.coffee_shop.Repository.TablesRepo;

@Controller
public class TablesController {
    @Autowired
    TablesRepo tablesRepo;

    @GetMapping("/")
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
}
