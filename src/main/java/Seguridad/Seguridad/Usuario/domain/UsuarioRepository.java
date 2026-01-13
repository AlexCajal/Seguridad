package Seguridad.Seguridad.Usuario.domain;

public interface UsuarioRepository {

    public boolean registro(Usuario user);
    public Usuario login(Usuario user);
}
