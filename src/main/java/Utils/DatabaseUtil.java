package Utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DatabaseUtil {
    private static final String URL = "jdbc:mysql://localhost:3306/gestion_hotel";
    private static final String USER = "root"; // Votre nom d'utilisateur MySQL
    private static final String PASSWORD = ""; // Votre mot de passe MySQL (laissez vide si aucun)

    public static Connection getConnection() {
        Connection connection = null;
        try {
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }
}
