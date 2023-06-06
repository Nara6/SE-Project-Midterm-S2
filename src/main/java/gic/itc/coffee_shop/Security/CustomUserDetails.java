package gic.itc.coffee_shop.Security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

// import cafe.shop.testing.cafe.shop.entities.User;
import gic.itc.coffee_shop.Entity.user;
import gic.itc.coffee_shop.Entity.user_type;

public class CustomUserDetails implements UserDetails {
  private user Usr;

  public CustomUserDetails(user u) {
    this.Usr = u;
  }

  @Override
  public Collection<? extends GrantedAuthority> getAuthorities() {
    // Set<Role> roles = user.getRoles();
    List<SimpleGrantedAuthority> authorities = new ArrayList<>();
    authorities.add(new SimpleGrantedAuthority(Usr.getUser_type_id().getName()));
    return authorities;
  }

  // public boolean hasRole(String roleName) {
  //   return this.emp.hasRole(roleName);
  // }

  @Override
  public String getPassword() {
    return Usr.getPassword();
  }

  @Override
  public String getUsername() {
    return Usr.getEmail();
  }
  
  public boolean hasRole(String role){
    return this.Usr.hasRole(role);
  } 

  @Override
  public boolean isAccountNonExpired() {
    return true;
  }

  @Override
  public boolean isAccountNonLocked() {
    return true;
  }

  @Override
  public boolean isCredentialsNonExpired() {
    return true;
  }

  @Override
  public boolean isEnabled() {
    return true;
  }

}
