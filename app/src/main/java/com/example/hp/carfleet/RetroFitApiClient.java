package com.example.hp.carfleet;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;




public class RetroFitApiClient {
    public static final String BASE_URL = "http://10.0.2.2:3000";
    private static Retrofit retrofit = null;
    static Gson gson= new GsonBuilder().setLenient().create();
    public static Retrofit getClient(){
        if(retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl(BASE_URL)
                    .addConverterFactory(GsonConverterFactory
                            .create(gson)).build();
        }
        return retrofit;
    }
}
