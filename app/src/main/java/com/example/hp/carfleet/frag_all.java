package com.example.hp.carfleet;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class frag_all extends Fragment{

    ModelAdapter modelAdapter;
    RecyclerView recyclerView1;
    RecyclerView recyclerView2;
    RecyclerView recyclerView3;
    RecyclerView recyclerView4;
    RecyclerView recyclerView5;
    RecyclerView recyclerView6;
    RecyclerView recyclerView7;
    RecyclerView recyclerView8;
    RecyclerView recyclerView9;

    ArrayList<Models> AudiList =new ArrayList<Models>() ;
    ArrayList<Models> BmwList =new ArrayList<Models>() ;
    ArrayList<Models> CitroenList =new ArrayList<Models>() ;
    ArrayList<Models> FordList =new ArrayList<Models>() ;
    ArrayList<Models> MercedesList =new ArrayList<Models>() ;
    ArrayList<Models> PeugeotList =new ArrayList<Models>() ;
    ArrayList<Models> RenaultList =new ArrayList<Models>() ;
    ArrayList<Models> ToyotaList =new ArrayList<Models>() ;
    ArrayList<Models> VolkswagenList =new ArrayList<Models>() ;


//    RetroFitApiInterface apiInterface = RetroFitApiClient.getClient().create(RetroFitApiInterface.class);
//    Call<ArrayList<Models>> AudiCall = apiInterface.getModelsAudi();
//    Call<ArrayList<Models>> BmwCall = apiInterface.getModelsBmw();
//    Call<ArrayList<Models>> CitroenCall = apiInterface.getModelsCitroen();
//    Call<ArrayList<Models>> FordCall = apiInterface.getModelsFord();
//    Call<ArrayList<Models>> MercedesCall = apiInterface.getModelsMercedes();
//    Call<ArrayList<Models>> PeugeotCall = apiInterface.getModelsPeugeot();
//    Call<ArrayList<Models>> RenaultCall = apiInterface.getModelsRenault();
//    Call<ArrayList<Models>> ToyotaCall = apiInterface.getModelsToyota();
//    Call<ArrayList<Models>> VolkswagenCall = apiInterface.getModelsVolkswagen();





    private frag_all.OnFragmentInteractionListener listener;

    public static frag_all newInstance() {
        return new frag_all();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);



    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        ArrayList<Models> Audi = new ArrayList<Models>();
        ArrayList<Models> Bmw = new ArrayList<Models>();
        ArrayList<Models> Citroen = new ArrayList<Models>();
        ArrayList<Models> Ford = new ArrayList<Models>();
        ArrayList<Models> Mercedes = new ArrayList<Models>();





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


        Bmw.add(new Models(null,"Bmw I3","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20I3.jpg?alt=media&token=96751740-7480-4709-b29a-04e08447388e",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Bmw.add(new Models(null,"Bmw I8","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20I8.jpg?alt=media&token=4933be43-d8ee-4993-a4fc-7dd83ca9a2d3",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Bmw.add(new Models(null,"Bmw Serie1","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20Serie1.jpg?alt=media&token=86e2c656-745d-446b-aa6c-8d5be83b838a",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Bmw.add(new Models(null,"Bmw Serie2","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20Serie2.jpg?alt=media&token=728871db-970d-4a40-b51c-15de4b5eb5d3",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Bmw.add(new Models(null,"Bmw Serie3 Gt","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20Serie3%20Gt.jpg?alt=media&token=c707c15f-8ddc-428f-b613-725f30090acd",
                "voiture","berline",null,"Diesel-Essence","manuelle"));



        Citroen.add(new Models(null,"Citroen Berlingo","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20Berlingo.jpg?alt=media&token=8b6886db-3959-47bb-b7d0-a07d5a803f97",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Citroen.add(new Models(null,"Citroen C-elysee","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20Berlingo.jpg?alt=media&token=8b6886db-3959-47bb-b7d0-a07d5a803f97",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Citroen.add(new Models(null,"Citroen C-zero","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20C-zero.jpg?alt=media&token=704d31c5-43c2-4aec-98ce-5e485b5c021e",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Citroen.add(new Models(null,"Citroen C1","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20C1.jpg?alt=media&token=4b2bcba2-95a4-412b-9a1c-c9ea381995a1",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Citroen.add(new Models(null,"Citroen C3 Aircross","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20C3%20Aircross.jpg?alt=media&token=3e6f5d98-7186-427e-b62d-2da0ddb29c8f",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Ford.add(new Models(null,"Ford C-max","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20C-max.jpg?alt=media&token=e36ddcc4-2529-45a4-b0e3-2d8ce4acdba5",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Ford.add(new Models(null,"Ford Ecosport","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Ecosport.jpg?alt=media&token=89986aeb-1768-4307-a849-2bb232d2bf4d",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Ford.add(new Models(null,"Ford Edge","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Edge.jpg?alt=media&token=5c38b7c5-5e25-45c7-a76c-6b71b52ea00a",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Ford.add(new Models(null,"Ford Expedition","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Expedition.jpg?alt=media&token=434032c8-f10e-45ee-ab03-3da2ff1d5ea3",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Ford.add(new Models(null,"Ford Explorer","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Explorer.jpg?alt=media&token=06a2973c-307e-45d0-bf47-0ed97a733f9f",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Mercedes.add(new Models(null,"Audi Citan","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Ecosport.jpg?alt=media&token=89986aeb-1768-4307-a849-2bb232d2bf4d",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Mercedes.add(new Models(null,"Mercedes Cla","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Audi%20A3.jpg?alt=media&token=138e202f-b73c-45f4-b317-4e8dc497a27e",
                "voiture","berline",null,"Diesel-Essence","manuelle"));



        Mercedes.add(new Models(null," Mercedes Classe A","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Mercedes%20Classe%20A.jpg?alt=media&token=d001f8f5-890d-4946-9508-13f6c3f15668",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Mercedes.add(new Models(null,"Mercedes Classe B","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Mercedes%20Classe%20B.jpg?alt=media&token=7aebfc07-9bf3-42cd-8c99-4fddae023f19",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Mercedes.add(new Models(null,"Audi A4","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Mercedes%20Classe%20C.jpg?alt=media&token=c18b8a7a-33b1-4bb7-ba1e-a1d81cee44e8",
                "voiture","berline",null,"Diesel-Essence","manuelle"));



        View view = inflater.inflate(R.layout.fragall_layout, container, false);
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recycle1);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recycle2);
        recyclerView3 = (RecyclerView) view.findViewById(R.id.recycle3);
        recyclerView4 = (RecyclerView) view.findViewById(R.id.recycle4);
        recyclerView5 = (RecyclerView) view.findViewById(R.id.recycle5);
        //recyclerView6 = (RecyclerView) view.findViewById(R.id.recycle6);
        //recyclerView7 = (RecyclerView) view.findViewById(R.id.recycle7);
        //recyclerView8 = (RecyclerView) view.findViewById(R.id.recycle8);
        //recyclerView9 = (RecyclerView) view.findViewById(R.id.recycle9);

        getModels(view,recyclerView1,Audi);
        getModels(view,recyclerView2,Audi);
        getModels(view,recyclerView3,Citroen);
        getModels(view,recyclerView4,Ford);
        getModels(view,recyclerView5,Mercedes);
        //getModels(view,PeugeotList,recyclerView6,PeugeotCall);
        //getModels(view,RenaultList,recyclerView7,RenaultCall);
        //getModels(view,ToyotaList,recyclerView8,ToyotaCall);
        //getModels(view,VolkswagenList,recyclerView9,VolkswagenCall);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof frag_all.OnFragmentInteractionListener) {
            listener = (frag_all.OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }
    @Override
    public void onDetach() {
        super.onDetach();
        listener = null;
    }


//    public void getModels(final View view, final ArrayList<Models> list, final RecyclerView recycle,Call<ArrayList<Models>> modelType) {
//
//        Call<ArrayList<Models>> call = modelType;
//        call.enqueue(new Callback<ArrayList<Models>>() {
//            @Override
//            public void onResponse(@NonNull Call<ArrayList<Models>> call, @NonNull Response<ArrayList<Models>> response) {
//
//                for (Models model:response.body()){
//                    list.add(model);
//                }
//                modelAdapter = new ModelAdapter(response.body(), view.getContext());
//
//                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
//                ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
//                recycle.setLayoutManager(mLayoutManager);
//                //recyclerView.setItemAnimator(new DefaultItemAnimator());
//                //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
//                recycle.setAdapter(modelAdapter);
//                Log.i("RESPONSE: ", ""+response.toString());
//                modelAdapter.notifyDataSetChanged();
//
//            }
//
//
//            @Override
//            public void onFailure(@NonNull Call<ArrayList<Models>> call, @NonNull Throwable t) {
//                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
//                Log.e("ERROR: ", t.getMessage());
//            }
//        });
//
//
//    }



    public void getModels(final View view, final RecyclerView recycle, final ArrayList<Models> list) {


                modelAdapter = new ModelAdapter(list, view.getContext(),new ModelAdapter.OnItemClickListener() {
                    @Override public void onItemClick(Models item) {
                        Intent intent = new Intent(getContext(), ModelDetails.class);
                        startActivity(intent);
                    }
                });
                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
                ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
                recycle.setLayoutManager(mLayoutManager);
                recycle.setAdapter(modelAdapter);

                modelAdapter.notifyDataSetChanged();

    }


    public interface OnFragmentInteractionListener {

    }

    private ArrayList<Marques> getAllItemList(){

        ArrayList<Marques> allItems = new ArrayList<Marques>();

        ArrayList<Models> Audi = new ArrayList<Models>();
        ArrayList<Models> Bmw = new ArrayList<Models>();
        ArrayList<Models> Citroen = new ArrayList<Models>();
        ArrayList<Models> Ford = new ArrayList<Models>();
        ArrayList<Models> Mercedes = new ArrayList<Models>();

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


        Bmw.add(new Models(null,"Bmw I3","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20I3.jpg?alt=media&token=96751740-7480-4709-b29a-04e08447388e",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Bmw.add(new Models(null,"Bmw I8","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20I8.jpg?alt=media&token=4933be43-d8ee-4993-a4fc-7dd83ca9a2d3",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Bmw.add(new Models(null,"Bmw Serie1","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20Serie1.jpg?alt=media&token=86e2c656-745d-446b-aa6c-8d5be83b838a",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Bmw.add(new Models(null,"Bmw Serie2","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20Serie2.jpg?alt=media&token=728871db-970d-4a40-b51c-15de4b5eb5d3",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Bmw.add(new Models(null,"Bmw Serie3 Gt","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Bmw%20Serie3%20Gt.jpg?alt=media&token=c707c15f-8ddc-428f-b613-725f30090acd",
                "voiture","berline",null,"Diesel-Essence","manuelle"));



        Citroen.add(new Models(null,"Citroen Berlingo","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20Berlingo.jpg?alt=media&token=8b6886db-3959-47bb-b7d0-a07d5a803f97",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Citroen.add(new Models(null,"Citroen C-elysee","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20Berlingo.jpg?alt=media&token=8b6886db-3959-47bb-b7d0-a07d5a803f97",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Citroen.add(new Models(null,"Citroen C-zero","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20C-zero.jpg?alt=media&token=704d31c5-43c2-4aec-98ce-5e485b5c021e",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Citroen.add(new Models(null,"Citroen C1","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20C1.jpg?alt=media&token=4b2bcba2-95a4-412b-9a1c-c9ea381995a1",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Citroen.add(new Models(null,"Citroen C3 Aircross","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Citroen%20C3%20Aircross.jpg?alt=media&token=3e6f5d98-7186-427e-b62d-2da0ddb29c8f",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Ford.add(new Models(null,"Ford C-max","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20C-max.jpg?alt=media&token=e36ddcc4-2529-45a4-b0e3-2d8ce4acdba5",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Ford.add(new Models(null,"Ford Ecosport","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Ecosport.jpg?alt=media&token=89986aeb-1768-4307-a849-2bb232d2bf4d",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Ford.add(new Models(null,"Ford Edge","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Edge.jpg?alt=media&token=5c38b7c5-5e25-45c7-a76c-6b71b52ea00a",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Ford.add(new Models(null,"Ford Expedition","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Expedition.jpg?alt=media&token=434032c8-f10e-45ee-ab03-3da2ff1d5ea3",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Ford.add(new Models(null,"Ford Explorer","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Explorer.jpg?alt=media&token=06a2973c-307e-45d0-bf47-0ed97a733f9f",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Mercedes.add(new Models(null,"Audi Citan","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Ford%20Ecosport.jpg?alt=media&token=89986aeb-1768-4307-a849-2bb232d2bf4d",
                "voiture","berline",null,"Diesel-Essence","manuelle"));

        Mercedes.add(new Models(null,"Mercedes Cla","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Audi%20A3.jpg?alt=media&token=138e202f-b73c-45f4-b317-4e8dc497a27e",
                "voiture","berline",null,"Diesel-Essence","manuelle"));



        Mercedes.add(new Models(null," Mercedes Classe A","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Mercedes%20Classe%20A.jpg?alt=media&token=d001f8f5-890d-4946-9508-13f6c3f15668",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Mercedes.add(new Models(null,"Mercedes Classe B","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Mercedes%20Classe%20B.jpg?alt=media&token=7aebfc07-9bf3-42cd-8c99-4fddae023f19",
                "voiture","berline",null,"Diesel-Essence","manuelle"));


        Mercedes.add(new Models(null,"Audi A4","188 kw","250 km/h","3954 cm","1740 cm","1416 cm",5,
                "https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/Mercedes%20Classe%20C.jpg?alt=media&token=c18b8a7a-33b1-4bb7-ba1e-a1d81cee44e8",
                "voiture","berline",null,"Diesel-Essence","manuelle"));



        allItems.add(new Marques( "Audi","https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/marques%2Faudi.png?alt=media&token=bb607ca5-1bad-4913-b9f1-3aa3df2ab64d",Audi));
        allItems.add(new Marques( "Bmw","https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/marques%2Fbmw.png?alt=media&token=e76e72b1-6776-40aa-92a1-40ffcd3de0e0",Bmw));
        allItems.add(new Marques( "Citroen","https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/marques%2Fcitroen.png?alt=media&token=7928a4ea-0b5a-4f30-a042-00914111251f",Citroen));
        allItems.add(new Marques( "Ford","https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/marques%2Fford.png?alt=media&token=fe864fb3-6139-4174-834e-940302d4e639",Ford));
        allItems.add(new Marques( "Mercedes","https://firebasestorage.googleapis.com/v0/b/sign-up-master-b2f0b.appspot.com/o/marques%2Fmercedes.png?alt=media&token=7f457f1f-bb6a-47d2-8166-80cf1522ed59",Mercedes));

        return allItems;
    }






}

