package com.example.szs.older;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.szs.More_Fragment;
import com.example.szs.R;
import com.example.szs.activity.Activity_Fragment;
import com.example.szs.bp.Bp_Fragment;
import com.example.szs.gulcose.Glucose_Fragment;
import com.example.szs.meals.Dairy_Fragment;
import com.example.szs.medicine.Medicine_Fragment;
import com.example.szs.remainder.MainActivity3;


public class Dashboard_Fragment extends Fragment {
    ImageView goMeal;
    ImageView goActivity;
    ImageView goMedicine;
    ImageView goBp;
    ImageView goBmi;
    Button goAdd;


    @SuppressLint({"WrongViewCast", "MissingInflatedId"})
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_dashboard, container, false);


        goMeal = view.findViewById(R.id.meal);
        goMeal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment meal = new Dairy_Fragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container, meal).commit();
            }
        });

        TextView input = view.findViewById(R.id.input);
        input.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment input = new Glucose_Fragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container, input).commit();
            }
        });

        goActivity = view.findViewById(R.id.activity);
        goActivity.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment activity = new Activity_Fragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container, activity).commit();
            }
        });

        goMedicine = view.findViewById(R.id.medicine);
        goMedicine.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment medicine = new Medicine_Fragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container, medicine).commit();
            }
        });

        goBp = view.findViewById(R.id.bp);
        goBp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment bp = new Bp_Fragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container, bp).commit();
            }
        });

        goBmi = view.findViewById(R.id.bmi);
        goBmi.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment bmi_cal = new Bmi_Calculator();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container, bmi_cal).commit();
            }
        });

        goAdd = view.findViewById(R.id.add);
        goAdd.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog_u = new Dialog(getActivity());
                dialog_u.setContentView(R.layout.custom_dialog_add);
                dialog_u.show();
                ;
            }
        });

        ImageView button = view.findViewById(R.id.notificationIcon);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity3.class);
                startActivity(intent);
            }
        });

        ImageView gopro = view.findViewById(R.id.profileIcon);
        gopro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment profile = new More_Fragment();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container, profile).commit();
            }
        });

        return view;
    }
}