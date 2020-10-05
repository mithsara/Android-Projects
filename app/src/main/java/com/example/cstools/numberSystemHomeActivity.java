package com.example.cstools;
import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.FrameLayout;
public class numberSystemHomeActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_number_system_home);

        FrameLayout converterFrame = (FrameLayout) findViewById(R.id.ConverterFrame);
        converterFrame.setOnClickListener((new View.OnClickListener(){
            public void onClick(View v){
                openNumberSystemConverter();
            }
        }));
        FrameLayout converterFrame2 = (FrameLayout) findViewById(R.id.HistoryFrame);
        converterFrame2.setOnClickListener((new View.OnClickListener(){
            public void onClick(View v){
                openNumberSystemConverter2();
            }
        }));

    }
    private void openNumberSystemConverter2() {
        Intent intent = new Intent(this,NumberList.class);
        startActivity(intent);
    }
    private void openNumberSystemConverter() {
        Intent intent = new Intent(this,numberSystemConverterActivity.class);
        startActivity(intent);
    }
}