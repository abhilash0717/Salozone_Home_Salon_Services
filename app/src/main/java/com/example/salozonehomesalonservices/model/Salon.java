package com.example.salozonehomesalonservices.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Salon implements Parcelable {

    private String name, address, salondId;

    public Salon()
    {

    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getSalondId() {
        return salondId;
    }

    public void setSalondId(String salondId) {
        this.salondId = salondId;
    }

    protected Salon(Parcel in) {
        name = in.readString();
        address = in.readString();
        salondId = in.readString();
    }

    public static final Creator<Salon> CREATOR = new Creator<Salon>() {
        @Override
        public Salon createFromParcel(Parcel in) {
            return new Salon(in);
        }

        @Override
        public Salon[] newArray(int size) {
            return new Salon[size];
        }
    };

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(address);
        parcel.writeString(salondId);
    }
}