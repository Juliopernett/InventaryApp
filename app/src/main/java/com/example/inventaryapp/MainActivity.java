package com.example.inventaryapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import java.util.ArrayList;


public class MainActivity extends AppCompatActivity {

    private RecyclerView lstOpciones;
    private Intent i;
    private ArrayList<Telefono> telefonos;
    private LinearLayoutManager llm;
    private String db = "Telefonos";
    private DatabaseReference databaseReference;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        lstOpciones = findViewById(R.id.lstCelulares);
        telefonos = new ArrayList<>();
        final AdaptadorTelefono
                adapter = new AdaptadorTelefono(telefonos);
        llm = new LinearLayoutManager(this);
        /*llm.setOrientation(1);ESTO LLEVA UN 1*/
        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db);
        databaseReference.addValueEventListener(new ValueEventListener() {
            @Override
            /*estar pendiente cuando hay un cambio en producción, recorre el arbol agrega esas personas al arbol*/
            public void onDataChange(@NonNull DataSnapshot dataSnapshot) {
                telefonos.clear();
                if (dataSnapshot.exists()) {
                    for (DataSnapshot snapshot : dataSnapshot.getChildren()) {
                        Telefono p = snapshot.getValue(Telefono.class);
                        telefonos.add(p);
                    }
                }
                adapter.notifyDataSetChanged();
                Datos.setTelefonos(telefonos);
            }

            @Override
            public void onCancelled(@NonNull DatabaseError databaseError) {

            }
        });

    }


    public void agregarPersona(View v){
        i = new Intent(MainActivity.this, Agregar_telefonos.class);
        startActivity(i);
        finish();
    }

}
