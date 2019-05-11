package com.example.hp.carfleet;

import android.app.Dialog;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.TextView;

import java.util.ArrayList;

public class ModelListActivity extends AppCompatActivity {

    RecyclerView recycler_model_list;
    int viewList;
    ArrayList<Models> mModels = new ArrayList<>();
    ArrayList<Models> mModelsList = new ArrayList<>();
    List_model_Adapter list_model_adapter;

    private ModelListActivity.OnFragmentInteractionListener listener;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_list);

        mModels.add(new Models(-1,"azerty"));
        mModels.add(new Models(-1,"aserty"));
        mModels.add(new Models(-1,"aderty"));
        mModels.add(new Models(-1,"aferty"));
        mModels.add(new Models(-1,"agerty"));
        mModels.add(new Models(-1,"aherty"));
        mModels.add(new Models(-1,"ajerty"));
        mModels.add(new Models(-1,"bzerty"));
        mModels.add(new Models(-1,"bverty"));

        Models Models;

        Models = new Models(-1,"bvzerty");
        Models.setFavoris(true);
        mModels.add(Models);

        Models = new Models(-1,"cvzerty");
        Models.setFavoris(true);
        mModels.add(Models);

        Models = new Models(-1,"dvzerty");
        Models.setFavoris(true);
        mModels.add(Models);

        Models = new Models(-1,"evzerty");
        Models.setFavoris(true);
        mModels.add(Models);

        Models = new Models(-1,"avzerty");
        Models.setFavoris(true);
        mModels.add(Models);

        Models = new Models(-1,"fvzerty");
        Models.setFavoris(true);
        mModels.add(Models);

        mModelsList = CommonModel.sortList(mModels);
        mModelsList = CommonModel.addAlphabet(mModelsList);
        list_model_adapter = new List_model_Adapter(mModelsList,ModelListActivity.this,new List_model_Adapter.OnItemClickListener() {
            @Override public void onItemClick(Models item) {
                    Intent intent = new Intent(ModelListActivity.this, VehiculeSearch.class);
                startActivity(intent);
            }
        });
        initDialog();

    }
    public void  initDialog() {
        final Dialog dialog = new Dialog(this);
        viewList = R.layout.liste_model;
        dialog.setContentView(R.layout.liste_model);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        recycler_model_list = dialog.findViewById(R.id.recycler_model_list);
        recycler_model_list.setLayoutManager(layoutManager);
        recycler_model_list.setAdapter(list_model_adapter);
        TextView constraint_title = dialog.findViewById(R.id.constraint_title);

        dialog.setCanceledOnTouchOutside(false);
        dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
        dialog.show();
    }

    public interface OnFragmentInteractionListener {

    }
}

