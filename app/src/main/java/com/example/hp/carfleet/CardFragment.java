package com.example.hp.carfleet;

import android.annotation.SuppressLint;
import android.media.Image;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.CardView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;


public class CardFragment extends Fragment {

    private CardView cardView;
    private ImageView image;
    static int[] images={R.drawable.voiture1,R.drawable.voiture2,R.drawable.voiture3};
    static int taille=images.length;
    public static Fragment getInstance(int position) {
        CardFragment f = new CardFragment();
        Bundle args = new Bundle();
        args.putInt("position", position);
        f.setArguments(args);

        return f;
    }

    @SuppressLint("DefaultLocale")
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.vehicule_item, container, false);

        cardView = (CardView) view.findViewById(R.id.vehicule_cardview);
        cardView.setMaxCardElevation(cardView.getCardElevation() * CardAdapter.MAX_ELEVATION_FACTOR);
        image = (ImageView)view.findViewById(R.id.vehiculeImage);
        image.setImageResource(images[getArguments().getInt("position")]);

        return view;
    }

    public CardView getCardView() {
        return cardView;
    }
}

