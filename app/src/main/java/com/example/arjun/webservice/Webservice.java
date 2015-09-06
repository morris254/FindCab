package com.example.arjun.webservice;

import com.squareup.okhttp.OkHttpClient;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import org.androidannotations.annotations.Background;
import org.androidannotations.annotations.EBean;

import java.io.IOException;

/**
 * Created by arjun on 6/9/15.
 */
@EBean
public class Webservice {
    OkHttpClient client = new OkHttpClient();

    @Background
    public void GetRequest(String url) {
        Request request = new Request.Builder().url(url).build();
        try {
            Response response = client.newCall(request).execute();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
