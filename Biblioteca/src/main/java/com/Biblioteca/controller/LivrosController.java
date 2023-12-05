package com.Biblioteca.controller;

import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.multipart.MultipartFile;

import com.Biblioteca.MensagemDeErro.MensagemErro;
import com.Biblioteca.model.Livros;
import com.Biblioteca.model.OrigemEnum;
import com.Biblioteca.model.StatusEnum;
import com.Biblioteca.service.ILivrosService;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Date;

import javax.xml.crypto.Data;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class LivrosController {

	@Autowired
	private ILivrosService service;

	@GetMapping("/livros")
	public ArrayList<Livros> recuperarTodos() {
		ArrayList<Livros> lista;
		lista = service.recuperarTodos();
		return lista;
	}

	@GetMapping("/livros/{codigo}")
	public ResponseEntity<Livros> recuperarPeloCodigo(@PathVariable int codigo) {
		Livros l = service.recuperarPeloCodigo(codigo);
		if (l != null) {
			return ResponseEntity.ok(l);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/livros/isbn{isbn}")
	public ResponseEntity<ArrayList<Livros>> recuperarPeloIsbn(@PathVariable String isbn) {
		ArrayList<Livros> lista = service.recuperarPeloIsbn(isbn);
		if (lista != null) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.notFound().build();
	}

	@PostMapping("/livros")
	public ResponseEntity<String> adicionarNovoLivro(@RequestBody Livros livro) {
		try {
			Livros res = service.adicionarNovoLivro(livro);

			if (res != null) {
				return ResponseEntity.status(201)
						.body("Cadastro Realizado\n Id: " + res.getIdLivro() + " Título: " + res.getTitulo());
			}
			return ResponseEntity.badRequest().body("Não foi possível fazer o cadastro");

		} catch (Exception ex) {
			return ResponseEntity.badRequest().body(ex.getMessage());
		}
	}

	@PutMapping("/livros/{id}")
	public ResponseEntity<Livros> atualizarDados(@PathVariable("id") int id, @RequestBody Livros l) {
		Livros res = service.atualizarDados(id, l);
		if (res != null) {
			return ResponseEntity.ok(res);
		}
		return ResponseEntity.notFound().build();
	}

	@GetMapping("/livros/busca")
	public ResponseEntity<?> buscaPorNome(@RequestParam(name = "palavra") String palavra) {
		ArrayList<Livros> lista = service.recuperarPeloNome(palavra);
		if (lista.size() > 0) {
			return ResponseEntity.ok(lista);
		}
		return ResponseEntity.status(404).body(new MensagemErro(9876, "Criterio de busca não foi satisfeito"));
	}

//  

	@PostMapping("/livros/upload")
	public ResponseEntity<?> realizarUploadDeLivros(@RequestParam(name = "arquivo") MultipartFile arquivo) {
		try {
			// Cria uma instância do Workbook para ler o arquivo .xlsx
			Workbook workbook = WorkbookFactory.create(arquivo.getInputStream());

			// Obtém a primeira planilha do arquivo
			org.apache.poi.ss.usermodel.Sheet sheet = workbook.getSheetAt(0);

			// Lista para armazenar os livros a serem adicionados
			ArrayList<Livros> lista = new ArrayList<>();

			// Itera pelas linhas da planilha (ignorando a primeira linha que contém os
			// cabeçalhos)
			for (int rowIndex = 1; rowIndex <= sheet.getLastRowNum(); rowIndex++) {
				Row row = sheet.getRow(rowIndex);
				if (row != null) {
					Livros l = new Livros();

					// Verifica o tipo de célula da coluna "idLivro"

					if (row.getCell(0).getCellType() == CellType.NUMERIC) {
						l.setIdLivro((int) row.getCell(0).getNumericCellValue()); // Converte o valor numérico para
																					// inteiro
					} else {
						throw new IllegalStateException("A célula da coluna 'idLivro' deve ser numérica.");
					}

					// Verifica o tipo de célula da coluna "dataAdicionadoAoAcervo"

					if (row.getCell(1).getCellType() == CellType.NUMERIC) {
						LocalDate dataBaseExcel = LocalDate.of(1900, 1, 1);
						LocalDate dataConvertida = dataBaseExcel
								.plusDays((long) row.getCell(1).getNumericCellValue() - 2);
						String dataFormatada = dataConvertida.getDayOfMonth() + "/" + dataConvertida.getMonthValue()
								+ "/" + dataConvertida.getYear();

						l.setDataAdicionadoAoAcervo(dataFormatada);

					} else if (row.getCell(1).getCellType() == CellType.BLANK) {
						Date data = new Date();
						SimpleDateFormat formatoData = new SimpleDateFormat("dd/MM/yyyy");
						String dataFormatada = formatoData.format(data);
						l.setDataAdicionadoAoAcervo(dataFormatada);

					} else {
						throw new IllegalStateException(
								"A célula da coluna 'dataAdicionadoAoAcervo' deve ser uma string.");
					}

					// Verifica o tipo de célula da coluna "autor"

					if (row.getCell(2).getCellType() == CellType.STRING) {
						String valorCelula = row.getCell(2).getStringCellValue().trim(); // Remove espaços em branco
						if (!valorCelula.isEmpty()) {
							l.setAutor(valorCelula);
						} else {
							l.setAutor("Sem autor declarado");
						}
					} else if (row.getCell(2).getCellType() == CellType.BLANK) {
						l.setAutor("Sem autor declarado");
					} else {
						throw new IllegalStateException(
								"A célula da coluna 'autor' deve ser uma string ou está vazia. " + l.getIdLivro());
					}

					// Verifica o tipo de célula da coluna "titulo"

					if (row.getCell(3).getCellType() == CellType.STRING) {
						l.setTitulo(row.getCell(3).getStringCellValue());
					} else if (row.getCell(3).getCellType() == CellType.BLANK) {
						l.setTitulo("Sem Autor");
					} else if (row.getCell(3).getCellType() == CellType.NUMERIC) {
						Double doubleValue = row.getCell(4).getNumericCellValue();
						String stringValue = Double.toString(doubleValue);
						l.setTitulo(stringValue);
					} else {
						throw new IllegalStateException(
								"A célula da coluna 'titulo' deve ser uma string. " + l.getIdLivro());
					}

					// Verifica o tipo de célula da coluna "nVolumeOuEdicao"

					if (row.getCell(4).getCellType() == CellType.NUMERIC) {
						int intValue = (int) row.getCell(4).getNumericCellValue();

						// Faça o que você precisa com o valor numérico aqui
						// Por exemplo, você pode convertê-lo em uma string:
						String stringValue = Integer.toString(intValue);
						l.setnVolumeOuEdicao(stringValue);
//	                    l.setnVolumeOuEdicao(row.getCell(4).getStringCellValue());
					} else {
						throw new IllegalStateException(
								"A célula da coluna 'nVolumeOuEdicao' deve ser uma string." + l.getIdLivro());
					}

					// Verifica o tipo de célula da coluna "localEdicao"

					if (row.getCell(5).getCellType() == CellType.STRING) {
						String stringValue = row.getCell(5).getStringCellValue();
						l.setLocalEdicao(stringValue);
					} else if (row.getCell(5).getCellType() == CellType.BLANK) {
						l.setLocalEdicao("Local da Edição não informado");
					} else {
						throw new IllegalStateException(
								"A célula da coluna 'localEdicao' deve ser uma string." + l.getIdLivro());
					}

					// Verifica o nome da editora
					if (row.getCell(6).getCellType() == CellType.STRING) {
						String stringValue = row.getCell(6).getStringCellValue();
						l.setEditora(stringValue);
					} else if (row.getCell(6) == null || row.getCell(6).getCellType() == CellType.BLANK) {
						l.setEditora("Editora não informada");

					} else {
						throw new IllegalStateException(
								"A célula da coluna 'Editora' deve ser uma string." + l.getIdLivro());
					}

					// Verifica o tipo de célula da coluna "anoDaEdicao"

					if (row.getCell(7).getCellType() == CellType.NUMERIC) {
						double numericValue = row.getCell(7).getNumericCellValue();
						int intValue = (int) numericValue;
						l.setAnoDaEdicao(Integer.toString(intValue));
					} else if (row.getCell(7).getCellType() == CellType.STRING) {
						String stringValue = row.getCell(7).getStringCellValue();
						l.setAnoDaEdicao(stringValue);
					} else if (row.getCell(7).getCellType() == CellType.BLANK) {
//						String stringValue = row.getCell(7).getStringCellValue();
						String stringValue = "Ano não declarado";
						l.setAnoDaEdicao(stringValue);
					} else {
						throw new IllegalStateException("A célula da coluna 'anoDaEdicao' deve ser uma string.");
					}
//				
					// Verifica o tipo de célula da coluna "isbn"

					if (row.getCell(8).getCellType() == CellType.STRING) {
						String stringValue = row.getCell(8).getStringCellValue();

//						l.setIsbn(Integer.parseInt(stringValue));
						l.setIsbn(stringValue);
					} else if (row.getCell(8).getCellType() == CellType.NUMERIC) {
						int intValue = (int) row.getCell(8).getNumericCellValue();

						l.setIsbn(Integer.toString(intValue));
					} else if (row.getCell(8).getCellType() == CellType.BLANK) {
						l.setIsbn("Sem ISBN");

					}

					else {
						throw new IllegalStateException(
								"A célula da coluna 'isbn' deve ser uma string. " + l.getIdLivro());
					}

					if (row.getCell(9).getCellType() == CellType.BLANK) {
						String origemValue = row.getCell(9).getStringCellValue();
						if (origemValue.isEmpty()) {
							l.setOrigem(OrigemEnum.NAODEFINIDO); // Define o valor padrão como NAODEFINIDO
						} else {
							// Verifica se o valor lido corresponde a algum valor do enum OrigemEnum
							try {
								OrigemEnum origemEnum = OrigemEnum.valueOf(origemValue);
								l.setOrigem(origemEnum);
							} catch (IllegalArgumentException e) {
								// Valor não reconhecido, definir como "Desconhecido" ou lançar uma exceção, se
								// preferir
								l.setOrigem(OrigemEnum.NAODEFINIDO);
							}
						}
					} else {
						throw new IllegalStateException("A célula da coluna 'origem' deve ser uma string.");
					}

					// Verifica o tipo de célula da coluna "classificacao"
					if (row.getCell(10).getCellType() == CellType.STRING) {
						l.setClassificacao(row.getCell(10).getStringCellValue());
					} else if (row.getCell(10).getCellType() == CellType.NUMERIC) {
						double numericValue = row.getCell(10).getNumericCellValue();
						String stringValue = Double.toString(numericValue);
						l.setClassificacao(stringValue);
					} else if (row.getCell(10).getCellType() == CellType.BLANK) {
						l.setClassificacao(""); // Se a célula estiver em branco, defina a classificação como uma string
												// vazia
					} else {
						throw new IllegalStateException(
								"A célula da coluna 'classificacao' deve ser uma string, numérica ou estar em branco.");
					}

					if (row.getCell(13).getCellType() == CellType.STRING) {
						String origemValue = row.getCell(13).getStringCellValue();
						if ("ATIVO".equals(origemValue)) {
							l.setStatus(StatusEnum.ATIVO);
						} else {
//							if ("INATIVO".equals(origemValue)) {
							l.setStatus(StatusEnum.INATIVO);
//				
						}
					} else {
						throw new IllegalStateException(
								"A célula da coluna 'Status' deve ser um StatusEnum. " + l.getIdLivro());
					}

					lista.add(l);
				}
			}

			// Salva todos os livros na lista no serviço
			service.saveAll(lista);

			// Fecha o workbook para liberar recursos
			workbook.close();

			return ResponseEntity.ok("Upload realizado!");
		} catch (Exception ex) {
			ex.printStackTrace();
			return ResponseEntity.badRequest().build();
		}
	}

//	private Long parseInt(String string) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
