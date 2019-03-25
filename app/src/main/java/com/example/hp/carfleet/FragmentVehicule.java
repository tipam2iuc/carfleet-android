package com.example.hp.carfleet;

import android.app.Application;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

import static com.facebook.FacebookSdk.getApplicationContext;

public class FragmentVehicule extends Fragment {

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

    RetroFitApiInterface apiInterface = RetroFitApiClient.getClient().create(RetroFitApiInterface.class);
    Call<ArrayList<Models>> AudiCall = apiInterface.getModelsAudi();
    Call<ArrayList<Models>> BmwCall = apiInterface.getModelsBmw();
    Call<ArrayList<Models>> CitroenCall = apiInterface.getModelsCitroen();
    Call<ArrayList<Models>> FordCall = apiInterface.getModelsFord();
    Call<ArrayList<Models>> MercedesCall = apiInterface.getModelsMercedes();
    Call<ArrayList<Models>> PeugeotCall = apiInterface.getModelsPeugeot();
    Call<ArrayList<Models>> RenaultCall = apiInterface.getModelsRenault();
    Call<ArrayList<Models>> ToyotaCall = apiInterface.getModelsToyota();
    Call<ArrayList<Models>> VolkswagenCall = apiInterface.getModelsVolkswagen();


    private OnFragmentInteractionListener listener;

    public static FragmentVehicule newInstance() {
        return new FragmentVehicule();
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_vehicule, container, false);
        recyclerView1 = (RecyclerView) view.findViewById(R.id.recycle1);
        recyclerView2 = (RecyclerView) view.findViewById(R.id.recycle2);
        recyclerView3 = (RecyclerView) view.findViewById(R.id.recycle3);
        recyclerView4 = (RecyclerView) view.findViewById(R.id.recycle4);
        recyclerView5 = (RecyclerView) view.findViewById(R.id.recycle5);
        recyclerView6 = (RecyclerView) view.findViewById(R.id.recycle6);
        recyclerView7 = (RecyclerView) view.findViewById(R.id.recycle7);
        recyclerView8 = (RecyclerView) view.findViewById(R.id.recycle8);
        recyclerView9 = (RecyclerView) view.findViewById(R.id.recycle9);

        getModels(view,AudiList,recyclerView1,AudiCall);
        getModels(view,BmwList,recyclerView2,BmwCall);
        getModels(view,CitroenList,recyclerView3,CitroenCall);
        getModels(view,FordList,recyclerView4,FordCall);
        getModels(view,MercedesList,recyclerView5,MercedesCall);
        getModels(view,PeugeotList,recyclerView6,PeugeotCall);
        getModels(view,RenaultList,recyclerView7,RenaultCall);
        getModels(view,ToyotaList,recyclerView8,ToyotaCall);
        getModels(view,VolkswagenList,recyclerView9,VolkswagenCall);

        return view;
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            listener = (OnFragmentInteractionListener) context;
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


    public void getModels(final View view, final ArrayList<Models> list, final RecyclerView recycle,Call<ArrayList<Models>> modelType) {

        Call<ArrayList<Models>> call = modelType;
        call.enqueue(new Callback<ArrayList<Models>>() {
            @Override
            public void onResponse(@NonNull Call<ArrayList<Models>> call, @NonNull Response<ArrayList<Models>> response) {

                for (Models model:response.body()){
                    list.add(model);
                }
                modelAdapter = new ModelAdapter(response.body(), view.getContext());

                RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(view.getContext());
                ((LinearLayoutManager) mLayoutManager).setOrientation(LinearLayoutManager.HORIZONTAL);
                recycle.setLayoutManager(mLayoutManager);
                //recyclerView.setItemAnimator(new DefaultItemAnimator());
                //recyclerView.addItemDecoration(new DividerItemDecoration(getActivity(), LinearLayoutManager.VERTICAL));
                recycle.setAdapter(modelAdapter);
                Log.i("RESPONSE: ", ""+response.toString());
                modelAdapter.notifyDataSetChanged();

            }


            @Override
            public void onFailure(@NonNull Call<ArrayList<Models>> call, @NonNull Throwable t) {
                Toast.makeText(getActivity(), t.getLocalizedMessage(), Toast.LENGTH_LONG).show();
                Log.e("ERROR: ", t.getMessage());
            }
        });


    }


    public interface OnFragmentInteractionListener {

    }

}
