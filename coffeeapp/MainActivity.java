package com.example.mohitsharma.myapplication6;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.text.NumberFormat;

public class MainActivity extends AppCompatActivity {

    int quantity = 2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

    }

    public void submitOrder(View view){



        EditText text = (EditText) findViewById(R.id.name_field);
        String name = text.getText().toString();
        Log.v("MainActivity", "Name: "+name);

        CheckBox whippedcream = (CheckBox) findViewById(R.id.whippedcream);
        boolean haswhippedcream = whippedcream.isChecked();
        Log.v("MainActivity", "Has whipped cream: "+haswhippedcream);

        CheckBox chocolate = (CheckBox) findViewById(R.id.chocolate);
        boolean haschocolate = chocolate.isChecked();
        Log.v("MainActivity", "Has chocolate: "+haschocolate);

        int price = calculatePrice(haswhippedcream, haschocolate);

        String order = submitOrderSummary(name, price, haswhippedcream, haschocolate);

        Intent intent = new Intent(Intent.ACTION_SENDTO);
        intent.setData(Uri.parse("mailto:")); // only email apps should handle this
        intent.putExtra(Intent.EXTRA_SUBJECT, "Coffee order for "+name);
        intent.putExtra(Intent.EXTRA_TEXT, order);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(intent);
        }

        displayMessage(order);
    }

    private String submitOrderSummary(String name, int price, boolean haswhippedcream, boolean haschocolate){
        String priceMessage = "Name: "+name+"\n"+"Has Whipped Cream: "+haswhippedcream+"\n"+"Has Chocolate: "+haschocolate+"\n"+"Quantity: "+quantity+ "\n" + "Total: $"+price;
        priceMessage = priceMessage+"\nThank You";
        //displayMessage(priceMessage);
        return priceMessage;
    }

    private int calculatePrice(boolean haswhippedcream, boolean haschocolate) {
        int baseprice = 5;
        if(haswhippedcream){
            baseprice=baseprice+1;
        }
        if(haschocolate){
            baseprice=baseprice+2;
        }
        int price = baseprice * 5;
        return price;
    }

    public void display(int number)
    {
        TextView quantity = (TextView) findViewById(R.id.quantity);
        quantity.setText(""+ number);
    }

    private void displayPrice(int number) {
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(NumberFormat.getCurrencyInstance().format(number));
    }

    private void displayMessage(String message){
        TextView price = (TextView) findViewById(R.id.price);
        price.setText(message);
    }

    public void increment(View view){
        if(quantity == 100)
        {
            Toast.makeText(this, "You cannot have more than 100 cup of coffees", Toast.LENGTH_SHORT).show();
            return;
        }

        quantity = quantity + 1;
        display(quantity);
    }

    public void decrement(View view){
        if(quantity == 1)
        {
            Toast.makeText(this, "You cannot have less than 1 cup of coffees", Toast.LENGTH_SHORT).show();
            return;
        }
        quantity = quantity - 1;
        display(quantity);
    }
}
