package gic.itc.coffee_shop.Repository;


import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;


import gic.itc.coffee_shop.Entity.drink_categories;

@Repository
public interface DrinkCategoriesRepo extends CrudRepository<drink_categories,Integer>{
    //we need this inorder for drink to access drink cat to find it by name 
    Optional<drink_categories> findByName(String name);
    drink_categories findById(int id);
    
    

}

