package com.example.logisticbackend.service;

import com.example.logisticbackend.dto.ShipmentVM;
import com.example.logisticbackend.enums.ShipmentStatus;
import com.example.logisticbackend.model.Shipment;
import com.example.logisticbackend.model.Customer;
import com.example.logisticbackend.repository.CustomerRepository;
import com.example.logisticbackend.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;
import java.util.UUID;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final CustomerRepository customerRepository;

    public void createShipment(ShipmentVM shipmentVM) {
        Customer senderCustomer = new Customer(null, shipmentVM.getSenderFirstName(), shipmentVM.getSenderLastName(),
                shipmentVM.getSenderEmail(), shipmentVM.getSenderAddress(), new HashSet<>(), new HashSet<>());
        Customer recipientCustomer = new Customer(null, shipmentVM.getRecipientFirstName(), shipmentVM.getRecipientLastName(),
                shipmentVM.getRecipientEmail(), shipmentVM.getRecipientAddress(), new HashSet<>(), new HashSet<>());
        String trackingId = generateTrackingId();
        Shipment shipment = new Shipment(null, trackingId, shipmentVM.getContent(), ShipmentStatus.RECEIVED, senderCustomer, recipientCustomer);
        shipmentRepository.save(shipment);

    }

    public Optional<Shipment> getShipment(String trackingId) {
        return shipmentRepository.findById(trackingId);
    }


    public static String generateTrackingId() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
