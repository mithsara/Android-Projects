package com.example.cstools;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;

public class DTCalSavedConnectionTypesActivity extends AppCompatActivity {

    ListView listView;

    ArrayList<DTCal> list;
    CustomListAdapter adapter;

    private FirebaseDatabase mDatabase;
    private DatabaseReference mDbRef;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t_cal_saved_connection_types);

        listView = (ListView) findViewById(R.id.ListView);

        mDatabase = FirebaseDatabase.getInstance();
        mDbRef = mDatabase.getReference("DTCal");

        list = new ArrayList<DTCal>();


        mDbRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    DTCal cal = data.getValue(DTCal.class);
                    cal.setKey(data.getKey());
                    list.add(cal);
                }
                adapter = new CustomListAdapter((Activity) getApplicationContext(),list);
                listView.setAdapter(adapter);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }

}
