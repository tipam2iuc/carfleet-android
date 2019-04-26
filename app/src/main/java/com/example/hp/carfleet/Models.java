package com.example.hp.carfleet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URL;

public class Models {


    @SerializedName("id")
    private String Id;
    @SerializedName("nomComplet")
    private String Name;
    @SerializedName("puissanceMax")
    private String PuissanceMax;
    @SerializedName("vitesseMax")
    private String VitesseMax;
    @SerializedName("longueur")
    private String Longueur;
    @SerializedName("largeur")
    private String Largeur;
    @SerializedName("hauteur")
    private String Hauteur;
    @SerializedName("nombrePlace")
    private int NombrePlace;
    @SerializedName("image")
    private String Picture;
    @SerializedName("typeModel")
    private String TypeModel;
    @SerializedName("carrosserie")
    private String Carrosserie;
    @SerializedName("marque")
    private String Marque;
    @SerializedName("essence")
    private String Essence;
    @SerializedName("boiteVitesse")
    private String BoiteVitesse;

    public Models(String id, String name, String puissanceMax, String vitesseMax, String longueur, String largeur, String hauteur, int nombrePlace, String picture, String typeModel, String carrosserie, String marque, String essence, String boiteVitesse) {
        Id = id;
        Name = name;
        PuissanceMax = puissanceMax;
        VitesseMax = vitesseMax;
        Longueur = longueur;
        Largeur = largeur;
        Hauteur = hauteur;
        NombrePlace = nombrePlace;
        Picture = picture;
        TypeModel = typeModel;
        Carrosserie = carrosserie;
        Marque = marque;
        Essence = essence;
        BoiteVitesse = boiteVitesse;
    }


    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getName() {
        return Name;
    }

    public void setName(String name) {
        Name = name;
    }

    public String getPuissanceMax() {
        return PuissanceMax;
    }

    public void setPuissanceMax(String puissanceMax) {
        PuissanceMax = puissanceMax;
    }

    public String getVitesseMax() {
        return VitesseMax;
    }

    public void setVitesseMax(String vitesseMax) {
        VitesseMax = vitesseMax;
    }

    public String getLongueur() {
        return Longueur;
    }

    public void setLongueur(String longueur) {
        Longueur = longueur;
    }

    public String getLargeur() {
        return Largeur;
    }

    public void setLargeur(String largeur) {
        Largeur = largeur;
    }

    public String getHauteur() {
        return Hauteur;
    }

    public void setHauteur(String hauteur) {
        Hauteur = hauteur;
    }

    public int getNombrePlace() {
        return NombrePlace;
    }

    public void setNombrePlace(int nombrePlace) {
        NombrePlace = nombrePlace;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getTypeModel() {
        return TypeModel;
    }

    public void setTypeModel(String typeModel) {
        TypeModel = typeModel;
    }

    public String getCarrosserie() {
        return Carrosserie;
    }

    public void setCarrosserie(String carrosserie) {
        Carrosserie = carrosserie;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public String getEssence() {
        return Essence;
    }

    public void setEssence(String essence) {
        Essence = essence;
    }

    public String getBoiteVitesse() {
        return BoiteVitesse;
    }

    public void setBoiteVitesse(String boiteVitesse) {
        BoiteVitesse = boiteVitesse;
    }




/* private Bitmap Picture;

    {
        try {
            URL url =new URL(this.Image);
            Picture = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;*/






}



