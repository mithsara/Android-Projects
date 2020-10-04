package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.w3c.dom.Text;

public class raid_results extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raid_results);

        Bundle resultsBundle = getIntent().getExtras();
        if(resultsBundle != null){
            String totalUsableStorage = resultsBundle.getString("totalUsableStorage");
            String costPerDrive = resultsBundle.getString("costPerDataType");
            String totalCost = resultsBundle.getString("totalCost");
            String diskSpaceEff = resultsBundle.getString("diskSpaceEfficiency");
            String totalNoOfDrives = resultsBundle.getString("totalNumberOfDrives");

            TextView firstResult = findViewById(R.id.txtTotUS);
            TextView secondResult = findViewById(R.id.txtCostTB);
            TextView thirdResult = findViewById(R.id.txtTotCost);
            TextView fourthResult = findViewById(R.id.txtDiskSpaceEffiency);
            TextView fifthResult = findViewById(R.id.txtNoDrives);

            firstResult.setText(totalUsableStorage);
            secondResult.setText(costPerDrive);
            thirdResult.setText(totalCost);
            fourthResult.setText(diskSpaceEff);
            fifthResult.setText(totalNoOfDrives);
        }
    }
}