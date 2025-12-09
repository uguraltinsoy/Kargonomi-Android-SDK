package com.deeplabstudio.kargonomisdk.Callback;

public class AddressRequest<T> {

    private SuccessCallback<T> successCallback;
    private ErrorCallback errorCallback;

    public AddressRequest<T> onSuccess(SuccessCallback<T> callback) {
        this.successCallback = callback;
        return this;
    }

    public AddressRequest<T> onError(ErrorCallback callback) {
        this.errorCallback = callback;
        return this;
    }

    public void triggerSuccess(T data) {
        if (successCallback != null) successCallback.onSuccess(data);
    }

    public void triggerError(Throwable error) {
        if (errorCallback != null) errorCallback.onError(error);
    }
}

