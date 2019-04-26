package com.example.hp.carfleet;

import android.app.Activity;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.OnSuccessListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.storage.FirebaseStorage;
import com.google.firebase.storage.StorageReference;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;

import static com.facebook.FacebookSdk.getApplicationContext;


public class ModelAdapter extends RecyclerView.Adapter<ModelAdapter.MyViewHolder> {
    ArrayList<Models> marquesList;
    static Context context;
    View itemView;
    private final OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Models item);
    }


    public ModelAdapter(ArrayList<Models> marquesList, Context context,OnItemClickListener listener) {
        this.marquesList = marquesList;
        this.context = context;

        this.listener = listener;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater  inflater = LayoutInflater.from(context);
        itemView = inflater.inflate(R.layout.car_list_row, parent, false);


        return new MyViewHolder(itemView);
    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
       // try {
          //  MyViewHolder.bind(modelList.get(position));
        try {
            holder.bind(marquesList.get(position),context, listener);
        } catch (IOException e) {
            e.printStackTrace();
        }
        TextView textView=new TextView(context);
        textView.setText(marquesList.get(position).getName());
        holder.carTitle.setText(marquesList.get(position).getName());
        Glide.with(context).load( marquesList.get(position).getPicture()).into(holder.carImage);
       // } catch (IOException e) {
         //   e.printStackTrace();
      //  }
    }

    @Override
    public int getItemCount() {
        return marquesList.size();
    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView carTitle;
        public  ImageView carImage;
        public TextView marqueTitle;
        public  ImageView marqueImage;

        public MyViewHolder(View view) {
            super(view);
            carTitle = (TextView) view.findViewById(R.id.cartitle);
            carImage = (ImageView) view.findViewById(R.id.carimage);
        }

        public void bind(final Models models,final Context context, final OnItemClickListener listener) throws IOException {


            itemView.setOnClickListener(new View.OnClickListener() {
                @Override public void onClick(View v) {
                    listener.onItemClick(models);
                }
            });

        }


    }
}
