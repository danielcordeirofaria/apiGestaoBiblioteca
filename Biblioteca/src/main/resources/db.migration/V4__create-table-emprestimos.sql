CREATE TABLE emprestimos (
    idEmprestimo INT AUTO_INCREMENT PRIMARY KEY,
    id_usuario INT NOT NULL,
    id_livro INT NOT NULL,
    data_emprestimo VARCHAR(255) NOT NULL,
    data_devolucao_prevista VARCHAR(255) NOT NULL,
    data_devolucao_real VARCHAR(255)
);

ALTER TABLE emprestimos
    ADD CONSTRAINT fk_usuario
    FOREIGN KEY (id_usuario)
    REFERENCES usuario(idUsuario);

ALTER TABLE emprestimos
    ADD CONSTRAINT fk_livro
    FOREIGN KEY (id_livro)
    REFERENCES livros(idLivro);
