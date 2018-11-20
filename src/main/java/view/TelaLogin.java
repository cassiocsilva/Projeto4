
package view;

import java.io.File;
import java.io.IOException;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

import model.ServicoUsuarioImpl;
import model.Usuario;

public class TelaLogin extends javax.swing.JFrame {

	public TelaLogin() {
		initComponents();
	}

	@SuppressWarnings("unchecked")

	private void initComponents() {

		jTextField1 = new javax.swing.JTextField();
		jPasswordField1 = new javax.swing.JPasswordField();
		jLabel1 = new javax.swing.JLabel();
		jLabel2 = new javax.swing.JLabel();
		jToggleButton1 = new javax.swing.JToggleButton();
		jButton1 = new javax.swing.JButton();

		setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

		jLabel1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel1.setText("Nome de Usuário");

		jLabel2.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jLabel2.setText("Senha");

		jToggleButton1.setFont(new java.awt.Font("Tahoma", 0, 18)); // NOI18N
		jToggleButton1.setText("OK");

		jButton1.setFont(new java.awt.Font("Tahoma", 1, 14)); // NOI18N
		jButton1.setText("Novo Usuário");

		jButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jButton1ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		jToggleButton1.addActionListener(new java.awt.event.ActionListener() {
			public void actionPerformed(java.awt.event.ActionEvent evt) {
				try {
					jToggleButton1ActionPerformed(evt);
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
		});

		javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
		getContentPane().setLayout(layout);
		layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(37, 37, 37)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jLabel1).addComponent(jLabel2))
						.addGap(18, 18, 18)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
								.addComponent(jPasswordField1).addComponent(jTextField1)
								.addComponent(jToggleButton1, javax.swing.GroupLayout.DEFAULT_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
								.addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE,
										Short.MAX_VALUE))
						.addContainerGap(84, Short.MAX_VALUE)));
		layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
				.addGroup(layout.createSequentialGroup().addGap(70, 70, 70)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
								.addComponent(jTextField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel1))
						.addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
						.addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
								.addComponent(jPasswordField1, javax.swing.GroupLayout.PREFERRED_SIZE,
										javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
								.addComponent(jLabel2))
						.addGap(18, 18, 18)
						.addComponent(jToggleButton1).addGap(27, 27, 27).addComponent(jButton1,
								javax.swing.GroupLayout.PREFERRED_SIZE, 37, javax.swing.GroupLayout.PREFERRED_SIZE)
						.addContainerGap(58, Short.MAX_VALUE)));

		pack();
	}

	
	private void jToggleButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// BOTÃO OK
		
		Usuario loginUsuario = new Usuario();
		loginUsuario.setNomeUsuario(jTextField1.getText());
		loginUsuario.setSenha(new String(jPasswordField1.getPassword()));
		
		ServicoUsuarioImpl sui = new ServicoUsuarioImpl("users.txt");
		Usuario loginCriptografado = sui.controllerTelaLogin(loginUsuario);

		if (loginCriptografado.getNomeUsuario() != null){
			
			if (loginCriptografado.getNomeUsuario().equals("Insira nomeUsuario")){
				JOptionPane pane = new JOptionPane("Insira Nome de Usuário");
		        JDialog dialog = pane.createDialog("");
		        dialog.setLocation(5, 5);
		        dialog.setVisible(true);
		        //JOptionPane.showMessageDialog(null, "Usuário ou senha incorreto(s)", "Alerta", 2);
		        
			} else if (loginCriptografado.getNomeUsuario().equals("Usuário tem cadastro, senha incorreta")){
				JOptionPane pane = new JOptionPane("Senha incorreta");
		        JDialog dialog = pane.createDialog("");
		        dialog.setLocation(5, 5);
		        dialog.setVisible(true);
		        
			} else if (loginCriptografado.getNomeUsuario().equals("Usuário não tem cadastro")){
				JOptionPane pane = new JOptionPane("Usuário não tem cadastro");
		        JDialog dialog = pane.createDialog("");
		        dialog.setLocation(5, 5);
		        dialog.setVisible(true);
			} 
			
			else {
				TelaPrincipal abreTelaPrincipal = new TelaPrincipal(loginCriptografado);
				abreTelaPrincipal.setVisible(true);
				dispose();
			}

		} else {
			System.out.println("Ops, verificaLogin nulo");
		}
		
	}

	private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) throws IOException {
		// BOTÃO CRIAR USUÁRIO
		
		TelaCadastroUsuarioAgenda abreTelaCadastroUsuario = new TelaCadastroUsuarioAgenda();
		abreTelaCadastroUsuario.setVisible(true);
		dispose();		
		
	}


	public static void main(String args[]) {

		try {
			for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
				if ("Nimbus".equals(info.getName())) {
					javax.swing.UIManager.setLookAndFeel(info.getClassName());
					break;
				}
			}
		} catch (ClassNotFoundException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (InstantiationException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (IllegalAccessException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		} catch (javax.swing.UnsupportedLookAndFeelException ex) {
			java.util.logging.Logger.getLogger(TelaLogin.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
		}

		java.awt.EventQueue.invokeLater(new Runnable() {
			public void run() {
				new TelaLogin().setVisible(true);
			}
		});
	}

	// Variables declaration - do not modify//GEN-BEGIN:variables
	static javax.swing.JButton jButton1;
	private javax.swing.JLabel jLabel1;
	private javax.swing.JLabel jLabel2;
	static javax.swing.JPasswordField jPasswordField1;
	static javax.swing.JTextField jTextField1;
	private javax.swing.JToggleButton jToggleButton1;
	// End of variables declaration//GEN-END:variables
}
