package com.example.logisticbackend.repository;

import com.example.logisticbackend.model.Shipment;
import org.springframework.data.repository.CrudRepository;

public interface ShipmentRepository extends CrudRepository<Shipment, Long> {

}
