package com.example.salozonehomesalonservices.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salozonehomesalonservices.R;
import com.example.salozonehomesalonservices.model.Barber;

import java.util.ArrayList;
import java.util.List;

public class MyBarberAdapter extends RecyclerView.Adapter<MyBarberAdapter.MyViewHolder> {

    Context context;
    List<Barber> barberList;

    public MyBarberAdapter(Context context, ArrayList<Barber> barberList) {

        this.context = context;
        this.barberList = barberList;
    }

    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.layout_barber, parent, false);
        return new MyViewHolder(itemView);

    }


    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        holder.txt_barber_name.setText(barberList.get(position).getName());
        holder.ratingBar.setRating((float) barberList.get(position).getRating());
    }

    @Override
    public int getItemCount() {

        return barberList.size();

    }




      class MyViewHolder extends RecyclerView.ViewHolder {

        TextView txt_barber_name;
        RatingBar ratingBar;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            txt_barber_name = (TextView)itemView.findViewById(R.id.txt_barber_name);
            ratingBar = (RatingBar)itemView.findViewById(R.id.rtb_barber);

        }
    }
}
