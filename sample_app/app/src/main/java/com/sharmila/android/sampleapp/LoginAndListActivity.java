package com.sharmila.android.sampleapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.ViewModelProvider;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.facebook.CallbackManager;
import com.facebook.FacebookCallback;
import com.facebook.FacebookException;
import com.facebook.Profile;
import com.facebook.login.LoginManager;
import com.facebook.login.LoginResult;
import com.facebook.login.widget.LoginButton;
import com.sharmila.android.sampleapp.adapaters.HotelListAdapter;
import com.sharmila.android.sampleapp.adapaters.HotelSelectedCallBack;
import com.sharmila.android.sampleapp.model.Hotel;
import com.sharmila.android.sampleapp.utils.Constants;
import com.sharmila.android.sampleapp.utils.UtilityFunctions;
import com.sharmila.android.sampleapp.viewmodel.HotelViewModel;

import java.util.Arrays;

/* Created By Sharmila Prasath
 * February 2021
 * Display Hotel List*/
public class LoginAndListActivity extends AppCompatActivity implements HotelSelectedCallBack {

    private RecyclerView recyclerView;
    private HotelListAdapter adapter;
    private CallbackManager callbackManager;
    private HotelViewModel model;
    private TextView txtViewEmail,txtViewName;
    private  Button loginButton=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_list);

        //Set up views
        setUpViews();

    }

    private void setUpViews() {
        txtViewEmail=findViewById(R.id.txtview_email);
        txtViewName=findViewById(R.id.txtview_name);
        //setup view model and network call
        model = new ViewModelProvider(this).get(HotelViewModel.class);

        //set up recycler
        recyclerView = findViewById(R.id.recycle_view_hotel_list);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        //set up facebook login
        loginButton = (LoginButton) findViewById(R.id.login_button);

        // Callback registration
        callbackManager = CallbackManager.Factory.create();
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList(Constants.USER_PROFILE));
        LoginManager.getInstance().registerCallback(callbackManager,
        new FacebookCallback<LoginResult>() {
            @Override
            public void onSuccess(LoginResult loginResult) {
                onFacebookLoginSuccess();

            }

            @Override
            public void onCancel() {

            }

            @Override
            public void onError(FacebookException exception) {
                Toast.makeText(getApplicationContext(),"Unexpected Error"+exception.getMessage().toString(),Toast.LENGTH_LONG).show();                        }
            });

        }

    private void onFacebookLoginSuccess() {
        //load hotel details in recycler view
        if(UtilityFunctions.isNetworkConnected(getApplicationContext()))
            setUpList();
        // Get User Name
        Profile profile=Profile.getCurrentProfile();
        setUpEmailAndUserName(profile.getFirstName(),profile.getLastName());
    }

    private void setUpEmailAndUserName(String userName,String email) {
        txtViewName.setText(userName);
        txtViewEmail.setText(email);
    }

    private void setUpList() {
        model.getHotels().observe(LoginAndListActivity.this, hotels -> {
            if(hotels!=null) {//check if list is not null
                adapter = new HotelListAdapter(LoginAndListActivity.this, hotels.getHotels());
                adapter.setHotelSelectedCallBack(new HotelSelectedCallBack() {//callbackwhen a hotel is clicked from the list
                    @Override
                    public void hotelSelectedCallBack(Hotel selectedHotel) {
                        Intent displayDetailsIntent=new Intent(getApplicationContext(),HotelDetailDisplayActivity.class);
                        startActivity(displayDetailsIntent);
                    }
                });
                recyclerView.setAdapter(adapter);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        callbackManager.onActivityResult(requestCode, resultCode, data);
        super.onActivityResult(requestCode, resultCode, data);
    }

    @Override
    public void hotelSelectedCallBack(Hotel selectedHotel) {
        Intent displayDetailsIntent=new Intent(this,HotelDetailDisplayActivity.class);
        startActivity(displayDetailsIntent);
    }
}