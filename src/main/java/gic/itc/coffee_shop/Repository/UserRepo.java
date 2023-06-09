package gic.itc.coffee_shop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.user;

@Repository
public interface UserRepo extends CrudRepository<user,Integer>{
    // List<user> findAll();
    // Optional<user> findById(int id);
    // Optional<user> findByEmail(String email);
    user findByEmail(String email);
    Optional<user> findByPassword(String password);
    user findById(int id);
    @Query("SELECT COUNT(*) FROM user")
    int findAllUser();
    @Query("SELECT u FROM user u where u.user_type_id=2")
    List<user> findAllCashier();
    


    
    
}
