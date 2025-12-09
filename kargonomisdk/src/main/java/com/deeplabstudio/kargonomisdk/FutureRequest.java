package com.deeplabstudio.kargonomisdk;

public class FutureRequest<T> {

    private SuccessCallback<T> successCallback;
    private ErrorCallback errorCallback;

    private boolean isCompleted = false;
    private T successValue;
    private Throwable errorValue;

    public interface SuccessCallback<T> {
        void onSuccess(T result);
    }

    public interface ErrorCallback {
        void onError(Throwable error);
    }

    public void triggerSuccess(T value) {
        if (isCompleted) return;

        isCompleted = true;
        successValue = value;

        if (successCallback != null) {
            successCallback.onSuccess(value);
        }
    }

    public void triggerError(Throwable error) {
        if (isCompleted) return;

        isCompleted = true;
        errorValue = error;

        if (errorCallback != null) {
            errorCallback.onError(error);
        }
    }

    public FutureRequest<T> onSuccess(SuccessCallback<T> callback) {
        this.successCallback = callback;

        // Eğer işlem önceden tamamlandıysa hemen çağır
        if (isCompleted && errorValue == null) {
            callback.onSuccess(successValue);
        }

        return this;
    }

    public FutureRequest<T> onError(ErrorCallback callback) {
        this.errorCallback = callback;

        // Eğer işlem önceden hata ile tamamlandıysa hemen çağır
        if (isCompleted && errorValue != null) {
            callback.onError(errorValue);
        }

        return this;
    }
}
