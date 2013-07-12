/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import domainModel.Usuario;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lewandowsky
 */
public class UsuarioDAO {
 
    private FileOutputStream arquivo = null;
    private ObjectOutputStream out = null;
    private String nomeArquivo = "arquivo.txt";
    
    public boolean Salvar(Usuario obj ){
        try {
            arquivo = new FileOutputStream(nomeArquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        try {
            out = new ObjectOutputStream(arquivo);
            out.writeObject(obj);
            out.close();
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return false;
        }
        return true;
        
    
    }
    
    
    public Usuario Abrir(){
        FileInputStream arquivoLeitura = null;
        ObjectInputStream objLeitura = null;
        Usuario obj = null;
        try {
            arquivoLeitura = new FileInputStream(nomeArquivo);
           
        } catch (FileNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        try {
            objLeitura = new ObjectInputStream(arquivoLeitura);
            
        } catch (IOException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        try {
            obj = (Usuario) objLeitura.readObject();
        } catch (IOException | ClassNotFoundException ex) {
            Logger.getLogger(UsuarioDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return obj;
    }
    
    
    public Usuario Autenticar(String usuario, String senha){
        Usuario tmp = Abrir();
        if(tmp.getNome().equals(usuario) && tmp.getSenha().equals(senha)){
            return tmp;
        }
        else {
            return null;
        }
    
    
    
    }
   
   
    
    
}
