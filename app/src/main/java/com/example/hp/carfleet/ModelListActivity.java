package com.example.hp.carfleet;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Build;
import android.support.annotation.RequiresApi;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class ModelListActivity extends AppCompatActivity {

    RecyclerView recycler_model_list;
    int viewList;
    ArrayList<model> models = new ArrayList<>();
    ArrayList<model> modelList = new ArrayList<>();
    List_model_Adapter list_model_adapter;

    private ModelListActivity.OnFragmentInteractionListener listener;





    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_model_list);

        models.add(new model(-1,"azerty"));
        models.add(new model(-1,"aserty"));
        models.add(new model(-1,"aderty"));
        models.add(new model(-1,"aferty"));
        models.add(new model(-1,"agerty"));
        models.add(new model(-1,"aherty"));
        models.add(new model(-1,"ajerty"));
        models.add(new model(-1,"bzerty"));
        models.add(new model(-1,"bverty"));

        model model;

        model = new model(-1,"bvzerty");
        model.setFavoris(true);
        models.add(model);

        model = new model(-1,"cvzerty");
        model.setFavoris(true);
        models.add(model);

        model = new model(-1,"dvzerty");
        model.setFavoris(true);
        models.add(model);

        model = new model(-1,"evzerty");
        model.setFavoris(true);
        models.add(model);

        model = new model(-1,"avzerty");
        model.setFavoris(true);
        models.add(model);

        model = new model(-1,"fvzerty");
        model.setFavoris(true);
        models.add(model);

        modelList = CommonModel.sortList(models);
        modelList = CommonModel.addAlphabet(modelList);
        list_model_adapter = new List_model_Adapter(modelList,ModelListActivity.this,new List_model_Adapter.OnItemClickListener() {
            @Override public void onItemClick(model item) {
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

