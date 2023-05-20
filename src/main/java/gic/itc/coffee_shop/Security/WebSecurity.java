// package gic.itc.coffee_shop.Security;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.context.annotation.Bean;
// import org.springframework.context.annotation.Configuration;
// import org.springframework.security.authentication.AuthenticationManager;
// import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
// import org.springframework.security.config.annotation.web.builders.HttpSecurity;
// import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
// import org.springframework.security.config.annotation.web.configuration.WebSecurityCustomizer;
// import org.springframework.security.config.http.SessionCreationPolicy;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
// import org.springframework.security.web.SecurityFilterChain;

// // import gic.itc.coffee_shop.util.JwtRequestFilter;

// @Configuration
// // @EnableWebSecurity
// // public class WebSecurity extends WebSecurityConfigurerAdapter{
// //     @Override
// //     public void configure(HttpSecurity http) throws Exception{
// //         http.csrf().disable();
// //         http.authorizeHttpRequests().anyRequest().permitAll();
// //         http.sessionManagement().sessionCreationPolicy(SessionCreationPolicy.STATELESS);
// //     }
// // }
// public class WebSecurity{
//     @Bean
//     public UserDetailsService userDetailsService(){
//         return new UserDetailsService();
//     }
//     @Bean
//     public BCryptPasswordEncoder passwordEncoder() {
//         return new BCryptPasswordEncoder();
//     }
//     @Bean
//     public SecurityFilterChain filterChain(HttpSecurity http) throws Exception {
     
//         http.authorizeRequests().antMatchers("/login").permitAll()
//                 .antMatchers("/users/**", "/settings/**").hasAuthority("Admin")
//                 .hasAnyAuthority("Admin", "Editor", "Salesperson")
//                 .hasAnyAuthority("Admin", "Editor", "Salesperson", "Shipper")
//                 .anyRequest().authenticated()
//                 .and().formLogin()
//                 .loginPage("/login")
//                     .usernameParameter("email")
//                     .permitAll()
//                 .and()
//                 .rememberMe().key("AbcdEfghIjklmNopQrsTuvXyz_0123456789")
//                 .and()
//                 .logout().permitAll();
 
//         http.headers().frameOptions().sameOrigin();
 
//         return http.build();
//     }
 
//     @Bean
//     public WebSecurityCustomizer webSecurityCustomizer() {
//         return (web) -> web.ignoring().antMatchers("/images/**", "/js/**", "/webjars/**");
//     }
// }
