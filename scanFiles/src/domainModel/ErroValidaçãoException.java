/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package domainModel;

import javax.swing.JOptionPane;

/**
 *
 * @author lewandowsky
 */
public class ErroValidaçãoException extends Exception{
   
    public ErroValidaçãoException(String msg){
        super(msg);
        JOptionPane.showMessageDialog(null, msg);
    }
}
