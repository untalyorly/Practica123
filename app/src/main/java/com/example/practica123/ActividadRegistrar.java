package com.example.practica123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class ActividadRegistrar extends AppCompatActivity {

    EditText nombre, apellido;
    Button enviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_actividad_registrar);

        nombre = (EditText) findViewById(R.id.editText2);
        apellido = (EditText) findViewById(R.id.editText3);
        enviar = (Button) findViewById(R.id.buttonEnviar);

        enviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(ActividadRegistrar.this, registrarDatos.class);
                Bundle bundle = new Bundle();
                bundle.putString("nombre", nombre.getText().toString());
                bundle.putString("apellido", apellido.getText().toString());
                intent.putExtras(bundle);
                startActivity(intent);
            }
        });


    }
}
