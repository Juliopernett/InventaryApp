package com.example.inventaryapp;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class AdaptadorTelefono extends  RecyclerView.Adapter<AdaptadorTelefono.TelefonoViewHolder> {
    private ArrayList<Telefono> telefonos;

    public  AdaptadorTelefono(ArrayList<Telefono>telefonos){
        this.telefonos=telefonos;
    }


    @Override
    public TelefonoViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        //vas a usar el layaut que ya cree
        View v = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_telefonos, viewGroup, false);
        return new TelefonoViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull TelefonoViewHolder telefonoViewHolder, int i) {
        Telefono t = telefonos.get(i);
        telefonoViewHolder.foto.setImageResource(t.getFoto());
        telefonoViewHolder.codigo.setText(t.getCodigo());
        telefonoViewHolder.marca.setText(t.getMarca());
        telefonoViewHolder.modelo.setText(t.getModelo());
        telefonoViewHolder.cantidad.setText(t.getCantidad());
    }

    @Override
    public int getItemCount() {
        return telefonos.size();
    }

    public static class TelefonoViewHolder extends RecyclerView.ViewHolder{
        private ImageView foto;
        private TextView codigo, marca, modelo, cantidad;
        private View v;

        public  TelefonoViewHolder(View itemView){
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

