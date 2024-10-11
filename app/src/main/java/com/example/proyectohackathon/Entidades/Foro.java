package com.example.proyectohackathon.Entidades;

public class Foro {
    private int idForo;
    private int idProducto;
    private int idCliente;
    private int Calificacion;
    private String Comentario;

    public int getIdForo() {
        return idForo;
    }


    public void setIdForo(int idForo) {
        this.idForo = idForo;
    }

    public int getIdProducto() {
        return idProducto;
    }

    public void setIdProducto(int idProducto) {
        this.idProducto = idProducto;
    }

    public int getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(int idCliente) {
        this.idCliente = idCliente;
    }

    public int getCalificacion() {
        return Calificacion;
    }

    public void setCalificacion(int calificacion) {
        Calificacion = calificacion;
    }

    public String getComentario() {
        return Comentario;
    }

    public void setComentario(String comentario) {
        Comentario = comentario;
    }
}
