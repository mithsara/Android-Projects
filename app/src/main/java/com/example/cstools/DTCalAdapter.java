package com.example.cstools;
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
import java.util.List;

public class DTCalAdapter extends RecyclerView.Adapter<DTCalAdapter.RecyclerViewHolder>{
    private Context mContext;
    private ImageView financeDelete,financeUpdate;
    private List<DTCal> number;
    private OnItemClickListener mListener;

    public DTCalAdapter(Context context, List<DTCal> uploads) {
        mContext = context;
        number = uploads;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.rowlayout, parent, false);
        return new RecyclerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        DTCal number1 = number.get(position);
        holder.conType.setText(number1.getConType());
        holder.conSpeed.setText((int) number1.getSpeed());
    }
    @Override
    public int getItemCount() {
        return number.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public TextView conType, conSpeed;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
           conType =itemView.findViewById ( R.id.conType );
            conSpeed = itemView.findViewById(R.id.conSpeed);
            financeDelete = itemView.findViewById(R.id.numberDelete);
            itemView.setOnClickListener(this);
            itemView.setOnCreateContextMenuListener(this);
            financeDelete.setOnClickListener(new View.OnClickListener() {
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
