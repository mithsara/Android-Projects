package com.example.cstools;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.concurrent.TimeUnit;

public class DTCalNewConnectionActivity extends AppCompatActivity {
    private EditText fileSize;
    private EditText speed;
    private Button btnCalculate;
    private Spinner mySpinner1;
    private Spinner mySpinner2;
    private Spinner mySpinner3;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mDbRef;

    String size;
    String speedunit;
    String conType;
    int day;
    long hours;
    long minutes;
    long second;
    double conSpeed;
    double conFileSize;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t_cal_new_connection);

        mySpinner1 = (Spinner) findViewById(R.id.spinnerFileSize);
        mySpinner2 = (Spinner) findViewById(R.id.spinnerSpeed);
        mySpinner3 = (Spinner) findViewById(R.id.spinnerConType);

        speed = (EditText) findViewById(R.id.atxtConnectionSpeed);
        fileSize = (EditText) findViewById(R.id.etxtFileSize);

        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        //getting content for the file sizes
        addItemsOnSpinnerFileSize();
        addItemsOnSpinnerConType();
        addItemsOnSpinnerSpeed();

        addListenerOnButton();

    }

    public void addItemsOnSpinnerFileSize(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.File_sizes_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner1.setAdapter(adapter);
    }

    public void addItemsOnSpinnerSpeed(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Speed_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner2.setAdapter(adapter);
    }

    public void addItemsOnSpinnerConType(){

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.Connection_Types_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner3.setAdapter(adapter);
    }

    public void addListenerOnSpinner(){
        mySpinner3.setOnItemSelectedListener(new CustomOnItemSelectedListener());

    }

    public void addListenerOnButton(){


        btnCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                getDataFromLayout();
                database();
                calculation();

                Intent intent = new Intent(DTCalNewConnectionActivity.this,DTCalResultActivity.class);

                Bundle extras = new Bundle();
                extras.putInt("DAY", day);
                extras.putLong("HOURS",hours);
                extras.putLong("MINUTES",minutes);
                extras.putLong("SECONDS",second);

                intent.putExtras(extras);
                startActivity(intent);
            }

        });
    }

    public void calculation(){

        if (size.equals("KB")){
            conFileSize = conFileSize * 1000 ;
        }else if (size.equals("MB")){
            conFileSize = conFileSize * 1000000 ;
        }else if (size.equals("GB")){
            conFileSize = conFileSize * 1000000000 ;
        }else {

        }

        if (speedunit.equals("Kbps")){
            conFileSize = conFileSize / 1000 ;
        }else if (speedunit.equals("Mbps")){
            conFileSize = conFileSize / 1000000 ;
        }else if (speedunit.equals("Gbps")){
            conFileSize = conFileSize / 1000000000 ;
        }else {

        }

        long seconds = (long) ((conFileSize * 8) / conSpeed);

        day = (int) TimeUnit.SECONDS.toDays(seconds);
        hours = TimeUnit.SECONDS.toHours(seconds) - (day * 24);
        minutes = TimeUnit.SECONDS.toMinutes(seconds) - (TimeUnit.SECONDS.toHours(seconds) * 60);
        second = TimeUnit.SECONDS.toSeconds(seconds) - (TimeUnit.SECONDS.toMinutes(seconds) * 60);

    }

    public void getDataFromLayout(){
        size = String.valueOf(mySpinner1.getSelectedItem());
        speedunit = String.valueOf(mySpinner2.getSelectedItem());
        conType = String.valueOf(mySpinner3.getSelectedItem());
        conSpeed = Double.parseDouble(speed.getText().toString());
        conFileSize = Double.parseDouble(fileSize.getText().toString());

    }

    public void database(){
        mDatabase = FirebaseDatabase.getInstance();
        mDbRef = mDatabase.getReference("DTCal");

//Setting firebase unique key for Hashmap list
        String userId = mDbRef.push().getKey();
// creating user object
        DTCal connection = new DTCal(conType,conSpeed);

        mDbRef.child(userId).setValue(connection);
    }
}
