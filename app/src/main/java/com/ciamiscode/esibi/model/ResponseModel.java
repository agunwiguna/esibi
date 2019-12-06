package com.ciamiscode.esibi.model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class ResponseModel {

    @SerializedName("status_code")
    private String statusCode;
    @SerializedName("message")
    private String message;

    List<GambarModel> result_huruf;
    List<GambarModel> result_angka;

    public List<GambarModel> getResult_huruf() {
        return result_huruf;
    }

    public void setResult_huruf(List<GambarModel> result_huruf) {
        this.result_huruf = result_huruf;
    }

    public List<GambarModel> getResult_angka() {
        return result_angka;
    }

    public void setResult_angka(List<GambarModel> result_angka) {
        this.result_angka = result_angka;
    }

    public String getStatusCode() {
        return statusCode;
    }

    public void setStatusCode(String statusCode) {
        this.statusCode = statusCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
