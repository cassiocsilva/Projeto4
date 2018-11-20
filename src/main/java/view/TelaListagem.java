
package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.Contato;
import model.Criptografar;
import model.ServicoContatoImpl;
import model.Usuario;

public class TelaListagem extends javax.swing.JFrame {

	Contato contatoSelecionado;
	String nome_arq_dados_c;

	public TelaListagem(Usuario loginCriptografado, String opcao, List<Contato> listaFiltroBusca) throws IOException {
		initComponents(loginCriptografado);

		if (opcao.equals("listar contatos")) {

			this.nome_arq_dados_c = "data_u" + loginCriptografado.getNomeUsuario() + ".txt";

			ServicoContatoImpl sci = new ServicoContatoImpl(nome_arq_dados_c);
			List<Contato> listaDataU = sci.listarTodosContatos();

			for (int i = 0; i < listaDataU.size(); i++) {

				Contato c = new Contato();
				c = listaDataU.get(i);
				this.list1.add(c.getNome() + "; " + c.getTelefone() + "; " + c.getEmail() + "; " + c.getEndereco());
			}

		}
		else if (opcao.equals("buscar contatos")) {
			
			for (int i=0; i<listaFiltroBusca.size(); i++) {
				Contato f = new Contato();
				f = listaFiltroBusca.get(i);
				this.list1.add(f.getNome() + "; " + f.getTelefone() + "; " + f.getEmail() + "; " + f.getEndereco());
			}
		}
	}

	@SuppressWarnings("unchecked")

	private void initComponents(Usuario loginCriptografado) {

		jLabel1 = new javax.swing.JLabel();
		list1 = new java.awt.List();
		jButton1 = new javax.swing.JButton();
		jButton2 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("Contatos existentes na agenda:");

		list1.addItemListener(new java.awt.event.ItemListener() {
			public void itemStateChanged(java.awt.event.ItemEvent evt) {
				list1ItemStateChanged(evt);

			}
		});

		jButton1.setText("Editar");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt, loginCriptografado);
			}
		});

		jButton2.setText("Excluir");
		jButton2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton2ActionPerformed(evt, loginCriptografado);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(33, 33, 33)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup().addComponent(jButton1)
										.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
										.addComponent(jButton2))
								.addComponent(jLabel1).addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 306,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(41, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(22, 22, 22)
						.addComponent(list1, javax.swing.GroupLayout.PREFERRED_SIZE, 218,
								javax.swing.GroupLayout.PREFERRED_SIZE)
						.addGap(23, 23, 23)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jButton1).addComponent(jButton2))
						.addContainerGap(32, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void list1ItemStateChanged(java.awt.event.ItemEvent evt) {// GEN-FIRST:event_list1ItemStateChanged
		// SELECIONAR CONTATO

		String[] selecao = list1.getSelectedItem().split("; ");

		for (int i = 0; i < selecao.length; i++) {
			Contato contatoS = new Contato();
			contatoS.setNome(selecao[0]);
			contatoS.setTelefone(selecao[1]);
			contatoS.setEmail(selecao[2]);
			contatoS.setEndereco(selecao[3]);
			this.contatoSelecionado = contatoS;
		}
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, Usuario loginCriptografado) {// GEN-FIRST:event_jButton1ActionPerformed
		// BOTÃO EDITAR CONTATO

		System.out.println("TELA LISTAGEM / contatoSelecionado.getNome()" + contatoSelecionado.getNome());

		String opcao = "Editar Contato";

		TelaCadastro abreTelaCadastro = new TelaCadastro(loginCriptografado, opcao, contatoSelecionado);
		abreTelaCadastro.setVisible(true);
		dispose();
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, Usuario loginCriptografado)
			throws IOException {// GEN-FIRST:event_jButton1ActionPerformed
		// BOTÃO EXCLUIR CONTATO

		ServicoContatoImpl sci = new ServicoContatoImpl(nome_arq_dados_c);
		boolean excluir = sci.removerContato(contatoSelecionado);

		dispose();
		TelaListagem abreTelaListagem = new TelaListagem(loginCriptografado, null, null);
		abreTelaListagem.setVisible(true);

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JLabel jLabel1;
	private java.awt.List list1;
	// End of variables declaration//GEN-END:variables
}