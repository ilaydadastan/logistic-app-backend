package com.example.logisticbackend.service;

import com.example.logisticbackend.enums.ShipmentStatus;
import com.example.logisticbackend.model.Shipment;
import com.example.logisticbackend.model.Customer;
import com.example.logisticbackend.repository.CustomerRepository;
import com.example.logisticbackend.repository.ShipmentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final CustomerRepository customerRepository;

    public void createShipment() {
        Customer senderCustomer = new Customer(null, "ilayda", "dastan", "ilayda@gmail.com", "Estonia", new HashSet<>(), new HashSet<>());
        Customer recipientCustomer = new Customer(null, "ilayda", "dastan", "ilayda@gmail.com", "Estonia", new HashSet<>(), new HashSet<>());
        Shipment shipment = new Shipment(null, "1", "box", ShipmentStatus.RECEIVED, customerRepository.save(senderCustomer), customerRepository.save(recipientCustomer));
        shipmentRepository.save(shipment);
    }

    public Optional<Shipment> getShipment(Long id) {
        return shipmentRepository.findById(id);
    }
}
