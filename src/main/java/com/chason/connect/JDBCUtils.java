package com.chason.connect;

import java.sql.*;

/**
 * utils for connect to mysql by jdbc
 */
public class JDBCUtils {

    private static final String USER = "glue";

    private static final String PASSWORD = "Glue01_glue";

    private static final String URL = "jdbc:mysql://localhost:3306/words?useSSL=false&serverTimezone=UTC";

    private static final String DRIVER = "com.mysql.cj.jdbc.Driver";

    public static Connection connect() {

        Connection connection = null;
        try {
            Class.forName(DRIVER);
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
        } catch (SQLException | ClassNotFoundException e) {
            e.printStackTrace();
        }
        return connection;
    }



}
