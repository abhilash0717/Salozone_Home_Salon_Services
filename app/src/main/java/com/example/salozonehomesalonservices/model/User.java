package com.example.salozonehomesalonservices.model;

import java.util.jar.Attributes;

public class User {

    private String name,address,phoneNumber;

    public User() {
    }


        public User (String name, String address, String phoneNumber)
        {

            this.name = name;
            this.address = address;
            this.phoneNumber = phoneNumber;
        }

        public String getName(){
        return name;

    }

    public void setName(String name){

        this.name = name;
    }

}
