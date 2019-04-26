package com.example.hp.carfleet;

public class Search {

    private String micon;
    private String mDescription;
    private  int img;
    private  int viewtype;

    public int getViewtype() {
        return viewtype;
    }

    public void setViewtype(int viewtype) {
        this.viewtype = viewtype;
    }

    public Search(){}

    public int getImg() {
        return img;
    }

    public void setImg(int img) {
        this.img = img;
    }

    public Search(String mDescription, int img) {
        this.mDescription = mDescription;
        this.img = img;
    }

    public String getMicon() {
        return micon;
    }

    public void setMicon(String micon) {
        this.micon = micon;
    }

    public String getmDescription() {
        return mDescription;
    }

    public void setmDescription(String mDescription) {
        this.mDescription = mDescription;
    }

    public Search(String micon, String mDescription) {
        this.micon = micon;
        this.mDescription = mDescription;
    }
}

