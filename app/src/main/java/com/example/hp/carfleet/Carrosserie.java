package com.example.hp.carfleet;

public class Carrosserie {

    private String id;
    private String intitule;

    public Carrosserie(String id, String intitule) {
        this.id = id;
        this.intitule = intitule;
    }

    public Carrosserie() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getIntitule() {
        return intitule;
    }

    public void setIntitule(String intitule) {
        this.intitule = intitule;
    }

    @Override
    public String toString() {
        return "Carrosserie{" +
                "id='" + id + '\'' +
                ", intitule='" + intitule + '\'' +
                '}';
    }
}
