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
import jakarta.persistence.Table;

@Entity
@Table(name = "tables")
public class tables {
    @Id
    @Column(nullable = false, unique = false)
    // @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "name")
    private String name;

    @Column(name = "status", columnDefinition = "boolean default true")
    private boolean status;

    // @ManyToOne(fetch = FetchType.LAZY)
    // @JoinColumn(name = "invoice")
    // private   ;

    // @OneToMany(mappedBy = "table_id", cascade = CascadeType.ALL, orphanRemoval =
    // true)
    // private List<history> history;

    // public List<history> getHistory() {
    //     return history;
    // }

    // public vsoid setHistory(List<history> history) {
    //     this.history = history;
    // }

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

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }

}
