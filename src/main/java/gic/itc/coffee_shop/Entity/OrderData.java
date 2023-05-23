package gic.itc.coffee_shop.Entity;

import java.math.BigDecimal;

public class OrderData {
    private String drinkName;
    private String drinkSize;
    private int quantity;
    private BigDecimal price;
    
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
