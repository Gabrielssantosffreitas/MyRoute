package com.gabriel.myroute.repository.roteiro;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.gabriel.myroute.entity.Roteiro;
import com.gabriel.myroute.repository.connection.database.ConnectionMySql;

public class RoteiroRepository {
	
	
	public List<Roteiro> getRoteiroByid_user(String id_user) {
		
		
		List<Roteiro> roteiro = new ArrayList<Roteiro>();
		
		
		ConnectionMySql mysql= new ConnectionMySql();
		
		try ( PreparedStatement ps =  mysql.connection().prepareStatement("select * from roteiro where id_cliente =?");
				){
			ps.setString(1, id_user);
			
			ResultSet rs = ps.executeQuery();
			
			while(rs.next()) {
				Roteiro rt = new Roteiro();
				rt.setId(Long.valueOf ( rs.getString("id")));
				rt.setNome(rs.getString("nome"));
				rt.setRoteiro(rs.getString("roteiro"));
				rt.setId_user(rs.getLong("id_user"));
				roteiro.addLast(rt);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		
		}
		return roteiro;
		
			
		
	}
	
	public void setRoteiro(Roteiro roteiro) {
		 ConnectionMySql mysql = new ConnectionMySql()	;
		 
		String sql = "insert into roteiro (nome,roteiro,id_user) values (?,?,?)";
  
        try (Connection con = mysql.connection(); // abrir e fechar automaticamente
             PreparedStatement statement = con.prepareStatement(sql);//
        ) {//try
            //substituição dos "?" pelos valores
            statement.setString(1, roteiro.getNome());
            statement.setString(2, roteiro.getRoteiro());
            statement.setLong(3, roteiro.getId_user());

            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        
		
	}
	
}
