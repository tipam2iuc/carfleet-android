package com.example.hp.carfleet;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Date;

public class Vehicle {

    @SerializedName("Id")
    private String Id;
    @SerializedName("marque")
    private String Marque;
    @SerializedName("Description")
    private String Description;
    @SerializedName("color")
    private String Couleur;
    @SerializedName("pictures")
    private String[] Images;
    @SerializedName("commissioning")
    private Date MiseEnService;
    @SerializedName("categoryId")
    private String CategoryId;

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public Vehicle() {
    }

    public Vehicle(String id, String marque, String description, String couleur, String[] images, Date miseEnService, String categoryId) {
        Id = id;
        Marque = marque;
        Description = description;
        Couleur = couleur;
        Images = images;
        MiseEnService = miseEnService;
        CategoryId = categoryId;
    }

    public String getId() {
        return Id;
    }

    public void setId(String id) {
        Id = id;
    }

    public String getMarque() {
        return Marque;
    }

    public void setMarque(String marque) {
        Marque = marque;
    }

    public String getDescription() {
        return Description;
    }

    public void setDescription(String description) {
        Description = description;
    }

    public String getCouleur() {
        return Couleur;
    }

    public void setCouleur(String couleur) {
        Couleur = couleur;
    }

    public String[] getImages() {
        return Images;
    }

    public void setImages(String images) {
        Images[0] = images;
    }

    public Date getMiseEnService() {
        return MiseEnService;
    }

    public void setMiseEnService(Date miseEnService) {
        MiseEnService = miseEnService;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "Id='" + Id + '\'' +
                ", Marque='" + Marque + '\'' +
                ", Description='" + Description + '\'' +
                ", Couleur='" + Couleur + '\'' +
                ", Images=" + Arrays.toString(Images) +
                ", MiseEnService=" + MiseEnService +
                '}';
    }
}
