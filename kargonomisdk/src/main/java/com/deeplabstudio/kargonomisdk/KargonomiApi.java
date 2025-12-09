package com.deeplabstudio.kargonomisdk;

import com.deeplabstudio.kargonomisdk.Models.Address.City;
import com.deeplabstudio.kargonomisdk.Models.Address.State;
import com.deeplabstudio.kargonomisdk.Models.User.UserCreditResponse;
import com.deeplabstudio.kargonomisdk.Models.Warehouse.WarehouseResponse;
import com.deeplabstudio.kargonomisdk.Models.Shipment.*;

import java.util.List;

import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.http.*;

public interface KargonomiApi {

    @GET("states")
    Call<List<State>> getStates();

    @GET("cities/{stateId}")
    Call<List<City>> getCities(@Path("stateId") int stateId);

    @GET("warehouses")
    Call<WarehouseResponse> getWarehouses();

    @GET("shipments")
    Call<ShipmentListResponse> getShipments(@Query("page") int page);

    @GET("shipments/{id}")
    Call<ShipmentDetailResponse> getShipmentDetail(@Path("id") String shipmentId);

    @POST("shipments")
    Call<ShipmentDetailResponse> createShipment(@Body CreateShipmentRequest request);

    @PUT("shipments/{id}")
    Call<ShipmentDetailResponse> updateShipment(
            @Path("id") String shipmentId,
            @Body CreateShipmentRequest request
    );

    @DELETE("shipments/{id}")
    Call<ResponseBody> deleteShipment(@Path("id") String shipmentId);

    @POST("shipments/cancel")
    Call<ResponseBody> cancelShipment(@Body CancelShipmentRequest request);

    @GET("shipments/{id}/barcode")
    Call<ResponseBody> getShipmentBarcode(
            @Path("id") String shipmentId,
            @Query("format") String format,
            @Query("packageContentVisibility") boolean contentVisibility,
            @Query("warningVisibility") boolean warningVisibility
    );

    @GET("shipment-price-comparison/{id}")
    Call<PriceComparisonResponse> getPriceComparison(@Path("id") String shipmentId);

    @Multipart
    @POST("confirm-shipping-price")
    Call<ResponseBody> confirmShippingPrice(
            @Part("shipment_id") RequestBody shipmentId,
            @Part("shipping_provider_id") RequestBody providerId
    );

    @GET("user/credit")
    Call<UserCreditResponse> getUserCredit();
}
