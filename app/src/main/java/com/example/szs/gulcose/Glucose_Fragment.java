package com.example.szs.gulcose;

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

public class Glucose_Fragment extends Fragment {


    public Button add;
    public ImageView back;
    View view;
    Nutrition_Repository repository;
    RecyclerView recyclerView;
    GlucoseRecyclerAdapter adapter;
    List<Glucose> allGlucose = new ArrayList<>();
    //   private Context context;

    @SuppressLint({"MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_glucose, container, false);
        repository = new Nutrition_Repository(getActivity().getApplication());

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        allGlucose = repository.GetAllGlucose();

        adapter = new GlucoseRecyclerAdapter(allGlucose);
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


//        TextView input = view.findViewById(R.id.input);


        add = view.findViewById(R.id.add_glucose);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_u_i_dialog_glucose);
                EditText activityName = dialog.findViewById(R.id.activity_type);
                EditText activityTime = dialog.findViewById(R.id.activity_time);
                EditText activityDate = dialog.findViewById(R.id.activity_date);
                Button createButton = dialog.findViewById(R.id.save);
/*
                activityDate.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Calendar calendar = Calendar.getInstance();
                        int MONTH = calendar.get(Calendar.MONTH);
                        int YEAR = calendar.get(calendar.YEAR);
                        int DAY = calendar.get(calendar.DATE);

                        DatePickerDialog datePickerDialog = new DatePickerDialog(context, new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker datePicker, int year, int month, int dayOfMonth) {
                                month = month + 1;
                                activityDate.setText(dayOfMonth + "/" + month + "/" + year);
                            }
                        }, YEAR, MONTH, DAY);
                        datePickerDialog.show();

                    }
                });

 */

                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (activityName.getText().toString().equals("")) {
                            Toast.makeText(getActivity(), "Please Insert Suger lavel", Toast.LENGTH_SHORT).show();
                        } else {
                            String name = activityName.getText().toString();
                            String date = activityDate.getText().toString();
                            String time = activityTime.getText().toString();
                            Toast.makeText(getActivity(), name + " is yor suger lavel", Toast.LENGTH_SHORT).show();
                            insertGlucose(name, date, time);
                            dialog.dismiss();

                            //                           input.setText(name);

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

    private void insertGlucose(String name, String date, String time) {
        Glucose temp = new Glucose(name, date, time);
        allGlucose.add(temp);
        adapter.notifyDataSetChanged();
        repository.InsertGlucose(temp);
    }

    private void Delete(int position) {
        Glucose glucose = allGlucose.get(position);
        repository.DeleteGlucose(glucose);
        allGlucose.remove(glucose);
        adapter.notifyDataSetChanged();
    }


}