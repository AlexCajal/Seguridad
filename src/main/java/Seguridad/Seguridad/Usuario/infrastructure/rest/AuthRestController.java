package Seguridad.Seguridad.Usuario.infrastructure.rest;

import Seguridad.Seguridad.Usuario.application.UsuarioUseCases;
import Seguridad.Seguridad.Usuario.domain.Usuario;
import Seguridad.Seguridad.Usuario.infrastructure.db.UsuarioRepositoryMySQL;
import Seguridad.Seguridad.context.security.JwtService;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/auth")
public class AuthRestController {

    private final JwtService jwtService;
    private UsuarioUseCases usuarioUseCases;

    public AuthRestController(JwtService jwtService) {
        this.jwtService = jwtService;
        this.usuarioUseCases = new UsuarioUseCases(new UsuarioRepositoryMySQL());
    }

    @PostMapping("/registro")
    public String registro(@RequestBody Usuario user){
        boolean correcto = this.usuarioUseCases.registro(user);
        if (correcto) return "Registrado correctamente";
        else return "mal";
    }
    @PostMapping("/login")
    public String login(@RequestBody Usuario user){
        Usuario userDB = this.usuarioUseCases.login(user);
        if (userDB != null) return jwtService.generateToken(userDB.getEmail());
        else return "User o passwor incorrecta";
    }
}
