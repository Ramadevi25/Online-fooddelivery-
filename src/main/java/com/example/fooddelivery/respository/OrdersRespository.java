package com.example.fooddelivery.respository;

import com.example.fooddelivery.model.Customer;
import com.example.fooddelivery.model.Orders;
import org.hibernate.criterion.Order;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrdersRespository extends JpaRepository<Orders,Integer> {
    @Query(value = "SELECT * FROM orders o INNER JOIN customers c ON c.id=o.customer_id WHERE c.id=?1 and o.totalprice>?2",
            nativeQuery=true
    )
    public List<Orders> findByTotalPrice(Integer customerId,Integer totalprice);
}
