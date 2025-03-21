package com.example.szs;

import android.os.Bundle;
import android.view.MenuItem;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.szs.activity.Activity_Fragment;
import com.example.szs.meals.Dairy_Fragment;
import com.example.szs.older.Dashboard_Fragment;
import com.google.android.material.bottomnavigation.BottomNavigationView;

public class MainActivity2 extends AppCompatActivity {
    BottomNavigationView bn_view;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main2);

        bn_view = findViewById(R.id.bn_view);

        bn_view.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {

                int id = item.getItemId();

                if (id == R.id.nav_dashboard) {
                    load_frag(new Dashboard_Fragment(), true);
                } else if (id == R.id.nav_plans) {
                    load_frag(new Activity_Fragment(), false);
                } else if (id == R.id.nav_dairy) {
                    load_frag(new Dairy_Fragment(), false);
                } else {
                    load_frag(new More_Fragment(), false);
                }

                return true;
            }
        });

        bn_view.setSelectedItemId(R.id.nav_dashboard);


    }

    public void load_frag(Fragment fragment, boolean flag) {
        FragmentManager fm = getSupportFragmentManager();
        FragmentTransaction ft = fm.beginTransaction();
        if (flag)
            ft.add(R.id.container, fragment);
        else
            ft.replace(R.id.container, fragment);
        ft.commit();
    }
}