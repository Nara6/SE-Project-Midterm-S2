package gic.itc.coffee_shop.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import gic.itc.coffee_shop.Entity.orders;

@Repository
public interface OrderRepo extends CrudRepository<orders,Integer>{
    @Query("SELECT COUNT(*) FROM invoice")
    int totalServe();

}
