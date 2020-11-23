package by.itClass.model.db;

import static by.itClass.constants.Constants.*;

import java.sql.Connection;
import java.sql.Statement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.DriverManager;
import java.util.Objects;
import java.util.Properties;

public class ConnectionManager {
    private static Connection cn;
    private static Properties properties;

    static {
        try {
            Class.forName(DB_DRIVER);
        } catch (ClassNotFoundException e) {
            System.err.println(e.getMessage());
        }
    }

    static {
        properties = new Properties();
//        try {
//            properties.load(new FileReader(DB_PROPERTY));
//        } catch (IOException e) {
//            System.err.println(e.getMessage());
//        }
    }

    public static Connection getConnection() throws SQLException {
        if (Objects.isNull(cn) || cn.isClosed()) {
            cn = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
        }
        return cn;
    }

    public static void closeConnection() {
        if (Objects.nonNull(cn)) {
            try {
                cn.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void closeStatement(Statement st) {
        if (Objects.nonNull(st)) {
            try {
                st.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }

    public static void closeResultSet(ResultSet rs) {
        if (Objects.nonNull(rs)) {
            try {
                rs.close();
            } catch (SQLException e) {
                System.err.println(e.getMessage());
            }
        }
    }
}
