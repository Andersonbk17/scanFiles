/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModel;

import java.io.File;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lewandowsky
 */
public class Diretorios {
    
    public List<File> listarArquivosDiretorio(String caminho) throws ErroValidaçãoException{
        List<File> listaArquivos = new LinkedList<>();
        File dir = new File(caminho);
       
            if(!dir.isDirectory()) {
                throw new  ErroValidaçãoException("O caminho informado não é um diretório valido !");
                
            }
        
        for(File f : dir.listFiles()){
            if(f.isDirectory()){
                listaArquivos.addAll(listarArquivosDiretorio(f.getPath()));
            }else {
                listaArquivos.add(f);
            }
        }
      
       return listaArquivos;
    }
    
}
