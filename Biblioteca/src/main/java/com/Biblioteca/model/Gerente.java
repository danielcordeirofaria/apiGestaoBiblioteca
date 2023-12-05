package com.Biblioteca.model;

import java.util.Collection;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;


@Table(name = "gerente")
@Entity(name = "gerente")
//@EqualsAndHashCode(of = "id")
public class Gerente implements UserDetails {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_gerente")
	private int idGerente;

	@Column(name = "nome_gerente", length = 100, nullable = false, unique = true)
	private String nomeGerente;

	@Column(name = "login", length = 20, nullable = false, unique = true)
	private String login;

	@Column(name = "password", length = 100, nullable = false)
	private String password;

	@Column(name = "email", length = 100, nullable = false, unique = true)
	private String email;

	@Column(name = "telefone", length = 20, nullable = false)
	private String telefone;

	public Gerente(int idGerente, String nomeGerente, String login, String email, String telefone, String password) {
		super();
		this.idGerente = idGerente;
		this.nomeGerente = nomeGerente;
		this.login = login;
		this.email = email;
		this.telefone = telefone;
		this.password = password;
	}

	public Gerente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public int getIdGerente() {
		return idGerente;
	}

	public void setIdGerente(int idGerente) {
		this.idGerente = idGerente;
	}

	public String getNomeGerente() {
		return nomeGerente;
	}

	public void setNomeGerente(String nomeGerente) {
		this.nomeGerente = nomeGerente;
	}

	public void SetUserName(String login) {
		this.login = login;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getTelefone() {
		return telefone;
	}

	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Override
	public Collection<? extends GrantedAuthority> getAuthorities() {

		return null;
	}

	@Override
	public String getPassword() {
		// TODO Auto-generated method stub
		return password;
	}

	public String getLogin() {
		return login;
	}

	public void setLogin(String login) {
		this.login = login;
	}

	@Override
	public boolean isAccountNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isAccountNonLocked() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isCredentialsNonExpired() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public boolean isEnabled() {
		// TODO Auto-generated method stub
		return true;
	}

	@Override
	public String getUsername() {
		// TODO Auto-generated method stub
		return login;
	}

}