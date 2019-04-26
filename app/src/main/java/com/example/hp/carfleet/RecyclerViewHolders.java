package com.example.hp.carfleet;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

public class RecyclerViewHolders extends RecyclerView.ViewHolder implements View.OnClickListener{

    public TextView Key;
    public TextView Value;

    public RecyclerViewHolders(View itemView) {
        super(itemView);
        itemView.setOnClickListener(this);
        Key = (TextView)itemView.findViewById(R.id.key);
        Value = (TextView)itemView.findViewById(R.id.value);
    }
    @Override
    public void onClick(View view) {
    }

}
