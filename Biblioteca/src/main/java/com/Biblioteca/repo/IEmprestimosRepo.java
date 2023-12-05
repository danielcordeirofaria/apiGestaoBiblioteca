package com.Biblioteca.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.Biblioteca.model.Emprestimos;
import com.Biblioteca.model.Livros;
import com.Biblioteca.model.Usuario;

@Repository
public interface IEmprestimosRepo extends JpaRepository<Emprestimos, Long> {
    List<Emprestimos> findByUsuario(Usuario idUsuario);
    List<Emprestimos> findByLivro(Livros idLivro);
}