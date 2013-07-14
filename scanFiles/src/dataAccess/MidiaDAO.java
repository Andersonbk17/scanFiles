
package dataAccess;

import domainModel.Diretorios;
import domainModel.ErroValidaçãoException;
import domainModel.Midia;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.LinkedList;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author lewandowsky
 */
public class MidiaDAO {
        private FileOutputStream arquivo = null;
        private ObjectOutputStream out = null;
        private String nomeArquivo = "midia"+ retornaNumeroMidia() +".dat";
    
        public boolean Salvar(Midia obj){
            try {
                arquivo = new FileOutputStream(nomeArquivo);
            } catch (FileNotFoundException ex) {
                Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
            try {
                out = new ObjectOutputStream(arquivo);
                out.writeObject(obj);
                out.close();
                return true;
            } catch (IOException ex) {
                Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    
        }
        
       public Midia Abrir(String nomeArquivo) {
        FileInputStream arquivo1 = null;
        ObjectInputStream objSalvo = null;
        
        try {
            arquivo1 = new FileInputStream(nomeArquivo);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        try {
            objSalvo = new ObjectInputStream(arquivo1);
            try {
                Midia readObject = (Midia) objSalvo.readObject();
                return readObject;
                
            } catch (ClassNotFoundException ex) {
                Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
        } catch (IOException ex) {
            Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            return null;
        }
        
    }
       
       
       public int retornaNumeroMidia(){
        
           Diretorios dir = new Diretorios();
           int qtd= 0 ;
        try {
            qtd =  dir.listarArquivosDiretorio("./").size();
        } catch (ErroValidaçãoException ex) {
            Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return qtd;
           
       }
       
       public List<File> listarMidias(){
           Diretorios dir = new Diretorios();
           List<File> listaArquivos = new LinkedList<>();
           
            try {
                 
                for(File  f : dir.listarArquivosDiretorio("./")){
                    if( f.getName().endsWith(".dat")){
                        listaArquivos.add(f);
                    }
            }
            } catch (ErroValidaçãoException ex) {
                Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return listaArquivos;
       
       }
       
}
