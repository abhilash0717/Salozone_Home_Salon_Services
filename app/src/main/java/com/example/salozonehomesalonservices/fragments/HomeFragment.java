package com.example.salozonehomesalonservices.fragments;


import android.content.Intent;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.salozonehomesalonservices.Adapter.HomeSliderAdapter;
import com.example.salozonehomesalonservices.Adapter.LookBookAdapter;
import com.example.salozonehomesalonservices.BookingActivity;
import com.example.salozonehomesalonservices.Interface.IBannerLoadListener;
import com.example.salozonehomesalonservices.Interface.ILookbookLoadListener;
import com.example.salozonehomesalonservices.R;
import com.example.salozonehomesalonservices.common.Common;
import com.example.salozonehomesalonservices.model.Banner;
import com.example.salozonehomesalonservices.service.picassoImageLoadingService;
import com.facebook.accountkit.AccountKit;
import com.facebook.accountkit.AccountKitLoginResult;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.OnFailureListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QueryDocumentSnapshot;
import com.google.firebase.firestore.QuerySnapshot;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;
import ss.com.bannerslider.Slider;

/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends Fragment implements ILookbookLoadListener, IBannerLoadListener {

    private Unbinder unbinder;

    @BindView(R.id.layout_user_information)
    LinearLayout layout_user_information;

    @BindView(R.id.txt_user_name)
    TextView txt_user_name;

    @BindView(R.id.banner_slider)
    Slider banner_slider;

    @BindView(R.id.recycler_look_book)
    RecyclerView recycler_look_book;

    @OnClick(R.id.card_view_booking)
            void booking()
    {

        startActivity(new Intent(getActivity(), BookingActivity.class));
    }


    CollectionReference bannerRef,lookbookRef;

    IBannerLoadListener iBannerLoadListener;
    ILookbookLoadListener iLookbookLoadListener;


    public HomeFragment() {

        bannerRef = FirebaseFirestore.getInstance().collection("banner");
        lookbookRef = FirebaseFirestore.getInstance().collection("lookbook");


    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_home, container, false);
        unbinder = ButterKnife.bind(this,view);

        Slider.init(new picassoImageLoadingService());
        iBannerLoadListener = this;
        iLookbookLoadListener = this;

        if( AccountKit.getCurrentAccessToken() != null )
        {

            setUserInformation();
            loadBanner();
            loadLookBook();
        }

        return view;
    }

    private void loadLookBook() {

        lookbookRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        List<Banner> lookbooks = new ArrayList<>();

                        if(task.isSuccessful())
                        {

                            for(QueryDocumentSnapshot bannerSnapShot : task.getResult())
                            {

                                Banner banner  = bannerSnapShot.toObject(Banner.class);
                                lookbooks.add(banner);
                            }

                            iLookbookLoadListener.onLookBookLoadSuccess(lookbooks);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                iLookbookLoadListener.onLookBookLoadFailed(e.getMessage());

            }
        });


    }

    private void loadBanner() {
        bannerRef.get()
                .addOnCompleteListener(new OnCompleteListener<QuerySnapshot>() {
                    @Override
                    public void onComplete(@NonNull Task<QuerySnapshot> task) {

                        List<Banner> banners = new ArrayList<>();

                        if(task.isSuccessful())
                        {

                            for(QueryDocumentSnapshot bannerSnapShot : task.getResult())
                            {

                                Banner banner  = bannerSnapShot.toObject(Banner.class);
                                banners.add(banner);
                            }

                            iBannerLoadListener.onBannerLoadSuccess(banners);
                        }

                    }
                }).addOnFailureListener(new OnFailureListener() {
            @Override
            public void onFailure(@NonNull Exception e) {

                iBannerLoadListener.onBannerLoadFailed(e.getMessage());

            }
        });
    }

    private void setUserInformation() {
        layout_user_information.setVisibility(View.VISIBLE);
        txt_user_name.setText(Common.currentUser.getName());

    }

    @Override
    public void onLookBookLoadSuccess(List<Banner> banners) {

        recycler_look_book.setHasFixedSize(true);
        recycler_look_book.setLayoutManager(new LinearLayoutManager(getActivity()));
        recycler_look_book.setAdapter(new LookBookAdapter(getActivity(),banners));
    }

    @Override
    public void onLookBookLoadFailed(String message) {

        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

    }

    @Override
    public void onBannerLoadSuccess(List<Banner> banners) {

            banner_slider.setAdapter(new HomeSliderAdapter(banners));

    }

    @Override
    public void onBannerLoadFailed(String message) {

        Toast.makeText(getActivity(), message, Toast.LENGTH_SHORT).show();

    }
}
