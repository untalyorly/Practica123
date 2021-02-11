package com.example.practica123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class registrarDatos extends AppCompatActivity {

    TextView nombre, apellido;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registrar_datos);

        nombre = (TextView)findViewById(R.id.textViewNombres);
        apellido = (TextView) findViewById(R.id.textViewApellidos);

        Bundle bundle = this.getIntent().getExtras();

        nombre.setText(bundle.getString("nombre"));
        apellido.setText(bundle.getString("apellido"));


    }
}
