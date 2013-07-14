
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
        private String nomeArquivo = "./data/midia"+ retornaNumeroMidia() +".dat";
    
        private void verificaPasta(){
            File dir = new File("./data");
            if(!dir.exists()){
                dir.mkdir();
            }
        
        }
        
        
        
        public boolean Salvar(Midia obj){
            try {
                 verificaPasta();
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
                verificaPasta();
                qtd =  dir.listarArquivosDiretorio("./data").size();
            } catch (ErroValidaçãoException ex) {
                Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
            }
            return qtd;
           
       }
       
       public List<Midia> listarMidias(){
           Diretorios dir = new Diretorios();
           
           List<Midia> listaMidia = new LinkedList<>();//verificar uso
            try {
                 verificaPasta();
                for(File  f : dir.listarArquivosDiretorio("./data")){
                    if( f.getName().endsWith(".dat")){
                          listaMidia.add(Abrir("./data/"+f.getName()));
                                              
                    }
            }
            } catch (ErroValidaçãoException ex) {
                Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return null;
            }
            return listaMidia;
       
       }
       
}
