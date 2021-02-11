package com.sharmila.android.sampleapp.utils;

import android.content.Context;

import android.net.ConnectivityManager;

import java.net.InetAddress;


public class UtilityFunctions {



    public static  boolean isNetworkConnected(Context ctx) {
        ConnectivityManager cm = (ConnectivityManager)ctx. getSystemService(Context.CONNECTIVITY_SERVICE);

        return cm.getActiveNetworkInfo() != null;
    }


    public static boolean isInternetAvailable() {
        try {
            InetAddress ipAddr = InetAddress.getByName("google.com");
            //You can replace it with your name
            return !ipAddr.equals("");

        } catch (Exception e) {
            return false;
        }
    }
}
