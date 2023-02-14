package com.example.IRTCSystem.Dtos;

import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
public class GetPassengerFromDto {

    private String source;


    private String destination;

    private LocalDate date;
}

