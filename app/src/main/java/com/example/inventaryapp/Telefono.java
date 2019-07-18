package com.example.inventaryapp;

public class Telefono {
    private String id;
    private int foto, cantidad;
    private String codigo, marca,modelo;

    public Telefono(String id, int foto, int cantidad, String codigo, String marca, String modelo) {
        this.id = id;
        this.foto = foto;
        this.cantidad = cantidad;
        this.codigo = codigo;
        this.marca = marca;
        this.modelo = modelo;
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

    public int getCantidad() {
        return cantidad;
    }

    public void setCantidad(int cantidad) {
        this.cantidad = cantidad;
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
