package com.example.kosharyan.api;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class ApiClient {


    private static Retrofit retrofit;

//ساخت شی رتروفیت


    public static Retrofit getRetrofit(){

        if (retrofit==null){
            retrofit = new Retrofit.Builder().baseUrl("https://test.koosharayan.ir/API/").addConverterFactory(GsonConverterFactory.create()).build();

        }

        return retrofit;


    }

}
