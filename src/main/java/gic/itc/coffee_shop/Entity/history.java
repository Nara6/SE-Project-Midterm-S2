// package gic.itc.coffee_shop.Entity;

// import jakarta.persistence.Column;
// import jakarta.persistence.Entity;
// import jakarta.persistence.FetchType;
// import jakarta.persistence.GeneratedValue;
// import jakarta.persistence.GenerationType;
// import jakarta.persistence.Id;
// import jakarta.persistence.JoinColumn;
// import jakarta.persistence.ManyToOne;
// import jakarta.persistence.Table;

// @Entity
// @Table(name = "history")
// public class history {
//     @Id
//     @Column(nullable = false)
//     @GeneratedValue(strategy = GenerationType.IDENTITY)
//     private int id;

//     @ManyToOne(fetch = FetchType.LAZY)
//     // @JoinColumn(name = "order_detail_id")
//     @JoinColumn(name = "order_detail_id", referencedColumnName = "id")
//     private order_details order_detail_id;

//     @Column(name = "message")
//     private String message;

//     public int getId() {
//         return id;
//     }

//     public void setId(int id) {
//         this.id = id;
//     }

//     public order_details getOrder_detail_id() {
//         return order_detail_id;
//     }

//     public void setOrder_detail_id(order_details order_detail_id) {
//         this.order_detail_id = order_detail_id;
//     }

//     public String getMessage() {
//         return message;
//     }

//     public void setMessage(String message) {
//         this.message = message;
//     }

// }
