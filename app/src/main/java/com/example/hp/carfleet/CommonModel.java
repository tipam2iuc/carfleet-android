package com.example.hp.carfleet;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class CommonModel {
    public static final int VIEWTYPE_GROUP = 0;
    public static final int VIEWTYPE_MODEL = 1;
    public static final int VIEWTYPE_MODEL_FAVORITE = 2;
    public static final int VIEWTYPE_GROUP_FAVORITE = 3;
    public static final int VIEWTYPE_ALL = 4;
    private static final int VIEWTYPE_OTHER = -1;

    public static List<String> regionAvailable = new ArrayList<>();

    public CommonModel(){}
    public static ArrayList<model> sortList(ArrayList<model> vehiculeArrayList){
        Collections.sort(vehiculeArrayList, new Comparator<model>() {
            @Override
            public int compare(model o1, model o2) {
                return o1.getNomModel().compareTo(o2.getNomModel());
            }
        });

        ArrayList<model> favoris = new ArrayList<>();
        for(model v: vehiculeArrayList){
            if(v.isFavoris()){
                favoris.add(v);
            }
        }
        vehiculeArrayList.removeAll(favoris);
        ArrayList<model> finalList = new ArrayList<>();
        finalList.addAll(favoris);
        finalList.addAll(vehiculeArrayList);
        return finalList;
    }

    public static ArrayList<model> addAlphabet(ArrayList<model> vehicules) {
        ArrayList<model> custumList = new ArrayList<>();
        model firstPosition = new model();

        firstPosition.setNomModel("?");
        firstPosition.setViewType(CommonModel.VIEWTYPE_OTHER);
        regionAvailable.add("?");
        custumList.add(firstPosition);
        firstPosition = new model();

        firstPosition.setNomModel("&");
        firstPosition.setViewType(CommonModel.VIEWTYPE_ALL);
        regionAvailable.add("&");
        custumList.add(firstPosition);
        firstPosition = new model();

        if (vehicules.get(0).isFavoris()) {
            firstPosition.setNomModel(".");
            firstPosition.setViewType(CommonModel.VIEWTYPE_GROUP_FAVORITE);
            regionAvailable.add(".");
        }
        else {
            firstPosition.setNomModel(vehicules.get(0).getNomModel().substring(0, 1).toUpperCase());
            firstPosition.setViewType(CommonModel.VIEWTYPE_GROUP);
            regionAvailable.add(vehicules.get(0).getNomModel().substring(0, 1).toUpperCase());
        }
        custumList.add(firstPosition);
        int i = 0;

        for (i = 0; i<vehicules.size()-1; i++){
            model v = new model();

            String region1 = vehicules.get(i).getNomModel().substring(0,1).toUpperCase();
            String region2 = vehicules.get(i+1).getNomModel().substring(0,1).toUpperCase();

            boolean favoris1 = vehicules.get(i).isFavoris();
            boolean favoris2 = vehicules.get(i+1).isFavoris();

            if(favoris1)
            {
                if(favoris1 == favoris2) {
                    vehicules.get(i).setViewType(CommonModel.VIEWTYPE_MODEL_FAVORITE);
                    custumList.add(vehicules.get(i));
                }
                else{
                    vehicules.get(i).setViewType(CommonModel.VIEWTYPE_MODEL_FAVORITE);
                    custumList.add(vehicules.get(i));
                    v.setViewType(CommonModel.VIEWTYPE_GROUP);
                    v.setNomModel(region2);
                    regionAvailable.add(region2);
                    custumList.add(v);
                }
            }
            else{
                if(region1.compareTo(region2)==0 ){
                    vehicules.get(i).setViewType(CommonModel.VIEWTYPE_MODEL);
                    custumList.add(vehicules.get(i));
                }
                else{
                    vehicules.get(i).setViewType(CommonModel.VIEWTYPE_MODEL);
                    custumList.add(vehicules.get(i));
                    v.setViewType(CommonModel.VIEWTYPE_GROUP);
                    v.setNomModel(region2);
                    regionAvailable.add(region2);
                    custumList.add(v);
                }
            }
        }
        vehicules.get(i).setViewType(CommonModel.VIEWTYPE_MODEL);
        custumList.add(vehicules.get(i));
        return custumList;
    }


        public static int findPositionWithName (String region, ArrayList < vehicule > list){
            for (int i = 0; i < list.size(); i++) {
                if (list.get(i).matricule.equals(region)) {
                    return i;
                }
            }
            return -1;
        }

    }
