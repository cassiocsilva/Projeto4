
package model;

import java.io.IOException;
import java.text.Normalizer;
import java.util.List;
import java.util.regex.Pattern;


public class ServicoUsuarioImpl implements
             ServicoUsuario{
	
	String nome_arq_dados_u;
	String nome_arq_dados_c;
	
    public ServicoUsuarioImpl(String nome_arq_dados_u){
        //implementar. passar referÃªncia ao instanciar o DAO
    	this.nome_arq_dados_u = nome_arq_dados_u;
    }
    
	
	public Usuario controllerTelaLogin(Usuario loginUsuario) throws IOException{

		Criptografar criptografa = new Criptografar();
		String nomeLC = loginUsuario.getNomeUsuario().toLowerCase();
		String nomeCriptografado = criptografa.criptografar(nomeLC);
		String senhaLC = loginUsuario.getSenha().toLowerCase();
		String senhaCriptografada = criptografa.criptografar(senhaLC);
		this.nome_arq_dados_c = "data_u"+nomeCriptografado+".txt";    //data_ufdvvlr.txt

		List<Usuario> listaTodosUsuarios = listarTodosUsuarios();

		Usuario verificaLogin = new Usuario();
		
		if (loginUsuario.getNomeUsuario().equals("")) {

			verificaLogin.setNomeUsuario("Insira nomeUsuario");
			return verificaLogin;

		} else {

			for (int i = 0; i < listaTodosUsuarios.size(); i++) {

				if (nomeCriptografado.equals(listaTodosUsuarios.get(i).getNomeUsuario())) {
					if (senhaCriptografada.equals(listaTodosUsuarios.get(i).getSenha())) {

						verificaLogin.setNomeUsuario(listaTodosUsuarios.get(i).getNomeUsuario());
						verificaLogin.setSenha(listaTodosUsuarios.get(i).getSenha());
						verificaLogin.setContatos(listaTodosUsuarios.get(i).getContatos());
						
						return verificaLogin;  //login OK, retorna Usuario "loginCriptografado" completo
						
					} else {
						verificaLogin.setNomeUsuario("Usuário tem cadastro, senha incorreta");
						return verificaLogin;
					}
				}
			}
			verificaLogin.setNomeUsuario("Usuário não tem cadastro");
			return verificaLogin;
		}		
	}
	
	
	@Override
    public Usuario inserir(Usuario u) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    
    	if (u.getNomeUsuario().equals("")) {
			u.setNomeUsuario("Insira Nome de Usuário");
			return u;
		} else if (u.getSenha().equals("")) {
			u.setNomeUsuario("Insira Senha de Usuário");
			return u;
		}
    	
    	Usuario usuarioCriptografadoExiste = controllerTelaLogin(u);
		
		if (usuarioCriptografadoExiste.getNomeUsuario().equals("Usuário não tem cadastro")){
			
			Usuario novoUsuario = new Usuario();
	    	String nome = u.getNomeUsuario();
	    	String senha = u.getSenha();
	   	    	
			String dados_validos = "false";
			boolean dadosValidos = false;
			boolean nomeEntreCincoEquinzeCaracteres = false;
			boolean nomeSomenteLetrasEnumeros = false;
			boolean senhaEntreCincoEquinzeCaracteres = false;
			boolean senhaSomenteLetrasEnumeros = false;
			int nomeEhLetraOuNumero = 0;
			int senhaEhLetraOuNumero = 0;
			
			if (nome.length() >= 5 && nome.length() <= 15) {
				nomeEntreCincoEquinzeCaracteres = true;
			} else if (nome.length() <= 5) {
				novoUsuario.setNomeUsuario("nome com menos de 5 caracteres");
				return novoUsuario;
			} else if (nome.length() >= 15) {
				novoUsuario.setNomeUsuario("nome com mais de 15 caracteres");
				return novoUsuario;
			}
			
			for (int i = 0; i < nome.length(); i++) {
				if (Character.isLetterOrDigit(nome.charAt(i)) == true) {
					nomeEhLetraOuNumero++;
				} else {
					novoUsuario.setNomeUsuario("nome contém caracter especial ou espaço");
					return novoUsuario;
				}
			}
			
			if (senha.length() >= 5 && senha.length() <= 15) {
				senhaEntreCincoEquinzeCaracteres = true;
			} else if (senha.length() <= 5) {
				novoUsuario.setNomeUsuario("senha com menos de 5 caracteres");
				return novoUsuario;
			} else if (senha.length() >= 15) {
				novoUsuario.setNomeUsuario("senha com mais de 15 caracteres");
				return novoUsuario;
			}
			
			for (int i = 0; i < senha.length(); i++) {
				if (Character.isLetterOrDigit(senha.charAt(i)) == true) {
					senhaEhLetraOuNumero++;
				} else {
					novoUsuario.setNomeUsuario("senha contém caracter especial ou espaço");
					return novoUsuario;
				}
			}
			
			String nomeLC = nome.toLowerCase();
			String nfdNormalizednomeLC = Normalizer.normalize(nomeLC, Normalizer.Form.NFD);
			Pattern patternnomeLC = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			String nomeLCsemAcentos = patternnomeLC.matcher(nfdNormalizednomeLC).replaceAll("");

			if (((nomeLC.length()) == (nomeEhLetraOuNumero)) && (nomeLC.equals(nomeLCsemAcentos))){
				nomeSomenteLetrasEnumeros = true;
			} else {
				novoUsuario.setNomeUsuario("nome contém acento(s)");
				return novoUsuario;
			}

			String senhaLC = senha.toLowerCase();
			String nfdNormalizedsenhaLC = Normalizer.normalize(senhaLC, Normalizer.Form.NFD);
			Pattern patternsenhaLC = Pattern.compile("\\p{InCombiningDiacriticalMarks}+");
			String senhaLCsemAcentos = patternsenhaLC.matcher(nfdNormalizedsenhaLC).replaceAll("");
			
			if (((senhaLC.length()) == (senhaEhLetraOuNumero)) && (senhaLC.equals(senhaLCsemAcentos))){
				senhaSomenteLetrasEnumeros = true;
			} else {
				novoUsuario.setNomeUsuario("senha contém acento(s)");
				return novoUsuario;
			}
			
			if (nomeEntreCincoEquinzeCaracteres && nomeSomenteLetrasEnumeros
					&& senhaEntreCincoEquinzeCaracteres && senhaSomenteLetrasEnumeros) {
				dadosValidos = true;
				dados_validos = "true";
			}
		
			if (dadosValidos) {
				
				UsuarioDAO_Impl udaoi = new UsuarioDAO_Impl();
				Usuario cadastraNoArquivo = udaoi.inserir(u);
				
				Usuario checaCadastro = buscarPorNomeUsuario(u.getNomeUsuario());
				
				Criptografar criptografa = new Criptografar();
				String nomeCriptografado = criptografa.criptografar(u.getNomeUsuario().toLowerCase());
				
				if (checaCadastro.getNomeUsuario().equals(nomeCriptografado)) {
					return u;
				} else {
					u.setNomeUsuario("Falha na operacao");
					return u;
				}
			}
			return u;
			
			
		} else {
			Usuario usuarioJaExiste = new Usuario();
			usuarioJaExiste.setNomeUsuario("Usuario já tem cadastro");
			return usuarioJaExiste;			
		}
	}
	
    
    @Override
    public Usuario inserir(String nomeUsuario, String senha, List<Contato> contatos) throws IOException {
    	
    	Usuario u = new Usuario();
    	u.setNomeUsuario(nomeUsuario);
    	u.setSenha(senha);
    	u.setContatos(contatos);
    	
    	if (u.getNomeUsuario().equals("")) {
			u.setNomeUsuario("Insira Nome de Usuário");
			return u;
		} else if (u.getSenha().equals("")) {
			u.setNomeUsuario("Insira Senha de Usuário");
			return u;
		}
		
		Usuario usuarioCriptografadoExiste = controllerTelaLogin(u);
		
		if (usuarioCriptografadoExiste.getNomeUsuario().equals("Usuário não tem cadastro")){
			
			Usuario validarEouCadastrar = inserir(u);
			return validarEouCadastrar;
			
		} else {
			Usuario usuarioJaExiste = new Usuario();
			usuarioJaExiste.setNomeUsuario("Usuario já tem cadastro");
			return usuarioJaExiste;			
		}
    }

    
    @Override
    public Usuario buscarPorNomeUsuario(String nomeUsuario) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	Criptografar criptografa = new Criptografar();
		String nomeCriptografado = criptografa.criptografar(nomeUsuario.toLowerCase());
    	
    	UsuarioDAO_Impl udaoi = new UsuarioDAO_Impl();
    	Usuario checaCadastro = udaoi.buscarPorNomeUsuario(nomeUsuario);
    	
    	if (checaCadastro.getNomeUsuario().equals("true")) {
    		
    		List<Usuario> listaTudao = udaoi.listarTodosUsuarios();
    		
    		
    		for (int i=0; i<listaTudao.size(); i++) {
    			
    			Usuario usuario = new Usuario();
    			usuario = listaTudao.get(i);
    			
    			if (usuario.getNomeUsuario().equals(nomeCriptografado)) {
    				return usuario;
    			}
    		}
    	} 
    	return checaCadastro;
    }
    

    @Override
    public boolean removerUsuario(Usuario u) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	UsuarioDAO_Impl udaoi = new UsuarioDAO_Impl();
    	
    	boolean removerUsuario = udaoi.removerUsuario(u);
    	
    	return removerUsuario;
    }

    
    @Override
	public Usuario atualizarUsuario(Usuario uAnt, Usuario uAtual) throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	String nomeUsuarioAtual = uAtual.getNomeUsuario();
    	String senhaUsuarioAtual = uAtual.getSenha();
    	
    	Usuario validarEouCadastrar = inserir(nomeUsuarioAtual,senhaUsuarioAtual,null);
    	
    	if (validarEouCadastrar.getNomeUsuario().equals(nomeUsuarioAtual)) {
    		
    		boolean removeUsuarioAnt = removerUsuario(uAnt);
    		
    		if (removeUsuarioAnt = true){
    			
    			return validarEouCadastrar;
    			
    		} else {
    			validarEouCadastrar.setNomeUsuario("Falha ao remover uAnt");
    		}
    	} 
    	
    	return validarEouCadastrar;
    }

    
    @Override
    public List<Usuario> listarTodosUsuarios() throws IOException {
        //throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    	
    	Usuario usuarioCriptografado = new Usuario();
    	
    	UsuarioDAO_Impl leArquivo = new UsuarioDAO_Impl();
    	List<Usuario> listaUsersTxt = leArquivo.listarTodosUsuarios();
    	
    	for (int i=0; i<listaUsersTxt.size(); i++) {
    		
    		usuarioCriptografado = listaUsersTxt.get(i);
    		
    		String nome_arq_dados_busca = "data_u"+usuarioCriptografado.getNomeUsuario()+".txt";

    		ServicoContatoImpl sci = new ServicoContatoImpl(nome_arq_dados_busca);
    		List<Contato> listaDataU = sci.listarTodosContatos();
    		
    		usuarioCriptografado.setContatos(listaDataU);
    		
    	}
    	
		return listaUsersTxt;
    
    }

}
