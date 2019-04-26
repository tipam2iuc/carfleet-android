package com.example.hp.carfleet;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.ColorStateList;
import android.os.Binder;
import android.support.annotation.NonNull;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;

public class List_car_Adapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    Context context;
    ArrayList<vehicule> vehiculeList;


    public List_car_Adapter(ArrayList<vehicule> vehicules, Context context){
        this.context = context;
        this.vehiculeList = vehicules;
    }


    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(viewGroup.getContext().getApplicationContext());

        if(viewType == Common.VIEWTYPE_GROUP) {
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.template_item_region, viewGroup, false);
            GroupViewHolder groupViewHolder = new GroupViewHolder(group);
            return groupViewHolder;
        }
        else if(viewType == Common.VIEWTYPE_CAR){
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.template_item_list, viewGroup, false);
            CarHolder carHolder = new CarHolder(group);
            return  carHolder;
        }
        else if(viewType == Common.VIEWTYPE_CAR_FAVORITE){
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.template_item_list_favorite, viewGroup, false);
            CarHolderFavorite carHolderFavorite = new CarHolderFavorite(group);
            return  carHolderFavorite;
        }
        else if(viewType == Common.VIEWTYPE_GROUP_FAVORITE){
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.template_item_favorite, viewGroup, false);
            GroupViewHolderFavorite groupViewHolderFavorite = new GroupViewHolderFavorite(group);
            return groupViewHolderFavorite;
        }
        else{
            ViewGroup group = (ViewGroup) inflater.inflate(R.layout.template_item_region, viewGroup, false);
            GroupViewHolder groupViewHolder = new GroupViewHolder(group);
            return groupViewHolder;
        }
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder viewHolder, int i) {
        if(viewHolder instanceof GroupViewHolder){
            GroupViewHolder groupViewHolder = (GroupViewHolder)viewHolder;
            vehicule v = vehiculeList.get(i);
            groupViewHolder.tregion.setText(v.getMatricule().length()<=2?v.getMatricule():v.getMatricule().substring(0,2));
        }
        else if(viewHolder instanceof  CarHolder){
            CarHolder carHolder = (CarHolder) viewHolder;
            vehicule v = vehiculeList.get(i);
            carHolder.Bind(v);
        }
        else if(viewHolder instanceof  GroupViewHolderFavorite){
            GroupViewHolderFavorite viewHolderFavorite = (GroupViewHolderFavorite) viewHolder;
        }
        else if(viewHolder instanceof  CarHolderFavorite){
            CarHolderFavorite carHolderFavorite = (CarHolderFavorite) viewHolder;
            vehicule v = vehiculeList.get(i);
            carHolderFavorite.Bind(v);
        }
    }

    @Override
    public int getItemViewType(int position) {
        return vehiculeList.get(position).getViewType();
    }

    @Override
    public int getItemCount() {
        return vehiculeList.size();
    }

    public static class CarHolder extends RecyclerView.ViewHolder {

        View itemView;
        private static TextView classe;
        private static TextView textView_tarif;
        private static TextView matricule;
        private static TextView marque;
        private static TextView transmition_conso;
        private static TextView position;
        private static TextView occupation;
        private static CardView boule;

        public CarHolder(View itemView) {
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

        @SuppressLint("NewApi")
        public void Bind(vehicule v){

            String conso;
            String trans;
            classe.setText(" * "+ v.getClasse() + "-class ");
            marque.setText(v.getMarque());
            matricule.setText(v.getMatricule());
            if(v.getConsommation()== vehicule.Consommation.Electrique)
                conso = "Elec";
            else if(v.getConsommation()== vehicule.Consommation.Diesel)
                conso = "Dies";
            else
                conso = (v.getConsommation().toString().length()==3?v.getConsommation().toString():v.getConsommation().toString().substring(0,3));

            if(v.getTransmition() == vehicule.Transmition.Auto)
                trans = "Auto";
            else
                trans = (v.getTransmition().toString().length()==3?v.getTransmition().toString():v.getTransmition().toString().substring(0,3));
            transmition_conso.setText("("+conso+"/"+trans+")");
            switch (v.type_position){
                case Gare:
                    position.setText("Garé à " + v.getPosition());
                    break;
                case Hors_Service:
                    position.setText("Hors service");
                    break;
                case En_Deplacement:
                    position.setText("En déplacement");
                    break;
            }
            int theColor = itemView.getResources().getColor(R.color.colorAccent);
            ColorStateList colorStateList;
            switch (v.getOccupation()){
                case En_location:
                    occupation.setText(" | En location");

                    textView_tarif.setText(String.valueOf(v.prix)+" FCFA / Jr");
                    textView_tarif.setVisibility(View.VISIBLE);
                    theColor = itemView.getResources().getColor(R.color.color_Location);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
                case Affecte:
                    occupation.setText(" | Affecté");
                    if (v.type_position ==  vehicule.Position.En_Deplacement)

                    theColor = itemView.getResources().getColor(R.color.color_Moving_Affected);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    if (v.type_position ==  vehicule.Position.Gare)

                    theColor = itemView.getResources().getColor(R.color.color_Not_Moving_Affected);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
                case En_panne:
                    occupation.setText(" | En panne");

                    theColor = itemView.getResources().getColor(R.color.color_Mistake);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
                case Accidente:
                    occupation.setText(" | Accidenté");

                    theColor = itemView.getResources().getColor(R.color.color_Mistake);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
                case Non_Affecte:
                    occupation.setText(" | Non Affecté");

                    theColor = itemView.getResources().getColor(R.color.color_Non_Affected);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;

                case Affecte_Employe:
                    occupation.setText(" | Affecté à un employé");

                    theColor = itemView.getResources().getColor(R.color.color_Non_Affected);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
            }
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

    private static class CarHolderFavorite extends RecyclerView.ViewHolder {

        View itemView;
        private static TextView classe;
        private static TextView textView_tarif;
        private static TextView matricule;
        private static TextView marque;
        private static TextView transmition_conso;
        private static TextView position;
        private static TextView occupation;
        private static CardView boule;

        public CarHolderFavorite(@NonNull View itemView) {
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

        @SuppressLint("NewApi")
        public void Bind(vehicule v){
            String conso;
            String trans;
            classe.setText(" * "+ v.getClasse() + "-class ");
            marque.setText(v.getMarque());
            matricule.setText(v.getMatricule());
            if(v.getConsommation()== vehicule.Consommation.Electrique)
                conso = "Elec";
            else if(v.getConsommation()== vehicule.Consommation.Diesel)
                conso = "Dies";
            else
                conso = (v.getConsommation().toString().length()==3?v.getConsommation().toString():v.getConsommation().toString().substring(0,3));

            if(v.getTransmition() == vehicule.Transmition.Auto)
                trans = "Auto";
            else
                trans = (v.getTransmition().toString().length()==3?v.getTransmition().toString():v.getTransmition().toString().substring(0,3));
            transmition_conso.setText("("+conso+"/"+trans+")");

            switch (v.type_position){
                case Gare:
                    position.setText("Garé à " + v.getPosition());
                    break;
                case Hors_Service:
                    position.setText("Hors service");
                    break;
                case En_Deplacement:
                    position.setText("En déplacement");
                    break;
            }
            int theColor = itemView.getResources().getColor(R.color.colorAccent);
            ColorStateList colorStateList;
            switch (v.getOccupation()){
                case En_location:
                    occupation.setText(" | En location");

                    textView_tarif.setText(String.valueOf(v.prix)+" FCFA / Jr");
                    textView_tarif.setVisibility(View.VISIBLE);
                    theColor = itemView.getResources().getColor(R.color.color_Location);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
                case Affecte:
                    occupation.setText(" | Affecté");
                    if (v.type_position ==  vehicule.Position.En_Deplacement)

                        theColor = itemView.getResources().getColor(R.color.color_Moving_Affected);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    if (v.type_position ==  vehicule.Position.Gare)

                        theColor = itemView.getResources().getColor(R.color.color_Not_Moving_Affected);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
                case En_panne:
                    occupation.setText(" | En panne");

                    theColor = itemView.getResources().getColor(R.color.color_Mistake);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
                case Accidente:
                    occupation.setText(" | Accidenté");

                    theColor = itemView.getResources().getColor(R.color.color_Mistake);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
                case Non_Affecte:
                    occupation.setText(" | Non Affecté");

                    theColor = itemView.getResources().getColor(R.color.color_Non_Affected);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;

                case Affecte_Employe:
                    occupation.setText(" | Affecté à un employé");

                    theColor = itemView.getResources().getColor(R.color.color_Non_Affected);
                    position.setTextColor(theColor);
                    colorStateList = ColorStateList.valueOf(theColor);
                    boule.setBackgroundTintList(colorStateList);

                    break;
            }
        }
    }
}

