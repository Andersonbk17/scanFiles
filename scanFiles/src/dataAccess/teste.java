/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import domainModel.Usuario;

/**
 *
 * @author lewandowsky
 */
public class teste {
    public static void main(String[] args) {
        UsuarioDAO u = new UsuarioDAO();
        Usuario ua = new Usuario();
        ua.setNome("Ronaldo");
        ua.setSenha("a");
        if(u.Autenticar("Ronaldo", "b") != null){
            System.out.print("ok");
        }
        //u.lerArquivo();
        //System.out.print(u.getNome());
        //u.FecharArquivo();
        
    }
}
