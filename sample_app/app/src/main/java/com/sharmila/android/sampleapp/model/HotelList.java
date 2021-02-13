package com.sharmila.android.sampleapp.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/* Created By Sharmila Prasath
 * February 2021
 * */
public class HotelList {

    @SerializedName("data")
    @Expose
    private List<Hotel> hotels;

    public List<Hotel> getHotels() {
        return hotels;
    }

    @NonNull
    @Override
    public String toString() {
        return hotels.toString();
    }
}
