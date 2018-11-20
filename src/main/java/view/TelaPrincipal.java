package view;

import java.io.IOException;

import model.Contato;
import model.Usuario;


public class TelaPrincipal extends javax.swing.JFrame {
	
	String opcao = "";
	Contato contatoSelecionado;

	public TelaPrincipal(Usuario loginCriptografado) {
		initComponents(loginCriptografado);
		
		this.setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);
	}

	private void initComponents(Usuario loginCriptografado) {

		//ExcluiArquivoReq12 Exclui = new ExcluiArquivoReq12();
		//Exclui.ExcluiArquivoReq12();
		
		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jButton2 = new javax.swing.JButton();
		jButton3 = new javax.swing.JButton();

		jButton1.setText("Buscar Contato");
		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton1ActionPerformed(evt, loginCriptografado);
			}
		});

		jLabel1.setText("Opções básicas da agenda de contatos.");

		jButton2.setText("Listar Contatos");
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

		jButton3.setText("Criar Contatos");
		jButton3.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				jButton3ActionPerformed(evt, loginCriptografado);
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(114, 114, 114)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
								.addComponent(jButton2, javax.swing.GroupLayout.Alignment.LEADING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE)
								.addComponent(jButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton3, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
						.addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
						.addContainerGap(70, Short.MAX_VALUE).addComponent(jLabel1).addGap(58, 58, 58)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addContainerGap().addComponent(jLabel1).addGap(38, 38, 38)
						.addComponent(jButton1).addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addComponent(jButton2).addGap(18, 18, 18).addComponent(jButton3)
						.addContainerGap(107, Short.MAX_VALUE)));
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt, Usuario loginCriptografado) {// GEN-FIRST:event_jButton1ActionPerformed
		// BOTÃO BUSCAR CONTATO
		TelaBusca abreBusca = new TelaBusca(loginCriptografado);
		abreBusca.setVisible(true);
		
	}

	private void jButton2ActionPerformed(java.awt.event.ActionEvent evt, Usuario loginCriptografado) throws IOException {// GEN-FIRST:event_jButton1ActionPerformed
		// BOTÃO LISTAR CONTATO
		String opcao = "listar contatos";
		TelaListagem abreListagem = new TelaListagem(loginCriptografado, opcao, null);
		abreListagem.setVisible(true);
		
	}

	private void jButton3ActionPerformed(java.awt.event.ActionEvent evt, Usuario loginCriptografado) {// GEN-FIRST:event_jButton1ActionPerformed
		// BOTÃO CRIAR CONTATO
		opcao = "Criar Contato";
		TelaCadastro abreCadastro = new TelaCadastro(loginCriptografado,opcao, contatoSelecionado);
		abreCadastro.setVisible(true);
		
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	private javax.swing.JButton jButton1;
	private javax.swing.JButton jButton2;
	private javax.swing.JButton jButton3;
	private javax.swing.JLabel jLabel1;
	// End of variables declaration//GEN-END:variables
}