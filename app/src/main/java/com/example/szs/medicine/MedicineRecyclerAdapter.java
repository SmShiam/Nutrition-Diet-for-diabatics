package com.example.szs.medicine;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.R;

import java.util.List;


public class MedicineRecyclerAdapter extends RecyclerView.Adapter<MedicineRecyclerAdapter.viewHolder> {

    List<Medicine> myMedicineList;

    public MedicineRecyclerAdapter(List<Medicine> myMedicineList) {
        this.myMedicineList = myMedicineList;
    }

    @NonNull
    @Override
    public viewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_medicine, parent, false);
        return new viewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull viewHolder holder, int position) {
        Medicine currentMedicine = myMedicineList.get(position);

        holder.name.setText(currentMedicine.getName());
        holder.units.setText(currentMedicine.getUnits());
        holder.time.setText(currentMedicine.getTime());
        holder.date.setText(currentMedicine.getDate());
    }

    @Override
    public int getItemCount() {
        if (myMedicineList == null || myMedicineList.isEmpty()) {
            return 0;
        } else
            return myMedicineList.size();
    }


    public class viewHolder extends RecyclerView.ViewHolder {
        TextView name, units, date, time;

        public viewHolder(@NonNull View itemView) {
            super(itemView);
            name = itemView.findViewById(R.id.name);
            units = itemView.findViewById(R.id.units);
            date = itemView.findViewById(R.id.date);
            time = itemView.findViewById(R.id.time);
        }
    }


}
