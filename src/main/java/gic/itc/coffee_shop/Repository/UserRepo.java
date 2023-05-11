package gic.itc.coffee_shop.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.user;

@Repository
public interface UserRepo extends CrudRepository<user,Integer>{
    Optional<user> findByEmail(String email);
    Optional<user> findByPassword(String password);
    
}
