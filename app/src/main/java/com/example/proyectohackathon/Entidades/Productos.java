package com.example.proyectohackathon.Entidades;

public class Productos {
    private int idProducto;
    private int idEmpresa;
    private String Nombre;
    private String Talla;
    private String Color;
    private int Costo;
    private int Nivel;
    private String Personalizable;
//F
    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdEmpresa() {
        return idEmpresa;
    }

    public void setIdEmpresa(int idEmpresa) {
        this.idEmpresa = idEmpresa;
    }

    public String getNombre() {
        return Nombre;
    }

    public void setNombre(String nombre) {
        Nombre = nombre;
    }

    public String getTalla() {
        return Talla;
    }

    public void setTalla(String talla) {
        Talla = talla;
    }

    public String getColor() {
        return Color;
    }

    public void setColor(String color) {
        Color = color;
    }

    public int getCosto() {
        return Costo;
    }

    public void setCosto(int costo) {
        Costo = costo;
    }

    public int getNivel() {
        return Nivel;
    }

    public void setNivel(int nivel) {
        Nivel = nivel;
    }

    public String getPersonalizable() {
        return Personalizable;
    }

    public void setPersonalizable(String personalizable) {
        Personalizable = personalizable;
    }
}
