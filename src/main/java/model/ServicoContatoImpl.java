
package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class ServicoContatoImpl implements
             ServicoContato{

    /* O construtor deve receber
    como parÃ¢metro o nome do arquivo de
    dados de contatos (referente ao usuÃ¡rio
    especÃ­fico carregado)*/
	
	String nome_arq_dados_c;
	
	public ServicoContatoImpl(String nome_arq_dados_c) {
		// TODO Auto-generated method stub
		this.nome_arq_dados_c = nome_arq_dados_c;
	}
    
    
    
    @Override
    public Contato inserir(Contato c) throws IOException {
        /* Colocar aqui a lÃ³gica do tipo
           sÃ³ inserir se o contato nÃ£o existir, 
           ou seja, utilizar o dao para buscar e depois
           para inserir, caso seja aplicÃ¡vel. */
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	File f = new File(nome_arq_dados_c);
    	if (f.exists()) {
    	} else {
    		f.createNewFile();
    	}
    	
		int nomeEhLetraOuNumero = 0;
		int telefoneEhNumero = 0;
		
		String nomeNovoContato = c.getNome().toUpperCase();
		String nomeNovoContatoN = Normalizer.normalize(nomeNovoContato, Normalizer.Form.NFD);
		Pattern nomeNovoContatoP = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
		String nomeNovoContatoNP = nomeNovoContatoP.matcher(nomeNovoContatoN).replaceAll("");
		String nomeNovoContatoNPSE = nomeNovoContatoNP.replaceAll(" ", "");
		
		List<Contato> listaDataU = listarTodosContatos();
		
    	for (int i=0; i<listaDataU.size(); i++) {
    		
    		Contato velhoContato = new Contato();
    		velhoContato = listaDataU.get(i);
    		
    		String nomeVelhoContato = velhoContato.getNome().toUpperCase();
    		String nomeVelhoContatoN = Normalizer.normalize(nomeVelhoContato, Normalizer.Form.NFD);
    		Pattern nomeVelhoContatoP = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
    		String nomeVelhoContatoNP = nomeVelhoContatoP.matcher(nomeVelhoContatoN).replaceAll("");
    		String nomeVelhoContatoNPSE = nomeVelhoContatoNP.replaceAll(" ", "");
    		
    		if (nomeNovoContatoNPSE.equals(nomeVelhoContatoNPSE)) {
    			c.setNome("Contato já existe");
    			return c;
    		}
    	}
		
		if (c.getNome().equals("")) {
			c.setNome("nome contato = string vazia");
			return c;
		}
		
		if ((nomeNovoContatoNPSE.equals(""))) {
			c.setNome("nome contato = string em branco");
			return c;
		}
		
		for (int i = 0; i < c.getNome().length(); i++) {
			if (Character.isLetterOrDigit(c.getNome().charAt(i)) == true) {
				nomeEhLetraOuNumero++;
			}
		}

		if (nomeNovoContatoNPSE.length() != (nomeEhLetraOuNumero)) {
			c.setNome("nome contém caracteres especiais");
			return c;		
		}
		
		if (c.getTelefone().equals("")) {
			c.setNome("telefone = string vazia");			
			return c;
		}

		for (int i = 0; i < c.getTelefone().length(); i++) {
			if (Character.isDigit(c.getTelefone().charAt(i)) == true) {
				telefoneEhNumero++;
			}
		}
		
		if (c.getTelefone().length() != telefoneEhNumero) {
			c.setNome("telefone não contém somente números");
			return c;
		} else if ((c.getTelefone().length() < 8)) {
			c.setNome("telefone menor que 8 números");
			return c;
		} else if ((c.getTelefone().length() > 20)) {
			c.setNome("telefone maior que 20 números");
			return c;
		}
		
		Pattern p = Pattern.compile("^[\\w-]+(\\.[\\w-]+)*@([\\w-]+\\.)+[a-zA-Z]{1,7}$");
		Matcher m = p.matcher(c.getEmail());
		if (!m.find()) {
			c.setNome("email inválido");
			return c;
		}

		if (c.getEndereco().length() < 3) {
			c.setNome("endereço menor que 3 caracteres");
			return c;
		} else if (c.getEndereco().length() > 255) {
			c.setNome("endereço maior que 255 caracteres");
			return c;
		}
		
		if (c.getEndereco().toLowerCase().contains("lugar nenhum")) {
			c.setNome("endereço contém frase lugar nenhum");
			return c;
		}
		if (c.getEndereco().toLowerCase().contains("judas perdeu as botas")) {
			c.setNome("endereço contém frase judas perdeu as botas");
			return c;
		}
		if (c.getEndereco().toLowerCase().contains("casa da mãe joana")) {
			c.setNome("endereço contém frase casa da mãe joana");
			return c;
		}
		if (c.getEndereco().toLowerCase().contains("num sei")) {
			c.setNome("endereço contém frase num sei");
			return c;
		}
		
		ContatoDAO_Impl cdaoi = new ContatoDAO_Impl(nome_arq_dados_c);
		cdaoi.inserir(c);

		return c;
    }

    
    
    @Override
    public Contato inserir(String nome, String tel, String email, String end) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	Contato c = new Contato();
    	c.setNome(nome);
    	c.setTelefone(tel);
    	c.setEmail(email);
    	c.setEndereco(end);
    	
		Contato validarEouInserir = inserir(c);
    	return validarEouInserir;
	}

    
    @Override
    public List<Contato> buscarPorParteNome(String parteNome) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	ContatoDAO_Impl leArquivo = new ContatoDAO_Impl(nome_arq_dados_c);
    	List<Contato> listaFiltroBusca = leArquivo.buscarPorParteNome(parteNome);
    	
    	/*
    	for (int i=0; i<listaFiltroBusca.size();i++) {
    		Contato c = new Contato();
    		c = listaFiltroBusca.get(i);
    		System.out.println("c.getNome(): "+c.getNome()); //laço apenas para verificar resultado dabusca
    	}
    	*/

		return listaFiltroBusca;  
    }

    
    @Override
    public boolean removerContato(Contato c) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	ContatoDAO_Impl cdaoi = new ContatoDAO_Impl(nome_arq_dados_c);
    	boolean remover = cdaoi.removerContato(c);
    	
    	return remover;
    }

    
    @Override
    public Contato atualizarContato(Contato cAnt, Contato cAtual) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	Contato validarEouInserir = inserir(cAtual);
    	
    	if (validarEouInserir.getNome().equals(cAtual.getNome())) {
    		
    		ContatoDAO_Impl cdaoi = new ContatoDAO_Impl(nome_arq_dados_c);
        	boolean remover = cdaoi.removerContato(cAnt);

    		return cAtual;
    		
    	} else {
    		
    		return validarEouInserir;
    	}
    }
    
   
    @Override
    public List<Contato> listarTodosContatos() throws IOException {
		//throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	ContatoDAO_Impl leArquivo = new ContatoDAO_Impl(nome_arq_dados_c);
    	List<Contato> listaDataU = leArquivo.listarTodosContatos();
    	
    	/*
    	for (int i=0; i<listaDataU.size();i++) {
    		Contato c = new Contato();
    		c = listaDataU.get(i);
    		System.out.println("\nc.getNome(): "+c.getNome()); //laço apenas para verificar resultado dabusca
    	}
    	*/
    	
		return listaDataU;
    }

    
}
