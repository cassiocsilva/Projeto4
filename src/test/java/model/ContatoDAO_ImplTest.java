package model;


import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

public class ContatoDAO_ImplTest {
		
	@Test public void CT67() throws IOException {
    	
		Contato c = new Contato();
		c.setNome("Contato um");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");
		
		String nome_arq_dados_c = "data_uTeste.txt";
        
        ContatoDAO_Impl classUnderTest = new ContatoDAO_Impl(nome_arq_dados_c);
        
        assertEquals("true",classUnderTest.inserir(c).getNome());        
    }
	
	@Test public void CT68() throws IOException {
    	
		Contato c = new Contato();
		c.setNome("Contato dois");
		c.setTelefone("12345678");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");
		
		String nome_arq_dados_c = "data_uTeste.txt";
        
        ContatoDAO_Impl classUnderTest = new ContatoDAO_Impl(nome_arq_dados_c);
        
        assertEquals("true",classUnderTest.inserir(c).getNome());        
    }
	
	@Test public void CT69() throws IOException {
		
		String nome_arq_dados_c = "data_uTeste.txt";
		String parteNome = "Um";
        
        ContatoDAO_Impl classUnderTest = new ContatoDAO_Impl(nome_arq_dados_c);
        
        assertNotNull(classUnderTest.buscarPorParteNome(parteNome));    
    }
	
	@Test public void CT70() throws IOException {
		
		Contato cAnt = new Contato();
		cAnt.setNome("Contato um");
		cAnt.setTelefone("12345678");
		cAnt.setEmail("c@c.com");
		cAnt.setEndereco("Endereço");
		
		Contato cAtual = new Contato();
		cAtual.setNome("Contato três");
		cAtual.setTelefone("12345678");
		cAtual.setEmail("c@c.com");
		cAtual.setEndereco("Endereço");
		
		String nome_arq_dados_c = "data_uTeste.txt";
        
        ContatoDAO_Impl classUnderTest = new ContatoDAO_Impl(nome_arq_dados_c);
        
        assertEquals("true",classUnderTest.atualizarContato(cAnt, cAtual).getNome());
	}
    
	@Test public void CT71() throws IOException {
		
		String nome_arq_dados_c = "data_uTeste.txt";
        
        ContatoDAO_Impl classUnderTest = new ContatoDAO_Impl(nome_arq_dados_c);
        
        assertNotNull(classUnderTest.listarTodosContatos());    
    }
	
	@Test public void CT72() throws IOException {
    	
		Contato c = new Contato();
		c.setNome("Contato dois");
		c.setTelefone("12345678");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");
		
		String nome_arq_dados_c = "data_uTeste.txt";
        
        ContatoDAO_Impl classUnderTest = new ContatoDAO_Impl(nome_arq_dados_c);
        
        assertEquals(true,classUnderTest.removerContato(c));        
    }
	
	@Test public void CT73() throws IOException {
    	
		Contato c = new Contato();
		c.setNome("Contato tres");
		c.setTelefone("12345678");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");
		
		String nome_arq_dados_c = "data_uTeste.txt";
        
        ContatoDAO_Impl classUnderTest = new ContatoDAO_Impl(nome_arq_dados_c);
        
        File arqDados = new File(nome_arq_dados_c);
        arqDados.deleteOnExit();
        
        assertEquals(true,classUnderTest.removerContato(c));
        
    }

}
