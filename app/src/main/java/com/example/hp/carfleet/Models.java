package com.example.hp.carfleet;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import com.google.gson.annotations.SerializedName;

import java.io.IOException;
import java.net.URL;

public class Models {
    @SerializedName("Id")
    private String Id;
    @SerializedName("Name")
    private String Name;
    @SerializedName("Type")
    private String Type;
    @SerializedName("Category")
    private String Category;
   @SerializedName("Picture")
    private String Picture;
    @SerializedName("PicturePath")
    private String PicturePath;
    @SerializedName("modelSelect")
    private String modelSelect;

    public String getModelSelect() {
        return modelSelect;
    }

    public void setModelSelect(String modelSelect) {
        this.modelSelect = modelSelect;
    }
/* private Bitmap Picture;

    {
        try {
            URL url =new URL(this.Image);
            Picture = BitmapFactory.decodeStream(url.openConnection().getInputStream());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    ;*/



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

    public String getType() {
        return Type;
    }

    public void setType(String type) {
        Type = type;
    }

    public String getCategory() {
        return Category;
    }

    public void setCategory(String category) {
        Category = category;
    }

    public String getPicture() {
        return Picture;
    }

    public void setPicture(String picture) {
        Picture = picture;
    }

    public String getPicturePath() {
        return PicturePath;
    }

    public void setPicturePath(String picturePath) {
        PicturePath = picturePath;
    }



}



