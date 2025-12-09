package com.deeplabstudio.kargonomisdk.Models.Shipment;

import com.google.gson.annotations.SerializedName;

public class PackageItem {

    @SerializedName("content")
    private String content;

    @SerializedName("barcode")
    private String barcode;

    @SerializedName("desi")
    private String desi;

    public PackageItem(String content, String barcode, String desi) {
        this.content = content;
        this.barcode = barcode;
        this.desi = desi;
    }

    // Getters + Setters
}

