package com.deeplabstudio.kargonomisdk.Models.Shipment;

public class CancelShipmentRequest {
    private String shipment_id;

    public CancelShipmentRequest(String shipmentId) {
        this.shipment_id = shipmentId;
    }

    public String getShipmentId() {
        return shipment_id;
    }
}

