package com.gabriel.myroute.service.singnUp;
import com.gabriel.myroute.entity.User;
import com.gabriel.myroute.repository.user.UserRepository;

public class SingnUpService {
    public boolean SingnUp(User user) {
        // verifica se o objeto e nullo
    	
        if (user == null) return false;
        
        UserRepository userRepository = new UserRepository();
        
        return userRepository.setUser(user);
    }
}
