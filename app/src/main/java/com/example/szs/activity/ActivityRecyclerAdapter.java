package com.example.szs.activity;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

import java.util.List;


public class ActivityRecyclerAdapter extends RecyclerView.Adapter<ActivityRecyclerAdapter.viewHolder> {

    List<Activity> myActivityList;

    public ActivityRecyclerAdapter(List<Activity> myActivityList) {
        this.myActivityList = myActivityList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_activity, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Activity currentActivity = myActivityList.get(position);

        holder.name.setText(currentActivity.getName());
        holder.time.setText(currentActivity.getTime());
        holder.date.setText(currentActivity.getDate());
    }

    @Override
    public int getItemCount() {
        if (myActivityList == null || myActivityList.isEmpty()) {
            return 0;
        } else
            return myActivityList.size();
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
