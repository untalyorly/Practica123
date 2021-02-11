package com.example.practica123;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.os.BatteryManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ProgressBar;
import android.widget.TextView;

public class BateriaActivity extends AppCompatActivity {

    private TextView mNivelBateriaTexto;
    private TextView estaCargando;
    private TextView usb_o_cc;
    private ProgressBar mNivelBateria;
    private BroadcastReceiver mReceiver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bateria);

        mNivelBateriaTexto = (TextView) findViewById(R.id.textBateria);
        mNivelBateria = (ProgressBar) findViewById(R.id.progressBarBateria);
        estaCargando = (TextView)findViewById(R.id.estaCargando);
        usb_o_cc = (TextView)findViewById(R.id.usb_o_cc);

        mReceiver = new BatteryBroadcastReceiver();
        registerReceiver(mReceiver, new IntentFilter(Intent.ACTION_BATTERY_CHANGED));


    }



    private class BatteryBroadcastReceiver extends BroadcastReceiver{
        @Override
        public void onReceive(Context context, Intent intent) {
            int level = intent.getIntExtra(BatteryManager.EXTRA_LEVEL, 0);
            mNivelBateriaTexto.setText("Nivel de bateria "+ " " + level);
            mNivelBateria.setProgress(level);

            int status = intent.getIntExtra(BatteryManager.EXTRA_STATUS, -1);
            boolean isCharging = status == BatteryManager.BATTERY_STATUS_CHARGING || status == BatteryManager.BATTERY_STATUS_FULL;
            estaCargando.setText("¿El teléfono está cargando? "+String.valueOf(isCharging));

            int chargePlug = intent.getIntExtra(BatteryManager.EXTRA_PLUGGED, -1);
            boolean usbCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_USB;
            boolean acCharge = chargePlug == BatteryManager.BATTERY_PLUGGED_AC;
            if(usbCharge == true){
                usb_o_cc.setText("El teléfono está cargando por cable USB");

            }else{
                if(acCharge == true){
                    usb_o_cc.setText("El telefono está conectado a corriente alterna");

                }else{
                    usb_o_cc.setText("El telefono no está cargando");
                }
            }
        }

    }

    @Override
    protected void onPause() {
        super.onPause();

        Log.v("CUARTO A - JENNIFER INTRIAGO ", "me active onPause");
        if(isDestroyed()){
            unregisterReceiver(mReceiver);
            Log.v("4A", "Destruida");
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.v("CUARTO A - JENNIFER INTRIAGO ", "me active onResumes");
    }

    @Override
    protected void onStop() {
        super.onStop();
        unregisterReceiver(mReceiver);
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
