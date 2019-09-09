package com.example.salozonehomesalonservices.Interface;

import com.example.salozonehomesalonservices.model.Salon;

import java.util.List;

public interface IBranchLoadListener {

    void onBranchLoadSuccess(List<Salon> salonList);
    void onBranchLoadFailed(String message);

}
