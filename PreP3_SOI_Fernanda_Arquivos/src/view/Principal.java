package view;

import java.io.IOException;
import controller.UniversidadesController;


public class Principal {
	
	public static void main(String[] args) throws IOException {
		UniversidadesController universidades = new UniversidadesController();  
		universidades.buscaUniversidade();
	}
}
		
	

