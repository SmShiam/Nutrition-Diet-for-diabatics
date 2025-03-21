package com.example.szs.medicine;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;
import androidx.recyclerview.widget.ItemTouchHelper;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.szs.Nutrition_Repository;
import com.example.szs.R;
import com.example.szs.older.Dashboard_Fragment;

import java.util.ArrayList;
import java.util.List;


public class Medicine_Fragment extends Fragment {

    public Button add;
    public ImageView back;
    View view;
    Nutrition_Repository repository;
    RecyclerView recyclerView;
    MedicineRecyclerAdapter adapter;
    List<Medicine> allMedicine = new ArrayList<>();

    @SuppressLint({"MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_medicine, container, false);
        repository = new Nutrition_Repository(getActivity().getApplication());

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        allMedicine = repository.GetAllMedicine();

        adapter = new MedicineRecyclerAdapter(allMedicine);
        recyclerView.setAdapter(adapter);


        new ItemTouchHelper(new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.LEFT | ItemTouchHelper.RIGHT) {
            @Override
            public boolean onMove(@NonNull RecyclerView recyclerView, @NonNull RecyclerView.ViewHolder viewHolder, @NonNull RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(@NonNull RecyclerView.ViewHolder viewHolder, int direction) {
                Delete(viewHolder.getLayoutPosition());
            }
        }).attachToRecyclerView(recyclerView);


        add = view.findViewById(R.id.add_medicine);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_diolog_medicine);
                EditText medicineName = dialog.findViewById(R.id.medicine_name);
                EditText medicineUnits = dialog.findViewById(R.id.medicine_units);
                EditText medicineTime = dialog.findViewById(R.id.medicine_time);
                EditText medicineDate = dialog.findViewById(R.id.medicine_date);
                Button createButton = dialog.findViewById(R.id.save);

                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (medicineName.getText().toString().equals("")) {
                            Toast.makeText(getActivity(), "Please Insert Activity Name", Toast.LENGTH_SHORT).show();
                        } else {
                            String name = medicineName.getText().toString();
                            String units = medicineUnits.getText().toString();
                            String date = medicineDate.getText().toString();
                            String time = medicineTime.getText().toString();
                            Toast.makeText(getActivity(), name + " is activity Name", Toast.LENGTH_SHORT).show();
                            insertMedicine(name, units, date, time);
                            dialog.dismiss();
                            ;
                        }
                    }
                });
                dialog.show();
            }
        });


        //work on back button
        back = view.findViewById(R.id.back);
        back.setOnClickListener(view -> {
            Fragment back = new Dashboard_Fragment();
            FragmentTransaction fm = requireActivity().getSupportFragmentManager().beginTransaction();
            fm.replace(R.id.container, back).commit();
        });
        return view;
    }

    private void insertMedicine(String name, String units, String date, String time) {
        Medicine temp = new Medicine(name, units, date, time);
        allMedicine.add(temp);
        adapter.notifyDataSetChanged();
        repository.InsertMedicine(temp);
    }

    private void Delete(int position) {
        Medicine medicine = allMedicine.get(position);
        repository.DeleteMedicine(medicine);
        allMedicine.remove(medicine);
        adapter.notifyDataSetChanged();
    }


}