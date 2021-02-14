package com.sharmila.android.sampleapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;
import android.widget.TextView;
import com.bumptech.glide.Glide;
import com.sharmila.android.sampleapp.adapaters.HotelSelectedCallBack;
import com.sharmila.android.sampleapp.model.Hotel;

/* Created By Sharmila Prasath
 * February 2021
 * Display Detailed Hotel Informationy*/
public class HotelDetailDisplayActivity extends AppCompatActivity {
    private  TextView txtViewHotelName;
    private  TextView txtViewHotelDescription;
    private  ImageView imageViewHotel;
    private Hotel selectedHotel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_hotel_detail_display);


        setUpViews();
    }

    private void setUpViews() {
        selectedHotel=Hotel.getInstance();
        txtViewHotelName=findViewById(R.id.txtview_hotel_title);
        txtViewHotelDescription=findViewById(R.id.txtview_hotel_description);
        imageViewHotel=findViewById(R.id.image_view_hotel_image);
        txtViewHotelName.setText(selectedHotel.getTitle());
        txtViewHotelDescription.setText(selectedHotel.getDescription());
        Glide.with(this)
                .load(selectedHotel.getImages().getSmall())
                .into(imageViewHotel);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_hotel_detail_display, menu);


        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {

        int id = item.getItemId();

        if (id == R.id.show_map) {
            // Create a Uri from an intent string. Use the result to create an Intent.
            Uri gmmIntentUri = Uri.parse("google.streetview:cbll="+selectedHotel.getLatitute()+","+selectedHotel.getLongtitude()+"");

            // Create an Intent from gmmIntentUri. Set the action to ACTION_VIEW
            Intent mapIntent = new Intent(Intent.ACTION_VIEW, gmmIntentUri);
            // Make the Intent explicit by setting the Google Maps package
            mapIntent.setPackage("com.google.android.apps.maps");

            // Attempt to start an activity that can handle the Intent
            startActivity(mapIntent);
        }
        return true;
    }


}
