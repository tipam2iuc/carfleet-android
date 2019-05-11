package com.example.hp.carfleet;

public class TacheModel {
    private String tacheEntretienId;
    private String ModelId;
    private String id;

    public TacheModel(String tacheEntretienId, String modelId, String id) {
        this.tacheEntretienId = tacheEntretienId;
        ModelId = modelId;
        this.id = id;
    }

    public TacheModel() {
    }

    public String getTacheEntretienId() {
        return tacheEntretienId;
    }

    public void setTacheEntretienId(String tacheEntretienId) {
        this.tacheEntretienId = tacheEntretienId;
    }

    public String getModelId() {
        return ModelId;
    }

    public void setModelId(String modelId) {
        ModelId = modelId;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return "TacheModel{" +
                "tacheEntretienId='" + tacheEntretienId + '\'' +
                ", ModelId='" + ModelId + '\'' +
                ", id='" + id + '\'' +
                '}';
    }
}
