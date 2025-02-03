package com.restorant.api.Model;

import com.fasterxml.jackson.annotation.JsonFormat;
import jakarta.persistence.*;

import java.util.Date;
import java.util.List;

@Entity
@Table(name = "orders")
public class Order {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "waiter_name", nullable = false, length = 40)
    private String waiterName;

    @Column(name = "table_no")
    private int tableNo;

    @Column(name = "order_time")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd.MM.yyyy")
    private Date orderTime;

    // Bir siparişin birden fazla yemeği olabilir
    @OneToMany(cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JoinColumn(name = "order_id") // "foods" tablosunda order_id sütunu olacak
    private List<Food> foods;

    public Order() {}

    public Order(Long id, String waiterName, Date orderTime, int tableNo, List<Food> foods) {
        this.id = id;
        this.waiterName = waiterName;
        this.orderTime = orderTime;
        this.tableNo = tableNo;
        this.foods = foods;
    }

    // Getter & Setter
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getWaiterName() { return waiterName; }
    public void setWaiterName(String waiterName) { this.waiterName = waiterName; }
    public int getTableNo() { return tableNo; }
    public void setTableNo(int tableNo) { this.tableNo = tableNo; }
    public Date getOrderTime() { return orderTime; }
    public void setOrderTime(Date orderTime) { this.orderTime = orderTime; }
    public List<Food> getFoods() { return foods; }
    public void setFoods(List<Food> foods) { this.foods = foods; }
}
