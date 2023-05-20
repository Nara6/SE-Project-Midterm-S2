// package gic.itc.coffee_shop.Entity;

// import java.time.LocalDateTime;
// import java.util.Date;

// import org.hibernate.annotations.CreationTimestamp;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.PrePersist;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "sales")
// public class sales {
//     @Id
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     @JoinColumn(name = "order_details_id")
//     private order_details order_details_id;

//     @Column(name = "price")
//     private Double price;

//     private Integer quantity;
//     private Date date;

//     // @CreationTimestamp
//     // @Temporal(TemporalType.TIMESTAMP)
//     // @Column(name = "date", nullable = false, updatable = false)
//     // private Date date;

//     // @Column(name = "date", nullable = false, updatable = false)
//     // private LocalDateTime date;

//     // @PrePersist
//     // protected void date() {
//     // date = LocalDateTime.now();
//     // }

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public Double getPrice() {
//         return price;
//     }

//     public void setPrice(Double price) {
//         this.price = price;
//     }

//     public Integer getQuantity() {
//         return quantity;
//     }

//     public void setQuantity(Integer quantity) {
//         this.quantity = quantity;
//     }

//     public Date getDate() {
//         return date;
//     }

//     public void setDate(Date date) {
//         this.date = date;
//     }

//     public order_details getOrder_details_id() {
//         return order_details_id;
//     }

//     public void setOrder_details_id(order_details order_details_id) {
//         this.order_details_id = order_details_id;
//     }

// }
