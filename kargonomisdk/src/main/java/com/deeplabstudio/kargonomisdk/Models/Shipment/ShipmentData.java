package com.deeplabstudio.kargonomisdk.Models.Shipment;

import com.google.gson.annotations.SerializedName;
import java.util.List;

public class ShipmentData {

    // Sender
    @SerializedName("sender_name")
    private String senderName;

    @SerializedName("sender_email")
    private String senderEmail;

    @SerializedName("sender_tax_number")
    private String senderTaxNumber;

    @SerializedName("sender_tax_place")
    private String senderTaxPlace;

    @SerializedName("sender_phone")
    private String senderPhone;

    @SerializedName("sender_address")
    private String senderAddress;

    @SerializedName("sender_state_id")
    private Integer senderStateId;

    @SerializedName("sender_city_id")
    private Integer senderCityId;

    @SerializedName("warehouse_id")
    private Integer warehouseId; // optional

    // Buyer
    @SerializedName("buyer_name")
    private String buyerName;

    @SerializedName("buyer_email")
    private String buyerEmail;

    @SerializedName("buyer_tax_number")
    private String buyerTaxNumber;

    @SerializedName("buyer_tax_place")
    private String buyerTaxPlace;

    @SerializedName("buyer_phone")
    private String buyerPhone;

    @SerializedName("buyer_address")
    private String buyerAddress;

    @SerializedName("buyer_state_id")
    private Integer buyerStateId;

    @SerializedName("buyer_city_id")
    private Integer buyerCityId;

    // Packages
    @SerializedName("packages")
    private List<PackageItem> packages;

    // Constructor
    public ShipmentData(String senderName, String senderEmail, String senderTaxNumber,
                        String senderTaxPlace, String senderPhone, String senderAddress,
                        Integer senderStateId, Integer senderCityId, Integer warehouseId,
                        String buyerName, String buyerEmail, String buyerTaxNumber,
                        String buyerTaxPlace, String buyerPhone, String buyerAddress,
                        Integer buyerStateId, Integer buyerCityId,
                        List<PackageItem> packages) {

        this.senderName = senderName;
        this.senderEmail = senderEmail;
        this.senderTaxNumber = senderTaxNumber;
        this.senderTaxPlace = senderTaxPlace;
        this.senderPhone = senderPhone;
        this.senderAddress = senderAddress;
        this.senderStateId = senderStateId;
        this.senderCityId = senderCityId;
        this.warehouseId = warehouseId;

        this.buyerName = buyerName;
        this.buyerEmail = buyerEmail;
        this.buyerTaxNumber = buyerTaxNumber;
        this.buyerTaxPlace = buyerTaxPlace;
        this.buyerPhone = buyerPhone;
        this.buyerAddress = buyerAddress;
        this.buyerStateId = buyerStateId;
        this.buyerCityId = buyerCityId;

        this.packages = packages;
    }
}
