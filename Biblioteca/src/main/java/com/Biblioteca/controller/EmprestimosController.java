package com.Biblioteca.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Biblioteca.model.Emprestimos;
import com.Biblioteca.model.Livros;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.service.IEmprestimosService;

@RestController
public class EmprestimosController {
	
	@Autowired
    private IEmprestimosService service;
	
  
    @PostMapping("/emprestimos")
    public ResponseEntity<Emprestimos> criarEmprestimo(@RequestBody Emprestimos emprestimos) {	
    	Emprestimos emp = service.criarEmprestimo(emprestimos);
    	if(emp != null) {
    		return ResponseEntity.status(201).body(emp);
    	}else {
    		return ResponseEntity.badRequest().build();
    	}
    		
    }
    
    @GetMapping("/emprestimos")
    public List<Emprestimos> listarTudo(){
    	return service.recuperarTodos();
    }

    @GetMapping("/emprestimos/usuario{usuario}")
    public List<Emprestimos> findByUsuario(@PathVariable Usuario usuario){
    	return service.findByUsuario(usuario);
    }
    
    @GetMapping("/emprestimos/livros{livro}")
    public List<Emprestimos> findByLivro(@PathVariable Livros livro){
    	return service.findByLivro(livro);
    }
    
    @PutMapping("/emprestimos/{id}")
	public ResponseEntity<Emprestimos> atualizarDados(@PathVariable("id") Long id, @RequestBody Emprestimos emprestimos) {
    	Emprestimos emp = service.atualizarDados(id, emprestimos);
	    if (emp != null) {
	        return ResponseEntity.ok(emp);
	    }
	    return ResponseEntity.notFound().build();
	}
    
    
}
