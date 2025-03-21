package com.example.szs.older;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.szs.R;


public class Bmi_Calculator extends Fragment {

    int wt = 0, ht = 0;
    ImageView back;

    @SuppressLint("MissingInflatedId")
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_bmi__calculator, container, false);

        TextView result_btn;
        Button bmi_btn;
        EditText edtWeight, edtHeight, edtHeightIn;
        edtWeight = view.findViewById(R.id.edtWeight);
        edtHeightIn = view.findViewById(R.id.edtHeightIn);
        edtHeight = view.findViewById(R.id.edtHeight);
        result_btn = view.findViewById(R.id.result_btn);
        bmi_btn = view.findViewById(R.id.bmi_btn);


        bmi_btn.setOnClickListener(v -> {
            double wtResult = 0.0;
            double htResult = 0.0;
            double htSubResult = 0.0;
            double totalHeight = 0;

            if (!edtWeight.getText().toString().isEmpty()) {


                if (!edtHeight.getText().toString().isEmpty()) {
                    if (wt == 0) {

                        wtResult = Double.parseDouble((edtWeight.getText().toString()));
                    } else if (wt == 1) {
                        wtResult = Double.parseDouble(edtWeight.getText().toString()) * 2.20462;
                    }


                    if (ht == 0) {
                        htResult = (Double.parseDouble(edtHeight.getText().toString()) * 0.3048);
                    } else if (ht == 1) {
                        htResult = (Double.parseDouble(edtHeight.getText().toString()) / 100);
                    } else if (ht == 2) {
                        htResult = Double.parseDouble(edtHeight.getText().toString());
                    }


                    if (!edtHeightIn.getText().toString().isEmpty()) {
                        if (ht == 0) {
                            htSubResult = (Double.parseDouble(edtHeightIn.getText().toString()) / 12);
                            htSubResult = htSubResult * 0.3048;
                        } else if (ht == 1) {
                            htSubResult = Double.parseDouble(edtHeightIn.getText().toString()) / 100;
                        } else if (ht == 2) {
                            htSubResult = Double.parseDouble(edtHeightIn.getText().toString()) / 100;
                        }
                        totalHeight = htResult + htSubResult;
                        double bmiResult = wtResult / (totalHeight * totalHeight);
                        double finalResult = Math.round(bmiResult * 10.0) / 10.0;
                        result_btn.setText("Your BMI is " + finalResult);
                        Log.d("FinalResultBmi", "onClick: " + finalResult);


                    } else {

                        totalHeight = htResult + htSubResult;
                        double bmiResult = wtResult / (totalHeight * totalHeight);
                        double finalResult = Math.round(bmiResult * 10.0) / 10.0;
                        result_btn.setText("Your BMI is " + finalResult);
                        Log.d("FinalResultBmi", "onClick: " + finalResult);

                        
                    }

                } else {
                    result_btn.setText("Please Enter Height");
                }
            } else {
                result_btn.setText("Please Enter Weight and Height");
            }

        });


        back = view.findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment back = new Dashboard_Fragment();
                FragmentTransaction fm = requireActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container, back).commit();
            }
        });

        return view;


    }


}
