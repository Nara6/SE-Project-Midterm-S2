package gic.itc.coffee_shop.Security;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserCache;
import org.springframework.security.web.authentication.logout.LogoutHandler;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;

public class CustomLogoutHandler implements LogoutHandler {


    @Override
    public void logout(HttpServletRequest request, HttpServletResponse response, 
      Authentication authentication) {
        SecurityContextHolder.clearContext();
        try{
            response.sendRedirect("/logout");
        }catch(Exception e){
            System.out.println(e.getMessage());
        }
        
    }
}
