package com.example.mohitsharma.androidsqlitepractise;

import android.database.Cursor;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    DBAdapter myDb;
    EditText newtext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        newtext = (EditText)findViewById(R.id.editText);
        openDB();

    }

    private void openDB() {
        myDb = new DBAdapter(this);
        myDb.open();
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        closeDB();
    }

    private void closeDB() {
        myDb.close();
    }

    private void displayText(String message) {
        TextView textView = (TextView) findViewById(R.id.editText);
        textView.setText(message);
    }
    public void onClick_AddRecord(View v) {
        displayText("Clicked add record!");
        long newID = myDb.insertRow("moh", 353, "Red");

        Cursor cursor = myDb.getRow(newID);
        displayRecordSet(cursor);

    }

    public void onClick_ClearAll(View v) {
        displayText("Clicked clear all!");
        myDb.deleteAll();
    }

    public void onClick_Delete(View v){
        //Integer inputText = newtext.;
        //Toast.makeText(MainActivity.this, inputText, Toast.LENGTH_LONG).show();

        //Cursor cursor =
        Cursor cursor = myDb.getRow(3);
        displayRecordSet(cursor);
        if(myDb.deleteRow(3)){
            Toast.makeText(MainActivity.this, "Row 3 deleted", Toast.LENGTH_LONG).show();
        }
    }

    public void onClick_Update(View v){
        //if(myDb.updateRow(4,"sid",369,"pink")){
          if(myDb.updateRowText("sid")){
            Toast.makeText(MainActivity.this, "Row named sid updated", Toast.LENGTH_LONG).show();
        }
    }


    public void onClick_DisplayRecords(View v) {
        displayText("Clicked display record!");

        Cursor cursor = myDb.getAllRows();
        displayRecordSet(cursor);
    }

    private void displayRecordSet(Cursor cursor) {

        String message = "";
        if(cursor.moveToFirst()){
            do {
                // Process the data:
                int id = cursor.getInt(DBAdapter.COL_ROWID);
                String name = cursor.getString(DBAdapter.COL_NAME);
                int studentNumber = cursor.getInt(DBAdapter.COL_STUDENTNUM);
                String favColour = cursor.getString(DBAdapter.COL_FAVCOLOUR);

                // Append data to the message:
                message += "id=" + id
                        +", name=" + name
                        +", #=" + studentNumber
                        +", Colour=" + favColour
                        +"\n";
            } while(cursor.moveToNext());
        }
        cursor.close();
        displayText(message);
    }


}
