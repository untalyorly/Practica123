package com.example.practica123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {
    Button  buttonLogin, buttonGuardar, buttonBuscar, buttonPasarParametro, buttonRecyclerView, buttonCamara, btnConversion ,btnCalendar, btnBateria;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonLogin = (Button) findViewById(R.id.buttonLogin);
        buttonBuscar = (Button) findViewById(R.id.buttonBuscar);
        buttonGuardar = (Button) findViewById(R.id.buttonGuardar);
        buttonPasarParametro = (Button) findViewById(R.id.buttonPasarParametro);
        buttonRecyclerView = (Button) findViewById(R.id.buttonRecyclerView);
        buttonCamara = (Button)findViewById(R.id.btnCamara);
        btnConversion = (Button) findViewById(R.id.btnConversion);
        btnCalendar = (Button) findViewById(R.id.btnCalendario);
        btnBateria = (Button) findViewById(R.id.btnBateria);

        btnBateria.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, BateriaActivity.class);
                startActivity(intent);
            }
        });

        btnCalendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, CalendarActivity.class);
                startActivity(intent);
            }
        });

        btnConversion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(MainActivity.this, NumeroActividad.class);
                startActivity(intent);
            }
        });

        buttonCamara.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, CamaraActivity.class);
                startActivity(intent);
            }
        });

        buttonLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this , ActividadLogin.class);
                startActivity(intent);
            }
        });

        buttonBuscar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActividadBuscar.class);
                startActivity(intent);
            }
        });

        buttonGuardar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, ActividadRegistrar.class);
                startActivity(intent);
            }
        });

        buttonPasarParametro.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, PasarParametro.class);
                startActivity(intent);

            }
        });

        buttonRecyclerView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this, recyclerView.class);
                startActivity(intent);
            }
        });


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        Intent intent;
        switch (item.getItemId()){
            case R.id.opcionLogin:
                intent = new Intent(MainActivity.this, ActividadLogin.class);
                startActivity(intent);
                break;
            case R.id.opcionRegistrar:
                intent = new Intent(MainActivity.this, ActividadRegistrar.class);
                startActivity(intent);
                break;

        }
        return true;
    }
}
