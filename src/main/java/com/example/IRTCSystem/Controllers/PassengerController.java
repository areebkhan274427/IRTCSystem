package com.example.IRTCSystem.Controllers;

import com.example.IRTCSystem.Dtos.GetPassengerFromDto;
import com.example.IRTCSystem.Dtos.PassengerRequestDto;
import com.example.IRTCSystem.Services.PassengerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;

@RestController
@RequestMapping("/passenger")
public class PassengerController {

    @Autowired
    PassengerService passengerService;

    @PostMapping("/add")
    public ResponseEntity<String> addPassenger(@RequestBody PassengerRequestDto passengerRequestDto){
        try {
            passengerService.addPassenger(passengerRequestDto);
            return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
        }
        catch (Exception e){
            return new ResponseEntity<>(e.getMessage(),HttpStatus.BAD_REQUEST);
        }
    }

    @GetMapping("/get_passenger_from")
    public ResponseEntity<Integer> getPassenger(@RequestBody GetPassengerFromDto getPassengerFromDto){
        int total= passengerService.getPassenger(getPassengerFromDto);
        return new ResponseEntity<>(total,HttpStatus.FOUND);
    }

    @GetMapping("/get_female")
    public ResponseEntity<Integer> findFemale(@RequestParam int fromAge,@RequestParam int toAge,@RequestParam String destination){
        int total= passengerService.findFemale(fromAge, toAge, destination);
        return new ResponseEntity<>(total,HttpStatus.FOUND);
    }




}
