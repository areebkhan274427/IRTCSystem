package com.example.IRTCSystem.Repositories;

import com.example.IRTCSystem.Models.Train;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrainRepository extends JpaRepository<Train,Integer> {

}
