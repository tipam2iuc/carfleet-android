package com.example.hp.carfleet;

import com.google.gson.annotations.SerializedName;

import java.util.Date;

public class vehicule {

    @SerializedName("id")
    private String id;
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




    public String getMatricule() {
        return matricule;
    }

    public void setMatricule(String matricule) {
        this.matricule = matricule;
    }

    public String getMarque() {
        return marque;
    }

    public void setMarque(String marque) {
        this.marque = marque;
    }

    public Transmition getTransmition() {
        return transmition;
    }

    public void setTransmition(Transmition transmition) {
        this.transmition = transmition;
    }

    public Consommation getConsommation() {
        return consommation;
    }

    public void setConsommation(Consommation consommation) {
        this.consommation = consommation;
    }

    public Position getType_position() {
        return type_position;
    }

    public void setType_position(Position type_position) {
        this.type_position = type_position;
    }

    public Occupation getOccupation() {
        return occupation;
    }

    public void setOccupation(Occupation occupation) {
        this.occupation = occupation;
    }

    public String getClasse() {
        return classe;
    }

    public void setClasse(String classe) {
        this.classe = classe;
    }


    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public boolean isFavoris() {
        return favoris;
    }

    public void setFavoris(boolean favoris) {
        this.favoris = favoris;
    }

    public vehicule() {
    }

    public int getViewType() {
        return viewType;
    }

    public void setViewType(int viewType) {
        this.viewType = viewType;
    }

    public vehicule(int viewType, boolean favoris,
                    String classe, String matricule,
                    String marque, Transmition transmition,
                    Consommation consommation, String position,
                    Position type_position, Occupation occupation) {
        this.viewType = viewType;
        this.favoris = favoris;
        this.classe = classe;
        this.matricule = matricule;
        this.marque = marque;
        this.transmition = transmition;
        this.consommation = consommation;
        this.position = position;
        this.type_position = type_position;
        this.occupation = occupation;
    }

    public vehicule(int viewType, boolean favoris, String classe, String matricule, String marque,
                    Transmition transmition, Consommation consommation, String position,
                    Position type_position, Occupation occupation, int prix) {
        this.viewType = viewType;
        this.favoris = favoris;
        this.classe = classe;
        this.matricule = matricule;
        this.marque = marque;
        this.transmition = transmition;
        this.consommation = consommation;
        this.position = position;
       this.type_position = type_position;
        this.occupation = occupation;
        this.prix = prix;
    }

    int viewType;
    boolean favoris = false;
    String classe;
    String matricule;
    String marque;
    Transmition transmition;
    Consommation consommation;
    String position;
    Position type_position;
    Occupation occupation;
    int prix;

    public String getIdentifiant() {
        return id;
    }

    public void setIdentifiant(String identifiant) {
        this.id = identifiant;
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

    enum Position
    {
        En_Deplacement,
        Hors_Service,
        Gare,
    }

    enum Transmition
    {
        Manuel,
        Auto,
        Semi_automatique,
    }

    enum Consommation
    {
        Essence,
        Diesel,
        Electrique,
        Hybride
    }

    enum Occupation
    {
        Affecte,
        Affecte_Employe,
        En_location,
        En_panne,
        Accidente,
        Non_Affecte
    }
}
