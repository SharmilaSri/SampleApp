package com.sharmila.android.sampleapp.viewmodel;

import android.util.Log;
import android.widget.Toast;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.sharmila.android.sampleapp.model.Hotel;
import com.sharmila.android.sampleapp.model.HotelList;
import com.sharmila.android.sampleapp.network.Api;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

/* Created By Sharmila Prasath
 * February 2021
 * */
public class HotelViewModel extends ViewModel {

    //this is the data that we will fetch asynchronously 
    private MutableLiveData<HotelList> hotelList;

    //we will call this method to get the data
    public LiveData<HotelList> getHotels() {
        //if the list is null 
        if (hotelList == null) {
            hotelList = new MutableLiveData<HotelList>();
            //we will load it asynchronously from server in this method
            loadHotels();
        }

        //finally we will return the list
        return hotelList;
    }

    private void loadHotels() {

        //This method is using Retrofit to get the JSON data from URL
            Retrofit retrofit = new Retrofit.Builder()
                    .baseUrl(Api.BASE_URL)
                    .addConverterFactory(GsonConverterFactory.create())
                    .build();

            Api api = retrofit.create(Api.class);
            Call<HotelList> call = api.getHotelList();


            call.enqueue(new Callback<HotelList>() {
                @Override
                public void onResponse(Call<HotelList> call, Response<HotelList> response) {
                    //finally we are setting the list to our MutableLiveData
                    hotelList.setValue(response.body());
                }

                @Override
                public void onFailure(Call<HotelList> call, Throwable t) {
                    Log.d("******************",t.getMessage().toString());
                }
            });
        }
    }

