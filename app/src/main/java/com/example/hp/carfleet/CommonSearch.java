package com.example.hp.carfleet;

import java.util.ArrayList;


public class CommonSearch {
    public static final int VIEWTYPE_SPACE = 0;
    public static final int VIEWTYPE_SEARCH = 1;

    public CommonSearch() {
    }

    public static ArrayList<Search> AddSpace (ArrayList<Search> Searchs) {
        ArrayList<Search> custumList = new ArrayList<>();
        Search firstPosition = new Search();
        int i;

        for (i = 0; i < Searchs.size() - 1; i++) {
            Search v = new Search();
            if (i == 2) {
                firstPosition.setViewtype(CommonSearch.VIEWTYPE_SPACE);
                custumList.add(firstPosition);
            }
            if (i==7)
            {
                firstPosition.setViewtype(CommonSearch.VIEWTYPE_SPACE);
                custumList.add(firstPosition);
            }
            Searchs.get(i).setViewtype(VIEWTYPE_SEARCH);
            custumList.add(Searchs.get(i));
        }

        return custumList;

    }
}
