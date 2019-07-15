package com.example.inventaryapp;

public class telefonos {
    private String id;
    private int foto;
    private int codigo;
    private String marca;
    private String modelo;
    private int cantidad;

    public telefonos(String id, int foto, int codigo, String marca, String modelo, int cantidad) {
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

    public int getCodigo() {
        return codigo;
    }

    public void setCodigo(int codigo) {
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
}
