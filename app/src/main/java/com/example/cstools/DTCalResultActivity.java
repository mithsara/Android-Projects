package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.EditText;
import android.widget.TextView;

public class DTCalResultActivity extends AppCompatActivity {

    TextView result;
    String timeFormat;
    int days;
    long hours;
    long minutes;
    long seconds;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t_cal_result);

        Intent intent = getIntent();
        Bundle extras = intent.getExtras();
        days = extras.getInt("DAY");
        hours = extras.getLong("HOURS");
        minutes = extras.getLong("MINUTES");
        seconds = extras.getLong("SECONDS");


    }
}