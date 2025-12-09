package com.deeplabstudio.kargonomisdk.Models.Shipment;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ShipmentDetailResponse {

    public int id;
    public String type;

    @SerializedName("shipping_webservice_order_id")
    public String shippingWebserviceOrderId;

    @SerializedName("shipping_webservice_barcode")
    public String shippingWebserviceBarcode;

    @SerializedName("shipping_webservice_tracking_code")
    public String shippingWebserviceTrackingCode;

    @SerializedName("shipping_provider_name")
    public String shippingProviderName;

    @SerializedName("shipping_provider_slug")
    public String shippingProviderSlug;

    @SerializedName("barcode_of_order_id")
    public String barcodeOfOrderId;

    public String status;

    @SerializedName("status_label")
    public String statusLabel;

    @SerializedName("shipping_webservice_created_at")
    public String shippingWebserviceCreatedAt;

    @SerializedName("ecommerce_provider_order_no")
    public String ecommerceProviderOrderNo;

    @SerializedName("ecommerce_provider")
    public String ecommerceProvider;

    @SerializedName("package_count")
    public int packageCount;

    @SerializedName("estimated_price")
    public double estimatedPrice;

    @SerializedName("real_price")
    public double realPrice;

    @SerializedName("order_price")
    public String orderPrice;

    @SerializedName("extra_shipping_price")
    public String extraShippingPrice;

    @SerializedName("delivery_date_to_shipment_office")
    public String deliveryDateToShipmentOffice;

    @SerializedName("shipping_provider_customer_delivery_date")
    public String shippingProviderCustomerDeliveryDate;

    @SerializedName("created_at")
    public String createdAt;

    @SerializedName("updated_at")
    public String updatedAt;

    @SerializedName("extra_field")
    public String extraField;

    public Sender sender;
    public Buyer buyer;
    public Warehouse warehouse;
    public Pricing pricing;

    @SerializedName("shipment_packages")
    public List<ShipmentPackage> shipmentPackages;


    // -------------------------
    // INNER MODELS
    // -------------------------

    public static class Sender {
        @SerializedName("sender_name")
        public String senderName;

        @SerializedName("sender_email")
        public String senderEmail;

        @SerializedName("sender_phone")
        public String senderPhone;

        @SerializedName("sender_phone2")
        public String senderPhone2;

        @SerializedName("sender_tax_number")
        public String senderTaxNumber;

        @SerializedName("sender_tax_place")
        public String senderTaxPlace;

        @SerializedName("sender_address")
        public String senderAddress;

        @SerializedName("sender_state")
        public String senderState;

        @SerializedName("sender_city")
        public String senderCity;
    }

    public static class Buyer {
        @SerializedName("buyer_name")
        public String buyerName;

        @SerializedName("buyer_email")
        public String buyerEmail;

        @SerializedName("buyer_phone")
        public String buyerPhone;

        @SerializedName("buyer_phone2")
        public String buyerPhone2;

        @SerializedName("buyer_tax_number")
        public String buyerTaxNumber;

        @SerializedName("buyer_tax_place")
        public String buyerTaxPlace;

        @SerializedName("buyer_address")
        public String buyerAddress;

        @SerializedName("buyer_state")
        public String buyerState;

        @SerializedName("buyer_city")
        public String buyerCity;
    }

    public static class Warehouse {
        public int id;
        public String name;

        @SerializedName("is_main")
        public int isMain;

        @SerializedName("is_temporary")
        public int isTemporary;

        @SerializedName("contact_name")
        public String contactName;

        @SerializedName("contact_phone")
        public String contactPhone;

        public String state;
        public String city;
        public String address;
        public String phone;

        @SerializedName("tax_number")
        public String taxNumber;

        @SerializedName("tax_place")
        public String taxPlace;
    }

    public static class Pricing {
        @SerializedName("package_count")
        public int packageCount;

        @SerializedName("estimated_price")
        public double estimatedPrice;

        @SerializedName("real_price")
        public double realPrice;

        @SerializedName("extra_shipping_price")
        public String extraShippingPrice;

        @SerializedName("price_diff")
        public double priceDiff;
    }

    public static class ShipmentPackage {
        public String desi;
        public String barcode;
        public String content;

        @SerializedName("real_desi")
        public String realDesi;
    }
}

