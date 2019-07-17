package com.example.inventaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;
import com.google.android.material.snackbar.Snackbar;
import java.util.ArrayList;
import java.util.Random;

public class Agregar_telefonos extends AppCompatActivity {
    private ArrayList<Integer> fotos;
    private EditText codigo, marca, modelo, cantidad;
    TextView prueba;


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

        String id, mar, mod, cod;
        int foto, cant;
        id = Datos.gesID();
        foto = this.fotoAleatoria();
        cod = codigo.getText().toString();
        mar = marca.getText().toString();
        mod = modelo.getText().toString();
        cant = Integer.parseInt(cantidad.getText().toString());
        /*prueba.setText(""+ cod +" "+ mar +" "+ mod +" "+ cant +" "+id+" "+foto);*/
        Telefono t = new Telefono (id, foto, cod, mar, mod, cant);
        t.guardar();
        limpiar();
        Snackbar.make(v,getString(R.string.mensaje), Snackbar.LENGTH_SHORT).show();
    }

    public void limpiar(View v){
        limpiar();
    }

    public  void limpiar(){
        codigo.setText("");
        marca.setText("");
        modelo.setText("");
        cantidad.setText("");
        prueba.setText("");
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

}
