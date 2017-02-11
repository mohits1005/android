package com.example.mohits1005.myapplication;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


public class MainActivity extends AppCompatActivity {

    TextView httpStuff;
    Student student;
    String details="";
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
        Call<Student> call = service.getData1("abcd","1234");
        call.enqueue(new Callback<Student>() {
            @Override
            public void onResponse(Call<Student> call, Response<Student> response) {
                  Student data = response.body();
                try {
                    Log.d("REsponse ", String.valueOf(response.body()));
                    Log.d("Response Email", data.getEmail());
                    Log.d("Response Password", data.getPassword());
                    httpStuff.setText(data.getEmail()+" "+data.getPassword());
                }catch (NullPointerException r){
                    r.printStackTrace();
                    if(data.getEmail()==null){
                        Log.d("Null email returned"," ");
                    }
                }
                  Log.d("Response Status","3");
            }

            @Override
            public void onFailure(Call<Student> call, Throwable t) {
                Log.d("Response", "3");
                t.printStackTrace();
            }
        });

    }

}


