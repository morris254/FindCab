package com.example.arjun.findcab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;


@EActivity(R.layout.activity_main)
public class MainActivity extends AppCompatActivity {


    @Click
    void btnLogin(){
        Intent intent = LoginActivity_.intent(getApplicationContext()).get();
        startActivity(intent);
    }

    @Click
    void btnSignUp(){
        Intent intent = SignupActivity_.intent(getApplicationContext()).get();
        startActivity(intent);
    }

}
