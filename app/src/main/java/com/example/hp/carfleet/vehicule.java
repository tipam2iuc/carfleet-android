package com.example.hp.carfleet;

public class vehicule {
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
