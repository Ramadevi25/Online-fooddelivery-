package com.example.fooddelivery.respository;

import com.example.fooddelivery.model.Orders;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface OrdersRespository extends JpaRepository<Orders,Integer> {
}
