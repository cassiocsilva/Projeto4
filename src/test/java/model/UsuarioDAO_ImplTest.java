package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.IOException;
import java.util.List;

public class UsuarioDAO_ImplTest {
	
	// CT01 A CT02 REFERENTES AO MÉTODO: Usuario inserir(Usuario u)
	
	@Test public void CT01() throws IOException {
    	
		Usuario u = new Usuario();
		u.setNomeUsuario("aaaaa");
		u.setSenha("11111");
		u.setContatos(null);
        
        UsuarioDAO_Impl classUnderTest = new UsuarioDAO_Impl();
        
        assertEquals("aaaaa",classUnderTest.inserir(u).getNomeUsuario());        
    }
	
	@Test public void CT02() throws IOException {
    	
		Usuario u = new Usuario();
		u.setNomeUsuario("NomeValido12345");
		u.setSenha("SenhaValida6789");
		u.setContatos(null);
        
        UsuarioDAO_Impl classUnderTest = new UsuarioDAO_Impl();
        
        assertEquals("NomeValido12345",classUnderTest.inserir(u).getNomeUsuario());        
    }	
	
	// CT03 A CT04 REFERENTES AO MÉTODO: Usuario buscarPorNomeUsuario(String nomeUsuario)	
	
	@Test public void CT03() throws IOException {
    	
        UsuarioDAO_Impl classUnderTest = new UsuarioDAO_Impl();
       
        assertEquals("true",classUnderTest.buscarPorNomeUsuario("aaaaa").getNomeUsuario());
    }
	
	
	@Test public void CT04() throws IOException {
    	
        UsuarioDAO_Impl classUnderTest = new UsuarioDAO_Impl();
       
        assertEquals("true",classUnderTest.buscarPorNomeUsuario("NomeValido12345").getNomeUsuario());
    }
	
	// CT05 REFERENTE AO MÉTODO: Usuario atualizarUsuario(Usuario uAnt, Usuario uAtual)
	
	@Test public void CT05() throws IOException {
    	
		Usuario uAnt = new Usuario();
		uAnt.setNomeUsuario("aaaaa");
		uAnt.setSenha("11111");
		
		Usuario uAtual = new Usuario();
		uAtual.setNomeUsuario("bbbbb");
		uAtual.setSenha("22222");
		
        UsuarioDAO_Impl classUnderTest = new UsuarioDAO_Impl();
        
        assertEquals("bbbbb",classUnderTest.atualizarUsuario(uAnt,uAtual).getNomeUsuario());
    }
	
	// CT06 e CT07 REFERENTES AO MÉTODO: boolean removerUsuario(Usuario u)
	
	@Test public void CT06() throws IOException {
    	
		Usuario u = new Usuario();
		u.setNomeUsuario("bbbbb");
		u.setSenha("22222");
        
        UsuarioDAO_Impl classUnderTest = new UsuarioDAO_Impl();
        
        assertEquals(true,classUnderTest.removerUsuario(u));
    }
	
	
	@Test public void CT07() throws IOException {
    	
		Usuario u = new Usuario();
		u.setNomeUsuario("NomeValido12345");
		u.setSenha("SenhaValida6789");
        
        UsuarioDAO_Impl classUnderTest = new UsuarioDAO_Impl();
        
        assertEquals(true,classUnderTest.removerUsuario(u));
    }
	
	
	@Test public void CT08() throws IOException {
        
        UsuarioDAO_Impl classUnderTest = new UsuarioDAO_Impl();
        
        assertNotNull(classUnderTest.listarTodosUsuarios());
    }
	
	
}
