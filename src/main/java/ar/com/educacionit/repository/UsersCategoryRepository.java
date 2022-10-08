
package ar.com.educacionit.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ar.com.educacionit.domain.Users;
import ar.com.educacionit.domain.UsersCategory;

@Repository
public interface UsersCategoryRepository extends JpaRepository<UsersCategory, Long>{ //EX DAO

		
}