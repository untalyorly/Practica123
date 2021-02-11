package com.example.practica123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class ConversionActividad extends AppCompatActivity {
    TextView texto;
    Double e = 1.119;
    Double conversion;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_conversion_actividad);

        texto = (TextView) findViewById(R.id.textView_mostrar_conversion);
        Bundle bundle = this.getIntent().getExtras();
        conversion = bundle.getDouble("euro");
        conversion = conversion * e;
        texto.setText(String.valueOf(conversion));








    }
}
