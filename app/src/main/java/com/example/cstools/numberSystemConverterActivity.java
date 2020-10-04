package com.example.cstools;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.cstools.model.Number;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import static android.text.InputType.TYPE_CLASS_NUMBER;
import static android.text.InputType.TYPE_TEXT_FLAG_CAP_CHARACTERS;

public class numberSystemConverterActivity extends AppCompatActivity {
    Button submitbtn;
    TextView answertxt;
    TextView answertxt2;
    TextView answertxt3;
    TextView answertxt4;
    Spinner spinner;
    EditText number;
    int spinPosition;
    boolean state = false;
    ArrayAdapter<String> arrayAdapter;
    private DatabaseReference mDatabaseRef;

    DatabaseReference numberReference;
    Number number1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_system_converter);

        submitbtn = (Button) findViewById(R.id.submitbtn);
        answertxt = (TextView)findViewById(R.id.answertxt);
        answertxt2 = (TextView)findViewById(R.id.answertxt2);
        answertxt3 = (TextView)findViewById(R.id.answertxt3);
        answertxt4 = (TextView)findViewById(R.id.answertxt4);
        number = (EditText)findViewById(R.id.enterNumberEditText);
        spinPosition = 0;
        number1 = new Number();
        numberReference= FirebaseDatabase.getInstance().getReference().child("Number");


        String[] numberType = {"Decimal","Binary","Octal","Hexa Decimal"};
        spinner = (Spinner) findViewById(R.id.spinner);


        arrayAdapter = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, numberType);
        spinner.setAdapter(arrayAdapter);

        spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                spinPosition = i;

                number.setText("");
                answertxt.setText("");
                answertxt2.setText("");
                answertxt3.setText("");
                answertxt4.setText("");

            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("number_system");

        submitbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                state = false;
                calculation();
                number1.setNumber(number.getText().toString().trim());
                if (!state) {
                    Toast.makeText(numberSystemConverterActivity.this, "number inserted successfully", Toast.LENGTH_LONG).show();
                    uploadFile();
                }
            }
        });


    }

    private void calculation() {
        calculateDecimal();
        calculateBinary();
        calculateOcatal();
        calculateHexaDecimal();
    }

    private void calculateDecimal() {
        String value = number.getText().toString();

        if (!checkingInputValidation()) {
            switch (spinPosition) {
                case 0:
                    try {
                        answertxt.setText("Decimal : "+value);
                        answertxt.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
                case 1:
                    try {
                        answertxt.setText("Decimal : " + Long.parseLong(value, 2));
                        answertxt.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
                case 2:
                    try {
                        answertxt.setText("Decimal : " + Long.parseLong(value, 8));
                        answertxt.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
                case 3:
                    try {
                        answertxt.setText("Decimal : " +  Long.parseLong(value, 16));
                        answertxt.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }

                    break;
            }
        }

    }

    private void calculateBinary() {
        String value = number.getText().toString();

        if (!checkingInputValidation()) {
            switch (spinPosition) {
                case 0:
                    try {
                        answertxt2.setText("Binary : " + Long.toBinaryString(Long.valueOf(value)));
                        answertxt2.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
                case 1:
                    try {
                        answertxt2.setText("Binary : "+value);
                        answertxt2.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
                case 2:
                    try {
                        answertxt2.setText("Binary : " + Long.toBinaryString(Long.parseLong(value, 8)));
                        answertxt2.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong 1234");
                        requestFocus(number);
                        state = true;
                    }
                    break;
                case 3:
                    try {
                        answertxt2.setText("Binary : " + Long.toBinaryString(Long.parseLong(value, 16)));
                        answertxt2.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
            }
        }
    }
    private void calculateOcatal() {
        String value = number.getText().toString();

        if (!checkingInputValidation()) {
            switch (spinPosition) {
                case 0:
                    try {
                        answertxt3.setText("Octal : " + Long.toOctalString(Long.valueOf(value)));
                        answertxt3.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }

                    break;
                case 1:
                    try {
                        long l = Long.parseLong(value, 2);
                        answertxt3.setText("Octal : " + Long.toOctalString(l));
                        answertxt3.setTextSize(20);

                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
                case 2:
                    try {
                        answertxt3.setText("Octal : "+value);
                        answertxt3.setTextSize(20);

                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
                case 3:
                    try {
                        answertxt3.setText("Octal : " + Long.toOctalString(Long.parseLong(value, 16)));
                        answertxt3.setTextSize(20);

                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
            }
        }
    }

    private void calculateHexaDecimal() {
        String value = number.getText().toString();

        if (!checkingInputValidation()) {
            switch (spinPosition) {
                case 0:
                    try {
                        answertxt4.setText("Hexa Decimal : " + Long.toHexString(Long.valueOf(value)));
                        answertxt4.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }

                    break;
                case 1:
                    try {
                        answertxt4.setText("Hexa Decimal : " + Long.toHexString(Long.parseLong(value, 2)));
                        answertxt4.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }

                    break;
                case 2:
                    try {
                        answertxt4.setText("Hexa Decimal : " + Long.toHexString(Long.parseLong(value, 8)));
                        answertxt4.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
                case 3:
                    try {
                        answertxt4.setText("Hexa Decimal : "+value);
                        answertxt4.setTextSize(20);
                    } catch (Exception e) {
                        number.setError("Something Wrong");
                        requestFocus(number);
                        state = true;
                    }
                    break;
            }
        }
    }

    private boolean checkingInputValidation() {
        String gettingInput = number.getText().toString();
        if (number.getText().toString().trim().isEmpty()) {
            number.setError("Field is empty");
            requestFocus(number);
            state = true;
            return true;
        } else if (gettingInput.matches(".*[G-Z].*") || gettingInput.matches(".*[g-z].*")) {
            number.setError("Insert Captial Letter for A to F");
            requestFocus(number);
            state = true;
            return true;
        }else if (spinPosition == 2 && gettingInput.matches(".*[8-9].*")) {
            number.setError("Value must be 0 to 7");
            requestFocus(number);
            state = true;
            return true;
        }else if (spinPosition == 1 && gettingInput.matches(".*[2-9].*")) {
            number.setError("Value must be 0 or 1");
            requestFocus(number);
            state = true;
            return true;
        }else if (gettingInput.length() > 15) {
            number.setError("Insertion limited to 6 digit");
            requestFocus(number);
            state = true;
            return true;
        }
        return false;
    }

    private void requestFocus(View view) {
        if (view.requestFocus()) {
            getWindow().setSoftInputMode(WindowManager.LayoutParams.SOFT_INPUT_STATE_ALWAYS_VISIBLE);
        }
    }

    public void itemSelect(View view) {
    }


    private class MyTextWatcher implements TextWatcher {

        private View view;

        private MyTextWatcher(View view) {
            this.view = view;
        }

        public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
        }

        @Override
        public void afterTextChanged(Editable editable) {
            switch (view.getId()) {
                case R.id.enterNumber:
                    validateInput();
                    break;

            }
        }
    }

    private void validateInput() {
        if (spinPosition == 0) {
            number.setInputType(TYPE_CLASS_NUMBER);
        } else if (spinPosition == 1) {
            number.setInputType(TYPE_CLASS_NUMBER);
        } else if (spinPosition == 2) {
            number.setInputType(TYPE_CLASS_NUMBER);
        } else {
            number.setInputType(TYPE_TEXT_FLAG_CAP_CHARACTERS);
        }
    }

    private void uploadFile() {
        String val = "";

        if(spinPosition == 0){
            val ="Decimal";
        }else if(spinPosition == 1){
            val ="Binary";
        }else if(spinPosition == 3){
            val ="Octal";
        }else if(spinPosition == 4){
            val ="Hexa Decimal";
        }

        Number upload = new Number(
                val,
                number.getText().toString(),
                answertxt.getText().toString(),
                answertxt2.getText().toString(),
                answertxt3.getText().toString(),
                answertxt4.getText().toString()
        );
        String uploadId = mDatabaseRef.push().getKey();
        mDatabaseRef.child(uploadId).setValue(upload);

    }
}