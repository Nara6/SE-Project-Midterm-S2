package gic.itc.coffee_shop.Entity;

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
@Table(name = "drink")
public class drink {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "description")
    private String description;

    @Column(name = "image_url")
    private String image_url;

    // @OneToOne(cascade = CascadeType.ALL)
    // @JoinColumn(name = "category_id", referencedColumnName = "id")
    // private drink_categories d_categories;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "category_id")
    private drink_categories category_id;

    @OneToMany(mappedBy = "drink_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<order_details> orderDetails;

    

    public List<order_details> getOrderDetails() {
        return orderDetails;
    }

    public void setOrderDetails(List<order_details> orderDetails) {
        this.orderDetails = orderDetails;
    }

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

    public drink_categories getCategory_id() {
        return category_id;
    }

    public void setCategory_id(drink_categories category_id) {
        this.category_id = category_id;
    }

}
