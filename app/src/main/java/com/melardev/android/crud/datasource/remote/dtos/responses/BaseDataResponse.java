package com.melardev.android.crud.datasource.remote.dtos.responses;

import com.google.gson.annotations.SerializedName;

public class BaseDataResponse {
    @SerializedName("success")
    private boolean success;
    @SerializedName("full_messages")
    private String[] fullMessages;

    public BaseDataResponse(boolean success) {
        this.success = success;
    }

    public BaseDataResponse() {
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String[] getFullMessages() {
        return fullMessages;
    }

    public void setFullMessages(String[] fullMessages) {
        this.fullMessages = fullMessages;
    }
}
