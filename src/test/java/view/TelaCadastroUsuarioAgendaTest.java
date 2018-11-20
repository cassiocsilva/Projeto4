package view;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;

import model.Criptografar;
import model.ServicoUsuarioImpl;
import model.Usuario;

public class TelaCadastroUsuarioAgendaTest {
	
	@Test
	public void CT150() throws IOException {
		
		TelaCadastroUsuarioAgenda tl = new TelaCadastroUsuarioAgenda();
		TelaCadastroUsuarioAgenda.jTextField1.setText("NomeValidoAAAAA");
		TelaCadastroUsuarioAgenda.jTextField3.setText("11111");
		TelaCadastroUsuarioAgenda.jTextField2.setText("11111");
		TelaCadastroUsuarioAgenda.jButton1.doClick();

		Usuario u = new Usuario();
		u.setNomeUsuario("NomeValidoAAAAA");
		u.setSenha("11111");
		
		ServicoUsuarioImpl sui = new ServicoUsuarioImpl("users.txt");
		
		Criptografar criptografa = new Criptografar();
		String nomeCriptografado = criptografa.criptografar(u.getNomeUsuario().toLowerCase());
        
        assertEquals(nomeCriptografado,sui.buscarPorNomeUsuario(u.getNomeUsuario()).getNomeUsuario());
		
		sui.removerUsuario(u);
		File f = new File("users.txt");
		f.delete();
	}
}
