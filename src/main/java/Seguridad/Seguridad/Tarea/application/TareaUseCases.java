package Seguridad.Seguridad.Tarea.application;

import Seguridad.Seguridad.Tarea.domain.TareaRepository;

public class TareaUseCases {

    private TareaRepository tareaRepository;

    public TareaUseCases(TareaRepository tareaRepository) {
        this.tareaRepository = tareaRepository;
    }
}
