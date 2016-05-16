package com.example.mohitsharma.androidlistcustomadapter2;

import android.app.Activity;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;
public class CustomAdapter extends ArrayAdapter<String> {

    Integer[] image_resource;
    String[] title;
    String[] desc;
    String[] date;
    Context context;

    public CustomAdapter(Activity context, String[] title, String[] desc, String[] date, Integer[] image_resource) {
        super(context, R.layout.row, title);
        //declarations
        this.title=title;
        this.context=context;
        this.desc=desc;
        this.date=date;
        this.image_resource=image_resource;

    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        LayoutInflater inflater = (LayoutInflater) context
                .getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View single_row = inflater.inflate(R.layout.row, null,
                true);
        TextView tv1 = (TextView) single_row.findViewById(R.id.newtext);
        TextView tv2 = (TextView) single_row.findViewById(R.id.newdesc);
        TextView tv3 = (TextView) single_row.findViewById(R.id.newdesc2);
        ImageView imageView = (ImageView) single_row.findViewById(R.id.newimage);
        tv1.setText(title[position]);
        tv2.setText(desc[position]);
        tv3.setText(date[position]);
        imageView.setImageResource(image_resource[position]);
        return single_row;
    }


}
