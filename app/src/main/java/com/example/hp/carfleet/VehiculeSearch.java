package com.example.hp.carfleet;

import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.Toolbar;
import android.widget.TextView;

import java.util.ArrayList;

public class VehiculeSearch extends AppCompatActivity {
    Toolbar tool_menu;
    RecyclerView recyclerView_liste_voiture;
    List_car_Adapter adapter;
    TextView textView_vehicule_number;
    LinearLayoutManager layoutManager;
    ArrayList<vehicule> vehiculeList = new ArrayList<>();
    ArrayList<vehicule> vehicules= new ArrayList<>();
    vehicule v;

    @RequiresApi(api = Build.VERSION_CODES.P)
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_vehicule_search);

        tool_menu = findViewById(R.id.tool_menu_bar);
        layoutManager = new LinearLayoutSmooth(this);
        recyclerView_liste_voiture = findViewById(R.id.recyclerView_liste_voiture);
        textView_vehicule_number = findViewById(R.id.textView_vehicule_number);
        recyclerView_liste_voiture.setLayoutManager(layoutManager);

        setSupportActionBar(tool_menu);

        v = new vehicule(-1,true,"C","LT322B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Auto, vehicule.Consommation.Diesel,
                "Akwa P-03", vehicule.Position.En_Deplacement, vehicule.Occupation.En_location,24000);
        vehiculeList.add(v);

        v =  new vehicule(-1,true,"C","LT323B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Auto, vehicule.Consommation.Hybride,
                "Akwa P-03", vehicule.Position.Hors_Service, vehicule.Occupation.Accidente);
        vehiculeList.add(v);

        v =  new vehicule(-1,false,"C","LT324B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Auto, vehicule.Consommation.Electrique,
                "Akwa P-03", vehicule.Position.Gare, vehicule.Occupation.Non_Affecte);
        vehiculeList.add(v);

        v=  new vehicule(-1,false,"C","LT325B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Manuel, vehicule.Consommation.Essence,
                "Akwa P-03", vehicule.Position.Gare, vehicule.Occupation.Non_Affecte);
        vehiculeList.add(v);

        v =  new vehicule(-1,false,"C","LT326B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Manuel, vehicule.Consommation.Essence,
                "Bonanjo P-02", vehicule.Position.Gare, vehicule.Occupation.Non_Affecte);
        vehiculeList.add(v);

        v =  new vehicule(-1,false,"C","LT327B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Manuel, vehicule.Consommation.Essence,
                "Akwa P-03", vehicule.Position.Gare, vehicule.Occupation.En_location,56000);
        vehiculeList.add(v);

        v =  new vehicule(-1,true,"C","LT328B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Manuel, vehicule.Consommation.Essence,
                "Makepe P-01", vehicule.Position.Gare, vehicule.Occupation.Non_Affecte);
        vehiculeList.add(v);

        v =  new vehicule(-1,true,"C","LT329B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Manuel, vehicule.Consommation.Diesel,
                "Akwa P-03", vehicule.Position.En_Deplacement, vehicule.Occupation.Affecte);
        vehiculeList.add(v);

        v =  new vehicule(-1,false,"C","CE324B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Auto, vehicule.Consommation.Electrique,
                "Akwa P-03", vehicule.Position.Hors_Service, vehicule.Occupation.En_panne);
        vehiculeList.add(v);

        v =  new vehicule(-1,false,"C","CE325B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Manuel, vehicule.Consommation.Essence,
                "Akwa P-03", vehicule.Position.En_Deplacement, vehicule.Occupation.Affecte_Employe);
        vehiculeList.add(v);

        v =  new vehicule(-1,false,"C","CE326B - Douala",
                "Mercedes-Benz", vehicule.Transmition.Manuel, vehicule.Consommation.Essence,
                "Akwa P-03", vehicule.Position.En_Deplacement, vehicule.Occupation.Affecte_Employe);
        vehiculeList.add(v);

        if(vehiculeList.size()<2){
            textView_vehicule_number.setText("Véhicule (0"+vehiculeList.size()+")");
        }
        else if(vehiculeList.size()>=2 && vehiculeList.size()<10){
            textView_vehicule_number.setText("Véhicules (0"+vehiculeList.size()+")");
        }
        else{
            textView_vehicule_number.setText("Véhicules ("+vehiculeList.size()+")");
        }

        vehicules = Common.sortList(vehiculeList);
        vehicules = Common.addRegion(vehicules);
        adapter = new List_car_Adapter(vehicules,getApplicationContext());
        recyclerView_liste_voiture.setAdapter(adapter);

//
//        recyclerView_liste_voiture.setOnScrollListener(new RecyclerView.OnScrollListener() {
//            @Override
//            public void onScrollStateChanged(@NonNull RecyclerView recyclerView, int newState) {
//                super.onScrollStateChanged(recyclerView, newState);
//                int x = newState;
//            }
//
//            @Override
//            public void onScrolled(@NonNull RecyclerView recyclerView, int dx, int dy) {
//                super.onScrolled(recyclerView, dx, dy);
//                {
////                    List_car_Adapter.lastScroll= List_car_Adapter.newScroll;
//                    List_car_Adapter.newScroll = dy;
////                    int x = List_car_Adapter.newScroll - List_car_Adapter.lastScroll;
//                }
//            }
//        });
    }
}
