
package dataAccess;

import domainModel.Midia;
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
public class MidiaDAO {
        private FileOutputStream arquivo = null;
        private ObjectOutputStream out = null;
        private String nomeArquivo = "midia.dat";
    
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
        
       public Midia Abrir(){
           FileInputStream arquivo1 =  null;
           ObjectInputStream objSalvo =  null;
           String nomeArquivo1 = "midia.dat";
        try {
            arquivo1 = new FileInputStream(nomeArquivo1);
        } catch (FileNotFoundException ex) {
            Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        try {
            objSalvo =  new ObjectInputStream(arquivo1);
               try {
                Midia readObject =(Midia) objSalvo.readObject();
                System.out.print(readObject.getListaDeArquivos());
               } catch (ClassNotFoundException ex) {
                   Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
               }
        } catch (IOException ex) {
            Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
        }
        return null;
        }
       
}
