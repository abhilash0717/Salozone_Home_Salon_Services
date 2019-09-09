package com.example.salozonehomesalonservices.Interface;

import com.example.salozonehomesalonservices.model.Banner;

import java.util.List;

public interface ILookbookLoadListener {

    void onLookBookLoadSuccess(List<Banner> banners);
    void onLookBookLoadFailed(String message);
}
