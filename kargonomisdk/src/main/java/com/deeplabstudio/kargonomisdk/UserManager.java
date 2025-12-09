package com.deeplabstudio.kargonomisdk;

import com.deeplabstudio.kargonomisdk.Models.User.UserCreditResponse;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class UserManager {

    public FutureRequest<UserCreditResponse> credit() {
        FutureRequest<UserCreditResponse> fr = new FutureRequest<>();

        Kargonomi.getApi().getUserCredit().enqueue(new Callback<UserCreditResponse>() {
            @Override
            public void onResponse(Call<UserCreditResponse> call, Response<UserCreditResponse> response) {
                if (response.isSuccessful()) {
                    fr.triggerSuccess(response.body());
                } else {
                    fr.triggerError(new Throwable("Credit error: " + response.code()));
                }
            }

            @Override
            public void onFailure(Call<UserCreditResponse> call, Throwable t) {
                fr.triggerError(t);
            }
        });

        return fr;
    }
}
