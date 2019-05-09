package com.example.hp.carfleet;

import com.google.gson.annotations.SerializedName;

import java.util.Arrays;
import java.util.Date;

public class Vehicle {

    @SerializedName("identifiant")
    private String identifiant;
    @SerializedName("immatriculation")
    private String immatriculation;
    @SerializedName("numeroChassis")
    private int numeroChassis;
    @SerializedName("couleur")
    private String couleur;
    @SerializedName("dateMiseEnService")
    private Date dateMiseEnService;
    @SerializedName("parkingId")
    private Date parkingId;
    @SerializedName("categoryId")
    private String CategoryId;
    @SerializedName("dateImmatriculation")
    private Date dateImmatriculation;
    @SerializedName("images")
    private String[] image;
    @SerializedName("kilometrage")
    private String kilometrage;
    @SerializedName("prixCatalogue")
    private double prixCatalogue;
    @SerializedName("entrepriseId")
    private String entrepriseId;

    public Vehicle(String identifiant, String immatriculation, int numeroChassis, String couleur, Date dateMiseEnService, Date parkingId, String categoryId, Date dateImmatriculation, String[] image, String kilometrage, double prixCatalogue, String entrepriseId) {
        this.identifiant = identifiant;
        this.immatriculation = immatriculation;
        this.numeroChassis = numeroChassis;
        this.couleur = couleur;
        this.dateMiseEnService = dateMiseEnService;
        this.parkingId = parkingId;
        CategoryId = categoryId;
        this.dateImmatriculation = dateImmatriculation;
        this.image = image;
        this.kilometrage = kilometrage;
        this.prixCatalogue = prixCatalogue;
        this.entrepriseId = entrepriseId;
    }

    public Vehicle() {
    }

    public String getIdentifiant() {
        return identifiant;
    }

    public void setIdentifiant(String identifiant) {
        this.identifiant = identifiant;
    }

    public String getImmatriculation() {
        return immatriculation;
    }

    public void setImmatriculation(String immatriculation) {
        this.immatriculation = immatriculation;
    }

    public int getNumeroChassis() {
        return numeroChassis;
    }

    public void setNumeroChassis(int numeroChassis) {
        this.numeroChassis = numeroChassis;
    }

    public String getCouleur() {
        return couleur;
    }

    public void setCouleur(String couleur) {
        this.couleur = couleur;
    }

    public Date getDateMiseEnService() {
        return dateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        this.dateMiseEnService = dateMiseEnService;
    }

    public Date getParkingId() {
        return parkingId;
    }

    public void setParkingId(Date parkingId) {
        this.parkingId = parkingId;
    }

    public String getCategoryId() {
        return CategoryId;
    }

    public void setCategoryId(String categoryId) {
        CategoryId = categoryId;
    }

    public Date getDateImmatriculation() {
        return dateImmatriculation;
    }

    public void setDateImmatriculation(Date dateImmatriculation) {
        this.dateImmatriculation = dateImmatriculation;
    }

    public String[] getImage() {
        return image;
    }

    public void setImage(String[] image) {
        this.image = image;
    }

    public String getKilometrage() {
        return kilometrage;
    }

    public void setKilometrage(String kilometrage) {
        this.kilometrage = kilometrage;
    }

    public double getPrixCatalogue() {
        return prixCatalogue;
    }

    public void setPrixCatalogue(double prixCatalogue) {
        this.prixCatalogue = prixCatalogue;
    }

    public String getEntrepriseId() {
        return entrepriseId;
    }

    public void setEntrepriseId(String entrepriseId) {
        this.entrepriseId = entrepriseId;
    }

    @Override
    public String toString() {
        return "Vehicle{" +
                "identifiant='" + identifiant + '\'' +
                ", immatriculation='" + immatriculation + '\'' +
                ", numeroChassis=" + numeroChassis +
                ", couleur='" + couleur + '\'' +
                ", dateMiseEnService=" + dateMiseEnService +
                ", parkingId=" + parkingId +
                ", CategoryId='" + CategoryId + '\'' +
                ", dateImmatriculation=" + dateImmatriculation +
                ", image=" + Arrays.toString(image) +
                ", kilometrage='" + kilometrage + '\'' +
                ", prixCatalogue=" + prixCatalogue +
                ", entrepriseId='" + entrepriseId + '\'' +
                '}';
    }
}