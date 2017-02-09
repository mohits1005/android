package com.example.mohits1005.myapplication;

import java.util.List;

import retrofit2.Call;
import retrofit2.http.GET;

/**
 * Created by mohits1005 on 2/8/2017.
 */

public interface APIService {
        @GET("json")
        Call<Student>getData1();
}
