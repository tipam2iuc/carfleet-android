package com.example.hp.carfleet;

import android.content.Context;
import android.content.Intent;
import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentStatePagerAdapter;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.hp.carfleet.CardAdapter;
import com.example.hp.carfleet.CardFragment;

import java.util.ArrayList;
import java.util.List;

import static com.example.hp.carfleet.CardFragment.taille;

public class VehiculeAdapter extends PagerAdapter {

    Context context;
    int images[];
    CardView cardView;


    LayoutInflater layoutInflater;


    public VehiculeAdapter(Context context, int images[]) {
        this.context = context;
        this.images = images;

        layoutInflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

    }

    @Override
    public int getCount() {
        return images.length;
    }

    @Override
    public boolean isViewFromObject(@NonNull View view, @NonNull Object o) {
        return view == ((CardView) o);
    }

    @Override
    public Object instantiateItem(ViewGroup container, final int position) {
        View itemView = layoutInflater.inflate(R.layout.vehicule_item, container, false);

        ImageView imageView = (ImageView) itemView.findViewById(R.id.vehiculeImage);

        cardView = (CardView) itemView.findViewById(R.id.vehicule_cardview);

        imageView.setImageResource(this.images[position]);
       container.addView(itemView);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);

        return itemView;
    }

    @Override
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((CardView) object);
    }




}
