package com.sharmila.android.sampleapp.model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/* Created By Sharmila Prasath
 * February 2021
 * */
public class Image {

    @SerializedName("small")
    @Expose
    String small="";
    @SerializedName("medium")
    @Expose
    String medium="";
    @SerializedName("large")
    @Expose
    String large="";

    public String getSmall() {
        return small;
    }

    public void setSmall(String small) {
        this.small = small;
    }

    public String getMedium() {
        return medium;
    }

    public void setMedium(String medium) {
        this.medium = medium;
    }

    public String getLarge() {
        return large;
    }

    public void setLarge(String large) {
        this.large = large;
    }
}
