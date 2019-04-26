package com.example.hp.carfleet;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

public class Common {
    public static final int VIEWTYPE_GROUP = 0;
    public static final int VIEWTYPE_CAR = 1;
    public static final int VIEWTYPE_CAR_FAVORITE = 2;
    public static final int VIEWTYPE_GROUP_FAVORITE = 3;

    public static List<String> regionAvailable = new ArrayList<>();

    public Common(){}
    public static ArrayList<vehicule> sortList(ArrayList<vehicule> vehiculeArrayList){
        Collections.sort(vehiculeArrayList, new Comparator<vehicule>() {
            @Override
            public int compare(vehicule o1, vehicule o2) {
                return o1.getMatricule().compareTo(o2.getMatricule());
            }
        });

        ArrayList<vehicule> favoris = new ArrayList<>();
        for(vehicule v: vehiculeArrayList){
            if(v.isFavoris()){
                favoris.add(v);
            }
        }
        vehiculeArrayList.removeAll(favoris);
        ArrayList<vehicule> finalList = new ArrayList<>();
        finalList.addAll(favoris);
        finalList.addAll(vehiculeArrayList);
        return finalList;
    }

    public static ArrayList<vehicule> addRegion(ArrayList<vehicule> vehicules){
        ArrayList<vehicule> custumList = new ArrayList<>();
        vehicule firstPosition = new vehicule();
        if(vehicules.get(0).isFavoris()){
            firstPosition.setMatricule("..");
            firstPosition.setViewType(Common.VIEWTYPE_GROUP_FAVORITE);
            regionAvailable.add("..");
        }else {
            firstPosition.setMatricule(vehicules.get(0).getMatricule().substring(0, 2).toUpperCase());
            firstPosition.setViewType(Common.VIEWTYPE_GROUP);
            regionAvailable.add(vehicules.get(0).getMatricule().substring(0, 2).toUpperCase());
        }
        custumList.add(firstPosition);
        int i = 0;

        for (i = 0; i<vehicules.size()-1; i++){
            vehicule v = new vehicule();

            String region1 = vehicules.get(i).getMatricule().substring(0,2).toUpperCase();
            String region2 = vehicules.get(i+1).getMatricule().substring(0,2).toUpperCase();

            boolean favoris1 = vehicules.get(i).isFavoris();
            boolean favoris2 = vehicules.get(i+1).isFavoris();

            if(favoris1)
            {
                if(region1.compareTo(region2)==0 ){
                    if(favoris1 == favoris2) {
                        vehicules.get(i).setViewType(Common.VIEWTYPE_CAR_FAVORITE);
                        custumList.add(vehicules.get(i));
                    }
                    else{
                        vehicules.get(i).setViewType(Common.VIEWTYPE_CAR_FAVORITE);
                        custumList.add(vehicules.get(i));
                        v.setViewType(Common.VIEWTYPE_GROUP);
                        v.setMatricule(region2);
                        regionAvailable.add(region2);
                        custumList.add(v);
                    }
                }
                else
                {
                    vehicules.get(i).setViewType(Common.VIEWTYPE_CAR_FAVORITE);
                    custumList.add(vehicules.get(i));
                    v.setViewType(Common.VIEWTYPE_GROUP);
                    v.setMatricule(region2);
                    regionAvailable.add(region2);
                    custumList.add(v);
                }
            }
            else{
                if(region1.compareTo(region2)==0 ){
                    vehicules.get(i).setViewType(Common.VIEWTYPE_CAR);
                    custumList.add(vehicules.get(i));
                }
                else{
                    vehicules.get(i).setViewType(Common.VIEWTYPE_CAR);
                    custumList.add(vehicules.get(i));
                    v.setViewType(Common.VIEWTYPE_GROUP);
                    v.setMatricule(region2);
                    regionAvailable.add(region2);
                    custumList.add(v);
                }
            }
        }
        vehicules.get(i).setViewType(Common.VIEWTYPE_CAR);
        custumList.add(vehicules.get(i));
        return custumList;
    }


    public static int findPositionWithName(String region, ArrayList<vehicule> list){
        for (int i=0; i<list.size();i++){
            if(list.get(i).matricule.equals(region)){
                return i;
            }
        }
        return -1;
    }


}
