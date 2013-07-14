/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package dataAccess;

import domainModel.Midia;
import java.util.Collection;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 *
 * @author lewandowsky
 */
public class teste {
    public static void main(String[] args) {
     
        MidiaDAO dao = new MidiaDAO();
        List<Midia> lista = dao.listarMidias();
       //lista.get(1).getCodMidia().
        Collection <String> filtro;
        List<String>  nome =  new LinkedList<>();
        nome.add("Anderson.txt");
        nome.add("carlos.dat");
        
        if(nome.get(0).matches("(?i).*  frase    .*")){
            System.out.printf("tem");
        }
        
        /*
         Fazer os testes de expressão regular
         
         
         */
        
        
        // System.out.print();
        
        
    }
}
