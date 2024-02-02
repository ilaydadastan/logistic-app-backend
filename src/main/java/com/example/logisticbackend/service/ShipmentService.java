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

@Service
@RequiredArgsConstructor
public class ShipmentService {

    private final ShipmentRepository shipmentRepository;
    private final CustomerRepository customerRepository;

    public void createShipment(ShipmentVM shipmentVM) {
        Customer senderCustomer = new Customer(null, shipmentVM.getSender().getFirstName(), shipmentVM.getSender().getLastName(),
                shipmentVM.getSender().getEmail(), shipmentVM.getSender().getAddress(), new HashSet<>(), new HashSet<>());
        Customer recipientCustomer = new Customer(null, shipmentVM.getRecipient().getFirstName(), shipmentVM.getRecipient().getLastName(),
                shipmentVM.getRecipient().getEmail(), shipmentVM.getRecipient().getAddress(), new HashSet<>(), new HashSet<>());
        Shipment shipment = new Shipment(null, "1", shipmentVM.getContent(), ShipmentStatus.RECEIVED, senderCustomer, recipientCustomer);
        shipmentRepository.save(shipment);
    }

    public Optional<Shipment> getShipment(Long id) {
        return shipmentRepository.findById(id);
    }
}
