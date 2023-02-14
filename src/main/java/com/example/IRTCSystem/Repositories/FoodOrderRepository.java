package com.example.IRTCSystem.Repositories;

import com.example.IRTCSystem.Models.FoodOrder;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FoodOrderRepository extends JpaRepository<FoodOrder,Integer> {
}
