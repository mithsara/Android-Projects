package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

import com.example.cstools.raid.RaidHome;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FrameLayout networkFrame = (FrameLayout) findViewById(R.id.HomeFrameNetwork);

        /*FrameLayout downloadFrame = (FrameLayout) findViewById(R.id.HomeFrameDownload);
        networkFrame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNetworkHome();
            }
        });
        downloadFrame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openDTCal();
        */
        networkFrame.setOnClickListener(new View.OnClickListener() {
            public void onClick(View v) {
                openNetworkHome();
            }
        });

        FrameLayout raidFrame = (FrameLayout) findViewById(R.id.HomeFrameRaid);
        raidFrame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                openRaidHome();
            }
        });

        FrameLayout numberFrame = (FrameLayout) findViewById(R.id.HomeFrameNumber);
        numberFrame.setOnClickListener(new View.OnClickListener() {

            public void onClick(View v) {
                openNumberSystemHome();
            }
        });
    }

    public void openNetworkHome() {
        Intent intent = new Intent(this, networkHomeActivity.class);
        startActivity(intent);
    }

    public void openRaidHome() {
        Intent intent = new Intent(this, RaidHome.class);
        startActivity(intent);
    }

    private void openNumberSystemHome() {
        Intent intent = new Intent(this, numberSystemHomeActivity.class);
        startActivity(intent);
    }


}