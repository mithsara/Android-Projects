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
        networkFrame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNetworkHome();
            }
        });

        FrameLayout numberFrame = (FrameLayout) findViewById(R.id.HomeFrameNumber);
        numberFrame.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                openNumberSystemHome();
            }
        });
    }

    public void openNetworkHome(){
        Intent intent = new Intent(this,networkHomeActivity.class);
        startActivity(intent);
    }
    private void openNumberSystemHome() {
        Intent intent = new Intent(this,numberSystemHomeActivity.class);
        startActivity(intent);
    }
}