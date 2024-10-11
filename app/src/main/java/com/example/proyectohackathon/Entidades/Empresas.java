package com.example.proyectohackathon.Entidades;

import java.sql.Blob;

public class Empresas {
    private int idEmpresa;
    private String Nombre;
    private String Descripcion;
    private String Ubicacion;

    public int getIdEmpresa() {
        return idEmpresa;
        //f
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

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public String getUbicacion() {
        return Ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        Ubicacion = ubicacion;
    }
}
