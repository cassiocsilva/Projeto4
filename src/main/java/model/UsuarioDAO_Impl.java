package model;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.net.URL;
import java.util.LinkedList;
import java.util.List;

public class UsuarioDAO_Impl implements UsuarioDAO {

	@Override
	public Usuario inserir(Usuario u) throws IOException {
		
		Criptografar criptografa = new Criptografar();
		String texto = u.getNomeUsuario();
		String nomeCriptografado = criptografa.criptografar(texto).toLowerCase();
		texto = u.getSenha();
		String senhaCriptografada = criptografa.criptografar(texto).toLowerCase();
		
		File arquivo_u = new File("users.txt");
		if (arquivo_u.exists()) {
		} else {
			arquivo_u.createNewFile();
		}
		
		FileWriter fw = new FileWriter(arquivo_u, true);
		PrintWriter pw = new PrintWriter(fw);

		pw.println(nomeCriptografado + "; " + senhaCriptografada);
		pw.close();
		fw.close();
		
		File arquivo_c = new File("data_u"+nomeCriptografado+".txt");
		if (arquivo_c.exists()) {
		} else {
			arquivo_c.createNewFile();
		}
		
		Usuario checaCadastrado = buscarPorNomeUsuario(u.getNomeUsuario());
		
		if (checaCadastrado.getNomeUsuario().equals("true")) {
			return u;
		} else {
			u.setNomeUsuario("Falha na operacao");
			return u;
		}
	}

	@Override
	public Usuario buscarPorNomeUsuario(String nomeUsuario) throws IOException {
		
		Criptografar criptografa = new Criptografar();
		String nomeCriptografado = criptografa.criptografar(nomeUsuario).toLowerCase();
		
		File arquivoU = new File("users.txt");
		if (arquivoU.exists()) {
		} else {
			arquivoU.createNewFile();
		}
		
		String linha;
		String[] linhaSplited = null;
		Usuario checaCadastro = new Usuario();
		checaCadastro.setNomeUsuario("false");
		
		try {
			
			BufferedReader br = new BufferedReader(new FileReader(arquivoU));
			
			while ((linha = br.readLine()) != null) {
				
				linhaSplited = linha.split("; ");
				
				if (linhaSplited[0].equals(nomeCriptografado)) {
					checaCadastro.setNomeUsuario("true");
					break;
				} else {
					checaCadastro.setNomeUsuario("false");
				}
			}
			
			br.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		return checaCadastro;
	}

	@Override
	public boolean removerUsuario(Usuario u) throws IOException {
		// TODO Auto-generated method stub
		
		Criptografar criptografa = new Criptografar();
		String nomeCriptografado = criptografa.criptografar(u.getNomeUsuario()).toLowerCase();
		String senhaCriptografada = criptografa.criptografar(u.getSenha()).toLowerCase();
		
		File arquivoC = new File("data_u"+nomeCriptografado+".txt");
		
		if (arquivoC.exists()) {
			arquivoC.delete();
		}
		
		File temp = new File("temp.txt");
		if (temp.exists()) {
			temp.delete();
			new File("temp.txt").createNewFile();
		} else {
			new File("temp.txt").createNewFile();
		}

		File arquivoDados = new File("users.txt");
		FileWriter fw = new FileWriter(temp, true);
		PrintWriter pw = new PrintWriter(fw);
		
		try {

			BufferedReader br = new BufferedReader(new FileReader(arquivoDados));
			//BufferedWriter bw = new BufferedWriter(new FileWriter(temp));

			while (br.ready()) {

				String linha = br.readLine();

				if ((linha.equals(nomeCriptografado+"; "+senhaCriptografada))) {
					linha = ("");
				}
				if (linha.equals("")) {
					continue;
				}
				pw.println(linha);
			}

			pw.close();
			fw.close();
			br.close();
			
			arquivoDados.delete();
			temp.renameTo(arquivoDados);
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Usuario checaCadastro = buscarPorNomeUsuario(u.getNomeUsuario());
		
		if (checaCadastro.getNomeUsuario().equals("false") && arquivoC.exists()==false){
			return true;  //se o usuário não estiver no users.txt e se o data_u tiver sido removido, remover usuario =true
		} else {
			return false;
		}
	}
	

	@Override
	public Usuario atualizarUsuario(Usuario uAnt, Usuario uAtual) throws IOException {
		// TODO Auto-generated method stub
		
		Criptografar criptografa = new Criptografar();
		String uAntCriptografado = criptografa.criptografar(uAnt.getNomeUsuario()).toLowerCase();
		String uAtualCriptografada = criptografa.criptografar(uAtual.getNomeUsuario()).toLowerCase();
		
		File arquivoC = new File("data_u"+uAntCriptografado+".txt");
		File arquivoCA = new File("data_u"+uAtualCriptografada+".txt");
		arquivoCA.createNewFile();
		arquivoC.renameTo(arquivoCA);
		arquivoC.delete();
		
		Usuario insere_uAtual = inserir(uAtual);
		
		if (insere_uAtual.getNomeUsuario().equals(uAtual.getNomeUsuario())) {
			
			boolean remove_uAnt = removerUsuario(uAnt);
			
			if (remove_uAnt == true) {
				return uAtual;
				
			} else {
				arquivoC.createNewFile();
				arquivoCA.renameTo(arquivoC);
				arquivoCA.delete();
				uAnt.setNomeUsuario("Falha na operacao");
				return uAnt;
			}
			
		} else {
			arquivoC.createNewFile();
			arquivoCA.renameTo(arquivoC);
			arquivoCA.delete();
			uAnt.setNomeUsuario("Falha na operacao");
			return uAnt;
		}
	}
	

	@Override
	public List<Usuario> listarTodosUsuarios() throws IOException {
		// TODO Auto-generated method stub
		
		File arquivo = new File("users.txt");

		if (arquivo.exists()) {
		} else {
			new File("users.txt").createNewFile();
		}
		
		BufferedReader reader = null;
		try {
			reader = new BufferedReader(new FileReader(new File("users.txt")));
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		String linha;
		List listaUsersTxt = new LinkedList();
		String[] textoSeparado = null;
		
		try {
			while ((linha = reader.readLine()) != null) {
				Usuario usuario = new Usuario();
				textoSeparado = linha.split("; ");
				usuario.setNomeUsuario(textoSeparado[0]);
				usuario.setSenha(textoSeparado[1]);
				listaUsersTxt.add(usuario);
			}

		} catch (IOException e) {
			e.printStackTrace();
		}
		
		reader.close();
		
		return listaUsersTxt;
	}

}
