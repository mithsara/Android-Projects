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
    private Context mContext;
    private ImageView raidDelete;
    private List<RaidHistory> raids;
    private OnItemClickListener mListener;

    public RaidAdapter(Context context, List<RaidHistory> uploads) {
        mContext = context;
        raids = uploads;
    }

    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.raid_model, parent, false);
        return new RecyclerViewHolder(v);
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        RaidHistory raid = raids.get(position);

        holder.raidType.setText("Raid Type Name : "+raid.getDriveCapacity());
        holder.raidDriveCost.setText("Drive Cost : "+raid.getDriveCost());
        holder.raidDriveCapacity.setText("Drives Per Raid : "+raid.getDrivesPerRaid());

    }
    @Override
    public int getItemCount() {
        return raids.size();
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
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    mListener.onItemClick(position);
                }
            }
        }
        @Override
        public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
            menu.setHeaderTitle("Select Action");
            MenuItem showItem = menu.add( Menu.NONE, 1, 1, "Show");
            MenuItem deleteItem = menu.add(Menu.NONE, 2, 2, "Delete");
            showItem.setOnMenuItemClickListener(this);
            deleteItem.setOnMenuItemClickListener(this);
        }
        @Override
        public boolean onMenuItemClick(MenuItem item) {
            if (mListener != null) {
                int position = getAdapterPosition();
                if (position != RecyclerView.NO_POSITION) {
                    switch (item.getItemId()) {
                        case 1:
                            mListener.onShowItemClick(position);
                            return true;
                        case 2:
                            mListener.onDeleteItemClick(position);
                            return true;
                    }
                }
            }
            return false;
        }
    }
    public interface OnItemClickListener {
        void onItemClick(int position);
        void onShowItemClick(int position);
        void onDeleteItemClick(int position);
    }
    public void setOnItemClickListener(OnItemClickListener listener) {
        mListener = listener;
    }
}