/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgm.telas.Consulta;

import java.awt.Component;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JDesktopPane;
import javax.swing.JOptionPane;
import javax.swing.table.DefaultTableModel;
import sgm.dao.ContratoDAO;
import sgm.dao.MercadoDAO;
import sgm.dao.PrefeituraDAO;
import sgm.dominio.Contrato;
import sgm.dominio.Mercado;
import sgm.dominio.Prefeitura;


public class ConsultarContrato extends javax.swing.JInternalFrame {
    private MercadoDAO mercadoDAO;
    private List <Mercado> mercados;
    private Mercado mercado;
    private ContratoDAO contratoDAO;
    private List <Contrato> contratos;
    
    public ConsultarContrato() {
        initComponents();
        this.aCSelMer.removeAllItems();
        mercadoDAO = new MercadoDAO();
        contratoDAO = new ContratoDAO();
        mercados = mercadoDAO.listar();
        contratos = contratoDAO.listar();
        for(Mercado mercado : mercados){
            aCSelMer.addItem(mercado.getNome());
        }
    }
    
    private void carregarTabela(){
        DefaultTableModel tabela = (DefaultTableModel)aCTabela.getModel();
        tabela.getDataVector().removeAllElements();
        tabela.fireTableDataChanged();
        for(Contrato c : contratos){
            if(c.getMercado().getCnpj().equals(this.mercado.getCnpj())){
                Object dados[] = new Object[]{c.getIdContrato(), c.getLocatario().getNome(), c.getBox()};
                tabela.addRow(dados);                
            }
        }
    }

    /**
     * This method is called from within the constructor to initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is always
     * regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        aCAlt = new javax.swing.JButton();
        aCCancelar = new javax.swing.JButton();
        aCSelMer = new javax.swing.JComboBox<>();
        jScrollPane1 = new javax.swing.JScrollPane();
        aCTabela = new javax.swing.JTable();
        aCSel = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Contrato");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("Selecione o Mercado:");

        aCAlt.setText("Consultar");
        aCAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCAltActionPerformed(evt);
            }
        });

        aCCancelar.setText("Cancelar");
        aCCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCCancelarActionPerformed(evt);
            }
        });

        aCSelMer.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCSelMerActionPerformed(evt);
            }
        });

        aCTabela.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {
                {null, null, null}
            },
            new String [] {
                "Nº DO CONTRATO", "LOCATARIO", "Nº DO BOX"
            }
        ) {
            Class[] types = new Class [] {
                java.lang.String.class, java.lang.Object.class, java.lang.String.class
            };

            public Class getColumnClass(int columnIndex) {
                return types [columnIndex];
            }
        });
        jScrollPane1.setViewportView(aCTabela);

        jLabel2.setText("Nº do contrato para consulta detalhada:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 459, Short.MAX_VALUE)
                            .addComponent(aCSelMer, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel1)
                                .addGap(0, 0, Short.MAX_VALUE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                                .addGap(0, 0, Short.MAX_VALUE)
                                .addComponent(aCCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 79, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                .addComponent(aCAlt))))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(120, 120, 120)
                                .addComponent(jLabel2))
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addGap(201, 201, 201)
                                .addComponent(aCSel, javax.swing.GroupLayout.PREFERRED_SIZE, 61, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(32, 32, 32)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aCSelMer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 156, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 42, Short.MAX_VALUE)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aCSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(45, 45, 45)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aCCancelar)
                    .addComponent(aCAlt))
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void aCAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCAltActionPerformed
        int numeroContrato = Integer.parseInt(this.aCSel.getText());
        ConsultaDetalhadaContrato tela = new ConsultaDetalhadaContrato(numeroContrato);
        JDesktopPane desktop = this.getDesktopPane();
        this.dispose();
        desktop.add(tela);
        tela.setVisible(true);
    }//GEN-LAST:event_aCAltActionPerformed

    private void aCSelMerActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCSelMerActionPerformed
        this.mercado = mercados.get(this.aCSelMer.getSelectedIndex());
        carregarTabela();
    }//GEN-LAST:event_aCSelMerActionPerformed

    private void aCCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_aCCancelarActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aCAlt;
    private javax.swing.JButton aCCancelar;
    private javax.swing.JTextField aCSel;
    private javax.swing.JComboBox<String> aCSelMer;
    private javax.swing.JTable aCTabela;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JScrollPane jScrollPane1;
    // End of variables declaration//GEN-END:variables
}
