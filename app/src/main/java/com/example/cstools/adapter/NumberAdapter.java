package com.example.cstools.adapter;
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
import com.example.cstools.model.Number;
import java.util.List;
public class NumberAdapter  extends RecyclerView.Adapter<NumberAdapter.RecyclerViewHolder>{
    private Context mContext;
    private ImageView financeDelete,financeUpdate;
    private List<Number> number;
    private OnItemClickListener mListener;

    public NumberAdapter(Context context, List<Number> uploads) {
        mContext = context;
        number = uploads;
    }
    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.number_model, parent, false);
        return new RecyclerViewHolder(v);
    }
    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, int position) {
        Number number1 = number.get(position);
        holder.numberId.setText(number1.getNumber());
        holder.typeId.setText(number1.getType());
    }
    @Override
    public int getItemCount() {
        return number.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener,
            View.OnCreateContextMenuListener, MenuItem.OnMenuItemClickListener {
        public TextView numberId,typeId;
        public RecyclerViewHolder(View itemView) {
            super(itemView);
            numberId =itemView.findViewById ( R.id.numberId );
            typeId = itemView.findViewById(R.id.type);
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

