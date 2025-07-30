package com.gabriel.myroute.repository.user;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.gabriel.myroute.entity.User;
import com.gabriel.myroute.repository.connection.database.ConnectionMySql;

public class UserRepository {

    ConnectionMySql connectionMySql = new ConnectionMySql();// driver de conexao do banco de dados

    // Cria um user no banco de dados
    public boolean setUser(User user) { // retorna um boolean false caso nenhuma linha seja alterada
        String sql = "insert into user (nome,email,senha,telefone) values (?,?,?,?)";
        int linhas = 0;

        try (Connection con = this.connectionMySql.connection(); // abrir e fechar automaticamente
             PreparedStatement statement = con.prepareStatement(sql);//
        ) {//try
            //substituição dos "?" pelos valores
            statement.setString(1, user.getNome());
            statement.setString(2, user.getEmail());
            statement.setString(3, user.getSenha());
            statement.setString(4, user.getTell());

            linhas = statement.executeUpdate();// verificando se alguma linha foi alterada
        } catch (SQLException e) {
            e.printStackTrace();
        }
        if (linhas > 0) {// se alguma linha foi alterada  retorna true
            return true;
        } else {
            return false;
        }
    }

    // Pegar os user do banco de dados
    public List<User> getUsers() {
        List<User> listUser = new ArrayList<User>(); // lista de usuarios

        try (Statement statement = this.connectionMySql.connection().createStatement();
             ResultSet resultSet = statement.executeQuery("select * from user");
        ) {
            while (resultSet.next()) { // vai de linha em linha no resultado Da query
                listUser.addLast(new User(
                        resultSet.getLong("id"),
                        resultSet.getNString("nome"),
                        resultSet.getString("email"),
                        resultSet.getNString("telefone"),
                        resultSet.getNString("senha"))
                );// cria um objeto User e adiciona na lista
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return listUser;
    }
}
