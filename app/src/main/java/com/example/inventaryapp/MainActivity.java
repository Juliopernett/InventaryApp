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
    private static  String db = "Telefonos";
    private DatabaseReference databaseReference;
    AdaptadorTelefono adapter;
    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        /*lstOpciones = (RecyclerView)findViewById(R.id.lstCelulares); */
        lstOpciones = findViewById(R.id.lstCelulares);

        lstOpciones.setLayoutManager(new LinearLayoutManager(this));

        telefonos = new ArrayList<>();
        final AdaptadorTelefono adapter = new AdaptadorTelefono(telefonos);
        llm = new LinearLayoutManager(this);
        llm.setOrientation(1);
        lstOpciones.setLayoutManager(llm);
        lstOpciones.setAdapter(adapter);
        databaseReference = FirebaseDatabase.getInstance().getReference();
        databaseReference.child(db).addValueEventListener(new ValueEventListener() {
            @Override
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


    public void agregarTelefono(View v){
        i = new Intent(MainActivity.this, Agregar_telefonos.class);
        startActivity(i);
        finish();
    }

}
