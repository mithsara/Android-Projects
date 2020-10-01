package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;

public class DTCalNewConnectionActivity extends AppCompatActivity {
    private EditText fileSize;
    private EditText speed;
    private Button btnCalculate;
    private Spinner mySpinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t_cal_new_connection);

        //getting content for the file sizes
        addItemsOnSpinner();




    }

    public void addItemsOnSpinner(){
        mySpinner = (Spinner) findViewById(R.id.spinnerFileSize);
        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(this,
                R.array.File_sizes_array, android.R.layout.simple_spinner_item);
        String sizeUnit = mySpinner.getSelectedItem().toString();
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mySpinner.setAdapter(adapter);
    }

    public void addListenerOnButton(){
        btnCalculate = (Button) findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                calculation();

            }

        });
    }

    private void calculation(){
        mySpinner = (Spinner) findViewById(R.id.spinnerFileSize);
        String size = String.valueOf(mySpinner.getSelectedItem());
    }


}