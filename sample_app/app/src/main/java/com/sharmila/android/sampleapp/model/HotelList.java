package com.sharmila.android.sampleapp.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

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
