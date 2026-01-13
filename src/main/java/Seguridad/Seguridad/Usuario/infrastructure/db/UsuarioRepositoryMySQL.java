package Seguridad.Seguridad.Usuario.infrastructure.db;

import Seguridad.Seguridad.Usuario.domain.Usuario;
import Seguridad.Seguridad.Usuario.domain.UsuarioRepository;
import Seguridad.Seguridad.context.db.MySQLConnection;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class UsuarioRepositoryMySQL implements UsuarioRepository {
    @Override
    public boolean registro(Usuario user) {
        String query = "INSERT INTO usuario (?,?)";
        PreparedStatement statement = null;
        try {
            statement = MySQLConnection.getInstance().prepareStatement(query);
            statement.setString(1,user.getEmail());
            statement.setString(2,user.getContrasenia());
            statement.execute();
            return true;
        } catch (SQLException e) {
            return false;
        }
    }

    @Override
    public Usuario login(Usuario user) {
        String query = "SELECT * FROM usuario WHERE email = ?";
        PreparedStatement statement = null;

        try {
            statement = MySQLConnection.getInstance().prepareStatement(query);
            statement.setString(1,user.getEmail());
            ResultSet rs = statement.executeQuery(query);
            while (rs.next()){
                return new Usuario(rs.getString("email"),rs.getString("contrasenia"));
            }

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }

        return user;
    }
}
