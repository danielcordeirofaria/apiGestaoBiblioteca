CREATE TABLE livros (
    id_livro INT AUTO_INCREMENT PRIMARY KEY,
    titulo VARCHAR(100) NOT NULL,
    data_adicionado_ao_acervo VARCHAR(10) NOT NULL,
    autor VARCHAR(100) NOT NULL,
    n_volume_ou_edicao VARCHAR(100) NOT NULL,
    local_edicao VARCHAR(100) NOT NULL,
    editora VARCHAR(50),
    ano_da_edicao VARCHAR(4) NOT NULL,
    origem VARCHAR(11) NOT NULL,
    classificacao VARCHAR(20),
    isbn VARCHAR(17),
    observacao VARCHAR(144),
    status VARCHAR(10) NOT NULL
);

ALTER TABLE livros
    ADD CONSTRAINT check_origem
    CHECK (origem IN ('DOACAO', 'COMPRA', 'NAODEFINIDO'));

ALTER TABLE livros
    ADD CONSTRAINT check_status
    CHECK (status IN ('ATIVO', 'INATIVO'));
