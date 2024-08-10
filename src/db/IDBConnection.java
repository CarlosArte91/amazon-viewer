package db;

import static constants.DataBase.*;

import java.sql.Connection;
import java.sql.DriverManager;

public interface IDBConnection {
    default Connection connectToDB() {
        Connection connection = null;

        try {
            Class.forName("com.mysql.cj.jdbc.Driver");
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            if (connection != null) {
                System.out.println("Connection with DB " + DB_NAME + " is OK. =)");
            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            return connection;
        }
    }
}
