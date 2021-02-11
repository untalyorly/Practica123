package com.example.practica123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

public class ActividadLogin extends AppCompatActivity {
    Button botonSesion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_login);

        Log.v("CUARTO A - JENNIFER INTRIAGO", "Me active en Oncreate");
        botonSesion = (Button) findViewById(R.id.buttonAutenticar);
        botonSesion.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActividadLogin.this, MainActivity.class);
                startActivity(intent);
            }
        });

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.v("CUARTO A - JENNIFER INTRIAGO ", "me active onStart");
    }



    @Override
    protected void onPause() {
        super.onPause();
        Log.v("CUARTO A - JENNIFER INTRIAGO ", "me active onPause");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("CUARTO A - JENNIFER INTRIAGO ", "me active onResumes");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.v("CUARTO A - JENNIFER INTRIAGO ", "me active onStop");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.v("CUARTO A - JENNIFER INTRIAGO ", "me active onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.v("CUARTO A - JENNIFER INTRIAGO ", "me active onDestroy");
    }
}
