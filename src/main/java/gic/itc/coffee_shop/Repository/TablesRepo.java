package gic.itc.coffee_shop.Repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.tables;

@Repository
public interface TablesRepo extends CrudRepository<tables,Integer>{
    tables findById(int id);
}
