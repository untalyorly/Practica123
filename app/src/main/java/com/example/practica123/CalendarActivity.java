package com.example.practica123;

import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CalendarView;
import android.widget.TextView;

public class CalendarActivity extends AppCompatActivity {
    CalendarView calendar;
    TextView textocalendario;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_calendar);
        calendar = findViewById(R.id.calendarView);
        textocalendario = findViewById(R.id.txtCalendar);

        calendar.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(@NonNull CalendarView calendarView, int i, int i1, int i2) {
                textocalendario.setText(String.valueOf(i) + "/" + String.valueOf(i1+1) + "/" + String.valueOf(i2));
            }
        });


    }
}
