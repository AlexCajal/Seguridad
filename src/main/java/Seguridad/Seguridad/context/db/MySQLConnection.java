package Seguridad.Seguridad.context.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class MySQLConnection {

    private static Connection connection;

    private MySQLConnection() {}

    public static Connection getInstance() {
        if (connection == null) {
            try {
                connection = DriverManager.getConnection(
                        "jdbc:mysql://servidortareas2.cwasnfjfbjhw.us-east-1.rds.amazonaws.com/Seguridad",
                        "admin", "admin12345.");
            } catch (SQLException sqlException) {
                throw new RuntimeException(sqlException);

            }
        }
        return connection;
    }
}
