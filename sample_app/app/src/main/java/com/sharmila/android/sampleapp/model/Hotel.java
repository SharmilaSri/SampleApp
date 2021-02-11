package com.sharmila.android.sampleapp.model;

import androidx.annotation.NonNull;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

public class Hotel {

    @SerializedName("id")
    @Expose
    int id;
    @SerializedName("title")
    @Expose
    String title="";
    @SerializedName("description")
    @Expose
    String description="";
    @SerializedName("address")
    @Expose
    String address="";
    @SerializedName("postcode")
    @Expose
    String postcode="";
    @SerializedName("phoneNumber")
    @Expose
    String phoneNumber="";
    @SerializedName("latitute")
    @Expose
    String latitute="";
    @SerializedName("longtitude")
    @Expose
    String longtitude="";

    @SerializedName("image")
    @Expose
    private Image images;

    public Image getImages() {
        return images;
    }

    @NonNull
    @Override
    public String toString() {
        return images.toString();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getPostcode() {
        return postcode;
    }

    public void setPostcode(String postcode) {
        this.postcode = postcode;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public String getLatitute() {
        return latitute;
    }

    public void setLatitute(String latitute) {
        this.latitute = latitute;
    }

    public String getLongtitude() {
        return longtitude;
    }

    public void setLongtitude(String longtitude) {
        this.longtitude = longtitude;
    }

    public void setImages(Image images) {
        this.images = images;
    }

    //Singleton design pattern
    private static Hotel hotelOb;
    public static Hotel getInstance(){
        if(hotelOb==null){
            hotelOb=new Hotel();
        }
        return  hotelOb;
    }

}
