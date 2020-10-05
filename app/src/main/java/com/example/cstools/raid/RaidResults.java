package com.example.cstools.raid;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.cstools.HomeActivity;
import com.example.cstools.R;

public class RaidResults<btnHome> extends AppCompatActivity {
    private Button btnHome;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raid_results);

        TextView firstResult, secondResult, thirdResult, fourthResult, fifthResult;

        Bundle resultsBundle = getIntent().getExtras();
        if(resultsBundle != null){
            String totalUsableStorage = resultsBundle.getString("totalUsableStorage");
            String costPerDrive = resultsBundle.getString("costPerDataType");
            String totalCost = resultsBundle.getString("totalCost");
            String diskSpaceEff = resultsBundle.getString("diskSpaceEfficiency");
            String totalNoOfDrives = resultsBundle.getString("totalNumberOfDrives");

            firstResult = findViewById(R.id.txtTotUS);
            secondResult = findViewById(R.id.txtCostTB);
            thirdResult = findViewById(R.id.txtTotCost);
            fourthResult = findViewById(R.id.txtDiskSpaceEffiency);
            fifthResult = findViewById(R.id.txtNoDrives);

            firstResult.setText(totalUsableStorage);
            secondResult.setText(costPerDrive);
            thirdResult.setText(totalCost);
            fourthResult.setText(diskSpaceEff);
            fifthResult.setText(totalNoOfDrives);
        }
        btnHome = (Button)findViewById(R.id.btnGoHome);

        btnHome.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                backToHomeActivity();
            }
        });
    }
    public void backToHomeActivity(){
        Intent intent = new Intent(this, HomeActivity.class);
        startActivity(intent);
    }
}