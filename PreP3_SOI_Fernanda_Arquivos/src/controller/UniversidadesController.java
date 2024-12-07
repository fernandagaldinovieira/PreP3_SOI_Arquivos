package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;

public class UniversidadesController {

	public void buscaUniversidade() throws IOException {
		String sistema = System.getProperty("os.name").toLowerCase();
		String path = null;
        
		if (sistema.contains("win")) {
			path = "C:" + File.separator + "TEMP";
		} else if (sistema.contains("nix") || sistema.contains("nux")){
			path = File.separator + "tmp";
		}

		File arquivo = new File(path, "hol.json");
		if (arquivo.exists() && arquivo.isFile()) {
			FileInputStream fileInputStream = new FileInputStream(arquivo);
			InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream);
			BufferedReader bufferedReader = new BufferedReader(inputStreamReader);
			String linha = bufferedReader.readLine();
				
				
			String[] vetUniversidades = linha.split("}");
			int tamanhoTotal = vetUniversidades.length;
				
			for(int i = 0; i < tamanhoTotal - 1; i++) {
				String[] vetAtributosUniversidade = vetUniversidades[i].split(",");
				int tamanho = vetAtributosUniversidade.length;
						
				for(int j = 0; j < tamanho - 1; j++) {
					if (vetAtributosUniversidade[j].contains("name")) {
						String nome = vetAtributosUniversidade[j].substring(vetAtributosUniversidade[j].indexOf(":") + 1).replace("\"", "").trim();
						System.out.println(i + 1);
						System.out.println("Nome: " + nome);
					}
						
					if (vetAtributosUniversidade[j].contains("page")) {
						String website = vetAtributosUniversidade[j].substring(vetAtributosUniversidade[j].indexOf("[") + 1).replace("\"", "").replace("]", "").trim();
						System.out.println("Website: " + website + "\n");
					}
				}
			}
					
			bufferedReader.close();
			fileInputStream.close();
			inputStreamReader.close();
		}
	}
}