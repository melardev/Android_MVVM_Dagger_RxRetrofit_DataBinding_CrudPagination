package com.melardev.android.crud.datasource.common.models;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.melardev.android.crud.datasource.common.enums.OperationStatus;

public class DataSourceOperation<T> {

    @NonNull
    public final OperationStatus operationStatus;

    @Nullable
    public final T data;
    @Nullable
    public final String[] fullMessages;

    private DataSourceOperation(@NonNull OperationStatus operationStatus, @Nullable T data, @Nullable String[] fullMessages) {
        this.operationStatus = operationStatus;
        this.data = data;
        this.fullMessages = fullMessages;
    }

    public static <T> DataSourceOperation<T> success(@NonNull T data) {
        return new DataSourceOperation<>(OperationStatus.SUCCESS, data, null);
    }

    public static <T> DataSourceOperation<T> success(String[] fullMessages, T data) {
        return new DataSourceOperation<>(OperationStatus.SUCCESS, data, fullMessages);
    }

    public static <T> DataSourceOperation<T> error(String[] msg, @Nullable T data) {
        return new DataSourceOperation<>(OperationStatus.ERROR, data, msg);
    }

    public static <T> DataSourceOperation<T> loading(@Nullable T data) {
        return new DataSourceOperation<>(OperationStatus.LOADING, data, null);
    }

    public boolean isSuccess() {
        return operationStatus == OperationStatus.SUCCESS && data != null;
    }

    public boolean isLoading() {
        return operationStatus == OperationStatus.LOADING;
    }

    public boolean isLoaded() {
        return operationStatus != OperationStatus.LOADING;
    }
}
