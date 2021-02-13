package com.sharmila.android.sampleapp.network;

import com.sharmila.android.sampleapp.model.Hotel;
import com.sharmila.android.sampleapp.model.HotelList;


import retrofit2.Call;
import retrofit2.http.GET;

/* Created By Sharmila Prasath
 * February 2021
 * */public interface Api {

    String BASE_URL = "https://dl.dropboxusercontent.com/s/6nt7fkdt7ck0lue/hotels.json/";

    @GET("hotels")
    Call<HotelList> getHotelList();
}
