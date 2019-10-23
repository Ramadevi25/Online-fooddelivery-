package com.example.fooddelivery.respository;

import com.example.fooddelivery.model.Customer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CustomerRespository extends JpaRepository<Customer,Integer> {
    //@Query("SELECT t FROM customers t WHERE t.customer_id = 'customerId'")
    //public List<Customer> findById();

    @Query(value = "SELECT * FROM customers t WHERE t.customer_id = 'customerId'",
            nativeQuery=true
    )
    public List<Customer> findById();
}
