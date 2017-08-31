package com.kelly.myapplication.retrofit;

import android.content.Context;


import com.kelly.myapplication.R;
import com.kelly.myapplication.interfaces.Constants;

import retrofit.RetrofitError;
import retrofit.mime.TypedByteArray;

/** Created by Paolo on 3/14/2016*/
class ErrorMessage {
    private final RetrofitError errorRetrofit;
    private final Context context;

    ErrorMessage(RetrofitError error, Context context){
        this.errorRetrofit = error;
        this.context = context;
    }

    int getTypeError(){
        int typeError;
        if (errorRetrofit.getResponse() != null) {
            typeError = Constants.REQUEST_SERVER_ERROR_CODE;
        } else if (errorRetrofit.getKind().equals(RetrofitError.Kind.NETWORK)) {
            typeError = Constants.REQUEST_NETWORK_CONNECTION_ERROR_CODE;
        }else{
            typeError = Constants.REQUEST_RETROFIT_ERROR_CODE;
        }

        return typeError;
    }

    String showError(){
        String error_message = "connection_error";
        try {
            if (getTypeError() == Constants.REQUEST_SERVER_ERROR_CODE) {
                error_message =  new String(((TypedByteArray)errorRetrofit.getResponse().getBody()).getBytes());
            } else {
                if (getTypeError() == Constants.REQUEST_NETWORK_CONNECTION_ERROR_CODE) {
                    error_message = "problem_with_internet";
                }
            }
        }catch (Exception e){
            error_message = e.toString();
        }
        return error_message;
    }
}