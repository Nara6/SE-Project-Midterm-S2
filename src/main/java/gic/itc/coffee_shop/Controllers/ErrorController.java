package gic.itc.coffee_shop.Controllers;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

import jakarta.servlet.RequestDispatcher;
import jakarta.servlet.http.HttpServletRequest;
@Controller
public class ErrorController implements org.springframework.boot.web.servlet.error.ErrorController{
    @GetMapping("/error")
    public String handleError(HttpServletRequest request) {
        String errorPage = "error"; 
        Object status = request.getAttribute(RequestDispatcher.ERROR_STATUS_CODE);  
        if (status != null) {
            Integer statusCode = Integer.valueOf(status.toString()); 
            if (statusCode == HttpStatus.NOT_FOUND.value()) {
                errorPage = "error/404";
            } else if (statusCode == HttpStatus.FORBIDDEN.value()) {
                errorPage = "error/403";
            } else if (statusCode == HttpStatus.INTERNAL_SERVER_ERROR.value()) {
                errorPage = "error/500"; 
            }
        }
        return errorPage;
    }
     
    // @Override
    // public String getErrorPath() {
    //     return "/error";
    // }
}

 

