package com.example.hp.carfleet;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;


public interface RetroFitApiInterface {
    @GET("modeles?marque=Audi")
   Call<ArrayList<Models>> getModelsAudi();

    @GET("modeles?marque=Bmw")
    Call<ArrayList<Models>> getModelsBmw();

    @GET("modeles?marque=Citroen")
    Call<ArrayList<Models>> getModelsCitroen();

    @GET("modeles?marque=Ford")
    Call<ArrayList<Models>> getModelsFord();

    @GET("modeles?marque=Mercedes")
    Call<ArrayList<Models>> getModelsMercedes();

    @GET("modeles?marque=Peugeot")
    Call<ArrayList<Models>> getModelsPeugeot();

    @GET("modeles?marque=Renault")
    Call<ArrayList<Models>> getModelsRenault();

    @GET("modeles?marque=Toyota")
    Call<ArrayList<Models>> getModelsToyota();

    @GET("modeles?marque=Volkswagen")
    Call<ArrayList<Models>> getModelsVolkswagen();



}