package com.example.IRTCSystem.Services;

import com.example.IRTCSystem.Models.FoodOrder;
import com.example.IRTCSystem.Models.Passenger;
import com.example.IRTCSystem.Models.Train;
import com.example.IRTCSystem.Repositories.FoodOrderRepository;
import com.example.IRTCSystem.Repositories.PassengerRepository;
import com.example.IRTCSystem.Repositories.TrainRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

@Service
public class FoodOrderService {

    @Autowired
    FoodOrderRepository foodOrderRepository;

    @Autowired
    PassengerRepository passengerRepository;

    @Autowired
    TrainRepository trainRepository;

    public void placeOrder(int customerId,int price){
        Passenger passenger=passengerRepository.findById(customerId).get();
        Train train=passenger.getTrain();
        FoodOrder foodOrder=FoodOrder.builder().price(price).build();
        foodOrder.setPassenger(passenger);
        foodOrder.setTrain(train);
        foodOrderRepository.save(foodOrder);
    }

    public int getTotalPrice(int trainId, LocalDate date){
        List<FoodOrder> foodOrderList=foodOrderRepository.findAll();
        int price=0;
        System.out.println(date);
        for(FoodOrder foodOrder:foodOrderList){
            Passenger passenger=foodOrder.getPassenger();
            Train train=foodOrder.getTrain();
            if(passenger.getDate().equals(date) && train.getId()==trainId){
                price+=foodOrder.getPrice();
            }
        }
        return price;
    }
}
