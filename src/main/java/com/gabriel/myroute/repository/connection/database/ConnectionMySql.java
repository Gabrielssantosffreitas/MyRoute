package com.gabriel.myroute.repository.connection.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionMySql {
    private static final String URL = "jdbc:mysql://localhost:3306/my_route";
    private static final String USER = "root";
    private static  final String SENHA= "140827gdJ@";

    public Connection connection() throws SQLException {return DriverManager.getConnection(URL,USER,SENHA);}// cria uma conexao com o banco de dados
}
