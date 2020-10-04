package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

import java.util.List;

public class raid_home extends AppCompatActivity {

    Spinner raidTypeSpinner, raidDriveCapacity;
    ArrayAdapter<String> adapterRaidType;
    ArrayAdapter<String> adapterDriveCapacity;
    EditText drCap, drCos, drPR, rGroup;
    int rt, dc, totUs, costPTB, totCost, dSpaceE, totDrives;
    private Button btnCalculate, btnCancel, btnHistory;

    // array for the raid types
    final String[] raidType = {"RAID 0 (Stripe)", "RAID 1 (Mirror)", "RAID 1E (Stripe + Mirror)" , "RAID 4 (Stripe + Parity)" , "RAID 5 (Stripe + Parity)" ,
            "RAID 6 (Stripe + Double Parity)" , "RAID 10 (Stripped Mirrors)" , "RAID 50 (Stripe + Parity)" , "RAID 60 (Double Parity + Stripe)"};

    // array for the drive capacity
    final String[] driveCapacity = {"GB" , "TB" };
    private Object View;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_raid_home);

        drCap = (EditText)findViewById(R.id.driveCap);
        drCos = (EditText) findViewById(R.id.driveCost);
        drPR = (EditText) findViewById(R.id.drivesperRaid);
        rGroup = (EditText) findViewById(R.id.raidGroup);

        raidTypeSpinner = findViewById(R.id.spinRaidType);
        raidDriveCapacity = findViewById(R.id.spinDriveCapacity);

        adapterRaidType = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, raidType);
        raidTypeSpinner.setAdapter(adapterRaidType);

        adapterDriveCapacity = new ArrayAdapter<String>(getApplicationContext(), android.R.layout.simple_list_item_1, driveCapacity);
        raidDriveCapacity.setAdapter(adapterDriveCapacity);

        raidTypeSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch (i) {
                    case 0:
                        rt = 0;
                        break;
                    case 1:
                        rt = 1;
                        break;
                    case 2:
                        rt = 2;
                        break;
                    case 3:
                        rt = 3;
                        break;
                    case 4:
                        rt = 4;
                        break;
                    case 5:
                        rt = 5;
                        break;
                    case 6:
                        rt = 6;
                        break;
                    case 7:
                        rt = 7;
                        break;
                    case 8:
                        rt = 8;
                        break;
                    default:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        raidDriveCapacity.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                switch(i){
                    case 0:
                        dc = 0;
                        break;
                    case 1:
                        dc = 1;
                        break;
                    default:
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });

        btnCalculate = (Button)findViewById(R.id.btnCalculate);

        btnCalculate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int raidCapacity = Integer.parseInt(drCap.getText().toString());
                int driveCost = Integer.parseInt(drCos.getText().toString());
                int drivesPerRaid = Integer.parseInt(drPR.getText().toString());
                int raidGroup = Integer.parseInt(rGroup.getText().toString());

                    //  totUs, costPTB, totCost, dSpaceE, totDrives
                if(dc == 0 && rt == 0){
                    if(drivesPerRaid >= 2) {
                        totUs = drivesPerRaid * raidGroup;
                        costPTB = driveCost * raidCapacity;
                        totCost = driveCost * drivesPerRaid * raidGroup;
                        dSpaceE = 10 * 10;
                        totDrives = drivesPerRaid * raidGroup;
                    }
                }
                else if(dc == 0 && rt == 1){
                    if(drivesPerRaid >= 2) {
                        totUs = raidCapacity * raidGroup;
                        costPTB = driveCost * raidCapacity;
                        totCost = driveCost * drivesPerRaid * raidGroup;
                        dSpaceE = (10 * 10) / 2;
                        totDrives = drivesPerRaid * raidGroup;
                    }
                }
                else if(dc == 0 && rt == 2){
                    if(drivesPerRaid >= 3){
                        totUs = raidCapacity * drivesPerRaid;
                        costPTB = driveCost * raidGroup;
                        totCost = driveCost * drivesPerRaid * raidGroup;
                        dSpaceE = (10 * 10) / 2;
                        totDrives = drivesPerRaid * raidGroup;
                    }
                }
                else if(dc == 0 && rt == 3){
                    if(drivesPerRaid >= 3){
                        totUs = raidCapacity * 2;
                        costPTB = (100 + 50) / raidCapacity;
                        totCost = driveCost * drivesPerRaid * raidGroup;
                        dSpaceE = 100 - (100 / 3);
                        totDrives = drivesPerRaid * raidGroup;
                    }
                }
                else if(dc == 0 && rt == 4){
                    if(drivesPerRaid >= 3){
                        totUs = raidCapacity * 2;
                        costPTB = (100 + 50) / raidCapacity;
                        totCost = driveCost * raidGroup;
                        dSpaceE = 100 - (100 / 3);
                        totDrives = drivesPerRaid * raidGroup;
                    }
                }
                else if(dc == 0 && rt == 5){
                    if(drivesPerRaid >= 4){
                        totUs = raidCapacity * 2;
                        costPTB = 200 / raidCapacity;
                        totCost = driveCost * drivesPerRaid;
                        dSpaceE = 100 - (100 / 3);
                        totDrives = drivesPerRaid;
                    }
                }
                else if(dc == 0 && rt == 6){
                    if(drivesPerRaid >= 4){
                        totUs = raidCapacity * 2;
                        costPTB = 200 / raidCapacity;
                        totCost = driveCost * drivesPerRaid;
                        dSpaceE = (10 * 10) / 2;
                        totDrives = drivesPerRaid * raidGroup;
                    }
                }
                else if(dc == 0 && rt == 7){
                    if(drivesPerRaid >= 6 && raidGroup >= 2){
                        totUs = raidCapacity * 10;
                        costPTB = 120 / raidCapacity;
                        totCost = raidGroup * drivesPerRaid * driveCost;
                        dSpaceE = 100 - (100 / 6);
                        totDrives = drivesPerRaid * raidGroup;
                    }
                }
                else if(dc == 0 && rt == 8){
                    if(drivesPerRaid >= 4 && raidGroup >= 2){
                        totUs = raidCapacity * drivesPerRaid;
                        costPTB = 200 / raidCapacity;
                        totCost = raidGroup * drivesPerRaid * driveCost;
                        dSpaceE = (10 * 10) / 2;
                        totDrives = drivesPerRaid * raidGroup;
                    }
                }

                else if(dc == 1 && rt == 0){
                    totUs = drivesPerRaid * raidGroup;
                    costPTB = driveCost * raidCapacity;
                    totCost = driveCost * drivesPerRaid * raidGroup;
                    dSpaceE = 10 * 10;
                    totDrives = drivesPerRaid * raidGroup;
                }
                else if(dc == 1 && rt == 2){

                }
                else if(dc == 1 && rt == 3){

                }
                else if(dc == 1 && rt == 4){

                }
                else if(dc == 1 && rt == 5){

                }
                else if(dc == 1 && rt == 6){

                }
                else if(dc == 1 && rt == 7){

                }
                else{

                }

                String totalUsableStorage = String.valueOf(totUs);
                String costPerDataType = String.valueOf(costPTB);
                String totalCost = String.valueOf(totCost);
                String diskSpaceEfficiency = String.valueOf(dSpaceE);
                String totalNumberOfDrives = String.valueOf(totDrives);

                Bundle resultsBundle = new Bundle();
                resultsBundle.putString("totalUsableStorage" , totalUsableStorage);
                resultsBundle.putString("costPerDataType" , costPerDataType);
                resultsBundle.putString("totalCost", totalCost);
                resultsBundle.putString("diskSpaceEfficiency" , diskSpaceEfficiency);
                resultsBundle.putString("totalNumberOfDrives" , totalNumberOfDrives);

                Intent goResultsIntent = new Intent(raid_home.this, raid_results.class);
                goResultsIntent.putExtras(resultsBundle);
                startActivity(goResultsIntent);

            }
        });

        btnCancel = (Button)findViewById(R.id.btnCancel);

        btnCancel.setOnClickListener(new View.OnClickListener() {
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