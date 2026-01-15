package Seguridad.Seguridad.Usuario.infrastructure.rest;

import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/api/usuarios")
public class UsuarioRestController {

    @GetMapping
    public String index(Authentication auth){
        return "Email:" + auth.getName();
    }
}
