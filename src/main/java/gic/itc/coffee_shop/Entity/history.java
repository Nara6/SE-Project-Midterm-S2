package gic.itc.coffee_shop.Entity;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "history")
public class history {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id")
    private orders order_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    private user user_id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "table_id")
    private tables table_id;

    @Column(name = "message")
    private String message;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public orders getOrder_id() {
        return order_id;
    }

    public void setOrder_id(orders order_id) {
        this.order_id = order_id;
    }

    public user getUser_id() {
        return user_id;
    }

    public void setUser_id(user user_id) {
        this.user_id = user_id;
    }

    public tables getTable_id() {
        return table_id;
    }

    public void setTable_id(tables table_id) {
        this.table_id = table_id;
    }

    

}
