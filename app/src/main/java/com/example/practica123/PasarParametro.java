package com.example.practica123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class PasarParametro extends AppCompatActivity {

    EditText cajaDatos;
    Button botonEnviar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pasar_parametro);

        cajaDatos = (EditText) findViewById(R.id.editTextParametro);
        botonEnviar = (Button) findViewById(R.id.buttonEnviarParametro);

        botonEnviar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(PasarParametro.this, RecibirParametroActivity.class);
                Bundle bundle = new Bundle();
                bundle.putString("dato", cajaDatos.getText().toString());
                intent.putExtras(bundle);

                startActivity(intent);
            }
        });
    }
}
