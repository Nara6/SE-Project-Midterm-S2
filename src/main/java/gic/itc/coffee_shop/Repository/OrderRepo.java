package gic.itc.coffee_shop.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.orders;

@Repository
public interface OrderRepo extends CrudRepository<orders,Integer>{
    //we need this inorder for drink to access drink cat to find it by name 
    // Optional<or> findByName(String name);
    
    

}
