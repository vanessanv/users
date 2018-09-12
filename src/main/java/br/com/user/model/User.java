package br.com.user.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="user")
public class User {

	@Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    private Integer id;

	@Column(name = "name", nullable = false)
    private String name;
    
	@Column(name = "cpf", nullable = false)
    private String cpf;

	@Column(name = "email", nullable = false)
    private String email;

	public User() {
		
	}
	public User(Integer id, String name, String cpf, String email) {
		this.id = id;
		this.name = name;
		this.cpf = cpf;
		this.email = email;
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}
	


	@Override
	public String toString() {
		return String.format(
				"User [id=%s, name=%s, email=%s, cpf=%s]", id,
				name, email, cpf);
	}
}
