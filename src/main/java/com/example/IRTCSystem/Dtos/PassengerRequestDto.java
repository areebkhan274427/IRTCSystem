package com.example.IRTCSystem.Dtos;

import com.example.IRTCSystem.Models.Train;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.time.LocalDate;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
public class PassengerRequestDto {

    private int trainId;

    private LocalDate date;

    private int age;

    private String gender;

}
