package com.example.proyectohackathon.Entidades;

public class Carrito {
    private int idCarrito;
    private int idCliente;
    private int idProducto;
    private String Personalizacion;
    private String Color;
    public int getIdCarrito() {
        return idCarrito;
    }

    public void setIdCarrito(int idCarrito) {
        this.idCarrito = idCarrito;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public String getPersonalizacion() {
        return Personalizacion;
    }

    public void setPersonalizacion(String personalizacion) {
        Personalizacion = personalizacion;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }
}
