package com.example.hp.carfleet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;

import java.io.IOException;
import java.util.ArrayList;

public class VehiculeRecycleAdapter extends RecyclerView.Adapter<VehiculeRecycleAdapter.MyViewHolder> {
    ArrayList<Models> vehicleList;
    static Context context;
    View itemView;
    private final VehiculeRecycleAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Models item);
    }


    public VehiculeRecycleAdapter(ArrayList<Models> marquesList, Context context,VehiculeRecycleAdapter.OnItemClickListener listener) {
        this.vehicleList = marquesList;
        this.context = context;

        this.listener = listener;
    }

    @NonNull
    @Override
    public VehiculeRecycleAdapter.MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater inflater = LayoutInflater.from(context);
        itemView = inflater.inflate(R.layout.vehicule_list_item, parent, false);


        return new VehiculeRecycleAdapter.MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull VehiculeRecycleAdapter.MyViewHolder holder, int position) {
        // try {
        //  MyViewHolder.bind(mModelsList.get(position));
        try {
            holder.bind(vehicleList.get(position),context, listener);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView textView=new TextView(context);
        textView.setText(vehicleList.get(position).getNomComplet());
        Glide.with(context).load( vehicleList.get(position).getImagePath()).into(holder.carImage);
        // } catch (IOException e) {
        //   e.printStackTrace();
        //  }
    }

    @Override
    public int getItemCount() {
        return vehicleList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {

        public ImageView carImage;


        public MyViewHolder(View view) {
            super(view);
            carImage = (ImageView) view.findViewById(R.id.vehiculeImage);
        }

        public void bind(final Models models,final Context context, final VehiculeRecycleAdapter.OnItemClickListener listener) throws IOException {


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(models);
                }
            });

        }


    }
}
