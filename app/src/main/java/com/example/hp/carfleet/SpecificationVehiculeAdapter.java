package com.example.hp.carfleet;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

public class SpecificationVehiculeAdapter extends RecyclerView.Adapter<RecyclerViewHolders> {

    private List<SpecificationVehicule> itemList;
    private Context context;

    public SpecificationVehiculeAdapter(Context context, List<SpecificationVehicule> itemList) {
        this.itemList = itemList;
        this.context = context;
    }

    @Override
    public RecyclerViewHolders onCreateViewHolder(ViewGroup parent, int viewType) {

        View layoutView = LayoutInflater.from(parent.getContext()).inflate(R.layout.specification_row, null);
        RecyclerViewHolders rcv = new RecyclerViewHolders(layoutView);
        return rcv;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolders holder, int position) {
        holder.Key.setText(itemList.get(position).getKey());
        holder.Value.setText(itemList.get(position).getValue());
    }

    @Override
    public int getItemCount() {
        return this.itemList.size();
    }
}
