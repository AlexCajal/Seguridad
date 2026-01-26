package Seguridad.Seguridad.Tarea.application;

import Seguridad.Seguridad.Tarea.domain.Tarea;
import Seguridad.Seguridad.Tarea.domain.TareaRepository;
import Seguridad.Seguridad.Usuario.domain.Usuario;

import java.util.ArrayList;

public class TareaUseCases {

    private TareaRepository tareaRepository;

    public TareaUseCases(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }

    public ArrayList<Tarea> getLista(Usuario user){
        return tareaRepository.getLista(user);
    }
    public Tarea  guardarTarea(Tarea t){
        return tareaRepository.guardarTarea(t);
    }
    public boolean asignarTarea(String idTarea, String emailUser, Usuario user){
        return tareaRepository.asignarTarea(idTarea, emailUser);
    }
    public Tarea datosTarea(String id){
        Tarea t = tareaRepository.datosTarea(id);

    }
}
