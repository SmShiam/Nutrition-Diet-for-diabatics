package com.example.szs;

import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.example.szs.older.P_P;
import com.example.szs.remainder.MainActivity3;


public class More_Fragment extends Fragment {

    TextView gop_p, godis, button;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_more, container, false);


        gop_p = view.findViewById(R.id.p_p1);
        gop_p.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Fragment pop = new P_P();
                FragmentTransaction fm = getActivity().getSupportFragmentManager().beginTransaction();
                fm.replace(R.id.container, pop).commit();
            }
        });

        godis = view.findViewById(R.id.dis);
        godis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog_u = new Dialog(getActivity());
                dialog_u.setContentView(R.layout.disclaimer);
                dialog_u.show();

            }
        });


        button = view.findViewById(R.id.re_ac3);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getActivity(), MainActivity3.class);
                startActivity(intent);
            }
        });

        TextView name1 = view.findViewById(R.id.name);
        TextView number1 = view.findViewById(R.id.number);


        TextView add = view.findViewById(R.id.edit);
        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Dialog dialog = new Dialog(getActivity());
                dialog.setContentView(R.layout.custom_profile);
                EditText name = dialog.findViewById(R.id.p_name);
                EditText number = dialog.findViewById(R.id.p_number);

                Button createButton = dialog.findViewById(R.id.save);

                createButton.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        if (name1.getText().toString().equals("")) {
                            Toast.makeText(getActivity(), "Please Insert  Name", Toast.LENGTH_SHORT).show();
                        } else {
                            String name = name1.getText().toString();
                            String number = number1.getText().toString();

                            name1.setText(name);
                            number1.setText(number);


                            dialog.dismiss();
                            ;
                        }
                    }
                });
                dialog.show();
            }
        });


        return view;
    }


}