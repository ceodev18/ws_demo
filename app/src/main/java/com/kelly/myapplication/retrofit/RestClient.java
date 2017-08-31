package com.kelly.myapplication.retrofit;

import android.content.Context;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.bind.DateTypeAdapter;
import com.squareup.okhttp.OkHttpClient;

import java.util.Date;
import java.util.concurrent.TimeUnit;

import retrofit.RestAdapter;
import retrofit.client.OkClient;
import retrofit.converter.GsonConverter;

/** Created by Paolo on 3/14/2016*/
public class RestClient {
    private final LotizerServices webServices;
    //private static final String BASE_URL ="http://ec2-184-73-174-10.compute-1.amazonaws.com:5432/";
    //private static final String BASE_URL ="http://ec2-184-73-174-10.compute-1.amazonaws.com:5432/";
    private static final String BASE_URL  = "http://ec2-52-88-240-200.us-west-2.compute.amazonaws.com:5000/";

    public RestClient(){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();

        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setReadTimeout(360, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(360, TimeUnit.SECONDS);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okHttpClient))
                .setConverter(new GsonConverter(gson))
                .build();

        webServices = restAdapter.create(LotizerServices.class);
    }

    public RestClient(Context context){
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .registerTypeAdapter(Date.class, new DateTypeAdapter())
                .create();

        RetrofitAuthenticator authAuthenticator = new RetrofitAuthenticator(context);
        OkHttpClient okHttpClient = new OkHttpClient();
        okHttpClient.setAuthenticator(authAuthenticator);
        okHttpClient.setReadTimeout(360, TimeUnit.SECONDS);
        okHttpClient.setConnectTimeout(360, TimeUnit.SECONDS);

        RestAdapter restAdapter = new RestAdapter.Builder()
                .setEndpoint(BASE_URL)
                .setLogLevel(RestAdapter.LogLevel.FULL)
                .setClient(new OkClient(okHttpClient))
                .setConverter(new GsonConverter(gson))
                .build();

        webServices = restAdapter.create(LotizerServices.class);
    }

    public LotizerServices getWebservices(){
        return webServices;
    }
}