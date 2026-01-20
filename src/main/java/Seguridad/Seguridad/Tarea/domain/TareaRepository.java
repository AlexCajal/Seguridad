package Seguridad.Seguridad.Tarea.domain;

import Seguridad.Seguridad.Usuario.domain.Usuario;

import java.util.ArrayList;

public interface TareaRepository {
    public ArrayList<Tarea> getLista(Usuario user);
    public Tarea guardarTarea(Tarea t);
    public boolean asignarTarea(String idTarea, String emailUser);
}
