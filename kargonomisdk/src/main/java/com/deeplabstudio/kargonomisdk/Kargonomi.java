package com.deeplabstudio.kargonomisdk;

import com.google.gson.Gson;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class Kargonomi {

    private static KargonomiApi api;
    private static String apiKey;
    private static final Gson gson = new Gson();

    public static AddressManager Address = new AddressManager();
    private static WarehouseManager warehouseManager = new WarehouseManager();
    public static WarehouseManager Warehouses = warehouseManager;
    public static ShipmentManager Shipments = new ShipmentManager();
    public static UserManager User = new UserManager();

    public static void init(String token) {
        apiKey = token;
        OkHttpClient client = new OkHttpClient.Builder().addInterceptor(chain -> {
            Request newRequest = chain.request().newBuilder()
                    .addHeader("Accept", "application/json")
                    .addHeader("Content-Type", "application/json")
                    .addHeader("Authorization", "Bearer " + apiKey)
                    .build();
            return chain.proceed(newRequest);
        }).build();

        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://app.kargonomi.com.tr/api/v1/")
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        api = retrofit.create(KargonomiApi.class);
    }

    public static KargonomiApi getApi() {
        return api;
    }

}