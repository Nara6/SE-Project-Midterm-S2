package gic.itc.coffee_shop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.drink;
import gic.itc.coffee_shop.Entity.drink_size;

@Repository
public interface SizeRepo extends CrudRepository<drink_size, Integer> {
   
    Optional<drink_size> findByName(String name);

   
    

}
