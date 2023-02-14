package com.example.IRTCSystem.Services;

import com.example.IRTCSystem.Dtos.TrainRequestDto;
import com.example.IRTCSystem.Repositories.TrainRepository;
import com.example.IRTCSystem.Models.Train;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class TrainService {

    @Autowired
    TrainRepository trainRepository;

    public void addTrain(TrainRequestDto trainRequestDto){
        Train train=Train.builder().source(trainRequestDto.getSource())
                .destination(trainRequestDto.getDestination()).build();
        trainRepository.save(train);
    }

}
