package com.example.IRTCSystem.Dtos;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Builder
@AllArgsConstructor
@Data
public class TrainRequestDto {
    private String source;

    private String destination;
}
