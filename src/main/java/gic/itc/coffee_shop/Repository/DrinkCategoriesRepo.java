package gic.itc.coffee_shop.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.drink_categories;

@Repository
public interface DrinkCategoriesRepo extends CrudRepository<drink_categories,Integer>{
    
}
