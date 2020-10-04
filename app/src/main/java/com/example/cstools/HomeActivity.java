package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

public class HomeActivity extends AppCompatActivity {

    Button raidButton;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FrameLayout networkFrame = (FrameLayout) findViewById(R.id.HomeFrameNetwork);
        networkFrame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNetworkHome();
            }
        });

        FrameLayout raidFrame = (FrameLayout) findViewById(R.id.HomeFrameRaid);
        raidFrame.setOnClickListener(new View.OnClickListener(){
            @Override
            public void onClick(View view) {
                openRaidHome();
            }
        });
    }
    public void openNetworkHome(){
        Intent intent = new Intent(this,networkHomeActivity.class);
        startActivity(intent);
    }

    public void openRaidHome(){
        Intent intent = new Intent(this,raid_home.class);
        startActivity(intent);
    }
}