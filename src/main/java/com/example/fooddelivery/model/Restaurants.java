package com.example.fooddelivery.model;
import javax.persistence.*;
import java.util.List;

@Entity
@Table(name="restaurants")
public class Restaurants {

    @Id
    private Integer id;

    @Column(name="name")
    private String name;

    @ManyToMany
    @JoinTable(name = "restaurant_food_relation",joinColumns = @JoinColumn(name = "restaurant_id"),
    inverseJoinColumns = @JoinColumn(name = "food_id"))
    List<FoodItems> foodItems;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<FoodItems> getFoodItems() {
        return foodItems;
    }

    public void setFoodItems(List<FoodItems> foodItems) {
        this.foodItems = foodItems;
    }

}
