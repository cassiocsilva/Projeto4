/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package model;

import java.io.IOException;
import java.util.List;

/**
 *
 * @author fabriciogmc
 */
public interface UsuarioDAO {
    public Usuario inserir(Usuario u) throws IOException;
    public Usuario buscarPorNomeUsuario(String nomeUsuario) throws IOException;
    public boolean removerUsuario(Usuario u) throws IOException;
    public Usuario atualizarUsuario(Usuario uAnt, 
                                    Usuario uAtual) throws IOException;
    public List<Usuario> listarTodosUsuarios() throws IOException;    
}
