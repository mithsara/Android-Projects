package com.example.cstools.raid;

import android.content.Context;
import android.view.ContextMenu;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.cstools.R;
import com.example.cstools.model.RaidHistory;

import java.util.List;


public  class RaidAdapter extends RecyclerView.Adapter<RaidAdapter.RecyclerViewHolder>{
    private Context mContext; // all raid context
    private ImageView raidDelete;
    private List<RaidHistory> raids;
    private OnItemClickListener mListener;

    public RaidAdapter(Context context, List<RaidHistory> uploads) { // constructor
        mContext = context;
        raids = uploads;
    }

    @Override
    public int getItemCount() {
        return raids.size(); // get count
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        // create new raid models and return (adapter)
        View v = LayoutInflater.from(mContext).inflate(R.layout.raid_model, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) { // set values for the adapter (model)
        RaidHistory raid = raids.get(position); // get values according to the array index

        holder.raidType.setText("Raid Type Name : "+raid.getDriveCapacity());
        holder.raidDriveCost.setText("Drive Cost : "+raid.getDriveCost());
        holder.raidDriveCapacity.setText("Drives Per Raid : "+raid.getDrivesPerRaid());

    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public TextView raidType, raidDriveCost, raidDriveCapacity;

        public RecyclerViewHolder(View itemView) {
            super(itemView);
            raidType =itemView.findViewById ( R.id.raidType );
            raidDriveCost = itemView.findViewById(R.id.raiddriveCost);
            raidDriveCapacity = itemView.findViewById(R.id.raidCapacity);

            raidDelete = itemView.findViewById(R.id.raidDelete);

            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);

            raidDelete.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (mListener != null) {
                        int position = getAdapterPosition();
                        if (position != RecyclerView.NO_POSITION) {
                            mListener.onDeleteItemClick(position);
                        }
                    }
                }
            });
        }

        @Override
        public void onClick(View v) {

        }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {

        }
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            return false;
        }
    }
    public interface OnItemClickListener {
        void onDeleteItemClick(int position);
    }

    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}