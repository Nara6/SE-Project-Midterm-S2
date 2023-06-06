package gic.itc.coffee_shop.Entity;

import java.security.Timestamp;
import java.time.LocalDateTime;
import java.util.List;

import jakarta.persistence.CascadeType;
import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.FetchType;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.Lob;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.OneToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "user")
public class user {
    @Id
    @Column(nullable = false)
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Column(name = "username")
    private String username;

    @Column(nullable = false)
    @Size(min = 6, message = "Password must be at least 6 characters long")
    private String password;

    @Column(name = "email", unique = true)
    private String email;
    @Lob
    @Column(name = "image_url", length=1111232443)
    private String image_url;

    @Column(name = "age")
    private int age;

    @Column(name = "gender")
    private String gender;

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    @Column(name="dob")
    private String dob;

    @Column(name = "created_at", columnDefinition = "TIMESTAMP DEFAULT CURRENT_TIMESTAMP")
    private LocalDateTime orderTime;

    @OneToOne()
    @JoinColumn(name = "user_type_id", referencedColumnName = "id")
    private user_type user_type_id;

    // @OneToMany(mappedBy = "user_id", cascade = CascadeType.ALL, orphanRemoval =
    // true)
    // private List<history> history;
    public boolean hasRole(String roleName) {
        if (this.getUser_type_id().getName().equals(roleName)) return true;
        else return false;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getImage_url() {
        return image_url;
    }

    public void setImage_url(String image_url) {
        this.image_url = image_url;
    }

    public user_type getUser_type_id() {
        return user_type_id;
    }

    public void setUser_type_id(user_type user_type_id) {
        this.user_type_id = user_type_id;
    }

    public LocalDateTime getOrderTime() {
        return orderTime;
    }

    public void setOrderTime(LocalDateTime orderTime) {
        this.orderTime = orderTime;
    }


    // public List<history> getHistory() {
    // return history;
    // }

    // public void setHistory(List<history> history) {
    // this.history = history;
    // }

    // public user_type getUser_type() {
    // return user_type_id;
    // }

    // public void setUser_type(user_type user_type) {
    // this.user_type_id = user_type_id;
    // }
}
