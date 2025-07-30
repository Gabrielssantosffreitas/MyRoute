package com.gabriel.myroute.service.login;

import java.nio.channels.Pipe.SourceChannel;
import java.util.List;
import com.gabriel.myroute.controller.util.AlertException;
import com.gabriel.myroute.entity.User;
import com.gabriel.myroute.repository.connection.database.ConnectionMySql;
import com.gabriel.myroute.repository.user.UserRepository;

public class LoginService {
	
	private User credenciasCorrect(List<User> users,String email,String senha,int posicao) {
        User usuario;
        
		int i =0;
		// caso base 
		if(posicao >= users.size() || posicao < 0) {
			return null;
		}else {
			i = posicao;
		}
		
		
		if(users.get(i).getEmail().equals(email) && users.get(i).getSenha().equals(senha)) {
			return users.get(i);
		}//caso recursivo 
		else {
			return credenciasCorrect(users, email, senha, posicao+1);
		}
		
		
	}
	public User logar(String email,String senha) {
		
		UserRepository userRepository = new UserRepository();
		
		List<User> users = userRepository.getUsers();
		
		return this.credenciasCorrect(users, email, senha,0);
		
		
		
	}
	
}
