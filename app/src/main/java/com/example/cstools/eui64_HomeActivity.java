package com.example.cstools;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.FrameLayout;

import android.os.Bundle;
import android.widget.TextView;

public class eui64_HomeActivity extends AppCompatActivity {

    Button   euibtn;
    TextView euiTV;
    EditText euiETMac1;
    EditText euiETMac2;

    protected String euiProcess(String Mac1,String Mac2){
        String mac1 =Mac1;
        String mac2 =Mac2;
        String macMid = "FFFE";

        String EUI64ANS="0";
        //
        String Mac1FlipIn = Character.toString(mac1.charAt(1));
        String Mac1FlipOut ;

        switch (Mac1FlipIn) {
            case "0":
                Mac1FlipOut = "2";
                break;
            case "1":
                Mac1FlipOut ="3";
                break;
            case "2":
                Mac1FlipOut = "0";
                break;
            case "3":
                Mac1FlipOut = "1";
                break;
            case "4":
                Mac1FlipOut = "6";
                break;
            case "5":
                Mac1FlipOut = "7";
                break;
            case "6":
                Mac1FlipOut = "4";
                break;
            case "7":
                Mac1FlipOut = "5";
                break;
            case "8":
                Mac1FlipOut = "A";
                break;
            case "9":
                Mac1FlipOut = "B";
                break;
            case "A":
                Mac1FlipOut = "8";
                break;
            case "B":
                Mac1FlipOut = "9";
                break;
            case "C":
                Mac1FlipOut = "E";
                break;
            case "D":
                Mac1FlipOut = "F";
                break;
            case "E":
                Mac1FlipOut = "C";
                break;
            case "F":
                Mac1FlipOut = "D";
                break;
            default:
                Mac1FlipOut = "NError";
        }

        char[] mac1arr = mac1.toCharArray();

        mac1arr[1]     = Mac1FlipOut.charAt(0);
        mac1           = String.valueOf(mac1arr);
        //
        EUI64ANS = mac1.trim()+macMid.trim()+mac2.trim();
        return EUI64ANS;
    }


    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_eui64home);

        euibtn      = (Button)   findViewById(R.id.btnEUI);
        euiTV       = (TextView) findViewById(R.id.euiAns);
        euiETMac1   = (EditText) findViewById(R.id.mac1);
        euiETMac2   = (EditText) findViewById(R.id.mac2);


        euibtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String macMid = "FFFE";
                String mac1   = euiETMac1.getText().toString().trim().toUpperCase().trim();
                String mac2   = euiETMac2.getText().toString().trim().toUpperCase().trim();

                euiProcess(mac1,mac1);
                String EUI64ANS = mac1.trim()+macMid.trim()+mac2.trim();


                if(EUI64ANS.toCharArray().length == 16) {
                    euiTV.setText("EUI-64: " + euiProcess(mac1,mac2));
                }
                else{
                    euiTV.setText("Enter A Valid MAC Address In Hexadecimal");
                }

            }
        });




    }
}