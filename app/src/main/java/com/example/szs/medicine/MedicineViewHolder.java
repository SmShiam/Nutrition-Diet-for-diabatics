package com.example.szs.medicine;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

public class MedicineViewHolder extends RecyclerView.ViewHolder {

    public TextView name, units, date, time;

    public MedicineViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        units = itemView.findViewById(R.id.units);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);

    }
}