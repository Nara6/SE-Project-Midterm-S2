package gic.itc.coffee_shop.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.invoice;

@Repository
public interface InvoiceRepo extends CrudRepository<invoice,Integer>{
    
    

}