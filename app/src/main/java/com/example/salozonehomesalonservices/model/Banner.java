package com.example.salozonehomesalonservices.model;

public class Banner {

    private String image;

    public Banner()
    {


    }

    public Banner(String image){

        this.image = image;
    }

    public String getImage(){

        return  image;
    }

    public void setImage(String image) {
        this.image = image;
    }
}
