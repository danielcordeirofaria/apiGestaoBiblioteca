package com.Biblioteca.model;

//import java.time.LocalDate;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;

@Entity
@Table(name = "emprestimos")
public class Emprestimos {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long idEmprestimo;

    @ManyToOne
    @JoinColumn(name = "id_usuario")
    private Usuario usuario;

    @ManyToOne
    @JoinColumn(name = "id_livro", nullable = false)
    private Livros livro;

    @Column(name = "data_emprestimo", nullable = false )
    private String dataEmprestimo;
    
    @Column(name = "data_devolucao_prevista", nullable = false)
    private String dataDevolucaoPrevista;
    
    @Column(name = "data_devolucao_real")
    private String dataDevolucaoReal;

	public Emprestimos(Long idEmprestimo, Usuario idUsuario, Livros idLivro, String dataEmprestimo, String dataDevolucao, String dataDevolucaoReal) {
		super();
		this.idEmprestimo = idEmprestimo;
		this.usuario = idUsuario;
		this.livro = idLivro;
		this.dataEmprestimo = dataEmprestimo;
		this.dataDevolucaoPrevista = dataDevolucao;
		this.dataDevolucaoReal = dataDevolucaoReal;

	}
	
	
	public Emprestimos() {
		
	}

	public Long getIdEmprestimo() {
		return idEmprestimo;
	}

	public void setIdEmprestimo(Long idEmprestimo) {
		this.idEmprestimo = idEmprestimo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public Livros getLivro() {
		return livro;
	}

	public void setLivro(Livros livro) {
		this.livro = livro ;
	}

	public String getDataEmprestimo() {
		return dataEmprestimo;
	}

	public void setDataEmprestimo(String dataEmprestimo) {
		this.dataEmprestimo = dataEmprestimo;
	}

	
	public String getDataDevolucaoPrevista() {
		return dataDevolucaoPrevista;
	}


	public void setDataDevolucaoPrevista(String dataDevolucaoPrevista) {
		this.dataDevolucaoPrevista = dataDevolucaoPrevista;
	}


	public String getDataDevolucaoReal() {
		return dataDevolucaoReal;
	}


	public void setDataDevolucaoReal(String dataDevolucaoReal) {
		this.dataDevolucaoReal = dataDevolucaoReal;
	}


	@Override
	public String toString() {
		return "Emprestimos [id=" + idEmprestimo + ", usuario=" + usuario.getIdUsuario() + ", livro=" + livro.getIdLivro() + ", dataEmprestimo="
				+ dataEmprestimo + ", dataDevolucaoPrevista=" + dataDevolucaoPrevista + ", dataDevolucaoReal="
				+ dataDevolucaoReal + "]";
	}

	

}