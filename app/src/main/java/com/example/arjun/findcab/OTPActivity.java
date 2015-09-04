package com.example.arjun.findcab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by arjun on 4/9/15.
 */
@EActivity(R.layout.otp_main)
public class OTPActivity extends AppCompatActivity {

    @ViewById(R.id.otp)
    EditText otp;

    @Click
    void otp_submit(){
        String str_otp = otp.getText().toString();
        Toast.makeText(getApplicationContext(), str_otp, Toast.LENGTH_SHORT).show();

        /*Intent intent = OTPActivity_.intent(getApplicationContext()).get();
        startActivity(intent);*/

    }



}
