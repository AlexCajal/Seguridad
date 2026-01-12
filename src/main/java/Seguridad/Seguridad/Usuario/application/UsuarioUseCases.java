package Seguridad.Seguridad.Usuario.application;

import Seguridad.Seguridad.Usuario.domain.Usuario;
import Seguridad.Seguridad.Usuario.domain.UsuarioRepository;
import com.google.common.hash.Hashing;

import java.nio.charset.StandardCharsets;

public class UsuarioUseCases {

    private UsuarioRepository usuarioRepository;

    public UsuarioUseCases(UsuarioRepository usuarioRepository){
        this.usuarioRepository = usuarioRepository;
    }
    public boolean registro (Usuario user){
        String pass = Hashing.sha256().hashString(user.getContrasenia(), StandardCharsets.UTF_8).toString();
        Usuario cifrado = new Usuario(user.getEmail(),pass);
        return this.usuarioRepository.registro(cifrado);
    }
}
