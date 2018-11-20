
package model;


public class Contato {
    private String nome;
    private String telefone;
    private String endereco;
    private String email;
    
    public Contato(){}
    
    //Criar outros construtores caso deseje

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
    
    public String getEndereco(){
    	return endereco;
    }
    
	public void setEndereco(String endereco) {
		this.endereco = endereco;
		
	}
    
    
    
    //Implementar a versão correta.
    @Override
    public boolean equals(Object o){
        return false;
    }

}
