package com.example.proyectohackathon.Entidades;

public class ProductoTipos {
    private int idProductoTipos;
    private int idProducto;
    private String Tipo;

    public int getIdProductoTipos() {
        return idProductoTipos;
    }
//F
    public void setIdProductoTipos(int idProductoTipos) {
        this.idProductoTipos = idProductoTipos;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
