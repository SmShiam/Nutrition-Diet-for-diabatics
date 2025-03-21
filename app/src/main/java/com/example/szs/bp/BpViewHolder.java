package com.example.szs.bp;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

public class BpViewHolder extends RecyclerView.ViewHolder {

    public TextView sys, dys, date, time;

    public BpViewHolder(@NonNull View itemView) {
        super(itemView);

        sys = itemView.findViewById(R.id.sys);
        dys = itemView.findViewById(R.id.dys);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);

    }
}