package com.example.hp.carfleet;

public class model {
    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public boolean isFavoris() {
        return favoris;
    }

    public void setFavoris(boolean favoris) {
        this.favoris = favoris;
    }

    public String getNomModel() {
        return nomModel;
    }

    public void setNomModel(String nomModel) {
        this.nomModel = nomModel;
    }

    public model(int viewType, String nomModel) {
        this.viewType = viewType;
        this.nomModel = nomModel;
    }

    public model()
    {

    }
    int viewType;
    boolean favoris = false;
    String nomModel;
}
