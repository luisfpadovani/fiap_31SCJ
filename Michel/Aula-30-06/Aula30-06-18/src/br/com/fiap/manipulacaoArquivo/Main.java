package br.com.fiap.manipulacaoArquivo;

import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class Main {

	public static void main(String[] args) {
		try {
			Path path = Paths.get("C:\\Windows");
			Path pathDestino = Paths.get("C:\\Temp");					 
			Files.walkFileTree(path, new LerArquivoRecursivamente(pathDestino));
			
			ListarArquivos list = new ListarArquivos(".exe", path);
			list.ListarArquivos();
			
		} catch (Exception e) {
			System.out.println(e);
		}
	}

}
