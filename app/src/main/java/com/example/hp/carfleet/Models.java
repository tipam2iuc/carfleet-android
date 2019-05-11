package com.example.hp.carfleet;

import com.google.gson.annotations.SerializedName;

public class Models {


    @SerializedName("id")
    private String id;

    public String getFavoris() {
        return Favoris;
    }

    public void setFavoris(String favoris) {
        Favoris = favoris;
    }

    @SerializedName("Favoris")
    private String Favoris;
    @SerializedName("nomComplet")
    private String nomComplet;
    @SerializedName("nomDeSerie")
    private String nomDeSerie;
    @SerializedName("anneDeProduction")
    private String anneDeProduction;
    @SerializedName("cylindre")
    private String cylindre;
    @SerializedName("puissanceMaximaleMin")
    private String puissanceMaximaleMin;
    @SerializedName("puissanceMaximaleMax")
    private String puissanceMaximaleMax;
    @SerializedName("vitesseMaximale")
    private String VitesseMaximale;
    @SerializedName("poidAvideMin")
    private int poidAvideMin;
    @SerializedName("poidAvideMax")
    private int poidAvideMax;
    @SerializedName("longueur")
    private String longueur;
    @SerializedName("largeur")
    private String largeur;
    @SerializedName("hauteur")
    private String hauteur;
    @SerializedName("marqueId")
    private String marqueId;
    @SerializedName("modeleParentId")
    private String modelParentId;
    @SerializedName("energieId")
    private String energieId;
    @SerializedName("nombrePlace")
    private int nombrePlace;
    @SerializedName("porte")
    private int porte;
    @SerializedName("consomationMixte")
    private boolean consomationMixte;
    @SerializedName("imagePath")
    private String imagePath;

    @SerializedName("carrosserieId")
    private String carrosserieId;
    @SerializedName("transmissionMoteur")
    private String transmissionMoteur;
    @SerializedName("boiteVitesse")
    private String boiteVitesse;

    public Models(Object o, String audi_a1, String s, String s1, String s2, String s3, String s4, int i, String s5, String voiture, String berline, Object o1, String s6, String manuelle) {
    }

    public Models(String id, String Favoris , String nomComplet, String nomDeSerie, String anneDeProduction, String cylindre, String puissanceMaximaleMin, String puissanceMaximaleMax, String vitesseMaximale, int poidAvideMin, int poidAvideMax, String longueur, String largeur, String hauteur, String marqueId, String modelParentId, String energieId, int nombrePlace, int porte, boolean consomationMixte, String imagePath, String carrosserieId, String transmissionMoteur, String boiteVitesse) {
        this.id = id;
        this.Favoris = Favoris;
        this.nomComplet = nomComplet;
        this.nomDeSerie = nomDeSerie;
        this.anneDeProduction = anneDeProduction;
        this.cylindre = cylindre;
        this.puissanceMaximaleMin = puissanceMaximaleMin;
        this.puissanceMaximaleMax = puissanceMaximaleMax;
        VitesseMaximale = vitesseMaximale;
        this.poidAvideMin = poidAvideMin;
        this.poidAvideMax = poidAvideMax;
        this.longueur = longueur;
        this.largeur = largeur;
        this.hauteur = hauteur;
        this.marqueId = marqueId;
        this.modelParentId = modelParentId;
        this.energieId = energieId;
        this.nombrePlace = nombrePlace;
        this.porte = porte;
        this.consomationMixte = consomationMixte;
        this.imagePath = imagePath;
        this.carrosserieId = carrosserieId;
        this.transmissionMoteur = transmissionMoteur;
        this.boiteVitesse = boiteVitesse;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getNomComplet() {
        return nomComplet;
    }

    public void setNomComplet(String nomComplet) {
        this.nomComplet = nomComplet;
    }

    public String getNomDeSerie() {
        return nomDeSerie;
    }

    public void setNomDeSerie(String nomDeSerie) {
        this.nomDeSerie = nomDeSerie;
    }

    public String getAnneDeProduction() {
        return anneDeProduction;
    }

    public void setAnneDeProduction(String anneDeProduction) {
        this.anneDeProduction = anneDeProduction;
    }

    public String getCylindre() {
        return cylindre;
    }

    public void setCylindre(String cylindre) {
        this.cylindre = cylindre;
    }

    public String getPuissanceMaximaleMin() {
        return puissanceMaximaleMin;
    }

    public void setPuissanceMaximaleMin(String puissanceMaximaleMin) {
        this.puissanceMaximaleMin = puissanceMaximaleMin;
    }

    public String getPuissanceMaximaleMax() {
        return puissanceMaximaleMax;
    }

    public void setPuissanceMaximaleMax(String puissanceMaximaleMax) {
        this.puissanceMaximaleMax = puissanceMaximaleMax;
    }

    public String getVitesseMaximale() {
        return VitesseMaximale;
    }

    public void setVitesseMaximale(String vitesseMaximale) {
        VitesseMaximale = vitesseMaximale;
    }

    public int getPoidAvideMin() {
        return poidAvideMin;
    }

    public void setPoidAvideMin(int poidAvideMin) {
        this.poidAvideMin = poidAvideMin;
    }

    public int getPoidAvideMax() {
        return poidAvideMax;
    }

    public void setPoidAvideMax(int poidAvideMax) {
        this.poidAvideMax = poidAvideMax;
    }

    public String getLongueur() {
        return longueur;
    }

    public void setLongueur(String longueur) {
        this.longueur = longueur;
    }

    public String getLargeur() {
        return largeur;
    }

    public void setLargeur(String largeur) {
        this.largeur = largeur;
    }

    public String getHauteur() {
        return hauteur;
    }

    public void setHauteur(String hauteur) {
        this.hauteur = hauteur;
    }

    public String getMarqueId() {
        return marqueId;
    }

    public void setMarqueId(String marqueId) {
        this.marqueId = marqueId;
    }

    public String getModelParentId() {
        return modelParentId;
    }

    public void setModelParentId(String modelParentId) {
        this.modelParentId = modelParentId;
    }

    public String getEnergieId() {
        return energieId;
    }

    public void setEnergieId(String energieId) {
        this.energieId = energieId;
    }

    public int getNombrePlace() {
        return nombrePlace;
    }

    public void setNombrePlace(int nombrePlace) {
        this.nombrePlace = nombrePlace;
    }

    public int getPorte() {
        return porte;
    }

    public void setPorte(int porte) {
        this.porte = porte;
    }

    public boolean isConsomationMixte() {
        return consomationMixte;
    }

    public void setConsomationMixte(boolean consomationMixte) {
        this.consomationMixte = consomationMixte;
    }



    public String getImagePath() {
        return imagePath;
    }

    public void setImagePath(String imagePath) {
        this.imagePath = imagePath;
    }

    public String getCarrosserieId() {
        return carrosserieId;
    }

    public void setCarrosserieId(String carrosserieId) {
        this.carrosserieId = carrosserieId;
    }

    public String getTransmissionMoteur() {
        return transmissionMoteur;
    }

    public void setTransmissionMoteur(String transmissionMoteur) {
        this.transmissionMoteur = transmissionMoteur;
    }

    public String getBoiteVitesse() {
        return boiteVitesse;
    }

    public void setBoiteVitesse(String boiteVitesse) {
        this.boiteVitesse = boiteVitesse;
    }


    //de model
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



    public Models(int viewType, String nomModel) {
        this.viewType = viewType;
        this.nomModel = nomModel;
    }


    int viewType;
    boolean favoris = false;
    String nomModel;
}










