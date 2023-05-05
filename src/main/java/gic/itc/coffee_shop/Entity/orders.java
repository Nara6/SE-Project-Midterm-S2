package gic.itc.coffee_shop.Entity;

import java.security.Timestamp;
import java.util.List;
import java.util.Set;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
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

    @ManyToOne
    @JoinColumn(name = "user_id", referencedColumnName = "id")
    private user user;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "table_id", referencedColumnName = "id")
    private tables tables;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<order_details> orderDetails;

    @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<history> history;

    public List<history> getHistory() {
        return history;
    }

    public void setHistory(List<history> history) {
        this.history = history;
    }

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private Timestamp orderTime;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public user getUser() {
        return user;
    }

    public void setUser(user user) {
        this.user = user;
    }

    public tables getTables() {
        return tables;
    }

    public void setTables(tables tables) {
        this.tables = tables;
    }

    public Timestamp getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(Timestamp orderTime) {
        this.orderTime = orderTime;
    }

}
