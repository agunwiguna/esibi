package com.ciamiscode.esibi.api;

import com.ciamiscode.esibi.model.ResponseModel;

import retrofit2.Call;
import retrofit2.http.GET;

public interface ApiService {

    @GET("tampil_huruf.php")
    Call<ResponseModel> getHuruf();

    @GET("tampil_angka.php")
    Call<ResponseModel> getAngka();

}
