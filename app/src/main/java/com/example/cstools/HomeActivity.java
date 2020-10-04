package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;

public class HomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        FrameLayout networkFrame = (FrameLayout) findViewById(R.id.HomeFrameNetwork);
        FrameLayout downloadFrame = (FrameLayout) findViewById(R.id.HomeFrameDownload);
        networkFrame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNetworkHome();
            }
        });
        downloadFrame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openDTCal();
            }
        });
    }
    public void openNetworkHome(){
        Intent intent = new Intent(this,networkHomeActivity.class);
        startActivity(intent);
    }

    public void openDTCal(){
        Intent intent = new Intent(this,DTCalHomeActivity.class);
        startActivity(intent);
    }
}