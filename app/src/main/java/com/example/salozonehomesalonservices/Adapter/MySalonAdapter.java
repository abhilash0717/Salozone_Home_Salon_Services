package com.example.salozonehomesalonservices.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salozonehomesalonservices.R;
import com.example.salozonehomesalonservices.model.Salon;

import java.util.List;

public class MySalonAdapter extends RecyclerView.Adapter<MySalonAdapter.MyViewholder> {

    Context context;
    List<Salon> salonList;

    public MySalonAdapter(Context context,List<Salon> salonList){
        this.context = context;
        this.salonList = salonList;
    }

    @NonNull
    @Override
    public MyViewholder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(context)
                .inflate(R.layout.layout_salon,parent,false);
        return new MyViewholder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull MyViewholder holder, int position) {
            holder.txt_salon_name.setText(salonList.get(position).getName());
        holder.txt_salon_address.setText(salonList.get(position).getAddress());
    }

    @Override
    public int getItemCount() {
        return salonList.size();
    }

    public class MyViewholder extends RecyclerView.ViewHolder {
        TextView txt_salon_name,txt_salon_address;
        public MyViewholder(@NonNull View itemView) {
            super(itemView);

            txt_salon_name = (TextView)itemView.findViewById(R.id.txt_salon_name);
            txt_salon_address = (TextView)itemView.findViewById(R.id.txt_salon_address);

        }
    }
}
