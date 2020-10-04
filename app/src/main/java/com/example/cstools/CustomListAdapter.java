package com.example.cstools;

import android.app.Activity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import androidx.annotation.NonNull;

import java.util.ArrayList;
import java.util.List;

public class CustomListAdapter extends ArrayAdapter {

    private final Activity context;
    private final ArrayList<DTCal> list;

    public CustomListAdapter(@NonNull Activity context, ArrayList<DTCal> list) {
        super(context, R.layout.rowlayout, list);
        this.context = context;
        this.list = list;
    }

    public View getView(int position, View view, ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View rowView=inflater.inflate(R.layout.rowlayout, null,true);

        DTCal cal = list.get(position);
        TextView conType = (TextView) rowView.findViewById(R.id.conType);
        TextView conSpeed = (TextView) rowView.findViewById(R.id.conSpeed);


        conType.setText(cal.getConType());
        conSpeed.setText(cal.getConType());

        return rowView;

    };
}
