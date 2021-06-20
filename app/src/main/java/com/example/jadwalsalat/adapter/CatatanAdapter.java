package com.example.jadwalsalat.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.jadwalsalat.R;
import com.example.jadwalsalat.database.CatatanModel;
import com.example.jadwalsalat.database.DatabaseCatatan;

import java.util.ArrayList;
import java.util.List;

public class CatatanAdapter extends RecyclerView.Adapter<CatatanAdapter.ViewHolder> {
    private Context context;
    private ArrayList<CatatanModel> catatanItems = new ArrayList<>();
    private DatabaseCatatan databaseCatatan;

    private Dialog dialog;

    public interface Dialog {
        void onClick(int position);
    }

    public void setDialog(Dialog dialog) {
        this.dialog = dialog;
    }


    public CatatanAdapter(Context context){
        this.context = context;
        databaseCatatan = DatabaseCatatan.initDbs(this.context);
    }

    public void setData(ArrayList<CatatanModel> items){
        catatanItems.clear();
        catatanItems.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public CatatanAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.itemlist_catatan,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CatatanAdapter.ViewHolder holder, int position) {
        holder.tvWaktu.setText(catatanItems.get(position).getWaktu());
        holder.tvCatatan.setText(catatanItems.get(position).getCatatan());
    }

    @Override
    public int getItemCount() {
        return catatanItems.size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder {
        TextView tvWaktu,tvCatatan;
        public ViewHolder(@NonNull View itemView) {
            super(itemView);

            tvWaktu = itemView.findViewById(R.id.itemlist_catatan_tv_judul);
            tvCatatan = itemView.findViewById(R.id.itemlist_catatan_tv_catatan);
            //fungsi klik
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (dialog!=null) {
                        dialog.onClick(getLayoutPosition());
                    }
                }
            });
        }
    }
}
