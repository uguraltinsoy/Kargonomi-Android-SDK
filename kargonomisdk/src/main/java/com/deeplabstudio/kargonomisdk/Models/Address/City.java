package com.deeplabstudio.kargonomisdk.Models.Address;

import com.google.gson.annotations.SerializedName;

public class City {
    @SerializedName("id")
    public int id;

    @SerializedName("state_id")
    public int stateId;

    @SerializedName("name")
    public String name;

    @Override
    public String toString() {
        return name;
    }
}
