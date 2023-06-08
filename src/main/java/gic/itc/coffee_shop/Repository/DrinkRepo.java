package gic.itc.coffee_shop.Repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import gic.itc.coffee_shop.Entity.drink;

@Repository
public interface DrinkRepo extends CrudRepository<drink, Integer> {
    // int getCategoryIDByName(String categoryName);
    Optional<drink> findByName(String name);
    @Query("SELECT d FROM drink_categories dc JOIN drink d On dc.id = d.category_id where dc.id=:category_id")
    List<drink> findByCategory_id(@Param("category_id") int category_id);
    Iterable<drink> findAllById(int id);
    drink findById(int id);
    @Query("SELECT COUNT(*) FROM drink")
    int totalDrink();

    // retrieve a list of drinks that belong to a specific category.
    // @Query("SELECT d FROM drink_categories dc JOIN drink d On dc.id = d.category_id where dc.id=:category_id")
    // List<drink> findByCategory_id(@Param("category_id") int category_id);
    // @Query("SELECT d FROM drink d WHERE d.category.id = :category_id")
    

}
