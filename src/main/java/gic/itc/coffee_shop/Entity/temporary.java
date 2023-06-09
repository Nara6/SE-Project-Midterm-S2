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
@Table(name = "temporary")
public class temporary {

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

    @ManyToOne
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private tables table_id;

    @ManyToOne
    @JoinColumn(name = "username", referencedColumnName = "id")
    private user username;

    @Column(name = "price")
    private BigDecimal price;

    @Column(name = "cash_received")
    private BigDecimal cash_received;

    
    public user getUsername() {
        return username;
    }

    public void setUsername(user username) {
        this.username = username;
    }

    @Column(name = "drinkName")
    private String drinkName;

    @Column(name = "drinkSize")
    private String drinkSize;

    @Column(name = "quantity")
    private int quantity;

    @Column(name = "total")
    private BigDecimal total;

    @Column(name = "changed")
    private BigDecimal changed;

    public BigDecimal getChanged() {
        return changed;
    }

    public void setChanged(BigDecimal changed) {
        this.changed = changed;
    }

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

    public tables getTable_id() {
        return table_id;
    }

    public void setTable_id(tables table_id) {
        this.table_id = table_id;
    }

    public BigDecimal getTotal() {
        return total;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public BigDecimal getCash_received() {
        return cash_received;
    }

    public void setCash_received(BigDecimal cash_received) {
        this.cash_received = cash_received;
    }

}