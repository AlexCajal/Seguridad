package Seguridad.Seguridad.Tarea.domain;

import java.sql.Timestamp;

public class Tarea {
    private String ID;
    private String texto;
    private String prioridad;
    private Timestamp fechaInicio;
    private Timestamp fechFin;
    private boolean estado;
    private String emailCreador;

    public Tarea(String ID, String texto, String prioridad, Timestamp fechaInicio, Timestamp fechFin, boolean estado, String emailCreador) {
        this.ID = ID;
        this.texto = texto;
        this.prioridad = prioridad;
        this.fechaInicio = fechaInicio;
        this.fechFin = fechFin;
        this.estado = estado;
        this.emailCreador = emailCreador;
    }

    public String getID() {
        return ID;
    }

    public String getTexto() {
        return texto;
    }

    public String getPrioridad() {
        return prioridad;
    }

    public Timestamp getFechaInicio() {
        return fechaInicio;
    }

    public Timestamp getFechFin() {
        return fechFin;
    }

    public boolean isEstado() {
        return estado;
    }

    public String getEmailCreador() {
        return emailCreador;
    }
}
