package gic.itc.coffee_shop.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.user;

@Repository
public interface UserRepo extends CrudRepository<user,Integer>{
    
}
