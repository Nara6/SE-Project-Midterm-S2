package gic.itc.coffee_shop.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.orders;
import gic.itc.coffee_shop.Entity.temporary;

@Repository
public interface TemporaryRepo extends CrudRepository<temporary,Integer>{
   

}
