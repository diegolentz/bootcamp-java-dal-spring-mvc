
package ar.com.educacionit.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ar.com.educacionit.domain.Cupon;
import ar.com.educacionit.repository.CuponRepository;

@Service
public class CuponService {

	//D.I
	@Autowired
	private CuponRepository repository;

	public List<Cupon> buscarTodos() {
		return this.repository.findAll();
	}

	public void eliminar(Long id) {
		this.repository.deleteById(id);		
	}

	public Cupon buscar(Long id) {
		Optional<Cupon> entity = this.repository.findById(id);
		if(entity.isPresent()) {
			return entity.get();
		}else {
			return null;
		}
	}
}