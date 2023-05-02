package gic.itc.coffee_shop.Controllers;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

@RestController
public class CafeController {
    @GetMapping("/")
    public Object index(){
        return new ModelAndView("loginform");
    }
}
