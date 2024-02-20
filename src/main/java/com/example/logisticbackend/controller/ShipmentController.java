package com.example.logisticbackend.controller;

import com.example.logisticbackend.dto.ShipmentVM;
import com.example.logisticbackend.model.Shipment;
import com.example.logisticbackend.service.ShipmentService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;
import java.util.UUID;

@RestController
@RequiredArgsConstructor
@RequestMapping("/shipments")
public class ShipmentController {

    private final ShipmentService shipmentService;

    @GetMapping("/{trackingId}")
    public Shipment getShipment(@PathVariable UUID trackingId) {
        Optional<Shipment> shipment = shipmentService.getShipment(trackingId);
        return shipment.orElse(null);
    }

    @PostMapping
    public String saveShipment(@RequestBody ShipmentVM shipmentVM) {
        shipmentService.createShipment(shipmentVM);
        return "shipment created";
    }

    @GetMapping
    public String hello(Authentication authentication){
        return "hello";
    }
}
