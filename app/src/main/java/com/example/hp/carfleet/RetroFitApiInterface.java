package com.example.hp.carfleet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RetroFitApiInterface {
    @GET("model?name=Audi")
   Call<ArrayList<Models>> getModelsAudi();

    @GET("model?name=Bmw")
    Call<ArrayList<Models>> getModelsBmw();

    @GET("model?name=Citroen")
    Call<ArrayList<Models>> getModelsCitroen();

    @GET("model?name=Ford")
    Call<ArrayList<Models>> getModelsFord();

    @GET("model?name=Mercedes")
    Call<ArrayList<Models>> getModelsMercedes();

    @GET("model?name=Peugeot")
    Call<ArrayList<Models>> getModelsPeugeot();

    @GET("model?name=Renault")
    Call<ArrayList<Models>> getModelsRenault();

    @GET("model?name=Toyota")
    Call<ArrayList<Models>> getModelsToyota();

    @GET("model?name=Volkswagen")
    Call<ArrayList<Models>> getModelsVolkswagen();



}