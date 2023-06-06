// package gic.itc.coffee_shop.Entity;

// import java.security.Timestamp;
// import java.util.List;
// import java.util.Set;

// import jakarta.persistence.CascadeType;
// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.OneToMany;
// import jakarta.persistence.OneToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "order_details")
// public class order_details {

//     @Id
//     @Column(nullable = false)
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;

//     @Column(name = "image_url")
//     private String image_url;

//     // @ManyToOne(fetch = FetchType.LAZY)
//     // @JoinColumn(name = "order_id", referencedColumnName = "id")
//     // private orders order;



// }
//     @Id
//     @Column(nullable = false)
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;

//     @ManyToOne
//     @JoinColumn(name = "user_id", referencedColumnName = "id")
//     private user user;

//     @OneToOne(cascade = CascadeType.ALL)
//     @JoinColumn(name = "table_id", referencedColumnName = "id")
//     private tables tables;

//     // @ManyToOne
//     // @JoinColumn(name = "order_details_id", referencedColumnName = "id")
//     // private orders order;

//     // @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, orphanRemoval = true)
//     // private List<orders> order_id;

//     // @OneToMany(mappedBy = "order_id", cascade = CascadeType.ALL, orphanRemoval = true)
//     // private List<history> history;



    // @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    // private Timestamp orderTime;

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public user getUser() {
//         return user;
//     }

//     public void setUser(user user) {
//         this.user = user;
//     }

//     public tables getTables() {
//         return tables;
//     }

//     public void setTables(tables tables) {
//         this.tables = tables;
//     }

//     public Timestamp getOrderTime() {
//         return orderTime;
//     }

//     public void setOrderTime(Timestamp orderTime) {
//         this.orderTime = orderTime;
//     }

// }
