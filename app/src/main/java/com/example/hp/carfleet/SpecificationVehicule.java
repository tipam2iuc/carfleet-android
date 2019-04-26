package com.example.hp.carfleet;

import java.util.Date;

public class SpecificationVehicule {

    private String Key;
    private String Value;
    private Date DateMiseEnService;

    public SpecificationVehicule() {
    }

    public String getKey() {
        return Key;
    }

    public void setKey(String key) {
        Key = key;
    }

    public String getValue() {
        return Value;
    }

    public void setValue(String value) {
        Value = value;
    }

    public Date getDateMiseEnService() {
        return DateMiseEnService;
    }

    public void setDateMiseEnService(Date dateMiseEnService) {
        DateMiseEnService = dateMiseEnService;
    }

    @Override
    public String toString() {
        return "SpecificationVehicule{" +
                "Key='" + Key + '\'' +
                ", Value='" + Value + '\'' +
                ", DateMiseEnService=" + DateMiseEnService +
                '}';
    }

    public SpecificationVehicule(String key, String value, Date dateMiseEnService) {
        if(Key=="Immatriculation")
        {
            Key = key + '\'' + dateMiseEnService;
            Value = value;
        }
        else
        {
            Key = key;
            Value = value;
        }




    }
}
