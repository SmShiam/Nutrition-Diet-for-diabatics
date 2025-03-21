package com.example.szs.meals;

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

public class Dairy_Fragment extends Fragment {

    public Button add;
    public ImageView back;
    View view;
    Nutrition_Repository repository;
    RecyclerView recyclerView;
    MealsRecyclerAdapter adapter;
    List<Meals> allMeals = new ArrayList<>();

    @SuppressLint({"MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_dairy, container, false);
        repository = new Nutrition_Repository(getActivity().getApplication());

        recyclerView = view.findViewById(R.id.recycler);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(getActivity()));

        allMeals = repository.GetAllMeals();

        adapter = new MealsRecyclerAdapter(allMeals);
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


        add = view.findViewById(R.id.add_meal);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_dialog_meals);
                EditText mealsName = dialog.findViewById(R.id.meal_name);
                EditText mealsQuentity = dialog.findViewById(R.id.meal_quentity);
                EditText mealsTime = dialog.findViewById(R.id.meal_time);
                EditText mealsDate = dialog.findViewById(R.id.meal_date);
                Button createButton = dialog.findViewById(R.id.save);

                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (mealsName.getText().toString().equals("")) {
                            Toast.makeText(getActivity(), "Please Insert Activity Name", Toast.LENGTH_SHORT).show();
                        } else {
                            String name = mealsName.getText().toString();
                            String quentity = mealsQuentity.getText().toString();
                            String date = mealsDate.getText().toString();
                            String time = mealsTime.getText().toString();
                            Toast.makeText(getActivity(), name + " is activity Name", Toast.LENGTH_SHORT).show();
                            insertMeals(name, quentity, date, time);
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

    private void insertMeals(String name, String quentity, String date, String time) {
        Meals temp = new Meals(name, quentity, date, time);
        allMeals.add(temp);
        adapter.notifyDataSetChanged();
        repository.InsertMeals(temp);
    }

    private void Delete(int position) {
        Meals meals = allMeals.get(position);
        repository.DeleteMeals(meals);
        allMeals.remove(meals);
        adapter.notifyDataSetChanged();
    }


}