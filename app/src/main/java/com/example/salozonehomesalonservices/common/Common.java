package com.example.salozonehomesalonservices.common;

import com.example.salozonehomesalonservices.model.Salon;
import com.example.salozonehomesalonservices.model.User;

public class Common {

    public static final String KEY_ENABLE_BUTTON_NEXT = "ENABLE_BUTTON_NEXT";
    public static final String KEY_SALON_STORE = "SALON_SAVE";
    public static final String KEY_BARBER_LOAD_DONE = "BARBER_LOAD_DONE";
    public static String IS_LOGIN = "ISLogin";
    public static User currentUser;
    public static Salon currentSalon;
    public static int step = 0;
    public static String city ="";
}
