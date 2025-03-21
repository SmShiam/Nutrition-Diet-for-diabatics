package com.example.szs.bp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

import java.util.List;


public class BpRecyclerAdapter extends RecyclerView.Adapter<BpRecyclerAdapter.viewHolder> {

    List<Bp> myBpList;

    public BpRecyclerAdapter(List<Bp> myBpList) {
        this.myBpList = myBpList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_bp, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Bp currentBp = myBpList.get(position);

        holder.sys.setText(currentBp.getSys());
        holder.dys.setText(currentBp.getDys());
        holder.time.setText(currentBp.getTime());
        holder.date.setText(currentBp.getDate());
    }

    @Override
    public int getItemCount() {
        if (myBpList == null || myBpList.isEmpty()) {
            return 0;
        } else
            return myBpList.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView sys, dys, date, time;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            sys = itemView.findViewById(R.id.sys);
            dys = itemView.findViewById(R.id.dys);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }


}
