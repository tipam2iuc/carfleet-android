package com.example.hp.carfleet;

import java.util.ArrayList;
import java.util.List;

public class Marques {
    private String Name;
    private String Image;
    private ArrayList<Models> ModelList;

    public Marques(String nom, String image, ArrayList<Models> modelList) {
        Name = nom;
        Image = image;
        ModelList = modelList;
    }

    public Marques() {
    }

    public String getName() {
        return Name;
    }

    public void setName(String nom) {
        Name = nom;
    }

    public String getImage() {
        return Image;
    }

    public void setImage(String image) {
        Image = image;
    }

    public ArrayList<Models> getModelList() {
        return ModelList;
    }

    public void setModelList(ArrayList<Models> modelList) {
        ModelList = modelList;
    }

    @Override
    public String toString() {
        return "Marques{" +
                "Nom='" + Name + '\'' +
                ", Image='" + Image + '\'' +
                ", ModelList=" + ModelList +
                '}';
    }
}
