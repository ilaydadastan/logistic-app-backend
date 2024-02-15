package com.example.logisticbackend.repository;

import com.example.logisticbackend.model.Shipment;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;
import java.util.UUID;


public interface ShipmentRepository extends CrudRepository<Shipment, Long> {
        Optional<Shipment> findByTrackingId(UUID trackingId);
}
