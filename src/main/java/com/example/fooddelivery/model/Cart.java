package com.example.fooddelivery.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="cart")
public class Cart {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name="customer_id")
    private Integer customerId;

    @Column(name="food_id")
    private Integer foodId;

    @OneToMany
    @JoinColumn(name="id")
    List<FoodItems> foodItemsList;

    public List<FoodItems> getFoodItemsList() { return foodItemsList; }

    public void setFoodItemsList(List<FoodItems> foodItemsList) { this.foodItemsList = foodItemsList; }

    public Integer getCustomerId() { return customerId; }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
    }

    public Integer getFoodId() {
        return foodId;
    }

    public void setFoodId(Integer foodId) {
        this.foodId = foodId;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

}
