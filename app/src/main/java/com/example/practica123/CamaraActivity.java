package com.example.practica123;

import android.Manifest;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.os.Environment;
import android.provider.MediaStore;
import android.support.annotation.NonNull;
import android.support.v4.app.ActivityCompat;
import android.support.v4.content.ContextCompat;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Switch;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.stream.Stream;

public class CamaraActivity extends AppCompatActivity implements View.OnClickListener{

    private final int REQUEST_PERMISSION_STORAGE_SAVE = 101;
    private final int REQUEST_PERMISSION_STORAGE_DELETE = 102;

    static final int REQUEST_IMAGE_CAPTURE= 1;

    Bitmap imageBitmap;

    private final String FOLDER_NAME= "UOCImageApp";
    private final String FILE_NAME = "imageapp.jpg";

    private Button buttonOpenImage;
    private ImageView imageView;
    private TextView textViewMessage;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_camara);

        buttonOpenImage = findViewById(R.id.button_captura);
        imageView = findViewById(R.id.imagen_galeria);
        textViewMessage = findViewById(R.id.mensaje_captura);

        buttonOpenImage.setOnClickListener(this);


        cargarImagenSiExiste();
    }

    private void cargarImagenSiExiste(){

        String myImage= Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + FOLDER_NAME + "/" + FILE_NAME;
        File imagen = new File(myImage);

        if(imagen.exists()){
            Picasso.get().load(imagen).into(imageView);
            textViewMessage.setVisibility(View.INVISIBLE);

        }else{
            textViewMessage.setVisibility(View.VISIBLE);
        }


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_captura, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.menu_opcion_camara:
                onSaveMenuTap();
                return true;
            case R.id.opcion_camara_guardar:
                onDeleteMenuTap();
                return true;

        }
        return super.onOptionsItemSelected(item);
    }


    private Boolean hasPermissionToWrite(){
        return ContextCompat.checkSelfPermission(this, Manifest.permission.WRITE_EXTERNAL_STORAGE) == PackageManager.PERMISSION_GRANTED;

    }
    private void onDeleteMenuTap(){
        if(!hasPermissionToWrite()){
            ActivityCompat.requestPermissions(this, new String[]{
                    Manifest.permission.WRITE_EXTERNAL_STORAGE
            }, REQUEST_PERMISSION_STORAGE_DELETE);
        }else{
            DialogInterface.OnClickListener dialogoClickListener = new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    switch (i){
                        case DialogInterface.BUTTON_POSITIVE:
                            try {
                                deleteImageFile();
                            }catch (IOException e){
                                e.printStackTrace();
                            }
                            break;
                        case DialogInterface.BUTTON_NEGATIVE:
                            break;
                    }
                }
            };
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Eliminar Imagen").setMessage("Desea eliminar esta imagen?").setPositiveButton("si", dialogoClickListener).setNegativeButton("No", dialogoClickListener).show();
        }
    }

    private void deleteImageFile() throws IOException{
        File storageDir = new File(Environment.getExternalStorageDirectory()+ "/UOCImageApp");
        File image= new File(storageDir + "/" + this.FILE_NAME);
        if(image.exists()){
            image.delete();
            Toast.makeText(this, "Archivo eliminado", Toast.LENGTH_LONG).show();
            textViewMessage.setVisibility(View.VISIBLE);
        }else{
            Toast.makeText(this, "Archivo no encontrado", Toast.LENGTH_LONG).show();
        }
    }

    private void onSaveMenuTap(){
        if(!hasPermissionToWrite()){
            ActivityCompat.requestPermissions(this, new String[]{Manifest.permission.WRITE_EXTERNAL_STORAGE}, REQUEST_PERMISSION_STORAGE_SAVE);

        }else{
            if(imageView.getDrawable() != null){

                createFolder();
                String storageDir = Environment.getExternalStorageDirectory() + "/UOCImagenApp/";
                createImagenFile(storageDir, this.FILE_NAME, imageBitmap);

            }else{
                Toast.makeText(this, "Toma una foto primero!", Toast.LENGTH_LONG).show();
            }
        }
    }

    private void createImagenFile(String storageDir, String fileName, Bitmap bitmap){
        try{
            File myFile = new File(storageDir, fileName);
            FileOutputStream stream = new FileOutputStream(myFile);
            bitmap.compress(Bitmap.CompressFormat.JPEG, 100, stream);
            stream.flush();
            stream.close();

            Toast.makeText(this, "Archivo guardado", Toast.LENGTH_LONG).show();
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    private void dispatchTakePictureIntent(){
        Intent takePictureIntent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if(takePictureIntent.resolveActivity(getPackageManager()) != null){
            startActivityForResult(takePictureIntent, REQUEST_IMAGE_CAPTURE);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK){
            Bundle extras = data.getExtras();
            imageBitmap = (Bitmap) extras.get("data");
            imageView.setImageBitmap(imageBitmap);
            textViewMessage.setVisibility(View.INVISIBLE);


        }else{

        }

    }

    public void createFolder(){
        String myFolder = Environment.getExternalStorageDirectory().getAbsolutePath() + "/" + FOLDER_NAME;
        File folder = new File(myFolder);

        if (!folder.exists()){
            if(!folder.mkdir()){
                Toast.makeText(this, FOLDER_NAME + "No se pudo crear", Toast.LENGTH_LONG).show();
            }else{
                Toast.makeText(this, FOLDER_NAME + "Se creo exitosamente", Toast.LENGTH_LONG).show();
            }
        }
    }



    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        switch (requestCode) {
            case REQUEST_PERMISSION_STORAGE_DELETE: {
                if(grantResults.length > 0&& grantResults[0]==PackageManager.PERMISSION_GRANTED){

            } else {
                    Toast.makeText(this,"No se permitio eliminar", Toast.LENGTH_LONG).show();
                }
            }
            case REQUEST_PERMISSION_STORAGE_SAVE: {
                if(grantResults.length > 0&& grantResults[0]==PackageManager.PERMISSION_GRANTED){
                    createFolder();
                    String storageDir = Environment.getExternalStorageDirectory() + "/UOCImageApp/";
                    createImagenFile(storageDir, FILE_NAME, imageBitmap);

                }else {
                    Toast.makeText(this, "No se permitio guardar", Toast.LENGTH_LONG).show();
                }
            }
        }
        //super.onRequestPermissionsResult(requestCode, permissions, grantResults);
    }

    @Override
    public void onClick(View v) {
        if (v == buttonOpenImage){
            dispatchTakePictureIntent();
        }

    }
}
