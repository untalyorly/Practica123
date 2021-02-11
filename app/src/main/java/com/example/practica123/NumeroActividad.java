package com.example.practica123;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class NumeroActividad extends AppCompatActivity {

    EditText caja;
    Button btnConvertir;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_numero_actividad);

        caja = (EditText) findViewById(R.id.editText_numero);
        btnConvertir = (Button) findViewById(R.id.btn_convertir);

        if(caja.getText().toString() != " "){
            btnConvertir.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    Intent intent = new Intent(NumeroActividad.this, ConversionActividad.class);
                    Bundle bundle = new Bundle();
                    bundle.putDouble("euro", Double.parseDouble(caja.getText().toString()));
                    intent.putExtras(bundle);
                    startActivity(intent);
                }
            });

        }

    }
}
