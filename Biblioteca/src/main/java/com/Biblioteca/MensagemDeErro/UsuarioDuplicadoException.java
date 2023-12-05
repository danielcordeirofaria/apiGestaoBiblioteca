package com.Biblioteca.MensagemDeErro;

public class UsuarioDuplicadoException extends RuntimeException {
    public UsuarioDuplicadoException(String mensagem) {
        super(mensagem);
    }
}
