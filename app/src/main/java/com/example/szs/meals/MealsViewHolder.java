package com.example.szs.meals;

import android.view.View;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

public class MealsViewHolder extends RecyclerView.ViewHolder {

    public TextView name, quentity, date, time;

    public MealsViewHolder(@NonNull View itemView) {
        super(itemView);

        name = itemView.findViewById(R.id.name);
        quentity = itemView.findViewById(R.id.quentity);
        date = itemView.findViewById(R.id.date);
        time = itemView.findViewById(R.id.time);

    }
}