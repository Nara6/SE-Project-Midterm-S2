package gic.itc.coffee_shop.Security;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;

import gic.itc.coffee_shop.Entity.user;
// import cafe.shop.testing.cafe.shop.entities.Employee;
// import cafe.shop.testing.cafe.shop.repositories.EmployeeRepository;
import gic.itc.coffee_shop.Repository.UserRepo;

public class CustomUserDetailsService implements UserDetailsService {
  
  @Autowired private UserRepo userRepo;

  @Override
  public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
    // System.out.println(email);
    user user = userRepo.findByEmail(email);
    // System.out.println(user.getEmail());
    if (user!=null) {
      return new CustomUserDetails(user);
    }else{
      throw new UsernameNotFoundException("No user found for the given username");
    }

  }

}
