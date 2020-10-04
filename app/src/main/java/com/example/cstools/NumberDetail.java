package com.example.cstools;
import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class NumberDetail extends AppCompatActivity {
    private TextView numberType,detailType, binaryDetail,decimalType,
            octalDetail,hexaDetail;
    private void initializeWidgets(){
        numberType= findViewById(R.id.numberType);
        detailType= findViewById(R.id.detailType);
        decimalType= findViewById(R.id.decimalType);
        octalDetail= findViewById(R.id.octalDetail);
        binaryDetail= findViewById(R.id.binaryDetail);
        hexaDetail= findViewById(R.id.hexaDetail);
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_detail);
        initializeWidgets();
        Intent i=this.getIntent();
        String type=i.getExtras().getString("TYPE_KEY");
        String number=i.getExtras().getString("NUMBER_KEY");
        String val1=i.getExtras().getString("VAL1_KEY");
        String val2=i.getExtras().getString("VAL2_KEY");
        String val3=i.getExtras().getString("VAL3_KEY");
        String val4=i.getExtras().getString("VAL4_KEY");

        numberType.setText("Type : "+type);
        detailType.setText("Number : "+number);
        decimalType.setText("Decimal : "+val1);
        octalDetail.setText("Binary : "+val2);
        binaryDetail.setText("Octal : "+val3);
        hexaDetail.setText("Hexa Decimal : "+val4);

    }
}
