package com.example.fooddelivery.respository;

import com.example.fooddelivery.model.CardDetails;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CardDetailRepository extends JpaRepository<CardDetails,Integer> {
    List<CardDetails> findByCustomerId(Integer customerId);
}
