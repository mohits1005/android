package com.example.mohits1005.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    TextView httpStuff;
    Student student;
    String details="";
    Map<String,NameData> list;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        httpStuff = (TextView) findViewById(R.id.tvHttp);
        Log.d("Response", "1");
        getData();
    }
    public void getData(){
        Log.d("Response", "2");
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("http://www.cscomment.esy.es/")
                .addConverterFactory(GsonConverterFactory.create())
                .build();

        APIService service = retrofit.create(APIService.class);
        Call<Student> call = service.getData1();
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                  Student data = response.body();
                try {
                    Log.d("Response ", String.valueOf(response.body()));
                    Log.d("Response Name", String.valueOf(data.getName()));
                    Log.d("Responsem ID", String.valueOf(data.getId()));
                    list = data.getName();
                    for(Map.Entry<String,NameData> map : list.entrySet()){
                        Log.d("Response ", map.getValue().getName());
                        Log.d("Response ", map.getValue().getType());
                    }

                }catch (NullPointerException r){
                    r.printStackTrace();
                }
                  Log.d("Response Status","3");
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.d("Response", "4");
                t.printStackTrace();
            }
        });

    }

}


