
package ar.com.educacionit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.repository.UsersRepository;

@Service
public class UsersService {

	//D.I
	@Autowired
	private UsersRepository repository;

	public List<Users> buscarTodos() {
		return this.repository.findAll();
	}

	/*
	 * https://www.baeldung.com/spring-data-derived-queries
	 **/
	public Users buscarPorNombreDeUsuario(String username) {
		return this.repository.findByUsername(username);
	}
	
	
}