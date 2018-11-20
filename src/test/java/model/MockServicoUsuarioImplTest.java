package model;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;

import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;

import model.ServicoUsuarioImpl;
import model.ServicoUsuario;
import model.Usuario;

public class MockServicoUsuarioImplTest {
	
	@Mock
	private ServicoUsuario servicoUsuario;
	
	public MockServicoUsuarioImplTest() {  //construtor
		
		servicoUsuario = (ServicoUsuario) Mockito.mock(ServicoUsuarioImpl.class);
	}

    @Test 
    public void CT155() throws IOException {
		
		Usuario u = new Usuario();
		u.setNomeUsuario("aaaaa");
		u.setSenha("11111");
		
		Mockito.when(servicoUsuario.inserir(u)).thenReturn(u);
		assertEquals("aaaaa", servicoUsuario.inserir(u).getNomeUsuario());       
    }
}
