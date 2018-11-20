package model;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

import view.TelaListagem;

public class ContatoDAO_Impl implements ContatoDAO {

	String nome_arq_dados_c;

	public ContatoDAO_Impl(String nome_arq_dados_c) {
		// TODO Auto-generated method stub
		this.nome_arq_dados_c = nome_arq_dados_c;
	}

	@Override
	public Contato inserir(Contato c) throws IOException {

		File arquivoDataU = new File(nome_arq_dados_c);
		
		if (arquivoDataU.exists()) {
		} else {
			arquivoDataU.createNewFile();
		}

		try {

			FileWriter fw = new FileWriter(arquivoDataU, true);
			PrintWriter escreverNoArquivoDeDados = new PrintWriter(fw);
			escreverNoArquivoDeDados.println(c.getNome().toUpperCase() + "; " + c.getTelefone() + "; " + 
					c.getEmail() + "; " + c.getEndereco() + "");
			fw.close();

		} catch (IOException e) {
			e.printStackTrace();
		}
		c.setNome("true");
		return c;
	}

	@Override
	public List<Contato> buscarPorParteNome(String parteNome) throws IOException {
		// TODO Auto-generated method stub
		
		List<Contato> listaDataU = listarTodosContatos();
		List<Contato> listaFiltroBusca = new LinkedList();
		
		for (int i=0; i<listaDataU.size(); i++) {
			
			if (listaDataU.get(i).getNome().contains(parteNome.toUpperCase())) {
				
				listaFiltroBusca.add(listaDataU.get(i));
			}
		}
		return listaFiltroBusca;
	}

	
	@Override
	public boolean removerContato(Contato c) throws IOException {
		// TODO Auto-generated method stub
				
		File arquivoTemp = new File("arquivoTemp.txt");
		if (arquivoTemp.exists()) {
			arquivoTemp.delete();
			new File("arquivoTemp.txt").createNewFile();
		} else {
			new File("arquivoTemp.txt").createNewFile();
		}

		File arquivoDados = new File(nome_arq_dados_c);
		File arquivoTemporario = new File("arquivoTemp.txt");
		
		Contato contact = new Contato();
		contact = c;

		try {

			BufferedReader br = new BufferedReader(new FileReader(arquivoDados));

			while (br.ready()) {
				
				String linha = br.readLine();

				if ((linha.contains(c.getNome().toUpperCase()+"; "+c.getTelefone()+"; "+c.getEmail()+"; "+c.getEndereco()))) {
					linha = ("");
				}
				if (linha.equals("")) {
					continue;
				}

				FileWriter aTemp = new FileWriter(arquivoTemporario, true);
				PrintWriter escreverNoArquivoDeDados = new PrintWriter(aTemp);
				escreverNoArquivoDeDados.println(linha);
				aTemp.close();
			}

			br.close();
			arquivoDados.delete();
			arquivoTemporario.renameTo(arquivoDados);		
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		return true;
	}

	
	@Override
	public Contato atualizarContato(Contato cAnt, Contato cAtual) throws IOException {
		
		boolean removerAnt = removerContato(cAnt);
		
		if (removerAnt == true) {
			
			Contato inserirAtual = inserir(cAtual);
			
			if (inserirAtual.getNome().equals("true")) {
				
				return cAtual;
				
			} else {
				cAtual.setNome("Falha na operação");
				return cAtual;
			}
		} else {
			cAtual.setNome("Falha na operação");
			return cAtual;
		}
	}
	

	@Override
	public List<Contato> listarTodosContatos() throws IOException {

		File arquivoTemp = new File("temp.txt");
		if (arquivoTemp.exists()) {
			arquivoTemp.delete();
			new File("temp.txt").createNewFile();
		} else {
			new File("temp.txt").createNewFile();
		}
		
		File arquivoDados = new File(nome_arq_dados_c);
		if (arquivoDados.exists()) {
		} else {
			arquivoDados.createNewFile();
		}
		
		File arquivoTemporario = new File("temp.txt");
		List listaDataU = new LinkedList();

		try {

			BufferedReader br = new BufferedReader(new FileReader(arquivoDados));
			ArrayList<String> listaLinhas = new ArrayList<String>();

			while (br.ready()) {

				String linha = br.readLine();

				if (linha != null) {
					listaLinhas.add(linha);
				}

				Collections.sort(listaLinhas);
			}

			FileWriter aTemp = new FileWriter(arquivoTemporario, true);
			PrintWriter escreverNoArquivoDeDados = new PrintWriter(aTemp);

			for (int i = 0; i < listaLinhas.size(); i++) {

				escreverNoArquivoDeDados.println(listaLinhas.get(i));

				String[] textoSeparado = null;

				Contato contato = new Contato();
				textoSeparado = listaLinhas.get(i).split("; ");
				contato.setNome(textoSeparado[0]);
				contato.setTelefone(textoSeparado[1]);
				contato.setEmail(textoSeparado[2]);
				contato.setEndereco(textoSeparado[3]);
				listaDataU.add(contato);

			}

			aTemp.close();
			br.close();
			arquivoDados.delete();
			arquivoTemporario.renameTo(arquivoDados);

		} catch (IOException e) {
			e.printStackTrace();
		}

		return listaDataU;
	}
}
