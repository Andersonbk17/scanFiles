/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package presentation;

import dataAccess.MidiaDAO;
import domainModel.Midia;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;
import javax.swing.table.DefaultTableModel;

/**
 *
 * @author lewandowsky
 */
public class frmListagemMidias extends javax.swing.JInternalFrame {

    /**
     * Creates new form frmListagemMidias
     */
    public frmListagemMidias() {
        initComponents();
        preencheTabela();
    }

    private void preencheTabela(){
        DefaultTableModel modelo = new DefaultTableModel();
        modelo.addColumn("ID");
        modelo.addColumn("Rótulo");
        modelo.addColumn("Numero de Arquivos");
        modelo.addColumn("Descrição");
        //MidiaDAO dao = new MidiaDAO();
        //this.listaMidias = dao.listarMidias();
        int id = 0;
        for(Midia m : this.listaMidias){
            ++id;
            Vector v = new Vector();
            v.add(0,id);
            v.add(1,m.getCodMidia());
            v.add(2,m.getListaDeArquivos().size());
            v.add(3,m.getDescricao());
            modelo.addRow(v);
        }
        tblListaMidias.setModel(modelo);
        tblListaMidias.repaint();
  
    }
    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        tblListaMidias = new javax.swing.JTable();
        lblFiltro = new javax.swing.JLabel();
        txtFiltro = new javax.swing.JTextField();
        btnFiltro = new javax.swing.JButton();
        cbjFiltro = new javax.swing.JComboBox();
        jButton1 = new javax.swing.JButton();

        setTitle("Listagem de Midias");
        setMinimumSize(new java.awt.Dimension(1000, 650));
        setPreferredSize(new java.awt.Dimension(1000, 650));

        tblListaMidias.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {},
                {},
                {},
                {}
            },
            new String [] {

            }
        ));
        jScrollPane1.setViewportView(tblListaMidias);

        lblFiltro.setText("Filtro");

        btnFiltro.setText("Filtrar");
        btnFiltro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                btnFiltroActionPerformed(evt);
            }
        });

        cbjFiltro.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Selecione", "Descrição", "Cod. Midia" }));
        cbjFiltro.setToolTipText("Selecione o tipo de Filtro");

        jButton1.setText("Sair");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addContainerGap(25, Short.MAX_VALUE)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 930, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(35, 35, 35))
                    .addGroup(layout.createSequentialGroup()
                        .addComponent(lblFiltro)
                        .addGap(26, 26, 26)
                        .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 427, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(56, 56, 56)
                        .addComponent(cbjFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(btnFiltro)
                        .addGap(122, 122, 122))))
            .addGroup(layout.createSequentialGroup()
                .addGap(308, 308, 308)
                .addComponent(jButton1, javax.swing.GroupLayout.PREFERRED_SIZE, 113, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(65, 65, 65)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(lblFiltro)
                    .addComponent(txtFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(btnFiltro)
                    .addComponent(cbjFiltro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(32, 32, 32)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 366, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 69, Short.MAX_VALUE)
                .addComponent(jButton1)
                .addGap(36, 36, 36))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
       this.dispose();
    }//GEN-LAST:event_jButton1ActionPerformed

    private void btnFiltroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_btnFiltroActionPerformed
        int opcao = cbjFiltro.getSelectedIndex();
        MidiaDAO dao = new MidiaDAO();
        switch(opcao){
        
            case 0:
                this.listaMidias.clear();
                this.listaMidias = dao.listarMidias();
                preencheTabela();
                break;
            case 1:
                this.listaMidias.clear();
                for(Midia m : dao.listarMidias()){
                       if(m.getDescricao().matches("(?i).*"+ txtFiltro.getText() +".*")){
                               this.listaMidias.add(m);     
                    }
                }
                
                preencheTabela();
                break;
            case 2:
                this.listaMidias.clear();
                for(Midia m : dao.listarMidias()){
                       if(m.getCodMidia().matches("(?i).*"+ txtFiltro.getText() +".*")){
                               this.listaMidias.add(m);     
                    }
                }
                
                preencheTabela();
                break;
        
        
        
        }
    }//GEN-LAST:event_btnFiltroActionPerformed
    private List<Midia> listaMidias = new LinkedList<>();
    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton btnFiltro;
    private javax.swing.JComboBox cbjFiltro;
    private javax.swing.JButton jButton1;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JLabel lblFiltro;
    private javax.swing.JTable tblListaMidias;
    private javax.swing.JTextField txtFiltro;
    // End of variables declaration//GEN-END:variables
}
