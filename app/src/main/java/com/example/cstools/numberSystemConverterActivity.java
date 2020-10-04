package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class numberSystemConverterActivity extends AppCompatActivity {

    EditText enterNumber;
    Button submitbtn;
    TextView answertxt;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_system_converter);

        enterNumber = (EditText)findViewById(R.id.enterNumberEditText);
        submitbtn = (Button)findViewById(R.id.submitbtn);
        answertxt = (TextView)findViewById(R.id.answertxt);

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int number = Integer.parseInt(enterNumber.getText().toString());
                String binary = Integer.toBinaryString(number);
                String octal = Integer.toOctalString(number);
                String hexaDecimal = Integer.toHexString(number);

                answertxt.setText("Decimal : " + number + "\n" + "Binary : " + binary + "\n"
                        + "Octal : " + octal + "\n" + "Hexa Decimal : " + hexaDecimal );

            }
        });


    }
}