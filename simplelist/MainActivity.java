package com.example.mohitsharma.androidlist;

import android.app.Activity;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        String[] arrstring = {"alpha","beta","charlie","delta","echo"};
        ListAdapter newadaptor = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, arrstring );
        ListView newlistview = (ListView)findViewById(R.id.newListView);
        newlistview.setAdapter(newadaptor);

        newlistview.setOnItemClickListener(
                new AdapterView.OnItemClickListener(){
                    @Override
                    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                        String arr = String.valueOf(parent.getItemAtPosition(position));
                        Toast.makeText(MainActivity.this, arr, Toast.LENGTH_LONG).show();
                    }
                }

        );

    }
}
