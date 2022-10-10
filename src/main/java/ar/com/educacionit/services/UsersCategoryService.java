
package ar.com.educacionit.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.domain.UsersCategory;
import ar.com.educacionit.repository.UsersCategoryRepository;
import ar.com.educacionit.repository.UsersRepository;

@Service
public class UsersCategoryService {

	
	@Autowired
	private UsersCategoryRepository repository;

	public List<UsersCategory> buscarTodos() {
		return this.repository.findAll();
	}
		
}
	
	