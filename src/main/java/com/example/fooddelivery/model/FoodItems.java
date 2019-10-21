package com.example.fooddelivery.model;

import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="food_items")
public class FoodItems {

    @Id
    private Integer id;
    @Column(name="name")
    private String foodName;
    @Column(name="price")
    private Double price;


    @ManyToMany(mappedBy = "foodItems")
    List<Restaurants> restaurants;




    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }
    public String getFoodName() {
        return foodName;
    }

    public void setFoodName(String foodName) {
        this.foodName = foodName;
    }

    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }

    @Override
    public String toString() {
        return "FoodItems{" +
                "id=" + id +
                ", foodName='" + foodName + '\'' +
                ", price=" + price +
                '}';
    }




}
