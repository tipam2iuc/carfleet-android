package com.example.hp.carfleet;

import java.util.Date;

public class tacheEntretien {

    private String id ;
    private Date date ;
    private String Intitule;
    private String tacheRealisee;
    private String estReportee;

    public tacheEntretien(String id, Date date, String intitule, String tacheRealisee, String estReportee) {
        this.id = id;
        this.date = date;
        Intitule = intitule;
        this.tacheRealisee = tacheRealisee;
        this.estReportee = estReportee;
    }

    public tacheEntretien() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getIntitule() {
        return Intitule;
    }

    public void setIntitule(String intitule) {
        Intitule = intitule;
    }

    public String getTacheRealisee() {
        return tacheRealisee;
    }

    public void setTacheRealisee(String tacheRealisee) {
        this.tacheRealisee = tacheRealisee;
    }

    public String getEstReportee() {
        return estReportee;
    }

    public void setEstReportee(String estReportee) {
        this.estReportee = estReportee;
    }

    @Override
    public String toString() {
        return "tacheEntretien{" +
                "id='" + id + '\'' +
                ", date=" + date +
                ", Intitule='" + Intitule + '\'' +
                ", tacheRealisee='" + tacheRealisee + '\'' +
                ", estReportee='" + estReportee + '\'' +
                '}';
    }
}
