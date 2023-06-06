package gic.itc.coffee_shop.Entity;

import java.util.ArrayList;
import java.util.List;

import org.springframework.data.jpa.repository.Lock;

import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import com.fasterxml.jackson.databind.deser.AbstractDeserializer;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Lob;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;

@Entity
@Table(name = "drink_categories")
public class drink_categories {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Lob
    @Column(name = "image_url", length = 111119000)
    private String image_url;

    @OneToMany(mappedBy = "category_id", cascade = CascadeType.ALL)
    // @JsonDeserialize(using = AbstractDeserializer.class)
    private List<drink> drinks;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public List<drink> getDrinks() {
        return drinks;
    }

    public void setDrinks(List<drink> drinks) {
        this.drinks = drinks;
    }

    // public List<drink> getDrink() {
    // return drink;
    // }

    // public void setDrink(List<drink> drink) {
    // this.drink = drink;
    // }

}
