package com.example.cstools;

import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemSelectedListener;
import android.widget.EditText;
import android.widget.Switch;

public class CustomOnItemSelectedListener implements OnItemSelectedListener {
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int pos, long id) {
        EditText edit = (EditText) view.findViewById(R.id.atxtConnectionSpeed);
        String conType = parent.getItemAtPosition(pos).toString();
        switch (conType){
            case "ADSL" :
                edit.setText("");
        }
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
