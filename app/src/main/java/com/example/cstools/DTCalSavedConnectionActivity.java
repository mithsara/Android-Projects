package com.example.cstools;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cstools.R;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;

public class DTCalSavedConnectionActivity extends AppCompatActivity implements DTCalAdapter.OnItemClickListener{
    private RecyclerView mRecyclerView;
    private DTCalAdapter mAdapter;
    private ProgressBar mProgressBar;
    private FirebaseStorage mStorage;
    private DatabaseReference mDatabaseRef;
    private ValueEventListener mDBListener;
    private List<DTCal> list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_d_t_cal_saved_connection);

        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProgressBar = findViewById(R.id.mydataPogress);
        mProgressBar.setVisibility(View.VISIBLE);
        list = new ArrayList<> ();
        mAdapter = new DTCalAdapter (DTCalSavedConnectionActivity.this, list);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(DTCalSavedConnectionActivity.this);
        mStorage = FirebaseStorage.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("raid_details");
        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                list.clear();
                for(DataSnapshot data: dataSnapshot.getChildren()){
                    DTCal cal = data.getValue(DTCal.class);
                    cal.setKey(data.getKey());
                    list.add(cal);
                }
                mAdapter.notifyDataSetChanged();
                mProgressBar.setVisibility(View.GONE);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(DTCalSavedConnectionActivity.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onDeleteItemClick(int position) {
        DTCal selectedItem = list.get(position);
        final String selectedKey = selectedItem.getKey();

        mDatabaseRef.child(selectedKey).removeValue();
        Toast.makeText(DTCalSavedConnectionActivity.this, "Task deleted", Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy() {
        super.onDestroy();
        mDatabaseRef.removeEventListener(mDBListener);
    }

    @Override
    public void onItemClick(int position) {

    }

    @Override
    public void onShowItemClick(int position) {

        DTCal clickedTeacher = list.get(position);
        final String selectedKey = clickedTeacher.getKey();
        String[] raidData = {selectedKey,clickedTeacher.getConType(),
                String.valueOf(clickedTeacher.getSpeed())
        };
        //updateActivity(raidData);

    }
}