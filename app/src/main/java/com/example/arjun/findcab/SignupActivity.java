package com.example.arjun.findcab;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.widget.EditText;
import android.widget.Toast;

import com.google.gson.Gson;
import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.Click;
import org.androidannotations.annotations.EActivity;
import org.androidannotations.annotations.UiThread;
import org.androidannotations.annotations.ViewById;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.io.Reader;
import java.lang.reflect.Array;
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
        GetRequest("http://192.168.0.8:3000/wines/55ea75e2ed43ae5e6975f58c");



        /*Intent intent = OTPActivity_.intent(getApplicationContext()).get();
        startActivity(intent);*/
    }

    @Background
    public void GetRequest(String url) {
        Request request = new Request.Builder().url(url).build();
        Response response = null;
        try {
            response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
        try {
            someuiStuff(response.body().string());
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @UiThread
    void someuiStuff(String getResponse) {

        try {
            JSONObject jsonObject = new JSONObject(getResponse.toString());
            String id = jsonObject.getString("_id");
            String name = jsonObject.getString("name");
            String year = jsonObject.getString("year");
            String grapes = jsonObject.getString("grapes");
            String country = jsonObject.getString("country");
            String region = jsonObject.getString("region");
            String description = jsonObject.getString("description");
            String picture = jsonObject.getString("picture");

            Toast.makeText(getApplicationContext(), id, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), name, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), year, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), grapes, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), country, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), region, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), description, Toast.LENGTH_SHORT).show();
            Toast.makeText(getApplicationContext(), picture, Toast.LENGTH_SHORT).show();
           
            
        }catch(JSONException e){
            e.printStackTrace();
        }

        //String data = gson.fromJson(getResponse.toString(), String.class);
        Log.d("Webservice", getResponse.toString() + "");
       Toast.makeText(getApplicationContext(), getResponse.toString()+"", Toast.LENGTH_SHORT).show();
    }
}
