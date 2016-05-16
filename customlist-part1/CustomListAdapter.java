package com.example.mohitsharma.androidlistcustomadaptor;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class CustomListAdapter extends ArrayAdapter<String>{
    String[] array;
    Integer[] image_resource;
    Context context;
    public CustomListAdapter(Activity context,Integer[] image_resource, String[] array){
        super(context, R.layout.custom_row, array);
        this.array = array;
        this.image_resource = image_resource;
        this.context = context;
    }
    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View single_row = inflater.inflate(R.layout.custom_row, null,
                true);
        TextView textView = (TextView) single_row.findViewById(R.id.newtext);
        ImageView imageView = (ImageView) single_row.findViewById(R.id.newimage);
        textView.setText(array[position]);
        imageView.setImageResource(image_resource[position]);
        return single_row;
    }

}
