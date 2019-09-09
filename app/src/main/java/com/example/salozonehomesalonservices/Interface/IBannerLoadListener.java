package com.example.salozonehomesalonservices.Interface;

import com.example.salozonehomesalonservices.model.Banner;

import java.util.List;

public interface IBannerLoadListener {

    void onBannerLoadSuccess(List<Banner> banners);
    void onBannerLoadFailed(String message);
}
