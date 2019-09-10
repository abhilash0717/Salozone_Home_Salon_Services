package com.example.salozonehomesalonservices.model;

import android.os.Parcel;
import android.os.Parcelable;

public class Barber implements Parcelable {

    private String name,username,password,barberID;
    private long rating;

    public Barber(){

    }

    protected Barber(Parcel in) {
        name = in.readString();
        username = in.readString();
        password = in.readString();
        barberID = in.readString();
        rating = in.readLong();
    }

    public static final Creator<Barber> CREATOR = new Creator<Barber>() {
        @Override
        public Barber createFromParcel(Parcel in) {
            return new Barber(in);
        }

        @Override
        public Barber[] newArray(int size) {
            return new Barber[size];
        }
    };

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getUsername() {
        return username;
    }

    public long getRating() {
        return rating;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setRating(long rating) {
        this.rating = rating;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getBarberID() {
        return barberID;
    }

    public void setBarberID(String barberID) {
        this.barberID = barberID;
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeString(name);
        parcel.writeString(username);
        parcel.writeString(password);
        parcel.writeString(barberID);
        parcel.writeLong(rating);
    }
}
