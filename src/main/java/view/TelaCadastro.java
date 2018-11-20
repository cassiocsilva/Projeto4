package view;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.Contato;
import model.ServicoContatoImpl;
import model.Usuario;

public class TelaCadastro extends javax.swing.JFrame {

	public TelaCadastro(Usuario loginCriptografado, String opcao, Contato contatoSelecionado) {
		// TODO Auto-generated constructor stub
		initComponents(loginCriptografado, opcao, contatoSelecionado);
	}

	private void initComponents(Usuario loginCriptografado, String opcao, Contato contatoSelecionado) {

		jTextField1 = new javax.swing.JTextField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jLabel4 = new javax.swing.JLabel();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();
		jTextField4 = new javax.swing.JTextField();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.DISPOSE_ON_CLOSE);

		jLabel1.setText("Nome");
		jLabel2.setText("Telefone");
		jLabel3.setText("Email");
		jLabel4.setText("Endereço");

		jTextField2.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jTextField2ActionPerformed(evt, loginCriptografado, opcao);
			}
		});

		if (opcao.equals("Criar Contato")) {
			
			jButton1.setText("Cadastrar");

		} else if (opcao.equals("Editar Contato")) {
			
			jButton1.setText("Editar");
			jTextField1.setText(contatoSelecionado.getNome());
			jTextField3.setText(contatoSelecionado.getTelefone());
			jTextField4.setText(contatoSelecionado.getEmail());
			jTextField2.setText(contatoSelecionado.getEndereco());

		}

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt, loginCriptografado, opcao, contatoSelecionado);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
						.addGroup(layout.createSequentialGroup().addGap(32, 32, 32).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addGroup(layout.createSequentialGroup()
										.addGroup(
												layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
														.addComponent(jLabel1).addComponent(jLabel3)
														.addComponent(jLabel2))
										.addGap(21, 21, 21)
										.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
												.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 211,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE, 211,
														javax.swing.GroupLayout.PREFERRED_SIZE)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 211,
														javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addGroup(layout.createSequentialGroup().addComponent(jLabel4).addGap(18, 18, 18)
										.addGroup(layout
												.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
												.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jTextField2, javax.swing.GroupLayout.DEFAULT_SIZE, 211,
														Short.MAX_VALUE))))
								.addContainerGap(55, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
				.createSequentialGroup().addGap(42, 42, 42)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
						.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
								javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addComponent(jLabel1))
				.addGap(18, 18, 18)
				.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING).addGroup(layout
						.createSequentialGroup()
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel2).addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jTextField4, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addGap(18, 18, 18).addComponent(jLabel4)).addComponent(jTextField2,
								javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
								javax.swing.GroupLayout.PREFERRED_SIZE))
				.addGap(18, 18, 18).addComponent(jButton1).addContainerGap(79, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jTextField2ActionPerformed(java.awt.event.ActionEvent evt, Usuario loginCriptografado, String opcao) {// GEN-FIRST:event_jTextField2ActionPerformed
		// TODO add your handling code here:
	}// GEN-LAST:event_jTextField2ActionPerformed

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, Usuario loginCriptografado, String opcao,
			Contato contatoSelecionado) throws IOException {// GEN-FIRST:event_jButton1ActionPerformed
		// BOTÃO CADASTRAR/EDITAR
			
		Contato c = new Contato();
		c.setNome(jTextField1.getText());
		c.setTelefone(jTextField3.getText());
		c.setEmail(jTextField4.getText());
		c.setEndereco(jTextField2.getText());
		Contato cAtual = c;
		
		String nome_arq_dados_c = "data_u"+loginCriptografado.getNomeUsuario()+".txt";
		
		if (opcao.equals("Criar Contato")){
			
			ServicoContatoImpl sci = new ServicoContatoImpl(nome_arq_dados_c);		
			Contato validarEouInserir = sci.inserir(c.getNome(), c.getTelefone(), c.getEmail(), c.getEndereco());
			
			if (validarEouInserir.getNome().equals("true")) {
				JOptionPane pane = new JOptionPane("Cadastro realizado, só sucesso!");
		        JDialog dialog = pane.createDialog("");
		        dialog.setLocation(5, 5);
		        dialog.setVisible(true);			
				dispose();
			} else {
				JOptionPane pane = new JOptionPane("Cadastro não realizado, dados inválidos:\n"+validarEouInserir.getNome());
		        JDialog dialog = pane.createDialog("");
		        dialog.setLocation(5, 5);
		        dialog.setVisible(true);
			}

		} else if (opcao.equals("Editar Contato")){
			
			System.out.println("TELA CADASTRO / contatoSelecionado.getNome()"+contatoSelecionado.getNome());
			System.out.println("TELA CADASTRO / cAtual.getNome()"+cAtual.getNome());
			
			ServicoContatoImpl sci = new ServicoContatoImpl(nome_arq_dados_c);				
			Contato validarEouEditar = sci.atualizarContato(contatoSelecionado, cAtual);
			
			if (validarEouEditar.getNome().equals("true")) {
				JOptionPane pane = new JOptionPane("Cadastro editado, só sucesso!");
		        JDialog dialog = pane.createDialog("");
		        dialog.setLocation(5, 5);
		        dialog.setVisible(true);			
				dispose();
				
				TelaListagem abreListagem = new TelaListagem(loginCriptografado, null, null);
				abreListagem.setVisible(true);
				
			} else {
				JOptionPane pane = new JOptionPane("Cadastro não editado, dados inválidos:\n"+validarEouEditar.getNome());
		        JDialog dialog = pane.createDialog("");
		        dialog.setLocation(5, 5);
		        dialog.setVisible(true);
			}	
		}
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	private javax.swing.JLabel jLabel4;
	private javax.swing.JTextField jTextField1;
	private javax.swing.JTextField jTextField2;
	private javax.swing.JTextField jTextField3;
	private javax.swing.JTextField jTextField4;
	// End of variables declaration//GEN-END:variables
}