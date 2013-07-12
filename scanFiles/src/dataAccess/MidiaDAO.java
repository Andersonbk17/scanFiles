
package dataAccess;

import domainModel.Midia;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
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
        private String nomeArquivo = "midia.txt";
    
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
                return true;
            } catch (IOException ex) {
                Logger.getLogger(MidiaDAO.class.getName()).log(Level.SEVERE, null, ex);
                return false;
            }
    
        }
        
        /*public Midia Abrir(){
            
        
        
        }
        * */
}
