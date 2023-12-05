package com.Biblioteca.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "livros")
public class Livros {

	@Id
//	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id_livro", unique = true)
	private int idLivro;
	
	@Column(name = "titulo", nullable = false, length = 100)
	private String titulo;
	
	@Column(name = "data_adicionado_ao_acervo", nullable = false, length = 10)
	private String dataAdicionadoAoAcervo;
	
	@Column(name = "autor", nullable = false, length = 100)
	private String autor;
	
	@Column(name = "n_volume_ou_edicao", nullable = false, length = 100)
	private String nVolumeOuEdicao;
	
	@Column(name = "local_edicao", nullable = false, length = 100)
	private String localEdicao;
	
	@Column(name = "editora", nullable = true, length = 50)
	private String editora;
	
	@Column(name = "ano_da_edicao", nullable = false, length = 4)
	private String anoDaEdicao;
	
	@Column(name = "origem", nullable = false, length = 11)
	@Enumerated(EnumType.STRING)
	private OrigemEnum origem;
	
	@Column(name = "classificacao", nullable = true, length = 20)
	private String classificacao;
	
	@Column(name = "isbn", nullable = true, length = 17)
	private String isbn;
	
	@Column(name = "observacao", length = 144)
	private String observacao;
	
	@Column(name = "status", nullable = false, length = 10)
	@Enumerated(EnumType.STRING)
	private StatusEnum status;

	

	public Livros() {
		super();
	}

	public Livros(int idLivro, String titulo, String dataAdicionadoAoAcervo, String autor, String nVolumeOuEdicao,
			String localEdicao, String editora, String anoDaEdicao, OrigemEnum origem, String classificacao, String isbn, String observacao,
			StatusEnum status) {
		super();
		this.idLivro = idLivro;
		this.titulo = titulo;
		this.dataAdicionadoAoAcervo = dataAdicionadoAoAcervo;
		this.autor = autor;
		this.nVolumeOuEdicao = nVolumeOuEdicao;
		this.localEdicao = localEdicao;
		this.editora = editora;
		this.anoDaEdicao = anoDaEdicao;
		this.origem = origem;
		this.classificacao = classificacao;
		this.isbn = isbn;
		this.observacao = observacao;
		this.status = status;
	}






	public String getTitulo() {
		return titulo;
	}

	public int getIdLivro() {
		return idLivro;
	}

	public void setIdLivro(int l) {
	    this.idLivro = l;
	}
	
	public void setTitulo(String titulo) {
		this.titulo = titulo;
	}

	public String getDataAdicionadoAoAcervo() {
		return dataAdicionadoAoAcervo;
	}

	public void setDataAdicionadoAoAcervo(String dataAdicionadoAoAcervo) {
		this.dataAdicionadoAoAcervo = dataAdicionadoAoAcervo;
	}

	public String getAutor() {
		return autor;
	}

	public void setAutor(String autor) {
		this.autor = autor;
	}

	public String getnVolumeOuEdicao() {
		return nVolumeOuEdicao;
	}

	public void setnVolumeOuEdicao(String nVolumeOuEdicao) {
		this.nVolumeOuEdicao = nVolumeOuEdicao;
	}

	public String getLocalEdicao() {
		return localEdicao;
	}

	public void setLocalEdicao(String localEdicao) {
		this.localEdicao = localEdicao;
	}

	public String getEditora() {
		return editora;
	}

	public void setEditora(String editora) {
		this.editora = editora;
	}

	public String getAnoDaEdicao() {
		return anoDaEdicao;
	}

	public void setAnoDaEdicao(String anoDaEdicao) {
		this.anoDaEdicao = anoDaEdicao;
	}

	public OrigemEnum getOrigem() {
		return origem;
	}

	public void setOrigem(OrigemEnum origem) {
		this.origem = origem;
	}

	public String getClassificacao() {
		return classificacao;
	}

	public void setClassificacao(String classificacao) {
		this.classificacao = classificacao;
	}

	public String getIsbn() {
		return isbn;
	}

	public void setIsbn(String isbn) {
		this.isbn = isbn;
	}

	public String getObservacao() {
		return observacao;
	}

	public void setObservacao(String observacao) {
		this.observacao = observacao;
	}


	public StatusEnum getStatus() {
		return status;
	}


	public void setStatus(StatusEnum status) {
		this.status = status;
	}

	
	
	
	
}
