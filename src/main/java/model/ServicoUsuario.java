
package model;

import java.io.IOException;
import java.util.List;

public interface ServicoUsuario {
	
    public Usuario inserir(Usuario u) throws IOException;
    
    public Usuario inserir(String nomeUsuario, String senha, 
                           List<Contato> contatos) throws IOException;
    
    /* Deve retornar um objeto completo, incluindo
    seus contatos.*/
    public Usuario buscarPorNomeUsuario(String nomeUsuario) throws IOException;
    
    /* A remoção de um usuário deve remover
    os contatos associados, via chamada de serviço
    de contatos.*/
    public boolean removerUsuario(Usuario u) throws IOException;
    
    /* Uma atualização de usuário pode, por exemplo,
    simplesmente alterar os seus contatos, afetando
    a lista do objeto e os arquivos de dados.*/
    public Usuario atualizarUsuario(Usuario uAnt, 
                                    Usuario uAtual) throws IOException;
    
    /* monta uma lista de objetos completos
    de usuário, contendo inclusive todos os contatos
    de cada usuário*/
    public List<Usuario> listarTodosUsuarios() throws IOException;       
}
