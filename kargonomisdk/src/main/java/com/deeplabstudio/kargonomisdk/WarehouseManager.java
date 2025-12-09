package com.deeplabstudio.kargonomisdk;

import com.deeplabstudio.kargonomisdk.Callback.AddressRequest;
import com.deeplabstudio.kargonomisdk.Callback.SuccessCallback;
import com.deeplabstudio.kargonomisdk.Models.Warehouse.Warehouse;
import com.deeplabstudio.kargonomisdk.Models.Warehouse.WarehouseResponse;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class WarehouseManager {

    public AddressRequest<List<Warehouse>> list(SuccessCallback<List<Warehouse>> success) {

        AddressRequest<List<Warehouse>> request = new AddressRequest<>();
        request.onSuccess(success);

        Call<WarehouseResponse> call = Kargonomi.getApi().getWarehouses();

        call.enqueue(new Callback<WarehouseResponse>() {
            @Override
            public void onResponse(Call<WarehouseResponse> call, Response<WarehouseResponse> response) {
                if (response.isSuccessful() && response.body() != null) {
                    request.triggerSuccess(response.body().data);
                } else {
                    request.triggerError(new Exception("API Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<WarehouseResponse> call, Throwable t) {
                request.triggerError(t);
            }
        });

        return request;
    }
}
