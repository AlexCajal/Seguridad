package Seguridad.Seguridad.Tarea.infrastructure;

import Seguridad.Seguridad.Tarea.domain.Tarea;
import Seguridad.Seguridad.Tarea.domain.TareaRepository;
import Seguridad.Seguridad.Usuario.domain.Usuario;
import Seguridad.Seguridad.context.db.MySQLConnection;

import java.sql.*;
import java.util.ArrayList;

public class TareaRepositoryMySQL implements TareaRepository {
    @Override
    public ArrayList<Tarea> getLista(Usuario user) {
        ArrayList<Tarea> lista = new ArrayList<>();
        String query = "SELECT * FROM tarea WHERE emailCreador = ?;";
        PreparedStatement st = null;
        try {
            st = MySQLConnection.getInstance().prepareStatement(query);
            st.setString(1,user.getEmail());
            ResultSet rs = st.executeQuery();
            while (rs.next()){
                String ID = rs.getString("ID");
                String texto = rs.getString("texto");
                String prioridad = rs.getString("prioridad");
                Timestamp fechaInicio = rs.getTimestamp("fechaInicio");
                Timestamp fechaFin = rs.getTimestamp("fechaFin");
                boolean estado = rs.getBoolean("estado");
                String emailCreador = rs.getString("emailCreador");

                Tarea t = new Tarea(ID,texto,prioridad,fechaInicio,fechaFin,estado);
                t.setEmailCreador(emailCreador);
                lista.add(t);

            }

            return lista;

        } catch (SQLException e) {
            return  null;
        }
    }

    @Override
    public Tarea guardarTarea(Tarea t) {
        String query = "INSERT INTO tarea VALUES (?,?,?,?,?,?,?);";
        PreparedStatement st = null;
        try {
            st = MySQLConnection.getInstance().prepareStatement(query);
            st.setString(1,t.getID());
            st.setString(2,t.getTexto());
            st.setString(3,t.getPrioridad());
            st.setTimestamp(4,t.getFechaInicio());
            st.setTimestamp(5,t.getFechFin());
            st.setBoolean(6,t.isEstado());
            st.setString(7,t.getEmailCreador());
            st.execute();

        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
        return t;
    }
    public boolean asignarTarea(String idTarea, String emailUser){
        String query = "INSERT INTO asignaciones VALUES (?,?)";
        PreparedStatement st = null;
        try {
            st = MySQLConnection.getInstance().prepareStatement(query);
            st.setString(1,idTarea);
            st.setString(2,emailUser);
            return st.execute();
        } catch (SQLException e) {
            throw new RuntimeException(e);
        }
    }


}
