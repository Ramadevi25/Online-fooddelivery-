package com.example.fooddelivery.model;

import javax.persistence.*;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.Order;
import java.util.List;

@Entity
@Table(name="order_details")
public class Orderdetails {

    @Id
    private Integer id;

    @Column(name="order_id")
    private Integer orderId;

    @Column(name="food_id")
    private Integer foodId;

    @Column(name="quantity")
    private Integer quantity;

    @OneToMany
    @JoinColumn(name="id")
    List<FoodItems> foodItemsList;

    public List<FoodItems> getFoodItemsList() {
        return foodItemsList;
    }

    public void setFoodItemsList(List<FoodItems> foodItemsList) {
        this.foodItemsList = foodItemsList;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    @Override
    public String toString() {
        return "Orderdetails{" +
                "id=" + id +
                ", orderId=" + orderId +
                ", foodId=" + foodId +
                ", quantity=" + quantity +
                '}';
    }
}
