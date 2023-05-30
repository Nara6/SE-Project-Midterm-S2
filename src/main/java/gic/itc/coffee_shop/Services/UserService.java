// package gic.itc.coffee_shop.Services;

// import org.springframework.beans.factory.annotation.Autowired;
// import org.springframework.security.core.userdetails.UserDetails;
// import org.springframework.security.core.userdetails.UserDetailsService;
// import org.springframework.security.core.userdetails.UsernameNotFoundException;
// import org.springframework.stereotype.Service;

// import gic.itc.coffee_shop.Entity.user;
// import gic.itc.coffee_shop.Repository.UserRepo;

// @Service
// public class UserService implements UserDetailsService{
    
//     final UserRepo userRepo;
//     public UserService(UserRepo userRepo){
//         this.userRepo = userRepo;
//     }
//     @Override
//     UserDetails loadUserByEmail(String email) throws UsernameNotFoundException{
//         boolean User = userRepo.findUserByEmail(email);
//         if(User){
//             throw new UsernameNotFoundException(email);
//         }else{
//             return new user();
//         }

//     }
// }
