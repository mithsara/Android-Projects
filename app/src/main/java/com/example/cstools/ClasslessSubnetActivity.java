package com.example.cstools;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ClasslessSubnetActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_classless_subnet);


    }

    public void changeFragment(View view){
        Fragment fragment;

        if(view == findViewById(R.id.btnSubEnt)){
            fragment = new subEnFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.defaultFragmentSubnet,fragment);
            ft.commit();
        }

        if(view == findViewById(R.id.btnSubView)){
            fragment = new subViewFragment();
            FragmentManager fm = getSupportFragmentManager();
            FragmentTransaction ft = fm.beginTransaction();
            ft.replace(R.id.defaultFragmentSubnet,fragment);
            ft.commit();
        }
    }
}