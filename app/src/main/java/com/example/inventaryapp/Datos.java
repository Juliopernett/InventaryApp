package com.example.inventaryapp;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;

import java.util.ArrayList;
public class Datos {
    private static  String db = "Telefonos";

    private static DatabaseReference databaseReference =
            FirebaseDatabase.getInstance().getReference();

    public  static ArrayList<Telefono> telefonos = new ArrayList<>();

    public static  void agregar(Telefono t){
        /*Estructura propia de una base de datos no relacional*/
        databaseReference.child(db).child(t.getId()).setValue(t);
    }

    public  static  void editar(Telefono t){
        databaseReference.child(db).child(t.getId()).setValue(t);
    }

    public  static  void eliminar(Telefono t){
        databaseReference.child(db).child(t.getId()).removeValue();
    }

    /*manda una peticion al servidor y me trae una llave unica*/
    public static String gesID(){
        return databaseReference.push().getKey();
    }

    public  static  void setTelefonos(ArrayList<Telefono> telefonos){
        Datos.telefonos=telefonos;
    }

    public static ArrayList<Telefono> optener(){
        return Datos.telefonos;
    }
}
