package com.deeplabstudio.kargonomisdk;

import com.deeplabstudio.kargonomisdk.Models.Shipment.*;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class ShipmentManager {

    // ----- 1) Shipments List -----
    public FutureRequest<ShipmentListResponse> list(int page) {
        FutureRequest<ShipmentListResponse> fr = new FutureRequest<>();

        Kargonomi.getApi().getShipments(page).enqueue(new Callback<ShipmentListResponse>() {
            @Override
            public void onResponse(Call<ShipmentListResponse> call, Response<ShipmentListResponse> response) {
                if (response.isSuccessful()) fr.triggerSuccess(response.body());
                else fr.triggerError(new Throwable("List error: " + response.code()));
            }

            @Override
            public void onFailure(Call<ShipmentListResponse> call, Throwable t) {
                fr.triggerError(t);
            }
        });

        return fr;
    }

    // ----- 2) Shipment Detail -----
    public FutureRequest<ShipmentDetailResponse> detail(String id) {
        FutureRequest<ShipmentDetailResponse> fr = new FutureRequest<>();

        Kargonomi.getApi().getShipmentDetail(id).enqueue(new Callback<ShipmentDetailResponse>() {
            @Override
            public void onResponse(Call<ShipmentDetailResponse> call, Response<ShipmentDetailResponse> response) {
                if (response.isSuccessful()) fr.triggerSuccess(response.body());
                else fr.triggerError(new Throwable("Detail error: " + response.code()));
            }

            @Override
            public void onFailure(Call<ShipmentDetailResponse> call, Throwable t) {
                fr.triggerError(t);
            }
        });

        return fr;
    }

    // ----- 3) Create Shipment -----
    public FutureRequest<ShipmentDetailResponse> create(CreateShipmentRequest req) {
        FutureRequest<ShipmentDetailResponse> fr = new FutureRequest<>();

        Kargonomi.getApi().createShipment(req).enqueue(new Callback<ShipmentDetailResponse>() {
            @Override
            public void onResponse(Call<ShipmentDetailResponse> call, Response<ShipmentDetailResponse> response) {
                if (response.isSuccessful()) fr.triggerSuccess(response.body());
                else fr.triggerError(new Throwable("Create error: " + response.code()));
            }

            @Override
            public void onFailure(Call<ShipmentDetailResponse> call, Throwable t) {
                fr.triggerError(t);
            }
        });

        return fr;
    }

    // ----- 4) Update Shipment -----
    public FutureRequest<ShipmentDetailResponse> update(String id, CreateShipmentRequest req) {
        FutureRequest<ShipmentDetailResponse> fr = new FutureRequest<>();

        Kargonomi.getApi().updateShipment(id, req).enqueue(new Callback<ShipmentDetailResponse>() {
            @Override
            public void onResponse(Call<ShipmentDetailResponse> call, Response<ShipmentDetailResponse> response) {
                if (response.isSuccessful()) fr.triggerSuccess(response.body());
                else fr.triggerError(new Throwable("Update error: " + response.code()));
            }

            @Override
            public void onFailure(Call<ShipmentDetailResponse> call, Throwable t) {
                fr.triggerError(t);
            }
        });

        return fr;
    }

    // ----- 5) Delete Shipment -----
    public FutureRequest<Void> delete(String id) {
        FutureRequest<Void> fr = new FutureRequest<>();

        Kargonomi.getApi().deleteShipment(id).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) fr.triggerSuccess(null);
                else fr.triggerError(new Throwable("Delete error: " + response.code()));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                fr.triggerError(t);
            }
        });

        return fr;
    }

    // ----- 6) Cancel Shipment -----
    public FutureRequest<Void> cancel(String id) {
        FutureRequest<Void> fr = new FutureRequest<>();

        CancelShipmentRequest req = new CancelShipmentRequest(id);

        Kargonomi.getApi().cancelShipment(req).enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                if (response.isSuccessful()) fr.triggerSuccess(null);
                else fr.triggerError(new Throwable("Cancel error: " + response.code()));
            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                fr.triggerError(t);
            }
        });

        return fr;
    }

    // ----- 7) Barcode PDF -----
    public FutureRequest<ResponseBody> barcode(String id, String format, boolean content, boolean warning) {
        FutureRequest<ResponseBody> fr = new FutureRequest<>();

        Kargonomi.getApi().getShipmentBarcode(id, format, content, warning)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful()) fr.triggerSuccess(response.body());
                        else fr.triggerError(new Throwable("Barcode error: " + response.code()));
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        fr.triggerError(t);
                    }
                });

        return fr;
    }

    public FutureRequest<PriceComparisonResponse> priceCompare(String shipmentId) {
        FutureRequest<PriceComparisonResponse> fr = new FutureRequest<>();

        Kargonomi.getApi().getPriceComparison(shipmentId)
                .enqueue(new Callback<PriceComparisonResponse>() {
                    @Override
                    public void onResponse(Call<PriceComparisonResponse> call, Response<PriceComparisonResponse> response) {
                        if (response.isSuccessful())
                            fr.triggerSuccess(response.body());
                        else
                            fr.triggerError(new Exception("Price compare error: " + response.code()));
                    }

                    @Override
                    public void onFailure(Call<PriceComparisonResponse> call, Throwable t) {
                        fr.triggerError(t);
                    }
                });

        return fr;
    }

    public FutureRequest<Void> confirmPrice(String shipmentId, String providerId) {
        FutureRequest<Void> fr = new FutureRequest<>();

        RequestBody idBody = RequestBody.create(
                okhttp3.MultipartBody.FORM, shipmentId
        );

        RequestBody providerBody = RequestBody.create(
                okhttp3.MultipartBody.FORM, providerId
        );

        Kargonomi.getApi()
                .confirmShippingPrice(idBody, providerBody)
                .enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        if (response.isSuccessful())
                            fr.triggerSuccess(null);
                        else
                            fr.triggerError(new Throwable("Confirm price error: " + response.code()));
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        fr.triggerError(t);
                    }
                });

        return fr;
    }
}
