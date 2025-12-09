package com.deeplabstudio.kargonomisdk.Models.Shipment;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class CreateShipmentRequest {

    @SerializedName("shipment")
    public Shipment shipment = new Shipment();

    public static class Shipment {
        @SerializedName("sender_name")
        public String sender_name; // OPSİYONEL (warehouse_id varsa)

        @SerializedName("sender_email")
        public String sender_email; // OPSİYONEL (warehouse_id varsa)

        @SerializedName("sender_tax_number")
        public String sender_tax_number; // OPSİYONEL (warehouse_id varsa)

        @SerializedName("sender_tax_place")
        public String sender_tax_place; // OPSİYONEL (warehouse_id varsa)

        @SerializedName("sender_phone")
        public String sender_phone; // OPSİYONEL (warehouse_id varsa)

        @SerializedName("sender_address")
        public String sender_address; // OPSİYONEL (warehouse_id varsa)

        @SerializedName("sender_state_id")
        public String sender_state_id; // OPSİYONEL (warehouse_id varsa)

        @SerializedName("sender_city_id")
        public String sender_city_id; // OPSİYONEL (warehouse_id varsa)

        @SerializedName("warehouse_id")
        public String warehouse_id; // OPSİYONEL (gönderici bilgilerini depodan otomatik çeker)

        // ----------------------
        // Alıcı Bilgileri
        // ----------------------

        @SerializedName("buyer_name")
        public String buyer_name; // ZORUNLU

        @SerializedName("buyer_email")
        public String buyer_email; // OPSİYONEL

        @SerializedName("buyer_tax_number")
        public String buyer_tax_number; // OPSİYONEL

        @SerializedName("buyer_tax_place")
        public String buyer_tax_place; // OPSİYONEL

        @SerializedName("buyer_phone")
        public String buyer_phone; // ZORUNLU

        @SerializedName("buyer_address")
        public String buyer_address; // ZORUNLU

        @SerializedName("buyer_state_id")
        public String buyer_state_id; // ZORUNLU

        @SerializedName("buyer_city_id")
        public String buyer_city_id; // ZORUNLU

        // ----------------------
        // Paket Bilgileri
        // ----------------------

        @SerializedName("packages")
        public List<PackageItem> packages; // ZORUNLU (min 1 adet)
    }

    public static class PackageItem {

        @SerializedName("content")
        public String content; // OPSİYONEL

        @SerializedName("barcode")
        public String barcode; // OPSİYONEL

        @SerializedName("desi")
        public String desi; // ZORUNLU
    }
}
