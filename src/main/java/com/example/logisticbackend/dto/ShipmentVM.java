package com.example.logisticbackend.dto;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class ShipmentVM {
    private UUID trackingId;
    private String content;
    private String senderFirstName;
    private String senderLastName;
    private String senderEmail;
    private String senderAddress;
    private String recipientFirstName;
    private String recipientLastName;
    private String recipientEmail;
    private String recipientAddress;

}
