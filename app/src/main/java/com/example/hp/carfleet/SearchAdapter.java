package com.example.hp.carfleet;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.IOException;
import java.util.ArrayList;


public class SearchAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private ArrayList<Search> mEmailData;
    private Context mContext;
    View view;
    private final SearchAdapter.OnItemClickListener listener;

    public interface OnItemClickListener {
        void onItemClick(Search item);
    }

    public SearchAdapter(Context mContext, ArrayList<Search> mEmailData,SearchAdapter.OnItemClickListener listener) {
        this.mEmailData = mEmailData;
        this.mContext = mContext;
        this.listener=listener;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        if (i== CommonSearch.VIEWTYPE_SEARCH)
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.recyclerview_mail_item,
                    viewGroup, false);
            return new SearchViewHolder(view);

        }
        else
        {
            view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.template2,
                    viewGroup, false);
            return new SpaceViewHolder(view);
        }

    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder searchViewHolder, int i) {

        try {
            bind(mEmailData.get(i),mContext, listener);
        } catch (IOException e) {
            e.printStackTrace();
        }
        if(searchViewHolder instanceof SearchViewHolder)
        {
            ((SearchViewHolder)searchViewHolder).mDescrtiption.setText(mEmailData.get(i).getmDescription());
            ((SearchViewHolder)searchViewHolder).mFavorite.setImageResource(mEmailData.get(i).getImg());
        }
    }

    @Override
    public int getItemViewType(int position) {
        return mEmailData.get(position).getViewtype();
    }

    @Override
    public int getItemCount() {
        return mEmailData.size();
    }
    public static class SearchViewHolder extends RecyclerView.ViewHolder {


        public TextView mDescrtiption;
        public ImageView mFavorite;


        public SearchViewHolder(@NonNull View itemView) {
            super(itemView);
            mDescrtiption = itemView.findViewById(R.id.searchOption);
            mFavorite = itemView.findViewById(R.id.ivFavorite);
        }
    }

    public class  SpaceViewHolder extends  RecyclerView.ViewHolder
    {

        public SpaceViewHolder(@NonNull View itemView) {
            super(itemView);
        }
    }

    public void bind(final Search models,final Context context, final SearchAdapter.OnItemClickListener listener) throws IOException {


        view.setOnClickListener(new View.OnClickListener() {
            @Override public void onClick(View v) {
                listener.onItemClick(models);
            }
        });

    }
}

