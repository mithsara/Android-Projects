package com.example.cstools.raid;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cstools.R;
import com.example.cstools.model.RaidHistory;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;


public class AllRaid extends AppCompatActivity implements RaidAdapter.OnItemClickListener{
    private RecyclerView mRecyclerView;
    private RaidAdapter mAdapter;
    private ProgressBar mProgressBar;
    private FirebaseStorage mStorage;
    private DatabaseReference mDatabaseRef;
    private ValueEventListener mDBListener;
    private List<RaidHistory> mRaidHistory;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.activity_raid_items );

        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProgressBar = findViewById(R.id.mydataPogress);
        mProgressBar.setVisibility(View.VISIBLE);
        mRaidHistory = new ArrayList<> ();
        mAdapter = new RaidAdapter (AllRaid.this, mRaidHistory);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(AllRaid.this);
        mStorage = FirebaseStorage.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("raid_details");
        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mRaidHistory.clear();
                for (DataSnapshot finance : dataSnapshot.getChildren()) {
                    RaidHistory upload = finance.getValue(RaidHistory.class);
                    upload.setKey(finance.getKey());
                    mRaidHistory.add(upload);
                }
                mAdapter.notifyDataSetChanged();
                mProgressBar.setVisibility(View.GONE);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(AllRaid.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onDeleteItemClick(int position) {
        RaidHistory selectedItem = mRaidHistory.get(position);
        final String selectedKey = selectedItem.getKey();

        mDatabaseRef.child(selectedKey).removeValue();
        Toast.makeText(AllRaid.this, "Task deleted", Toast.LENGTH_SHORT).show();
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

        RaidHistory clickedTeacher = mRaidHistory.get(position);
        final String selectedKey = clickedTeacher.getKey();
        String[] raidData = {selectedKey,clickedTeacher.getRaidType(),
                clickedTeacher.getDriveCapacity(),clickedTeacher.getDriveCost(),
                clickedTeacher.getDrivesPerRaid(),clickedTeacher.getRaidGroup()
        };
        //updateActivity(raidData);
    }


}