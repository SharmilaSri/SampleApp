package com.sharmila.android.sampleapp.adapaters;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sharmila.android.sampleapp.HotelDetailDisplayActivity;
import com.sharmila.android.sampleapp.R;
import com.sharmila.android.sampleapp.model.Hotel;
import com.sharmila.android.sampleapp.model.HotelList;
import com.sharmila.android.sampleapp.model.Image;

import java.util.ArrayList;
import java.util.List;


/* Created By Sharmila Prasath
 * February 2021
 * Used in DisplayListActivity
 * */
public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder>{

    private List<Hotel> hotelList;
    private Context context;
    private HotelSelectedCallBack hotelSelectedCallBack;


    public HotelListAdapter(Context context,List<Hotel> hotelList) {

        this.context=context;
        this.hotelList=hotelList;

    }

    public void setHotelSelectedCallBack(HotelSelectedCallBack hotelSelectedCallBack){
        this.hotelSelectedCallBack=hotelSelectedCallBack;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.hotel_item_layout, parent, false);


        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.txtViewHotelName.setText(hotelList.get(position).getTitle());
        holder.txtViewAddressLineOne.setText(hotelList.get(position).getAddress());
        holder.txtViewAddressLineTwo.setText(hotelList.get(position).getAddress());
        Glide.with(context)
                .load(hotelList.get(position).getImages().getSmall())
                .into(holder.imageViewHotel);
        holder.parentLayout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

               moveToHotelDetailDisplayActivity(position);
            }
        });
    }

    private void moveToHotelDetailDisplayActivity(int position) {
        //Create a singleton hotel and set required values
        Hotel selectedHotel=Hotel.getInstance();
        selectedHotel.setTitle(hotelList.get(position).getTitle()).setDescription(hotelList.get(position).getDescription())
        .setLongtitude(hotelList.get(position).getLongtitude()).setLatitute(hotelList.get(position).getLatitute());
       /* selectedHotel.setDescription(hotelList.get(position).getDescription());
        selectedHotel.setLongtitude(hotelList.get(position).getLongtitude());
        selectedHotel.setLatitute(hotelList.get(position).getLatitute());*/
        Image image=new Image();
        image.setSmall(hotelList.get(position).getImages().getSmall());
        selectedHotel.setImages(image);

        hotelSelectedCallBack.hotelSelectedCallBack(selectedHotel);
    }

    @Override
    public int getItemCount() {
        return hotelList.size();
    }

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView txtViewHotelName;
        private final TextView txtViewAddressLineOne;
        private final TextView txtViewAddressLineTwo;
        private final ImageView imageViewHotel;
        private final ConstraintLayout parentLayout;

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            txtViewHotelName = (TextView) view.findViewById(R.id.txt_view_hotel_name);
            txtViewAddressLineOne=(TextView) view.findViewById(R.id.txt_view_address_line_1);
            txtViewAddressLineTwo=(TextView) view.findViewById(R.id.txt_view_address_line_2);
            imageViewHotel=(ImageView) view.findViewById(R.id.image_view_hotel);
            parentLayout=(ConstraintLayout) view.findViewById(R.id.layout_parent);
        }


    }
}
