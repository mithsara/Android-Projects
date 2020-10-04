package com.example.cstools;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ProgressBar;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;


import com.example.cstools.adapter.NumberAdapter;
import com.example.cstools.model.Number;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.storage.FirebaseStorage;

import java.util.ArrayList;
import java.util.List;


public class NumberList extends AppCompatActivity implements NumberAdapter.OnItemClickListener{
    private RecyclerView mRecyclerView;
    private NumberAdapter mAdapter;
    private ProgressBar mProgressBar;
    private FirebaseStorage mStorage;
    private DatabaseReference mDatabaseRef;
    private ValueEventListener mDBListener;
    private List<Number> mNumber;

    private void openDetailActivity(String[] data){
        Intent intent = new Intent(this, NumberDetail.class);
        intent.putExtra("TYPE_KEY",data[0]);
        intent.putExtra("NUMBER_KEY",data[1]);
        intent.putExtra("VAL1_KEY",data[2]);
        intent.putExtra("VAL2_KEY",data[3]);
        intent.putExtra("VAL3_KEY",data[4]);
        intent.putExtra("VAL4_KEY",data[5]);
        startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        setContentView ( R.layout.number_items );

        mRecyclerView = findViewById(R.id.mRecyclerView);
        mRecyclerView.setHasFixedSize(true);
        mRecyclerView.setLayoutManager(new LinearLayoutManager(this));
        mProgressBar = findViewById(R.id.myStudentDataLoaderProgressBar);
        mProgressBar.setVisibility(View.VISIBLE);
        mNumber = new ArrayList<>();
        mAdapter = new NumberAdapter (NumberList.this, mNumber);
        mRecyclerView.setAdapter(mAdapter);
        mAdapter.setOnItemClickListener(NumberList.this);
        mStorage = FirebaseStorage.getInstance();
        mDatabaseRef = FirebaseDatabase.getInstance().getReference("number_system");
        mDBListener = mDatabaseRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                mNumber.clear();
                for (DataSnapshot finance : dataSnapshot.getChildren()) {
                    Number upload = finance.getValue(Number.class);
                    upload.setKey(finance.getKey());
                    mNumber.add(upload);
                }
                mAdapter.notifyDataSetChanged();
                mProgressBar.setVisibility(View.GONE);
            }
            @Override
            public void onCancelled(DatabaseError databaseError) {
                Toast.makeText(NumberList.this, databaseError.getMessage(), Toast.LENGTH_SHORT).show();
                mProgressBar.setVisibility(View.INVISIBLE);
            }
        });
    }

    @Override
    public void onDeleteItemClick(int position) {
        Number selectedItem = mNumber.get(position);
        final String selectedKey = selectedItem.getKey();

        mDatabaseRef.child(selectedKey).removeValue();
        Toast.makeText(NumberList.this, "Task deleted", Toast.LENGTH_SHORT).show();
    }
    protected void onDestroy() {
        super.onDestroy();
        mDatabaseRef.removeEventListener(mDBListener);
    }

    @Override
    public void onItemClick(int position) {

        Number clicked=mNumber.get(position);
        String[] Data={clicked.getType(),
                clicked.getNumber(),
                clicked.getValue1(),
                clicked.getValue2(),
                clicked.getValue3(),
                clicked.getValue4()
        };

        openDetailActivity(Data);
    }

    @Override
    public void onShowItemClick(int position) {

    }


}