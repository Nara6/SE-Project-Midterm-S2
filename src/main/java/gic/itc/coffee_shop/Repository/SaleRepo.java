package gic.itc.coffee_shop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import gic.itc.coffee_shop.Entity.invoice;

@Repository
public interface SaleRepo extends CrudRepository<invoice,Integer>{
    // List<user> findAll();
    // Optional<user> findById(int id);
    // Optional<user> findByEmail(String email);
    // user findByEmail(String email);
    // Optional<user> findByPassword(String password);
    invoice findById(int id);
    List<invoice> findAll();

    @Query("SELECT SUM(total) FROM invoice")
    float findTotalSale();
    
    
}
