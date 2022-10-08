
package ar.com.educacionit.domain;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;

@Entity
@Table(name = "users")
public class Users {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;
	
	@NotEmpty
	@Column(name = "password", length = 100, nullable=false)
	private String password;
	
	@NotEmpty
	@Column(name = "username", length = 100, nullable=false, unique=true)
	private String username;

	//roles del usuario
	@ManyToMany(fetch = FetchType.EAGER)
	@JoinTable(name="users_roles",
		joinColumns = @JoinColumn(name="users_id"),
		inverseJoinColumns = @JoinColumn(name="roles_id"))
	private Set<Roles> roles;
	
	@ManyToOne
	@JoinColumn(name = "users_category_id",referencedColumnName = "id")
	private UsersCategory category;
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public Set<Roles> getRoles() {
		return roles;
	}

	public UsersCategory getCategory() {
		return category;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public void setRoles(Set<Roles> roles) {
		this.roles = roles;
	}

	public void setCategory(UsersCategory category) {
		this.category = category;
	}

}