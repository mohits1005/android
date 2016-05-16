package com.example.mohitsharma.androidlistcustomadapter2;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;
import android.app.Activity;
import android.view.Menu;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Integer[] image_resource = {
                R.drawable.ic_launcher,
                R.drawable.android,
                R.drawable.windows,
                R.drawable.apple,
                R.drawable.firefox
        };

         String[] array = {
                "IC Launcher",
                "Android",
                "Windows",
                "IOS",
                "Firefox"
        };

        String[] desc = {
                "Average",
                "Good",
                "Good",
                "Bad",
                "Bad"
        };

        String[] date = {
                "5-12-16",
                "5-12-16",
                "5-12-16",
                "5-12-16",
                "5-12-16"
        };


        CustomAdapter adapter = new CustomAdapter(this, array, desc, date, image_resource);
        ListView lv = (ListView) findViewById(R.id.newListView);
        lv.setAdapter(adapter);




    }


}
