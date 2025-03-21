package com.example.szs.bp;

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


public class Bp_Fragment extends Fragment {

    public Button add;
    public ImageView back;
    View view;
    Nutrition_Repository repository;
    RecyclerView recyclerView;
    BpRecyclerAdapter adapter;
    List<Bp> allBp = new ArrayList<>();

    @SuppressLint({"MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_bp, container, false);
        repository = new Nutrition_Repository(getActivity().getApplication());

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        allBp = repository.GetAllBp();

        adapter = new BpRecyclerAdapter(allBp);
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


        add = view.findViewById(R.id.add_bp);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_dialog_bp);
                EditText bpSys = dialog.findViewById(R.id.bp_sys);
                EditText bpDys = dialog.findViewById(R.id.bp_dys);
                EditText bpTime = dialog.findViewById(R.id.bp_time);
                EditText bpDate = dialog.findViewById(R.id.bp_date);
                Button createButton = dialog.findViewById(R.id.save);

                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (bpSys.getText().toString().equals("")) {
                            Toast.makeText(getActivity(), "Please Insert Activity Name", Toast.LENGTH_SHORT).show();
                        } else {
                            String sys = bpSys.getText().toString();
                            String dys = bpDys.getText().toString();
                            String date = bpDate.getText().toString();
                            String time = bpTime.getText().toString();
                            Toast.makeText(getActivity(), sys + " is activity Name", Toast.LENGTH_SHORT).show();
                            insertBp(sys, dys, date, time);
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

    private void insertBp(String sys, String dys, String date, String time) {
        Bp temp = new Bp(sys, dys, date, time);
        allBp.add(temp);
        adapter.notifyDataSetChanged();
        repository.InsertBp(temp);
    }

    private void Delete(int position) {
        Bp bp = allBp.get(position);
        repository.DeleteBp(bp);
        allBp.remove(bp);
        adapter.notifyDataSetChanged();
    }


}