package com.example.szs.activity;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

public class ActivityViewHolder extends RecyclerView.ViewHolder {

    public TextView name, date, time;

    public ActivityViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);

    }
}