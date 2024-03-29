package com.ciamiscode.esibi.model;

import com.google.gson.annotations.SerializedName;

public class GambarModel {

    @SerializedName("nama")
    private String nama;
    @SerializedName("gambar")
    private String gambar;

    public String getNama() {
        return nama;
    }

    public void setNama(String nama) {
        this.nama = nama;
    }

    public String getGambar() {
        return gambar;
    }

    public void setGambar(String gambar) {
        this.gambar = gambar;
    }
}
