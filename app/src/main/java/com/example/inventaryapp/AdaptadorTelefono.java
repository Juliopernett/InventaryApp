package com.example.inventaryapp;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorTelefono extends  RecyclerView.Adapter<AdaptadorTelefono.TelefonoViewHolder>{

    private ArrayList<Telefono> telefonos;

    public  AdaptadorTelefono(ArrayList<Telefono>telefonos){
        this.telefonos=telefonos;
    }
    @Override
    public TelefonoViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        /*vas a usar el layaut que ya cree
        inflr extendiendo la culumna en el padre y no va a pararlo*/
        View v = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_telefonos, parent, false);
        //devolvemos el holder que hemos extendido del view group en nuestra actividad
        TelefonoViewHolder holder = new TelefonoViewHolder(v);
        return holder;
    }

    @Override
    /*LO QUE QUEREMOS HACER CON NUESTRO RECYCLER VIEW*/
    public void onBindViewHolder(@NonNull TelefonoViewHolder holder, int position) {
        Telefono t = telefonos.get(position);
        holder.foto.setImageResource(t.getFoto());
        holder.codigo.setText(t.getCodigo());
        holder.marca.setText(t.getMarca());
        holder.modelo.setText(t.getModelo());
        holder.cantidad.setText(t.getCantidad()+"");
    }

    @Override
    /*REGRESA EL NUMERO DE FILAS DE NUESTRO RECYLCLER VIEW*/
    public int getItemCount() {
        return telefonos.size();
    }

    public static class TelefonoViewHolder extends RecyclerView.ViewHolder{
        /*Declaramos los campos que tenemos en nuestro contenedor (ITEM_telefonos)*/
        ImageView foto;
        TextView codigo, marca, modelo, cantidad;
        View v;
        /*lo que vamos a mostrara (para el ejemplo es nuestro ITEM_telefonos)*/
        public TelefonoViewHolder(View itemView) {
            super(itemView);
            v = itemView;
            foto = v.findViewById(R.id.foto);
            codigo = v.findViewById(R.id.lblcodigo);
            marca = v.findViewById(R.id.lblMarca);
            modelo = v.findViewById(R.id.lblModelo);
            cantidad = v.findViewById(R.id.lblCantidad);
        }
    }
}

