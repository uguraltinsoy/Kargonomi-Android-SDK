package com.deeplabstudio.kargonomisdk.Models.Address;

import com.google.gson.annotations.SerializedName;

public class State {
    @SerializedName("id")
    public int id;

    @SerializedName("name")
    public String name;

    @SerializedName("state_code")
    public String stateCode;

    @Override
    public String toString() {
        return name;
    }
}
