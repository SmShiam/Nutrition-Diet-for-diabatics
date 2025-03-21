package com.example.szs.meals;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

import java.util.List;


public class MealsRecyclerAdapter extends RecyclerView.Adapter<MealsRecyclerAdapter.viewHolder> {

    List<Meals> myMealsList;

    public MealsRecyclerAdapter(List<Meals> myMealsList) {
        this.myMealsList = myMealsList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_meal, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Meals currentMeals = myMealsList.get(position);

        holder.name.setText(currentMeals.getName());
        holder.quentity.setText(currentMeals.getQuentity());
        holder.time.setText(currentMeals.getTime());
        holder.date.setText(currentMeals.getDate());
    }

    @Override
    public int getItemCount() {
        if (myMealsList == null || myMealsList.isEmpty()) {
            return 0;
        } else
            return myMealsList.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name, quentity, date, time;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            quentity = itemView.findViewById(R.id.quentity);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }


}
