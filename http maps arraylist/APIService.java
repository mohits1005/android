package com.example.mohits1005.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by mohits1005 on 2/8/2017.
 */

public interface APIService {
        @GET("json/")
        Call<Student>getData1();
}
