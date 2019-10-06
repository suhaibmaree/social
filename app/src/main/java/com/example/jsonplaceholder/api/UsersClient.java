package com.example.jsonplaceholder.api;

import com.google.gson.Gson;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.jackson.JacksonConverterFactory;

public class UsersClient {

    public static final String baseUrl ="https://jsonplaceholder.typicode.com/";
    public static Retrofit RETROFIT = null;

    public static Retrofit getUsers(){

        if (RETROFIT == null){
            RETROFIT = new Retrofit.Builder()
                    .baseUrl(baseUrl)
                    .addConverterFactory(JacksonConverterFactory.create())
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .build();
        }
        return RETROFIT;
    }

}
