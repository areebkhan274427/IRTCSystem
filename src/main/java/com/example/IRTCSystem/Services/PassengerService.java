package com.example.IRTCSystem.Services;

import com.example.IRTCSystem.Dtos.GetPassengerFromDto;
import com.example.IRTCSystem.Dtos.PassengerRequestDto;
import com.example.IRTCSystem.Models.Passenger;
import com.example.IRTCSystem.Models.Train;
import com.example.IRTCSystem.Repositories.PassengerRepository;
import com.example.IRTCSystem.Repositories.TrainRepository;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

@Service
public class PassengerService {

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    TrainRepository trainRepository;

    public void addPassenger(PassengerRequestDto passengerRequestDto) throws Exception {
        if(trainRepository.findById(passengerRequestDto.getTrainId()).isEmpty()){
           throw new Exception("Train does not Exist");
        }
        Train train=trainRepository.findById(passengerRequestDto.getTrainId()).get();
        Passenger passenger=Passenger.builder().age(passengerRequestDto.getAge()).date(passengerRequestDto.getDate())
                .gender(passengerRequestDto.getGender()).train(train).build();
        passengerRepository.save(passenger);
    }

    public int getPassenger(GetPassengerFromDto getPassengerFromDto){
        String source=getPassengerFromDto.getSource();
        String destination=getPassengerFromDto.getDestination();
        LocalDate date= getPassengerFromDto.getDate();

        List<Passenger> passengerList = passengerRepository.findAll();
        int count=0;

        for(Passenger passenger:passengerList){
            Train train=passenger.getTrain();
            if(train.getSource().equals(source) && train.getDestination().equals(destination) && passenger.getDate().equals(date)){
                count++;
            }
        }
        return count;
    }

    public int findFemale(int fromAge,int toAge,String destination){
        List<Passenger> passengerList = passengerRepository.findAll();
        int count=0;

        for(Passenger passenger:passengerList){
            Train train=passenger.getTrain();
            if(passenger.getAge()>=fromAge && passenger.getAge()<=toAge && train.getDestination().equals(destination) && passenger.getGender().equals("Female")){
                count++;
            }
        }
        return count;
    }






}
