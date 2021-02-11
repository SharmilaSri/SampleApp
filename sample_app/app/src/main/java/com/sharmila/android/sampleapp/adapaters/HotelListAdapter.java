package com.sharmila.android.sampleapp.adapaters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.lifecycle.LiveData;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.sharmila.android.sampleapp.R;
import com.sharmila.android.sampleapp.model.Hotel;
import com.sharmila.android.sampleapp.model.HotelList;

import java.util.ArrayList;
import java.util.List;

public class HotelListAdapter extends RecyclerView.Adapter<HotelListAdapter.ViewHolder>{

    private List<Hotel> hotelList;
    private Context context;


    public HotelListAdapter(Context context,List<Hotel> hotelList) {

        this.context=context;
        this.hotelList=hotelList;

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
                .load("hotelList.get(position).getImages().getMedium()")
                .into(holder.imageViewHotel);
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

        public ViewHolder(View view) {
            super(view);
            // Define click listener for the ViewHolder's View

            txtViewHotelName = (TextView) view.findViewById(R.id.txt_view_hotel_name);
            txtViewAddressLineOne=(TextView) view.findViewById(R.id.txt_view_address_line_1);
            txtViewAddressLineTwo=(TextView) view.findViewById(R.id.txt_view_address_line_2);
            imageViewHotel=(ImageView) view.findViewById(R.id.image_view_hotel);
        }


    }
}
