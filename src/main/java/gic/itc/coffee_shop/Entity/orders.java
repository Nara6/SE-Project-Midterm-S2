package gic.itc.coffee_shop.Entity;

import java.math.BigDecimal;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "orders")
public class orders {

    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_id", referencedColumnName = "id")
    private drink drink_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drink_size_id", referencedColumnName = "id")
    private drink_size drink_size_id;

    @Column(name = "drinkName")
    private String drinkName;

    @Column(name = "drinkSize")
    private String drinkSize;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "price")
    private BigDecimal price;

    
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public drink getDrink_id() {
        return drink_id;
    }

    public void setDrink_id(drink drink_id) {
        this.drink_id = drink_id;
    }

    public drink_size getDrink_size_id() {
        return drink_size_id;
    }

    public void setDrink_size_id(drink_size drink_size_id) {
        this.drink_size_id = drink_size_id;
    }

    public String getDrinkName() {
        return drinkName;
    }

    public void setDrinkName(String drinkName) {
        this.drinkName = drinkName;
    }

    public String getDrinkSize() {
        return drinkSize;
    }

    public void setDrinkSize(String drinkSize) {
        this.drinkSize = drinkSize;
    }

    public int getQuantity() {
        return quantity;
    }

    public void setQuantity(int quantity) {
        this.quantity = quantity;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    
    


}