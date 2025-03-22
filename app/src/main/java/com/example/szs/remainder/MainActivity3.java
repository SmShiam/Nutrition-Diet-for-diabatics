package com.example.szs.remainder;

import android.app.AlarmManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.ImageView;
import android.widget.TimePicker;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.szs.MainActivity2;
import com.example.szs.R;

import java.util.Calendar;

public class MainActivity3 extends AppCompatActivity {

    Button showDateTimeButton, setAlarmButton;

    DatePicker datePicker;
    TimePicker timePicker;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);

        datePicker = findViewById(R.id.datePicker);
        timePicker = findViewById(R.id.timepicker);

        showDateTimeButton = findViewById(R.id.showDateTimeButton);
        setAlarmButton = findViewById(R.id.setAlarmButton);

        
        ImageView back = findViewById(R.id.back);
        back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity3.this, MainActivity2.class);
                startActivity(intent);
            }
        });


        showDateTimeButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                toggleDateTimeVisiblity();
            }
        });

        setAlarmButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                setAlarm();
                datePicker.setVisibility(View.GONE);
                timePicker.setVisibility(View.GONE);
                setAlarmButton.setVisibility(View.GONE);
            }
        });

    }

    private void setAlarm() {


        cancelPreviousAlarm();

        int day = datePicker.getDayOfMonth();
        int month = datePicker.getMonth();
        int year = datePicker.getYear();
        int hour = timePicker.getHour();
        int minute = timePicker.getMinute();

        Calendar calendar = Calendar.getInstance();
        calendar.set(year, month, day, hour, minute);

        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(MainActivity3.this, AlramReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity3.this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT | PendingIntent.FLAG_MUTABLE);
        alarmManager.set(AlarmManager.RTC_WAKEUP, calendar.getTimeInMillis(), pendingIntent);

        Toast.makeText(MainActivity3.this, "Alarm set for " + day + "/" + (month + 1) + "/" + year + " at " + hour + ":" + minute, Toast.LENGTH_SHORT).show();


    }

    private void cancelPreviousAlarm() {


        AlarmManager alarmManager = (AlarmManager) getSystemService(Context.ALARM_SERVICE);

        Intent intent = new Intent(MainActivity3.this, AlramReceiver.class);
        PendingIntent pendingIntent = PendingIntent.getBroadcast(MainActivity3.this, 0, intent, PendingIntent.FLAG_IMMUTABLE);

        if (pendingIntent != null) {

            alarmManager.cancel(pendingIntent);
            pendingIntent.cancel();
        }


    }

    private void toggleDateTimeVisiblity() {


        int datevisiblity = datePicker.getVisibility();
        int timevisiblity = timePicker.getVisibility();

        if (datevisiblity == View.GONE & timevisiblity == View.GONE) {

            datePicker.setVisibility(View.VISIBLE);
            timePicker.setVisibility(View.VISIBLE);
            setAlarmButton.setVisibility(View.VISIBLE);
        } else {

            datePicker.setVisibility(View.GONE);
            timePicker.setVisibility(View.GONE);
            setAlarmButton.setVisibility(View.GONE);


        }
    }
}


