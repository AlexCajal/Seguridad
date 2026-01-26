package Seguridad.Seguridad.Tarea.infrastructure;

import Seguridad.Seguridad.Tarea.application.TareaUseCases;
import Seguridad.Seguridad.Tarea.domain.Tarea;
import Seguridad.Seguridad.Usuario.domain.Usuario;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/api/tarea")
public class TareaRestController {

    private TareaUseCases tareaUseCases;

    public  TareaRestController(){
        this.tareaUseCases = new TareaUseCases(new TareaRepositoryMySQL());
    }

    @GetMapping()
    public ArrayList<Tarea> getLista(Authentication authentication){
        Usuario user = new Usuario(authentication.getName(),null);
        return this.tareaUseCases.getLista(user);
    }

    @PostMapping("/nueva")
    public Tarea guardarTarea(Authentication authentication , @RequestBody Tarea t){
        Usuario user = new Usuario(authentication.getName(),null);
        t.setEmailCreador(user.getEmail());

        return  this.tareaUseCases.guardarTarea(t);
    }
    @PostMapping("/asignar")
    public String asignarTarea(Authentication authentication , @RequestBody String idTarea, @PathVariable String emailUser){
        Usuario user = new Usuario(authentication.getName(), null);
        if (this.tareaUseCases.asignarTarea(idTarea,emailUser,user));
        return "Error al asignar la tarea";
    }
    @GetMapping("{id}")
    public Tarea datosTarea(@PathVariable String id){
        return this.tareaUseCases.datosTarea(id);
    }
}
