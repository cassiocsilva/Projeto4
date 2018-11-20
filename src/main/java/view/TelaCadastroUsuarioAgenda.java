package view;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.ServicoUsuarioImpl;
import model.Usuario;

public class TelaCadastroUsuarioAgenda extends javax.swing.JFrame {

	public TelaCadastroUsuarioAgenda() {
		initComponents();
	}

	private void initComponents() {

		jButton1 = new javax.swing.JButton();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jLabel3 = new javax.swing.JLabel();
		jTextField1 = new javax.swing.JTextField();
		jTextField2 = new javax.swing.JTextField();
		jTextField3 = new javax.swing.JTextField();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jButton1.setText("Cadastrar");
		jLabel1.setText("Nome de Usuário: ");
		jLabel2.setText("Senha:");
		jLabel3.setText("Confirmação de Senha:");

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(
				layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING).addGroup(layout
						.createSequentialGroup().addGap(54, 54, 54).addGroup(layout
								.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
								.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
										.addGroup(layout.createSequentialGroup().addComponent(jLabel2)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout
												.createSequentialGroup()
												.addComponent(jLabel1)
												.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED,
														javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
												.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
														javax.swing.GroupLayout.PREFERRED_SIZE))
										.addGroup(javax.swing.GroupLayout.Alignment.TRAILING,
												layout.createSequentialGroup().addComponent(jLabel3).addGap(49, 49, 49)
														.addComponent(jTextField2,
																javax.swing.GroupLayout.PREFERRED_SIZE, 116,
																javax.swing.GroupLayout.PREFERRED_SIZE)))
								.addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 116,
										javax.swing.GroupLayout.PREFERRED_SIZE))
						.addContainerGap(46, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup().addGap(26, 26, 26)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel1).addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel2).addComponent(jTextField3, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jLabel3).addComponent(jTextField2, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED).addComponent(jButton1)
						.addContainerGap(28, Short.MAX_VALUE)));

		pack();
	}// </editor-fold>//GEN-END:initComponents

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {// GEN-FIRST:event_jButton1ActionPerformed
		// BOTÃO CADASTRAR:

		String nomeUsuario = (jTextField1.getText());
		String senha = (jTextField3.getText());
		String cadastroConfirmaSenha = (jTextField2.getText());
		
		if ((senha.equals(cadastroConfirmaSenha)) && (nomeUsuario.length() > 0)) {
			
			ServicoUsuarioImpl sui = new ServicoUsuarioImpl("users.txt");
			Usuario validarEouCadastrar = sui.inserir(nomeUsuario,senha,null);
			
			if (validarEouCadastrar.getNomeUsuario().equals(nomeUsuario)) {
				TelaLogin abreTelaLogin = new TelaLogin();
				abreTelaLogin.setVisible(true);
				dispose();
				
			} else if (validarEouCadastrar.getNomeUsuario().equals("Usuario já tem cadastro")){
				JOptionPane pane = new JOptionPane("Usuario já tem cadastro");
				JDialog dialog = pane.createDialog("");
				dialog.setLocation(5, 5);
				dialog.setVisible(true);

			} else if (validarEouCadastrar.getNomeUsuario().equals("Falha na operacao")){
				JOptionPane pane = new JOptionPane("Falha na operacao, tente novamente");
				JDialog dialog = pane.createDialog("");
				dialog.setLocation(5, 5);
				dialog.setVisible(true);
			} else {
				JOptionPane pane = new JOptionPane("Dados inválidos: " + validarEouCadastrar.getNomeUsuario());
				JDialog dialog = pane.createDialog("");
				dialog.setLocation(5, 5);
				dialog.setVisible(true);
			}
			
		} else if (nomeUsuario.length() == 0) {
			JOptionPane pane = new JOptionPane("Insira Nome de Usuário");
			JDialog dialog = pane.createDialog("");
			dialog.setLocation(5, 5);
			dialog.setVisible(true);
		
		
		} else {
			JOptionPane pane = new JOptionPane("Senha diferente de Confirmação de Senha");
			JDialog dialog = pane.createDialog("");
			dialog.setLocation(5, 5);
			dialog.setVisible(true);
		}
		

	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	static javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	private javax.swing.JLabel jLabel3;
	static javax.swing.JTextField jTextField1;
	static javax.swing.JTextField jTextField2;
	static javax.swing.JTextField jTextField3;
	// End of variables declaration//GEN-END:variables
}