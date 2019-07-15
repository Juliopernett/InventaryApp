package com.example.inventaryapp;

public class Telefono {
    private String id;
    private int foto, cantidad;
    private String codigo, marca,modelo;

    public Telefono(String id, int foto, String codigo, String marca, String modelo, int cantidad) {
        this.id = id;
        this.foto = foto;
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
        this.cantidad = cantidad;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public int getFoto() {
        return foto;
    }

    public void setFoto(int foto) {
        this.foto = foto;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
    }

    public void guardar(){
        Datos.agregar(this);
    }

    public void eliminar(){
        Datos.eliminar(this);
    }

    public  void editar(){
        Datos.editar(this);
    }

}
