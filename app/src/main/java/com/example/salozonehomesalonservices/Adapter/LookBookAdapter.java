package com.example.salozonehomesalonservices.Adapter;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salozonehomesalonservices.R;
import com.example.salozonehomesalonservices.model.Banner;
import com.squareup.picasso.Picasso;

import java.util.List;

public class LookBookAdapter extends RecyclerView.Adapter<LookBookAdapter.MyViewHOlder> {


    Context context;
    List<Banner> lookbook;

    public LookBookAdapter(Context context,List<Banner> lookbook){

        this.context = context;
        this.lookbook = lookbook;
    }

    @NonNull
    @Override
    public MyViewHOlder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.layout_look_book,viewGroup,false);
        return new MyViewHOlder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHOlder holder, int position) {

        Picasso.get().load(lookbook.get(position).getImage()).into(holder.imageView);

    }

    @Override
    public int getItemCount() {
        return lookbook.size();
    }

    public class MyViewHOlder extends RecyclerView.ViewHolder {
        ImageView imageView;
        public MyViewHOlder(@NonNull View itemView) {
            super(itemView);

            imageView = (ImageView)itemView.findViewById(R.id.image_look_book);

        }
    }
}
