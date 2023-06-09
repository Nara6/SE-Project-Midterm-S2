package gic.itc.coffee_shop.Repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.user_type;

@Repository
public interface UserTypeRepo extends CrudRepository<user_type, Integer> {
    Optional<user_type> findByName(String name);

}



