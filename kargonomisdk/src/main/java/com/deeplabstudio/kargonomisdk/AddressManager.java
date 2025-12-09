package com.deeplabstudio.kargonomisdk;

import com.deeplabstudio.kargonomisdk.Callback.AddressRequest;
import com.deeplabstudio.kargonomisdk.Callback.SuccessCallback;
import com.deeplabstudio.kargonomisdk.Models.Address.City;
import com.deeplabstudio.kargonomisdk.Models.Address.State;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
public class AddressManager {
    public AddressRequest<List<State>> stateList(SuccessCallback<List<State>> success) {

        AddressRequest<List<State>> request = new AddressRequest<>();
        request.onSuccess(success);

        Call<List<State>> call = Kargonomi.getApi().getStates();

        call.enqueue(new Callback<List<State>>() {
            @Override
            public void onResponse(Call<List<State>> call, Response<List<State>> response) {
                if (response.isSuccessful()) {
                    request.triggerSuccess(response.body());
                } else {
                    request.triggerError(new Exception("API Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<State>> call, Throwable t) {
                request.triggerError(t);
            }
        });

        return request;
    }

    public AddressRequest<List<City>> cityList(int stateId, SuccessCallback<List<City>> success) {

        AddressRequest<List<City>> request = new AddressRequest<>();
        request.onSuccess(success);

        Call<List<City>> call = Kargonomi.getApi().getCities(stateId);

        call.enqueue(new Callback<List<City>>() {
            @Override
            public void onResponse(Call<List<City>> call, Response<List<City>> response) {
                if (response.isSuccessful()) {
                    request.triggerSuccess(response.body());
                } else {
                    request.triggerError(new Exception("API Error: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<List<City>> call, Throwable t) {
                request.triggerError(t);
            }
        });

        return request;
    }
}


