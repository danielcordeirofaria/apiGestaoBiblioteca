#apiGestaoBiblioteca
Essa API é desenvolvida para manter uma banco de dados local em H2.

Regegistro de novos usuários: tipo de endipoint: post Endpoint: "/usuarios" Jason:

{ "nomeUsuario": "string", (length = 100, nullable = false) "email": "string", (length = 100, nullable = false) "telefone": "string", (length = 20, nullable = false) "logradouro": "string", (length = 100, nullable = false)) "numero": "string", (length = 20) "complemento": "string", ( length = 100) "bairro": "string", (length = 100, nullable = false) "cidade": "string, (length = 100, nullable = false) "uf": "string, (length = 2, nullable = false) "cep": "string, (length = 9, nullable = false) "dataNascimento": "string, (nullable = false) "rg": "string, (length = 20, nullable = false) "dataUltimoEmprestimo": "Date, "dataUltimaDevolucao": "Date
}

*O email e Rg não pode ser repetido

Alteração de dados de determinado usuário Tipo de endipoint: Put: Endpoint: "/usuarios/{id}"

Você somente precisa alterar os dados que precisam ser alterados

Registro de novos Livros: Primeiramente, faça o upload através do arquivo xls padrão O end point é "/livros/upload"

Para fazer um registro de um livro novo após o lançamento em lote: end point: "/livros" tipo do end point: post json: { "titulo": "string", (nullable = false, length = 100) "dataAdicionadoAoAcervo": "string", (nullable = false, length = 100) "autor": "string", (nullable = false, length = 100) "nVolumeOuEdicao": "String", (nullable = false, length = 100) "localEdicao": "String", (nullable = false, length = 100) "editora": "String", (nullable = true, length = 50) "anoDaEdicao": "String", (nullable = false, length = 100) "origem": "NAODEFINIDO", "DOACAO" ou "COMPRA", (nullable = false) "classificacao": "String", (nullable = true, length = 20) "isbn": "String", (nullable = true, length = 17) "observacao": String, (length = 144) "status": "ATIVO" ou "INTAIVO", (nullable = false) }
