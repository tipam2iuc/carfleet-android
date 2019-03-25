package com.example.hp.carfleet;

import java.util.Date;

public class Document {

    enum type
    {
        Immatriculation,
        Conformité,
        ContrôleTechnique,
        Assurance,
        CarteIdentité,
        PermisDeConduire
    }

    private String Id;
    private String Name;
    private type Type;
    private Date CreatedDate;
    private String Picture;
    private Date ExpirationDate;
    private Date DeliveryDate;
    private String VehicleId;

    public Document() {
    }

    public Document(String id, String name, type type, Date createdDate, String picture, Date expirationDate, Date deliveryDate, String vehicleId) {
        Id = id;
        Name = name;
        Type = type;
        CreatedDate = createdDate;
        Picture = picture;
        ExpirationDate = expirationDate;
        DeliveryDate = deliveryDate;
        VehicleId = vehicleId;
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

    public type getType() {
        return Type;
    }

    public void setType(type type) {
        Type = type;
    }

    public Date getCreatedDate() {
        return CreatedDate;
    }

    public void setCreatedDate(Date createdDate) {
        CreatedDate = createdDate;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public Date getExpirationDate() {
        return ExpirationDate;
    }

    public void setExpirationDate(Date expirationDate) {
        ExpirationDate = expirationDate;
    }

    public Date getDeliveryDate() {
        return DeliveryDate;
    }

    public void setDeliveryDate(Date deliveryDate) {
        DeliveryDate = deliveryDate;
    }

    public String getVehicleId() {
        return VehicleId;
    }

    public void setVehicleId(String vehicleId) {
        VehicleId = vehicleId;
    }

    @Override
    public String toString() {
        return "Document{" +
                "Id='" + Id + '\'' +
                ", Name='" + Name + '\'' +
                ", Type=" + Type +
                ", CreatedDate=" + CreatedDate +
                ", Picture='" + Picture + '\'' +
                ", ExpirationDate=" + ExpirationDate +
                ", DeliveryDate=" + DeliveryDate +
                ", VehicleId='" + VehicleId + '\'' +
                '}';
    }
}

