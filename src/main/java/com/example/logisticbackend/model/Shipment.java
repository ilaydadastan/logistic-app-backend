package com.example.logisticbackend.model;

import com.example.logisticbackend.enums.ShipmentStatus;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "SHIPMENTS")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Shipment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID")
    private Long id;
    @Column(name = "TRACKING_ID")
    private UUID trackingId;
    @Column(name = "CONTENT")
    private String content;
    @Column(name = "STATUS")
    private ShipmentStatus status;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "sender_id", referencedColumnName = "id")
    private Customer senderCustomer;
    @ManyToOne(cascade = CascadeType.PERSIST)
    @JoinColumn(name = "recipient_id", referencedColumnName = "id")
    private Customer recipientCustomer;

}
