package com.example.szs.gulcose;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

public class GlucoseViewHolder extends RecyclerView.ViewHolder {

    public TextView name, date, time;

    public GlucoseViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);

    }
}