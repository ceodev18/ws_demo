package com.kelly.myapplication.retrofit;

import android.content.Context;

import com.squareup.okhttp.Authenticator;
import com.squareup.okhttp.Request;
import com.squareup.okhttp.Response;

import java.io.IOException;
import java.net.Proxy;


/** Created by Paolo on 3/15/2016.*/
public class RetrofitAuthenticator implements Authenticator{
    private final RestClient restClient;

    public RetrofitAuthenticator(Context context) {
        restClient = new RestClient();
    }


    @Override
    public Request authenticate(Proxy proxy, Response response) throws IOException {
        String newAccessToken = "welcome_to_mars";
        // Add new header to rejected request and retry it
        return response.request().newBuilder()
                .header("Authorization", String.format("Bearer %s", newAccessToken))
                .build();
    }

    @Override
    public Request authenticateProxy(Proxy proxy, Response response) throws IOException {
        //TODO not implemented
        return null;
    }
}