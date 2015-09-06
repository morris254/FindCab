package com.example.arjun.findcab;

import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.example.arjun.webservice.Wines;
import com.google.gson.Gson;
import com.squareup.okhttp.MediaType;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.RequestBody;
import com.squareup.okhttp.Response;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

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
    OkHttpClient client = new OkHttpClient();


    Gson gson = new Gson();

    @Click
    void sign_up() {

        String mobileno = mobile_no.getText().toString().trim();
        String pwd = password.getText().toString().trim();
        String confirmpwd = confirm_password.getText().toString().trim();

        /*Toast.makeText(getApplicationContext(), mobileno, Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(),pwd,Toast.LENGTH_SHORT).show();
        Toast.makeText(getApplicationContext(), confirmpwd, Toast.LENGTH_SHORT).show();*/

        client.setConnectTimeout(60000, TimeUnit.MILLISECONDS);
        client.setReadTimeout(60000, TimeUnit.MILLISECONDS);
        GetRequest("http://192.168.0.8:3000/wines");



        /*Intent intent = OTPActivity_.intent(getApplicationContext()).get();
        startActivity(intent);*/
    }

    @Background
    public void GetRequest(String url) {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
            someuiStuff(response.body().string());

            /*Wines wine = new Wines();
            wine.setName("Arjun");
            wine.setCountry("India");
            wine.setDescription("Associate Consultant");
            String toSend = gson.toJson(wine);

            RequestBody body = RequestBody.create(MediaType.parse("application/json"), toSend);
            Request request1 = new Request.Builder().url("http://192.168.0.8:3000/wines").post(body).build();

                Response responsehttp = client.newCall(request1).execute();*/
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void someuiStuff(String getResponse) {
        Gson gson = new Gson();
        Wines[] wines = gson.fromJson(getResponse.toString(), Wines[].class);

        for(int i =0;i<wines.length;i++){
            Toast.makeText(getApplicationContext(), wines[i].get_id(), Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), wines[i].getName(), Toast.LENGTH_SHORT).show();
        }
        /*serverResponseStatus = responsehttp.code();
        System.out.println("Response status is " + serverResponseStatus);*/
                Log.d("Webservice", getResponse.toString() + "");
        Toast.makeText(getApplicationContext(), getResponse.toString()+"", Toast.LENGTH_SHORT).show();
    }
}
