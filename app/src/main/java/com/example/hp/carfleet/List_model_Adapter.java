package com.example.hp.carfleet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;

public class List_model_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<model> modelList;
    ViewGroup group;
    private final List_model_Adapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(model item);
    }


    public List_model_Adapter(ArrayList<model> models, Context context,List_model_Adapter.OnItemClickListener listener){
        this.context = context;
        this.modelList = models;
        this.listener=listener;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext());

        if(viewType == CommonModel.VIEWTYPE_GROUP) {
            group = (ViewGroup) inflater.inflate(R.layout.template_item_alphabet, viewGroup, false);

            GroupViewHolder groupViewHolder = new GroupViewHolder(group);

            return groupViewHolder;
        }
        else if(viewType == CommonModel.VIEWTYPE_MODEL){
            group = (ViewGroup) inflater.inflate(R.layout.template_item_list_model, viewGroup, false);
            ModelHolder carHolder = new ModelHolder(group);
            return  carHolder;
        }
        else if(viewType == CommonModel.VIEWTYPE_MODEL_FAVORITE){
            group = (ViewGroup) inflater.inflate(R.layout.template_item_list_favorite_model, viewGroup, false);
            ModelHolderFavorite carHolderFavorite = new ModelHolderFavorite(group);
            return  carHolderFavorite;
        }
        else if(viewType == CommonModel.VIEWTYPE_GROUP_FAVORITE){

            group = (ViewGroup) inflater.inflate(R.layout.template_item_favorite_model, viewGroup, false);
            GroupViewHolderFavorite groupViewHolderFavorite = new GroupViewHolderFavorite(group);
            return groupViewHolderFavorite;
        }
        else if(viewType == CommonModel.VIEWTYPE_ALL){

            group = (ViewGroup) inflater.inflate(R.layout.template_item_list_all, viewGroup, false);
            GroupViewHolderAll groupViewHolderAll = new GroupViewHolderAll(group);
            return groupViewHolderAll;
        }
        else{

            group = (ViewGroup) inflater.inflate(R.layout.template_item_list_other, viewGroup, false);
            GroupViewHolderFavorite groupViewHolder = new GroupViewHolderFavorite(group);
            return groupViewHolder;
        }
    }



    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {


        if(viewHolder instanceof GroupViewHolder){
            try {
                bind(modelList.get(i),context, listener);
            } catch (IOException e) {
                e.printStackTrace();
            }
            GroupViewHolder groupViewHolder = (GroupViewHolder)viewHolder;
            model v = modelList.get(i);
            groupViewHolder.tregion.setText(v.getNomModel().length()<=1?v.getNomModel():v.getNomModel().substring(0,1));
        }
        else if(viewHolder instanceof ModelHolder){
            try {
                bind(modelList.get(i),context, listener);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ModelHolder modelHolder = (ModelHolder) viewHolder;
            model v = modelList.get(i);
        }
        else if(viewHolder instanceof  GroupViewHolderFavorite){
            try {
                bind(modelList.get(i),context, listener);
            } catch (IOException e) {
                e.printStackTrace();
            }
            GroupViewHolderFavorite viewHolderFavorite = (GroupViewHolderFavorite) viewHolder;
        }
        else if(viewHolder instanceof ModelHolderFavorite){
            try {
                bind(modelList.get(i),context, listener);
            } catch (IOException e) {
                e.printStackTrace();
            }
            ModelHolderFavorite modelHolderFavorite = (ModelHolderFavorite) viewHolder;
            model v = modelList.get(i);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return modelList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return modelList.size();
    }

    public static class ModelHolder extends RecyclerView.ViewHolder {

        View itemView;
        private static TextView classe;
        private static TextView textView_tarif;
        private static TextView matricule;
        private static TextView marque;
        private static TextView transmition_conso;
        private static TextView position;
        private static TextView occupation;
        private static CardView boule;

        public ModelHolder(View itemView) {
            super(itemView);
            this.itemView = itemView;

            classe = itemView.findViewById(R.id.textView_classe_car);
            textView_tarif = itemView.findViewById(R.id.textView_tarif);
            marque = itemView.findViewById(R.id.textView_marque_car);
            matricule = itemView.findViewById(R.id.textView_matricule_car);
            transmition_conso = itemView.findViewById(R.id.textView_Type_car);
            position = itemView.findViewById(R.id.textView_Parking_car);
            occupation = itemView.findViewById(R.id.textView_Occupation_car);
            boule = itemView.findViewById(R.id.textView_boule_parking_car);
        }
    }

    private class GroupViewHolder extends RecyclerView.ViewHolder {

        private TextView tregion;

        public GroupViewHolder(@NonNull View itemView) {
            super(itemView);
            tregion = itemView.findViewById(R.id.textView_region);

        }
    }

    private class GroupViewHolderFavorite extends RecyclerView.ViewHolder {
        public GroupViewHolderFavorite(@NonNull View itemView) {
            super(itemView);
        }
    }

    private static class ModelHolderFavorite extends RecyclerView.ViewHolder {

        View itemView;
        private static TextView classe;
        private static TextView textView_tarif;
        private static TextView matricule;
        private static TextView marque;
        private static TextView transmition_conso;
        private static TextView position;
        private static TextView occupation;
        private static CardView boule;

        public ModelHolderFavorite(@NonNull View itemView) {
            super(itemView);
            this.itemView = itemView;
            classe = itemView.findViewById(R.id.textView_classe_car);
            textView_tarif = itemView.findViewById(R.id.textView_tarif);
            marque = itemView.findViewById(R.id.textView_marque_car);
            matricule = itemView.findViewById(R.id.textView_matricule_car);
            transmition_conso = itemView.findViewById(R.id.textView_Type_car);
            position = itemView.findViewById(R.id.textView_Parking_car);
            occupation = itemView.findViewById(R.id.textView_Occupation_car);
            boule = itemView.findViewById(R.id.textView_boule_parking_car);
        }
    }

    private class GroupViewHolderAll extends RecyclerView.ViewHolder {
        public GroupViewHolderAll(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void bind(final model models,final Context context, final List_model_Adapter.OnItemClickListener listener) throws IOException {


        group.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(models);
            }
        });

    }
}

