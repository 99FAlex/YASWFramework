package de.alexf99.yasw.data.database;

import de.alexf99.yasw.data.database.objects.YaswConnection;

import java.sql.*;

public class Mysql {
    public static Connection MysqlCon;

    public static void MysqlStatement(String ip, int port, String database , String username, String password, String sql) throws SQLException {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database, username, password)) {
            try (Statement stmt = con.createStatement()) {

                stmt.execute(sql);
            }
        } catch (SQLException e) {
        }
    }
    public static void MysqlStatement(YaswConnection yaswConnection, String sql) throws SQLException {
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://" + yaswConnection.getIp() + ":" + yaswConnection.getPort() + "/" + yaswConnection.getDatabase(), yaswConnection.getUsername(), yaswConnection.getPassword())) {
            try (Statement stmt = con.createStatement()) {

                stmt.execute(sql);
            }
        } catch (SQLException e) {
        }
    }


    public static ResultSet MysqlResultStatement(String ip, int port, String database , String username, String password, String sql){
        try (Connection con = DriverManager
                .getConnection("jdbc:mysql://" + ip + ":" + port + "/" + database, username, password)) {
            try (Statement stmt = con.createStatement()) {

                stmt.execute(sql);
            }
        } catch (SQLException e) {
        }
        return null;
    }



    /*public static String MysqlResultStatement(Connection connection, String sql) throws SQLException {
        String selectSql = "SELECT * FROM test";
        try (Statement stmt = connection.createStatement()) {
            try (ResultSet resultSet = stmt.executeQuery(selectSql)) {
                System.out.println(resultSet.first());
            }
            //stmt.execute(sql);
        }


        return null;
    }*/


}
