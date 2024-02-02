package com.example.logisticbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentVM {
    private String trackingId;
    private String content;
    private CustomerVM sender;
    private CustomerVM recipient;

}
