package com.example.jadwalsalat.adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;
import com.example.jadwalsalat.R;
import com.example.jadwalsalat.model.DataItem;
import com.example.jadwalsalat.view.activity.JadwalSalatDetailActivity;

import java.util.ArrayList;

public class JadwalSalatAdapter extends RecyclerView.Adapter<JadwalSalatAdapter.viewHolder> {
    private ArrayList<DataItem> data = new ArrayList<>();
    private Context context;


    public JadwalSalatAdapter(Context context) {
        this.context = context;
    }

    public void setData(ArrayList<DataItem> items){
        data.clear();
        data.addAll(items);
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public JadwalSalatAdapter.viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list,parent,false);

        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull JadwalSalatAdapter.viewHolder holder, final int position) {

        holder.TVTglValue.setText(data.get(position).getDate().getReadable());
        CardView cardView = holder.CVItem;
        cardView.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, JadwalSalatDetailActivity.class);

                intent.putExtra("tvFajr", data.get(position).getTimings().getFajr());
                intent.putExtra("tvDhuhr",data.get(position).getTimings().getDhuhr());
                intent.putExtra("tvAsr",data.get(position).getTimings().getAsr());
                intent.putExtra("tvMaghrib",data.get(position).getTimings().getMaghrib());
                intent.putExtra("tvIsha",data.get(position).getTimings().getIsha());
                intent.putExtra("tvImsak",data.get(position).getTimings().getImsak());
                context.startActivity(intent);
            }
        });

    }

    @Override
    public int getItemCount() {
        return data.size();
    }

    public class viewHolder extends RecyclerView.ViewHolder {
        TextView TVTglValue;
        CardView CVItem;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            CVItem = itemView.findViewById(R.id.itemlist_cv);
            TVTglValue= itemView.findViewById(R.id.tv_tanggal_value);
        }
    }
}
