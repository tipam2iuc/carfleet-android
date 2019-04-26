package com.example.hp.carfleet;


import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Vehicules_Fragment extends Fragment {


    VehiculeRecycleAdapter vehiculeAdapter;
    RecyclerView recyclerView;



    public Vehicules_Fragment() {
        // Required empty public constructor
    }

    private Vehicules_Fragment.OnFragmentInteractionListener listener;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }


    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof Vehicules_Fragment.OnFragmentInteractionListener) {
            listener = (Vehicules_Fragment.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    public interface OnFragmentInteractionListener {

    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Models> Audi = new ArrayList<Models>();

        View view=inflater.inflate(R.layout.fragment_vehicules_, container, false);
        recyclerView = (RecyclerView) view.findViewById(R.id.recycle_vehicule);

        getModels(view,recyclerView,Audi);
        Audi.add(new Models(null,"Audi A1","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Audi%20A1.jpg?alt=media&token=54cec5c7-6c5d-4ac0-a9f6-322242e9822a",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Audi.add(new Models(null,"Audi A3","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Audi%20A3.jpg?alt=media&token=138e202f-b73c-45f4-b317-4e8dc497a27e",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Audi.add(new Models(null,"Audi A2","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Audi%20A2.jpg?alt=media&token=215525e7-3ee0-4d6f-b82a-73edb0f833e0",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Audi.add(new Models(null,"Audi A4 Allroad","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Audi%20A4%20Allroad.jpg?alt=media&token=1de4e423-027d-478f-b787-a5faa42afde1",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Audi.add(new Models(null,"Audi A4","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Audi%20A4.jpg?alt=media&token=acd749bb-fecf-49e8-8a93-705c2cc0dbf1",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        // Inflate the layout for this fragment


        return view;
    }

    public void getModels(final View view, final RecyclerView recycle, final ArrayList<Models> list) {


        vehiculeAdapter = new VehiculeRecycleAdapter(list, view.getContext(),new VehiculeRecycleAdapter.OnItemClickListener() {
            @Override public void onItemClick(Models item) {
                Intent intent = new Intent(getContext(), VehiculeDetails.class);
                startActivity(intent);
            }
        });
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
        ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.VERTICAL);
        recycle.setLayoutManager(mLayoutManager);
        recycle.setAdapter(vehiculeAdapter);

        vehiculeAdapter.notifyDataSetChanged();

    }

}
