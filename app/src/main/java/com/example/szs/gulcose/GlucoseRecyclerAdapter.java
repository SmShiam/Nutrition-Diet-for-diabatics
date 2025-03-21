package com.example.szs.gulcose;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

import java.util.List;


public class GlucoseRecyclerAdapter extends RecyclerView.Adapter<GlucoseRecyclerAdapter.viewHolder> {

    List<Glucose> myGlucoseList;

    public GlucoseRecyclerAdapter(List<Glucose> myGlucoseList) {
        this.myGlucoseList = myGlucoseList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_glucose, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Glucose currentGlucose = myGlucoseList.get(position);

        holder.name.setText(currentGlucose.getName());
        holder.time.setText(currentGlucose.getTime());
        holder.date.setText(currentGlucose.getDate());
    }

    @Override
    public int getItemCount() {
        if (myGlucoseList == null || myGlucoseList.isEmpty()) {
            return 0;
        } else
            return myGlucoseList.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name, date, time;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }


}
