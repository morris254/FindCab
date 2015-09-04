package com.example.arjun.findcab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by arjun on 3/9/15.
 */

@EActivity(R.layout.signup)
public class SignupActivity extends AppCompatActivity {

    @ViewById(R.id.mobile_no)
    EditText mobile_no;

    @ViewById(R.id.password)
    EditText password;

    @ViewById(R.id.confirm_password)
    EditText confirm_password;

    @Click
    void sign_up(){

        String mobileno = mobile_no.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        String confirmpwd = confirm_password.getText().toString().trim();

        Toast.makeText(getApplicationContext(), mobileno, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),pwd,Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), confirmpwd, Toast.LENGTH_SHORT).show();

        Intent intent = OTPActivity_.intent(getApplicationContext()).get();
        startActivity(intent);
    }



}
