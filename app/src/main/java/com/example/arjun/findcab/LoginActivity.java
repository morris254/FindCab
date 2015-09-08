package com.example.arjun.findcab;

import android.support.v7.app.AppCompatActivity;
import android.widget.TextView;
import android.widget.Toast;

import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.ViewById;

/**
 * Created by arjun on 3/9/15.
 */
@EActivity(R.layout.login)
public class LoginActivity extends AppCompatActivity {

    @ViewById(R.id.mobile_no)
    TextView mobile_no;

    @ViewById(R.id.password)
    TextView password;

    @Click
    void login(){
        if(!mobile_no.getText().toString().replace(" ","").equals("") && !password.getText().toString().replace(" ", "").equals("")) {
            String mobileno = mobile_no.getText().toString().replace(" ","");

            String pwd = password.getText().toString().replace(" ", "");

            if(mobileno.equals("9999999999") && pwd.equals("findCab@123") ){
                Toast.makeText(getApplicationContext(), "Logged in",Toast.LENGTH_SHORT).show();
            }else {

                Toast.makeText(getApplicationContext(), mobileno, Toast.LENGTH_SHORT).show();
                Toast.makeText(getApplicationContext(), pwd, Toast.LENGTH_SHORT).show();
            }


        }
    }
}
