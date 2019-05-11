package com.example.hp.carfleet;

import java.util.Date;

public class Document {

    public Document(String id, String name, Document.type type, Date dateCreation, Date dateExpiration, Date dateDelivrance, String fichier) {
        this.id = id;
        this.name = name;
        this.type = type;
        this.dateCreation = dateCreation;
        this.dateExpiration = dateExpiration;
        this.dateDelivrance = dateDelivrance;
        this.fichier = fichier;
    }

    public Document() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Document.type getType() {
        return type;
    }

    public void setType(Document.type type) {
        this.type = type;
    }

    public Date getDateCreation() {
        return dateCreation;
    }

    public void setDateCreation(Date dateCreation) {
        this.dateCreation = dateCreation;
    }

    public Date getDateExpiration() {
        return dateExpiration;
    }

    public void setDateExpiration(Date dateExpiration) {
        this.dateExpiration = dateExpiration;
    }

    public Date getDateDelivrance() {
        return dateDelivrance;
    }

    public void setDateDelivrance(Date dateDelivrance) {
        this.dateDelivrance = dateDelivrance;
    }

    public String getFichier() {
        return fichier;
    }

    public void setFichier(String fichier) {
        this.fichier = fichier;
    }

    @Override
    public String toString() {
        return "Document{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", type=" + type +
                ", dateCreation=" + dateCreation +
                ", dateExpiration=" + dateExpiration +
                ", dateDelivrance=" + dateDelivrance +
                ", fichier='" + fichier + '\'' +
                '}';
    }

    enum type
    {
        Immatriculation,
        Conformité,
        ContrôleTechnique,
        Assurance,
        CarteIdentité,
        PermisDeConduire
    }

    private String id;
    private String name;
    private type type;
    private Date dateCreation;

    private Date dateExpiration;
    private Date dateDelivrance;
    private String fichier;


}

