package com.example.practica123;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RecibirParametroActivity extends AppCompatActivity {
    TextView texto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recibir_parametro);

        texto = (TextView) findViewById(R.id.lblParametro);
        Bundle bundle = this.getIntent().getExtras();
        texto.setText(bundle.getString("dato"));
    }
}
