package com.Biblioteca.model;

import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "usuarios")
public class Usuario {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_usuario")
	private int idUsuario;
	
	@Column(name = "nome_usuario", length = 100, nullable = false)
	private String nomeUsuario;
	
	@Column(name = "email", length = 100, nullable = false)
	private String email;
	
	@Column(name = "telefone", length = 20, nullable = false) 
	private String telefone;
	
	@Column(name = "logradouro", length = 100, nullable = false)
	private String logradouro;
	
	@Column(name = "numero", length = 20)
	private String numero;
	
	@Column(name = "complemento", length = 20)
	private String complemento;
	
	@Column(name = "bairro", length = 100, nullable = false)
	private String bairro;
	
	@Column(name = "cidade", length = 100, nullable = false)
	private String cidade;
	
	@Column(name = "uf", length = 2, nullable = false)
	private String uf;
	
	@Column(name = "cep", length = 10, nullable = false)
	private String cep;
	
	@Column(name = "data_nascimento", length = 20, nullable = false)
	private String dataNascimento;
	
	@Column(name = "rg",  length = 20, nullable = false)
	private String rg;
	
	@Column(name = "profissao",  length = 20, nullable = false)
	private String profissao;
	
	@Column(name = "data_ultimo_emprestimo",  length = 20)
	private Date dataUltimoEmprestimo;
	
	@Column(name = "data_ultima_devolucao",  length = 20)
	private Date dataUltimaDevolucao;
	
	
	
	
	public Usuario(int idUsuario, String nomeUsuario, String email, String telefone, String logradouro, String numero,
			String complemento, String bairro, String cidade, String uf, String cep, String dataNascimento, String rg,
			String profissao, Date dataUltimoEmprestimo, Date dataUltimaDevolucao) {
		super();
		this.idUsuario = idUsuario;
		this.nomeUsuario = nomeUsuario;
		this.email = email;
		this.telefone = telefone;
		this.logradouro = logradouro;
		this.numero = numero;
		this.complemento = complemento;
		this.bairro = bairro;
		this.cidade = cidade;
		this.uf = uf;
		this.cep = cep;
		this.dataNascimento = dataNascimento;
		this.rg = rg;
		this.profissao = profissao;
		this.dataUltimoEmprestimo = dataUltimoEmprestimo;
		this.dataUltimaDevolucao = dataUltimaDevolucao;
	}

	public Usuario(int idUsuario) {
		super();
		this.idUsuario = idUsuario;
		
	}
	
	public Usuario() {
		super();
	}



	public String getDataNascimento() {
		return dataNascimento;
	}

	
	
	public Date getDataUltimoEmprestimo() {
		return dataUltimoEmprestimo;
	}



	public void setDataUltimoEmprestimo(Date dataUltimoEmprestimo) {
		this.dataUltimoEmprestimo = dataUltimoEmprestimo;
	}



	public Date getDataUltimaDevolucao() {
		return dataUltimaDevolucao;
	}



	public void setDataUltimaDevolucao(Date dataUltimaDevolucao) {
		this.dataUltimaDevolucao = dataUltimaDevolucao;
	}



	public void setDataNascimento(String dataNascimento) {
		this.dataNascimento = dataNascimento;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public String getProfissao() {
		return profissao;
	}

	public void setProfissao(String profissao) {
		this.profissao = profissao;
	}

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNomeUsuario() {
		return nomeUsuario;
	}

	public void setNomeUsuario(String nomeUsuario) {
		this.nomeUsuario = nomeUsuario;
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

	public String getLogradouro() {
		return logradouro;
	}

	public void setLogradouro(String logradouro) {
		this.logradouro = logradouro;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getComplemento() {
		return complemento;
	}

	public void setComplemento(String complemento) {
		this.complemento = complemento;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}

	public String getCidade() {
		return cidade;
	}

	public void setCidade(String cidade) {
		this.cidade = cidade;
	}

	public String getUf() {
		return uf;
	}

	public void setUf(String uf) {
		this.uf = uf;
	}

	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}
	
	
	
}
