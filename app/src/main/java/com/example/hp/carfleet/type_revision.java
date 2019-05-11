package com.example.hp.carfleet;

public class type_revision {

    private String id ;
    private String intitule;
    private String tacheEntretienId;

    public type_revision(String id, String intitule, String tacheEntretienId) {
        this.id = id;
        this.intitule = intitule;
        this.tacheEntretienId = tacheEntretienId;
    }

    public type_revision() {
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

    public String getTacheEntretienId() {
        return tacheEntretienId;
    }

    public void setTacheEntretienId(String tacheEntretienId) {
        this.tacheEntretienId = tacheEntretienId;
    }

    @Override
    public String toString() {
        return "type_revision{" +
                "id='" + id + '\'' +
                ", intitule='" + intitule + '\'' +
                ", tacheEntretienId='" + tacheEntretienId + '\'' +
                '}';
    }
}
