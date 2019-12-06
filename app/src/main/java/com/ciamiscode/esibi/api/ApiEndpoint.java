package com.ciamiscode.esibi.api;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiEndpoint {

    private static final String BASE_URL = "http://esibi.ergnologi.com/";

    private static Retrofit retrofit;

    public static Retrofit getClient()
    {
        if(retrofit == null)
        {
            Gson gson = new GsonBuilder().setLenient().create();
            retrofit = new Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create(gson))
                    .build();
        }

        return  retrofit;
    }

}
