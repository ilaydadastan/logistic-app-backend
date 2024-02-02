package com.example.logisticbackend.controller;

import com.example.logisticbackend.dto.ShipmentVM;
import com.example.logisticbackend.model.Shipment;
import com.example.logisticbackend.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping("/{id}")
    public Shipment getShipment(@PathVariable Long id) {
        Optional<Shipment> shipment = shipmentService.getShipment(id);
        return shipment.orElse(null);
    }

    @PostMapping
    public String saveShipment(@RequestBody ShipmentVM shipmentVM) {
        shipmentService.createShipment(shipmentVM);
        return "shipment created";
    }
}
