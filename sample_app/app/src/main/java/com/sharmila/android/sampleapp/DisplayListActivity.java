package com.sharmila.android.sampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.os.Bundle;

import com.sharmila.android.sampleapp.adapaters.HotelListAdapter;
import com.sharmila.android.sampleapp.model.HotelList;
import com.sharmila.android.sampleapp.viewmodel.HotelViewModel;

public class DisplayListActivity extends AppCompatActivity {
    RecyclerView recyclerView;
    HotelListAdapter adapter;

   HotelList hotelList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        //Set up views
        setUpViews();

    }

    private void setUpViews() {
        recyclerView = findViewById(R.id.recycle_view_hotel_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        HotelViewModel model = new ViewModelProvider(this).get(HotelViewModel.class);
        model.getHotels().observe(this, hotels -> {
            adapter = new HotelListAdapter(DisplayListActivity.this, hotels.getHotels());
            recyclerView.setAdapter(adapter);
        });
    }
}