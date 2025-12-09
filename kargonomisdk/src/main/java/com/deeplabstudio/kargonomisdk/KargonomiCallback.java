package com.deeplabstudio.kargonomisdk;

public interface KargonomiCallback<T> {
    void onSuccess(T result);
    void onError(Throwable error);
}

