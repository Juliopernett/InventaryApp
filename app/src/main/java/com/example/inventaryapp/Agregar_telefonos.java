package com.example.inventaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.google.android.material.snackbar.Snackbar;
import com.google.firebase.database.DatabaseReference;

import java.util.ArrayList;
import java.util.Random;

public class Agregar_telefonos extends AppCompatActivity {
    private ArrayList<Integer> fotos;
    private EditText codigo, marca, modelo, cantidad;
    TextView prueba;
    int band = 0;

    private static  String db = "Telefonos";
    private DatabaseReference databaseReference;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agregar_telefonos);
            fotos = new ArrayList<>();
            fotos.add(R.drawable.images);
            fotos.add(R.drawable.images2);
            fotos.add(R.drawable.images3);
            fotos.add(R.drawable.images4);

            codigo = findViewById(R.id.txtCodigo);
            marca = findViewById(R.id.txtMarca);
            modelo = findViewById(R.id.txtModelo);
            cantidad = findViewById(R.id.txtCantidad);
            prueba = findViewById(R.id.txtPrueba);
    }

   public void guardar(View v){
        if (validar()){

            String id, mar, mod, cod;
            int foto, cant;
            id = Datos.gesID();
            foto = this.fotoAleatoria();
            cod = codigo.getText().toString();
            mar = marca.getText().toString();
            mod = modelo.getText().toString();
            cant = Integer.parseInt(cantidad.getText().toString());
            /* prueba.setText("" + codi + " " + cod + " " + mar + " " + mod + " " + cant + " " + id + " " + foto);*/
            Telefono t = new Telefono(id,foto,cant,cod,mar,mod);
            t.guardar();
            limpiar();
            Snackbar.make(v, getString(R.string.mensaje), Snackbar.LENGTH_SHORT).show();
       }
    }

    public void limpiar(View v){
        limpiar();
    }
    public  void limpiar(){
        codigo.setText("");
        marca.setText("");
        modelo.setText("");
        cantidad.setText("");
        codigo.requestFocus();
    }

    public int fotoAleatoria(){
        int fotoSeleccionada;
        Random r = new Random();
        fotoSeleccionada = r.nextInt(this.fotos.size());
        return fotos.get(fotoSeleccionada);
    }

    public void onBackPressed(){
        Intent i = new Intent(Agregar_telefonos.this, MainActivity.class);
        startActivity(i);
        finish();
    }

    public boolean validar(){

        if(codigo.getText().toString().isEmpty()){
            codigo.setError(getResources().getString(R.string.error_1));
            codigo.requestFocus();
            return false;
        }else if(marca.getText().toString().isEmpty()) {
            marca.setError(getResources().getString(R.string.error_2));
            marca.requestFocus();
            return false;
        }else if(modelo.getText().toString().isEmpty()) {
            modelo.setError(getResources().getString(R.string.error_3));
            modelo.requestFocus();
            return false;
        }else if(cantidad.getText().toString().isEmpty()) {
            cantidad.setError(getResources().getString(R.string.error_4));
            cantidad.requestFocus();
            return false;
        }else if (Datos.consultarCodigo(codigo.getText().toString())){
            codigo.setError(getResources().getString(R.string.error_5));
            codigo.requestFocus();
            return false;

        }
        return true;
        /*FALTA VALIDAR EL CODIGO UNICO*/
    }

}
