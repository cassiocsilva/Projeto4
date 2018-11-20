package model;

public class Criptografar {
	
	public String criptografar(String texto) {
		int tamanhoTexto = texto.length();
		StringBuilder textoCriptografado = new StringBuilder();

		for (int c = 0; c < tamanhoTexto; c++) {

			int charCriptografado = ((int) texto.charAt(c)) + 3;

			while (charCriptografado > 126)
				charCriptografado -= 94;
			
			if (charCriptografado == 58){
				charCriptografado = 48;
			} else if (charCriptografado == 59){
				charCriptografado = 49;
			} else if (charCriptografado == 60){
				charCriptografado = 50;
			} else if (charCriptografado == 123){
				charCriptografado = 97;
			} else if (charCriptografado == 124){
				charCriptografado = 98;
			} else if (charCriptografado == 125){
				charCriptografado = 99;
			}

			textoCriptografado.append((char) charCriptografado);
		}
		
		return textoCriptografado.toString();
	}

}
