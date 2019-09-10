package com.example.salozonehomesalonservices.fragments;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.localbroadcastmanager.content.LocalBroadcastManager;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.salozonehomesalonservices.Adapter.MyBarberAdapter;
import com.example.salozonehomesalonservices.R;
import com.example.salozonehomesalonservices.common.Common;
import com.example.salozonehomesalonservices.common.SpacesItemDecoration;
import com.example.salozonehomesalonservices.model.Barber;

import java.util.ArrayList;

import javax.annotation.Nullable;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.Unbinder;

public class BookingStep2Fragment extends Fragment {

    Unbinder unbinder;
    LocalBroadcastManager localBroadcastManager;

    @BindView( R.id.recycler_barber)
    RecyclerView recycler_barber;


    private BroadcastReceiver barberDoneReciever = new BroadcastReceiver() {
        @Override
        public void onReceive(Context context, Intent intent) {
            ArrayList<Barber> barberArrayList = intent.getParcelableArrayListExtra(Common.KEY_BARBER_LOAD_DONE);
            MyBarberAdapter adapter = new MyBarberAdapter(getContext(), barberArrayList);
            recycler_barber.setAdapter(adapter);

        }
    };


    static BookingStep2Fragment instance;

    public static BookingStep2Fragment getInstance() {

        if(instance == null)
            instance = new BookingStep2Fragment();
        return instance;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState){
        super.onCreate(savedInstanceState);

        localBroadcastManager = LocalBroadcastManager.getInstance(getContext());
        localBroadcastManager.registerReceiver(barberDoneReciever,new IntentFilter(Common.KEY_BARBER_LOAD_DONE));
    }

    @Override
    public void onDestroy() {

        localBroadcastManager.unregisterReceiver(barberDoneReciever);
        super.onDestroy();
    }

    @androidx.annotation.Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @androidx.annotation.Nullable ViewGroup container, @androidx.annotation.Nullable Bundle savedInstanceState) {
         super.onCreateView(inflater, container, savedInstanceState);

         View itemView = inflater.inflate(R.layout.fragment_booking_step_2,container,false);
         unbinder = ButterKnife.bind(this,itemView);

         initView();

        return itemView;
    }

    private void initView() {
        recycler_barber.setHasFixedSize(true);
        recycler_barber.setLayoutManager(new GridLayoutManager(getActivity(),2));
        recycler_barber.addItemDecoration(new SpacesItemDecoration(4));
    }
}
