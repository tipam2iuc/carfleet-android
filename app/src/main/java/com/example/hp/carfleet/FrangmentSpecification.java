package com.example.hp.carfleet;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link FrangmentSpecification.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link FrangmentSpecification#newInstance} factory method to
 * create an instance of this fragment.
 */
public class FrangmentSpecification extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;
    RecyclerView rView;
    private GridLayoutManager lLayout;

    private OnFragmentInteractionListener mListener;

    public FrangmentSpecification() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment FrangmentSpecification.
     */
    // TODO: Rename and change types and number of parameters
    public static FrangmentSpecification newInstance(String param1, String param2) {
        FrangmentSpecification fragment = new FrangmentSpecification();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }


    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view=inflater.inflate(R.layout.fragment_vehicule_specification, container, false);
        List<SpecificationVehicule> rowListItem = getAllItemList();
        lLayout = new GridLayoutManager(getContext(), 3);

        rView = (RecyclerView) view.findViewById(R.id.vehicule_specification_recycler);
        rView.setHasFixedSize(true);
        rView.setLayoutManager(lLayout);

        SpecificationVehiculeAdapter rcAdapter = new SpecificationVehiculeAdapter(getContext(), rowListItem);
        rView.setAdapter(rcAdapter);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }

    private List<SpecificationVehicule> getAllItemList(){

        List<SpecificationVehicule> allItems = new ArrayList<SpecificationVehicule>();
        allItems.add(new SpecificationVehicule("Immatriculation", "LT3238-Douala",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Numero Chassis", "2457842545",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Kilométrage", "4658 km",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Segment D", "Classe Familiale",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Carosserie", "Berline - Tricorps",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Vitesse Maximale", "250 km/h",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Energie", "Essence",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Boîte de vitesse", "6 vitesses manuelles",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Puissance", "510 chevaux",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Longueur", "4 686 mm",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Largueur", "1 810 mm",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Hauteur", "1 442 mm",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Poids à vide", "1 456 kg",new Date(2014,3,20)));
        allItems.add(new SpecificationVehicule("Appellation", "Mercedes Benz Class C(W205)",new Date(2014,3,20)));


        return allItems;
    }
}
