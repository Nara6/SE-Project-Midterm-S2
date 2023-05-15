package gic.itc.coffee_shop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.drink;

@Repository
public interface DrinkRepo extends CrudRepository<drink,Integer>{
    // int getCategoryIDByName(String categoryName);
    Optional<drink> findByName(String name);

    //retrieve a list of drinks that belong to a specific category.
    // List<drink> findByCategory_id(int category_id);

   
}
