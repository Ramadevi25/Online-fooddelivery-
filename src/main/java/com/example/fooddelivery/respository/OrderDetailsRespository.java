package com.example.fooddelivery.respository;

import com.example.fooddelivery.model.Orderdetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@Repository
public interface OrderDetailsRespository extends JpaRepository<Orderdetails,Integer> {

    List<Orderdetails> findByOrderId(Integer orderId);

}
