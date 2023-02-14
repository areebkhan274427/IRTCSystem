package com.example.IRTCSystem.Controllers;

import com.example.IRTCSystem.Dtos.TrainRequestDto;
import com.example.IRTCSystem.Services.TrainService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/train")
public class TrainController {

    @Autowired
    TrainService trainService;

    @PostMapping("/add")
    public ResponseEntity<String> addTrain(@RequestBody() TrainRequestDto trainRequestDto){
        trainService.addTrain(trainRequestDto);
        return new ResponseEntity<>("Success", HttpStatus.ACCEPTED);
    }
}
