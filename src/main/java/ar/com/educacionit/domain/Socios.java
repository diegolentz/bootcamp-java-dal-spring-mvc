
package ar.com.educacionit.domain;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;

/*
 * MAPEO DE ENTIDADES CON HIBERNATE
 */
/*
 * 
 JPA: java persistence api (muchas interfaces)
 Hibernate: implementacion de JPA
 @Entity > es una entidad: representa tabla: DEBEN tener un id=PK
 @Table: indicar el nombre de la tabla
*/
@Entity
@Table(name = "socios")
//@Data
//@AllArgsConstructor
public class Socios {

	@Id
	//la clave en la db: es AUTOINCREMENT
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	//pk compusta (vemos mas adelante)
	
	@Column(nullable = false,length = 50, name="apellido")
	private String apellido;
	
	@Column(nullable = false,length = 60)
	private String nombre;
	
	@Column(nullable = false,length = 6,unique = true)
	private String codigo;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getCodigo() {
		return codigo;
	}

	public void setCodigo(String codigo) {
		this.codigo = codigo;
	}
	
}