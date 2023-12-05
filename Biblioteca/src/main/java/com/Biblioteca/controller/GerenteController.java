package com.Biblioteca.controller;

import java.util.ArrayList;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.Biblioteca.MensagemDeErro.GerenteDuplicadoException;
import com.Biblioteca.MensagemDeErro.MensagemErro;
import com.Biblioteca.MensagemDeErro.UsuarioDuplicadoException;
import com.Biblioteca.model.Gerente;
import com.Biblioteca.model.Usuario;
import com.Biblioteca.service.IEmprestimosService;
import com.Biblioteca.service.GerenteServiceImpl;

//@RestController
//public class GerenteController {
//	
//	@Autowired
//    private GerenteServiceImpl service;
//	
//	
//	@GetMapping("/gerentes")
//	public ArrayList<Gerente> recuperarTodos() {
//		return service.recuperarTodos();
//	}
//
//	@GetMapping("/gerentes/{id}")
//	public ResponseEntity<?> recuperarPeloId(@PathVariable int id) {
//		Gerente g = service.recuperarPeloId(id);
//		if (g != null) {
//			return ResponseEntity.ok(g.getIdGerente() + "-" + g.getNomeGerente() + ": " + g.getUsername());
//		}
//		return ResponseEntity.status(404).body(new MensagemErro(404, "Gerente não existe."));
//
//	}
//
//	@PostMapping("/gerentes")
//	public ResponseEntity<?> cadastrarGerente(@RequestBody Gerente g) {
//		try {
//			Gerente res = service.cadastrarGerente(g);
//			return ResponseEntity.status(201).body(
//					res.getIdGerente() + "- " + res.getNomeGerente() + " Cadastrado"
//					);
//		} catch (GerenteDuplicadoException ex) {
//			return ResponseEntity.status(400).body(new MensagemErro(400, ex.getMessage()));
//		}
//	}
//
//	@PutMapping("/gerentes/{id}")
//	public ResponseEntity<Gerente> atualizarDados(@PathVariable("id") int id, @RequestBody Gerente g) {
//		Gerente res = service.atualizarDados(id, g);
//		if (res != null) {
//			return ResponseEntity.status(201).body(res);
//		}
//		return ResponseEntity.notFound().build();
//	}
//
//}


@RestController
public class GerenteController {

    @Autowired
    private GerenteServiceImpl service;

    @GetMapping("/gerentes")
    public ResponseEntity<ArrayList<Gerente>> recuperarTodos() {
        ArrayList<Gerente> gerentes = service.recuperarTodos();
        return ResponseEntity.ok(gerentes);
    }

    @GetMapping("/gerentes/{id}")
    public ResponseEntity<?> recuperarPeloId(@PathVariable int id) {
        Gerente g = service.recuperarPeloId(id);
        if (g != null) {
            return ResponseEntity.ok(g);
        }
        return ResponseEntity.status(404).body(new MensagemErro(404, "Gerente não existe."));
    }

    @PostMapping("/gerentes")
    public ResponseEntity<?> cadastrarGerente(@RequestBody Gerente g) {
        try {
            Gerente res = service.cadastrarGerente(g);
            return ResponseEntity.status(201).body(res);
        } catch (GerenteDuplicadoException ex) {
            return ResponseEntity.status(400).body(new MensagemErro(400, ex.getMessage()));
        }
    }

    @PutMapping("/gerentes/{id}")
    public ResponseEntity<Gerente> atualizarDados(@PathVariable("id") int id, @RequestBody Gerente g) {
        Gerente res = service.atualizarDados(id, g);
        if (res != null) {
            return ResponseEntity.status(201).body(res);
        }
        return ResponseEntity.notFound().build();
    }
}
