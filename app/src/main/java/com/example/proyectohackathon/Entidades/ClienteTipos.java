package com.example.proyectohackathon.Entidades;

public class ClienteTipos {
    private  int idClienteTipos;
    private int idCliente;
    private String Tipo;
    public int getIdClienteTipos() {
        return idClienteTipos;
    }

    public void setIdClienteTipos(int idClienteTipos) {
        this.idClienteTipos = idClienteTipos;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public String getTipo() {
        return Tipo;
    }

    public void setTipo(String tipo) {
        Tipo = tipo;
    }
}
