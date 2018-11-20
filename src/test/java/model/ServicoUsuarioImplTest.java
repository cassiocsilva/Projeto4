package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class ServicoUsuarioImplTest {
    
	
    // TESTES CT09 A CT24 REFERENTES AO M�TODO: Usuario inserir(Usuario u)
    
    @Test public void CT09() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("");
		u.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Insira Nome de Usu�rio",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT10() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("12345");
		u.setSenha("");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Insira Senha de Usu�rio",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT11() throws IOException {

		Usuario u = new Usuario();
		u.setNomeUsuario("1234");
		u.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome com menos de 5 caracteres",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT12() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("1234567890123456");
		u.setSenha("22222");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome com mais de 15 caracteres",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT13() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("nome!=");
		u.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome cont�m caracter especial ou espa�o",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT14() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("nome nome");
		u.setSenha("22222");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome cont�m caracter especial ou espa�o",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT15() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("12345");
		u.setSenha("1234");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha com menos de 5 caracteres",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT16() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("12345");
		u.setSenha("1234567890123456");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha com mais de 15 caracteres",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT17() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("12345");
		u.setSenha("senha!=");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha cont�m caracter especial ou espa�o",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT18() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("12345");
		u.setSenha("senha senha");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha cont�m caracter especial ou espa�o",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT19() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("S�oJos�");
		u.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome cont�m acento(s)",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT20() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("12345");
		u.setSenha("S�oJos�");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha cont�m acento(s)",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT21() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("aaaaa");
		u.setSenha("11111");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("aaaaa",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT22() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("NomeValidoAAAAA");
		u.setSenha("SenhaValida1111");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("NomeValidoAAAAA",classUnderTest.inserir(u).getNomeUsuario());
    }
	
    @Test public void CT23() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("aaaaa");
		u.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Usuario j� tem cadastro",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    @Test public void CT24() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("NomeValidoAAAAA");
		u.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Usuario j� tem cadastro",classUnderTest.inserir(u).getNomeUsuario());
    }
    
    
	// TESTES CT25 A CT40 REFERENTES AO M�TODO: Usuario inserir(String nomeUsuario, String senha, List<Contato> contatos)
	
    @Test public void CT25() throws IOException {
    	
    	String nomeUsuario = "";
    	String senha = "12345";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Insira Nome de Usu�rio",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT26() throws IOException {
    	
    	String nomeUsuario = "12345";
    	String senha = "";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Insira Senha de Usu�rio",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }    
    
    @Test public void CT27() throws IOException {
    	
    	String nomeUsuario = "1234";
    	String senha = "12345";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome com menos de 5 caracteres",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT28() throws IOException {
    	
    	String nomeUsuario = "1234567890123456";
    	String senha = "12345";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome com mais de 15 caracteres",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT29() throws IOException {
    	
    	String nomeUsuario = "nome!=";
    	String senha = "12345";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome cont�m caracter especial ou espa�o",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT30() throws IOException {
    	
    	String nomeUsuario = "nome nome";
    	String senha = "12345";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome cont�m caracter especial ou espa�o",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT31() throws IOException {
    	
    	String nomeUsuario = "12345";
    	String senha = "1234";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha com menos de 5 caracteres",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT32() throws IOException {
    	
    	String nomeUsuario = "12345";
    	String senha = "1234567890123456";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha com mais de 15 caracteres",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT33() throws IOException {
    	
    	String nomeUsuario = "12345";
    	String senha = "senha!=";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha cont�m caracter especial ou espa�o",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT34() throws IOException {
    	
    	String nomeUsuario = "12345";
    	String senha = "senha senha";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha cont�m caracter especial ou espa�o",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT35() throws IOException {
    	
    	String nomeUsuario = "S�oJos�";
    	String senha = "12345";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome cont�m acento(s)",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT36() throws IOException {
    	
    	String nomeUsuario = "12345";
    	String senha = "S�oJos�";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha cont�m acento(s)",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    
    
    @Test public void CT37() throws IOException {
    	
    	String nomeUsuario = "bbbbb";
    	String senha = "22222";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("bbbbb",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    

    @Test public void CT38() throws IOException {
    	
    	String nomeUsuario = "NomeValidoBBBBB";
    	String senha = "SenhaValida2222";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("NomeValidoBBBBB",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
	
    @Test public void CT39() throws IOException {
    	
    	String nomeUsuario = "bbbbb";
    	String senha = "12345";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Usuario j� tem cadastro",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    @Test public void CT40() throws IOException {
    	
    	String nomeUsuario = "NomeValidoBBBBB";
    	String senha = "12345";
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Usuario j� tem cadastro",classUnderTest.inserir(nomeUsuario,senha, null).getNomeUsuario());
    }
    
    
    // TESTES CT41 A CT56 REFERENTES AO M�TODO: Usuario atualizarUsuario(Usuario uAnt, Usuario uAtual)
    
    @Test public void CT41() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("");
		uAtual.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Insira Nome de Usu�rio",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT42() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("12345");
		uAtual.setSenha("");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Insira Senha de Usu�rio",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT43() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("1234");
		uAtual.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome com menos de 5 caracteres",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT44() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("1234567890123456");
		uAtual.setSenha("22222");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome com mais de 15 caracteres",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT45() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("nome!=");
		uAtual.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome cont�m caracter especial ou espa�o",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT46() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("nome nome");
		uAtual.setSenha("22222");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome cont�m caracter especial ou espa�o",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT47() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("12345");
		uAtual.setSenha("1234");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha com menos de 5 caracteres",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT48() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("12345");
		uAtual.setSenha("1234567890123456");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha com mais de 15 caracteres",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT49() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("12345");
		uAtual.setSenha("senha!=");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha cont�m caracter especial ou espa�o",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT50() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("12345");
		uAtual.setSenha("senha senha");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha cont�m caracter especial ou espa�o",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT51() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("S�oJos�");
		uAtual.setSenha("12345");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("nome cont�m acento(s)",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT52() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("12345");
		uAtual.setSenha("S�oJos�");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("senha cont�m acento(s)",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT53() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("NomeValidoCCCCC");
		uAtual.setSenha("SenhaValida3333");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("NomeValidoCCCCC",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT54() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("nomevalidoAAAAA");
		uAnt.setSenha("senhavalida1111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("ccccc");
		uAtual.setSenha("33333");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("ccccc",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
	
    @Test public void CT55() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("bbbbb");
		uAnt.setSenha("22222");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("nomevalidoBBBBB");
		uAtual.setSenha("senhavalida2222");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Usuario j� tem cadastro",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    @Test public void CT56() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("nomevalidoBBBBB");
		uAnt.setSenha("senhavalida2222");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("bbbbb");
		uAtual.setSenha("22222");
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("Usuario j� tem cadastro",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
    
    
    // TESTES CT57 A CT60 REFERENTES AO M�TODO: Usuario buscarPorNomeUsuario(String nomeUsuario)
    
    @Test public void CT57() throws IOException {
    	
		String nomeUsuario = "aaaaa";
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("false",classUnderTest.buscarPorNomeUsuario(nomeUsuario).getNomeUsuario());
    }   
    
    @Test public void CT58() throws IOException {
    	
		String nomeUsuario = "NomeValidoAAAAA";
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals("false",classUnderTest.buscarPorNomeUsuario(nomeUsuario).getNomeUsuario());
    }
    
    @Test public void CT59() throws IOException {
    	
		String nomeUsuario = "bbbbb";
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
		
		Criptografar criptografa = new Criptografar();
		String nomeCriptografado = criptografa.criptografar(nomeUsuario.toLowerCase());
        
        assertEquals(nomeCriptografado,classUnderTest.buscarPorNomeUsuario(nomeUsuario).getNomeUsuario());
    }   
	
    @Test public void CT60() throws IOException {
    	
		String nomeUsuario = "NomeValidoBBBBB";
		
		ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
		
		Criptografar criptografa = new Criptografar();
		String nomeCriptografado = criptografa.criptografar(nomeUsuario.toLowerCase());
        
        assertEquals(nomeCriptografado,classUnderTest.buscarPorNomeUsuario(nomeUsuario).getNomeUsuario());
    }  
    
    
    // TESTES CT61 A CT65 REFERENTES AO M�TODO: boolean removerUsuario(Usuario u)
    
    @Test public void CT61() throws IOException {
    	
    	Usuario u = new Usuario();
		u.setNomeUsuario("aaaaa");
		u.setSenha("11111");
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals(true,classUnderTest.removerUsuario(u));
    }
    
    @Test public void CT62() throws IOException {
    	
    	Usuario u = new Usuario();
		u.setNomeUsuario("NomeValidoAAAAA");
		u.setSenha("SenhaValida1111");
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals(true,classUnderTest.removerUsuario(u));
    }
	
    @Test public void CT63() throws IOException {
    	
    	Usuario u = new Usuario();
		u.setNomeUsuario("bbbbb");
		u.setSenha("22222");
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals(true,classUnderTest.removerUsuario(u));
    }
    
    @Test public void CT64() throws IOException {
    	
    	Usuario u = new Usuario();
		u.setNomeUsuario("nomevalidoBBBBB");
		u.setSenha("senhavalida2222");
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals(true,classUnderTest.removerUsuario(u));
    }
    
    @Test public void CT65() throws IOException {
    	
    	Usuario u = new Usuario();
		u.setNomeUsuario("ccccc");
		u.setSenha("33333");
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals(true,classUnderTest.removerUsuario(u));
    }
    
    @Test public void CT66() throws IOException {
    	
    	Usuario u = new Usuario();
		u.setNomeUsuario("nomevalidoCCCCC");
		u.setSenha("senhavalida3333");
    	
        ServicoUsuarioImpl classUnderTest = new ServicoUsuarioImpl("users.txt");
        
        assertEquals(true,classUnderTest.removerUsuario(u));
    }
    
    


}
