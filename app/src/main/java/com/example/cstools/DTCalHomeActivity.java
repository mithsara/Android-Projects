package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class DTCalHomeActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t_cal_home);

        CardView save = (CardView) findViewById(R.id.viewCard);
        CardView use = (CardView) findViewById(R.id.useCard);

        save.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DTCalHomeActivity.this,DTCalSavedConnectionTypesActivity.class);
                startActivity(intent);
            }
        });

        use.setOnClickListener(new View.OnClickListener(){
            public void onClick(View v){
                Intent intent = new Intent(DTCalHomeActivity.this,DTCalNewConnectionActivity.class);
                startActivity(intent);
            }
        });
    }
}