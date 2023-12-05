package com.Biblioteca.model;
import java.io.File;
import java.io.FileInputStream;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;

public class LeituraArquivoExcel {
	public void lerArquivoXLS(String filePath) {
        try {
            // Carrega o arquivo .xls
            File arquivo = new File(filePath);
            FileInputStream fis = new FileInputStream(arquivo);
            Workbook workbook = new HSSFWorkbook(fis);

            // Obtém a primeira planilha do arquivo
            Sheet sheet = workbook.getSheetAt(0);
            System.out.println(sheet);
            // Faça o processamento necessário com a planilha...

            // Fecha o arquivo
            workbook.close();
            fis.close();

            System.out.println("Arquivo .xls lido com sucesso!");
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
