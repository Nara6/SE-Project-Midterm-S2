// package gic.itc.coffee_shop.Entity;

// import java.util.List;

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

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "order_id")
//     private orders order;

//     @OneToOne(cascade = CascadeType.ALL)
//     @JoinColumn(name = "table_id", referencedColumnName = "id")
//     private tables tables;
    

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public orders getOrder() {
//         return order;
//     }

//     public void setOrder(orders order) {
//         this.order = order;
//     }

//     public tables getTables() {
//         return tables;
//     }

//     public void setTables(tables tables) {
//         this.tables = tables;
//     }

    
    
// }
