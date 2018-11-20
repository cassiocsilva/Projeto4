package model;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;


public class ServicoContatoImplTest {
	
	
	// TESTES CT74 A CT107 REFERENTES AO MÉTODO: Contato inserir(Contato c)

	@Test
	public void CT74() throws IOException {

		Contato c = new Contato();
		c.setNome("");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("nome contato = string vazia", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT75() throws IOException {

		Contato c = new Contato();
		c.setNome("   ");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("nome contato = string em branco", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT76() throws IOException {

		Contato c = new Contato();
		c.setNome("Fulano@2018");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("nome contém caracteres especiais", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT77() throws IOException {

		Contato c = new Contato();
		c.setNome("José João da Silva 2018");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT78() throws IOException {

		Contato c = new Contato();
		c.setNome("Jose Joao da Silva 2018");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("Contato já existe", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT79() throws IOException {

		Contato c = new Contato();
		c.setNome("a");
		c.setTelefone("");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone = string vazia", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT80() throws IOException {

		Contato c = new Contato();
		c.setNome("a");
		c.setTelefone("   ");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone não contém somente números", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT81() throws IOException {

		Contato c = new Contato();
		c.setNome("a");
		c.setTelefone("12 3456 7890");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone não contém somente números", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT82() throws IOException {

		Contato c = new Contato();
		c.setNome("a");
		c.setTelefone("(12)3456-7890");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone não contém somente números", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT83() throws IOException {

		Contato c = new Contato();
		c.setNome("a");
		c.setTelefone("1234567");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone menor que 8 números", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT84() throws IOException {

		Contato c = new Contato();
		c.setNome("a");
		c.setTelefone("123456789012345678901");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone maior que 20 números", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT85() throws IOException {

		Contato c = new Contato();
		c.setNome("a");
		c.setTelefone("12345678");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT86() throws IOException {

		Contato c = new Contato();
		c.setNome("b");
		c.setTelefone("12345678901234567890");
		c.setEmail("c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT87() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c@@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT88() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c@c@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT89() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("@c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT90() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail(" @c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT91() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c @c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT92() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c@");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT93() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c@ ");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT94() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c@ c.com");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT95() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c@11");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT96() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c@1.1");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT97() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c1@a.");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT98() throws IOException {

		Contato c = new Contato();
		c.setNome("c");
		c.setTelefone("1234567890");
		c.setEmail("c@fatec.sp.gov.br");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT99() throws IOException {

		Contato c = new Contato();
		c.setNome("d");
		c.setTelefone("1234567890");
		c.setEmail("abc@z1.c");
		c.setEndereco("Endereço");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT100() throws IOException {

		Contato c = new Contato();
		c.setNome("e");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("En");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço menor que 3 caracteres", classUnderTest.inserir(c).getNome());
	}

	@Test
	public void CT101() throws IOException {

		Contato c = new Contato();
		c.setNome("e");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee256");

		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço maior que 255 caracteres", classUnderTest.inserir(c).getNome());
	}
	
	@Test
	public void CT102() throws IOException {

		Contato c = new Contato();
		c.setNome("e");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("lugar nenhum");
		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);
		
		assertEquals("endereço contém frase lugar nenhum", classUnderTest.inserir(c).getNome());
	}
	
	@Test
	public void CT103() throws IOException {

		Contato c = new Contato();
		c.setNome("e");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("Rua onde judas perdeu as botas");
		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço contém frase judas perdeu as botas", classUnderTest.inserir(c).getNome());
	}
	
	@Test
	public void CT104() throws IOException {

		Contato c = new Contato();
		c.setNome("e");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("casa da mãe joana");
		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço contém frase casa da mãe joana", classUnderTest.inserir(c).getNome());
	}
	
	@Test
	public void CT105() throws IOException {

		Contato c = new Contato();
		c.setNome("e");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("num sei o endereço");
		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço contém frase num sei", classUnderTest.inserir(c).getNome());
	}
	
	@Test
	public void CT106() throws IOException {

		Contato c = new Contato();
		c.setNome("e");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("End");
		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(c).getNome());
	}
	
	@Test
	public void CT107() throws IOException {

		Contato c = new Contato();
		c.setNome("f");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee255");
		String nome_arq_dados_c = "data_uTesteServ.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);
		
		/////////////////////////////////////////////
		File arqDados = new File(nome_arq_dados_c);
		arqDados.deleteOnExit();
		/////////////////////////////////////////////

		assertEquals("true", classUnderTest.inserir(c).getNome());
	}
	
	
	// TESTES CT108 A CT141 REFERENTES AO MÉTODO: Contato inserir(String nome, String tel, String email, String end)
	
	@Test
	public void CT108() throws IOException {
		
		String nome = "";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("nome contato = string vazia", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT109() throws IOException {
		
		String nome = "   ";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("nome contato = string em branco", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT110() throws IOException {
		
		String nome = "Fulano@2018";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("nome contém caracteres especiais", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT111() throws IOException {
		
		String nome = "José João da Silva 2018";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT112() throws IOException {
		
		String nome = "Jose Joao da Silva 2018";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("Contato já existe", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT113() throws IOException {
		
		String nome = "a";
		String tel = "";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone = string vazia", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT114() throws IOException {
		
		String nome = "a";
		String tel = "   ";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone não contém somente números", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT115() throws IOException {
		
		String nome = "a";
		String tel = "12 3456 7890";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone não contém somente números", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT116() throws IOException {
		
		String nome = "a";
		String tel = "(12)3456-7890";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone não contém somente números", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT117() throws IOException {
		
		String nome = "a";
		String tel = "1234567";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone menor que 8 números", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT118() throws IOException {
		
		String nome = "a";
		String tel = "123456789012345678901";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("telefone maior que 20 números", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT119() throws IOException {
		
		String nome = "a";
		String tel = "12345678";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT120() throws IOException {
		
		String nome = "b";
		String tel = "12345678901234567890";
		String email = "c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT121() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c@@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT122() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c@c@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT123() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "@c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}
	
	@Test
	public void CT124() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = " @c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT125() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c @c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT126() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c@";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT127() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c@ ";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT128() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c@ c.com";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT129() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c@11";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT130() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c@1.1";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT131() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c1@a.";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("email inválido", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT132() throws IOException {
		
		String nome = "c";
		String tel = "1234567890";
		String email = "c@fatec.sp.gov.br";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT133() throws IOException {
		
		String nome = "d";
		String tel = "1234567890";
		String email = "abc@z1.c";
		String end = "Endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT134() throws IOException {
		
		String nome = "e";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "En";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço menor que 3 caracteres", classUnderTest.inserir(nome, tel, email, end).getNome());
	}

	@Test
	public void CT135() throws IOException {
		
		String nome = "e";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee256";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço maior que 255 caracteres", classUnderTest.inserir(nome, tel, email, end).getNome());
	}
	
	@Test
	public void CT136() throws IOException {
		
		String nome = "e";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "lugar nenhum";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço contém frase lugar nenhum", classUnderTest.inserir(nome, tel, email, end).getNome());
	}
	
	@Test
	public void CT137() throws IOException {
		
		String nome = "e";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "Rua onde judas perdeu as botas";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço contém frase judas perdeu as botas", classUnderTest.inserir(nome, tel, email, end).getNome());
	}
	
	@Test
	public void CT138() throws IOException {
		
		String nome = "e";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "casa da mãe joana";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço contém frase casa da mãe joana", classUnderTest.inserir(nome, tel, email, end).getNome());
	}
	
	@Test
	public void CT139() throws IOException {
		
		String nome = "e";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "num sei o endereço";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("endereço contém frase num sei", classUnderTest.inserir(nome, tel, email, end).getNome());
	}
	
	@Test
	public void CT140() throws IOException {
		
		String nome = "e";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "End";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(nome, tel, email, end).getNome());
	}
	
	@Test
	public void CT141() throws IOException {
		
		String nome = "f";
		String tel = "1234567890";
		String email = "c@c.com";
		String end = "eeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeeee255";

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.inserir(nome, tel, email, end).getNome());
	}
	
	
	// TESTE CT142 REFERENTE AO MÉTODO: List<Contato> buscarPorParteNome(String parteNome)
	
	@Test public void CT142() throws IOException {
		
		String nome_arq_dados_c = "data_uTesteServ2.txt";
		String parteNome = "Silva";
        
		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

        assertNotNull(classUnderTest.buscarPorParteNome(parteNome));
    }
	
	
	// TESTE CT143 REFERENTE AO MÉTODO: Contato atualizarContato(Contato cAnt, Contato cAtual)
	
	@Test
	public void CT143() throws IOException {
		
		Contato cAnt = new Contato();
		cAnt.setNome("a");
		cAnt.setTelefone("12345678");
		cAnt.setEmail("c@c.com");
		cAnt.setEndereco("End");
		
		Contato cAtual = new Contato();
		cAtual.setNome("z");
		cAtual.setTelefone("1234567890");
		cAtual.setEmail("c@c.com");
		cAtual.setEndereco("End");

		String nome_arq_dados_c = "data_uTesteServ2.txt";

		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		assertEquals("true", classUnderTest.atualizarContato(cAnt, cAtual).getNome());
	}
	
	
	// TESTE CT144 REFERENTE AO MÉTODO: List<Contato> listarTodosContatos()
	
	@Test public void CT144() throws IOException {
		
		String nome_arq_dados_c = "data_uTesteServ2.txt";
        
		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);
        
        assertNotNull(classUnderTest.listarTodosContatos());    
    }
	
	
	// TESTE CT145 REFERENTE AO MÉTODO: boolean removerContato(Contato c)

	@Test public void CT145() throws IOException {
		
		Contato c = new Contato();
		c.setNome("z");
		c.setTelefone("1234567890");
		c.setEmail("c@c.com");
		c.setEndereco("End");
		
		String nome_arq_dados_c = "data_uTesteServ2.txt";
        
		ServicoContatoImpl classUnderTest = new ServicoContatoImpl(nome_arq_dados_c);

		/////////////////////////////////////////////
		File arqDados = new File(nome_arq_dados_c);
		arqDados.deleteOnExit();
		/////////////////////////////////////////////
        
        assertEquals(true,classUnderTest.removerContato(c));        
    }
}
