/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import domainModel.Diretorios;
import java.io.File;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.JFileChooser;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lewandowsky
 */
public class frmScanner extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmScanner
     */
    public frmScanner() {
        initComponents();
    }
    
    
    private void listarArquivosDietorio(String Caminho){
      Diretorios tmp = new Diretorios();
        this.litaArquivos = tmp.listarArquivosDiretorio(Caminho);
        /*
         * 
         * teste
        for(File f : listarArquivosDiretorio){
            System.out.print(f.getName() +"tamanho = " + (f.length() / 1024)+"\n");
        */
    }
    
    private void preencheTabela(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("Nome do Arquivo");
        modelo.addColumn("Caminho");
        modelo.addColumn("Data de Criação");
        modelo.addColumn("Tamanho");
        DateFormat df = new SimpleDateFormat ("dd/MM/yyyy HH:mm:ss.SSS");  
        for(File a : this.litaArquivos){
            Vector v = new Vector();
            v.add(0,a.getName());
            v.add(1,a.getPath());
            Date tmpData = new Date(a.lastModified());
            df.format(tmpData);
            
            v.add(2,tmpData);
            v.add(3,(a.length() / 1024));
            //v.add(3,a.getTipo());
            modelo.addRow(v);
        
        }
        
        this.tblListaDeArquivos.setModel(modelo);
        this.tblListaDeArquivos.repaint();
   
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        lblCodMidia = new javax.swing.JLabel();
        txtCodMidia = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaDeArquivos = new javax.swing.JTable();
        btnEscolher = new javax.swing.JButton();
        lblCaminhoDaMidia = new javax.swing.JLabel();
        txtCaminhoDaMidia = new javax.swing.JTextField();
        btnScan = new javax.swing.JButton();

        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1000, 650));

        lblCodMidia.setText("Código da Midia");

        tblListaDeArquivos.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblListaDeArquivos);

        btnEscolher.setText("Escolher");
        btnEscolher.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnEscolherActionPerformed(evt);
            }
        });

        lblCaminhoDaMidia.setText("Caminho da midia");

        btnScan.setText("Scan");
        btnScan.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnScanActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCodMidia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(txtCodMidia, javax.swing.GroupLayout.PREFERRED_SIZE, 199, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addGap(20, 20, 20)
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 941, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(lblCaminhoDaMidia)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(txtCaminhoDaMidia, javax.swing.GroupLayout.PREFERRED_SIZE, 360, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)
                        .addComponent(btnEscolher)
                        .addGap(104, 104, 104)
                        .addComponent(btnScan, javax.swing.GroupLayout.PREFERRED_SIZE, 134, javax.swing.GroupLayout.PREFERRED_SIZE)))
                .addContainerGap(29, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(35, 35, 35)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCodMidia)
                    .addComponent(txtCodMidia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(30, 30, 30)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblCaminhoDaMidia)
                    .addComponent(txtCaminhoDaMidia, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnEscolher)
                    .addComponent(btnScan, javax.swing.GroupLayout.PREFERRED_SIZE, 51, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(55, 55, 55)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(62, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void btnEscolherActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnEscolherActionPerformed
       JFileChooser pasta = new JFileChooser();
       pasta.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
       pasta.showOpenDialog(this);
       this.txtCaminhoDaMidia.setText( pasta.getSelectedFile().getPath());
      
       
    }//GEN-LAST:event_btnEscolherActionPerformed

    private void btnScanActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnScanActionPerformed
        listarArquivosDietorio(txtCaminhoDaMidia.getText());
        preencheTabela();
    }//GEN-LAST:event_btnScanActionPerformed
   
    private List<File> litaArquivos = new LinkedList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnEscolher;
    private javax.swing.JButton btnScan;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblCaminhoDaMidia;
    private javax.swing.JLabel lblCodMidia;
    private javax.swing.JTable tblListaDeArquivos;
    private javax.swing.JTextField txtCaminhoDaMidia;
    private javax.swing.JTextField txtCodMidia;
    // End of variables declaration//GEN-END:variables
}
