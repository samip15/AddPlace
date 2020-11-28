package com.example.mvvmapp.adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.request.RequestOptions;
import com.example.mvvmapp.R;
import com.example.mvvmapp.models.NicePlace;

import java.util.ArrayList;
import java.util.List;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {
    private List<NicePlace> mNicePlaces = new ArrayList<>();
    private Context mContext;

    public RecyclerAdapter(Context mContext,List<NicePlace> mNicePlaces) {
        this.mNicePlaces = mNicePlaces;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        ViewHolder vh = new ViewHolder(view);
        return vh;
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerView.ViewHolder holder, int position) {
        // Set the name of the 'NicePlace'
        ((ViewHolder)holder)._txt.setText(mNicePlaces.get(position).getTitle());

        // Set the image
        RequestOptions defaultOptions = new RequestOptions()
                .error(R.drawable.ic_launcher_background);
        Glide.with(mContext)
                .setDefaultRequestOptions(defaultOptions)
                .load(mNicePlaces.get(position).getImageUrl())
                .into(((ViewHolder)holder).img_item);
    }

    @Override
    public int getItemCount() {
        return mNicePlaces.size();
    }

    private   class ViewHolder extends RecyclerView.ViewHolder{
        ImageView img_item;
        TextView _txt;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            img_item = itemView.findViewById(R.id.image);
            _txt = itemView.findViewById(R.id.image_name);
        }
    }

}
