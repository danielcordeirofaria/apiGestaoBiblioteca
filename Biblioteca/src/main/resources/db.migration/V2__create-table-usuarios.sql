CREATE TABLE usuarios (
    id_usuario INT AUTO_INCREMENT PRIMARY KEY,
    nome_usuario VARCHAR(100) NOT NULL,
    email VARCHAR(100) NOT NULL,
    telefone VARCHAR(20) NOT NULL,
    logradouro VARCHAR(100) NOT NULL,
    numero VARCHAR(20),
    complemento VARCHAR(20),
    bairro VARCHAR(100) NOT NULL,
    cidade VARCHAR(100) NOT NULL,
    uf VARCHAR(2) NOT NULL,
    cep VARCHAR(10) NOT NULL,
    data_nascimento VARCHAR(20) NOT NULL,
    rg VARCHAR(20) NOT NULL,
    profissao VARCHAR(20) NOT NULL,
	data_ultimo_emprestimo STRING VARCHAR(20), 
	data_ultima_devolucao  STRING VARCHAR(20)
);
