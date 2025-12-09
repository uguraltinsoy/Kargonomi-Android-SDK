package com.deeplabstudio.kargonomisdk.Models.Shipment;

import java.util.List;

public class PriceComparisonResponse {
    public List<ShippingProviderPrice> shipping_provider_with_price;
    public ShipmentDetail shipment;

    public static class ShippingProviderPrice {
        public int id;
        public String name;
        public String slug;
        public double price;
        public String warning; // null olabilir
    }

    // --- Shipment Detail ---
    public static class ShipmentDetail {
        public int id;
        public String type;
        public String shipping_webservice_order_id;
        public String shipping_webservice_barcode;
        public String shipping_webservice_tracking_code;
        public String tracking_url;
        public String shipping_provider_name;
        public String shipping_provider_slug;
        public String barcode_of_order_id;
        public String status;
        public String status_label;
        public String shipping_webservice_created_at;
        public String ecommerce_provider_order_no;
        public String ecommerce_provider;
        public int package_count;
        public String estimated_price;
        public String real_price;
        public String order_price;
        public String extra_shipping_price;
        public String buyer_name;
        public String delivery_date_to_shipment_office;
        public String shipping_provider_customer_delivery_date;
        public String created_at;
        public String updated_at;
        public String extra_field;

        public Sender sender;
        public Buyer buyer;
        public Pricing pricing;
        public Warehouse warehouse;
        public List<ShipmentPackage> shipment_packages;
    }

    // --- Sender Info ---
    public static class Sender {
        public String sender_name;
        public String sender_email;
        public String sender_phone;
        public String sender_phone2;
        public String sender_tax_number;
        public String sender_tax_place;
        public String sender_address;
        public String sender_state;
        public String sender_city;
    }

    // --- Buyer Info ---
    public static class Buyer {
        public String buyer_name;
        public String buyer_email;
        public String buyer_phone;
        public String buyer_phone2;
        public String buyer_tax_number;
        public String buyer_tax_place;
        public String buyer_address;
        public String buyer_state;
        public String buyer_city;
    }

    // --- Pricing Info ---
    public static class Pricing {
        public int package_count;
        public String estimated_price;
        public String real_price;
        public String extra_shipping_price;
        public String price_diff;
    }

    // --- Warehouse ---
    public static class Warehouse {
        public int id;
        public String name;
        public int is_main;
        public int is_temporary;
        public String contact_name;
        public String contact_phone;
        public String state;
        public String city;
        public String address;
        public String phone;
        public String tax_number;
        public String tax_place;
    }

    // --- Package ---
    public static class ShipmentPackage {
        public String desi;
        public String barcode;
        public String content;
        public String real_desi;
    }
}
