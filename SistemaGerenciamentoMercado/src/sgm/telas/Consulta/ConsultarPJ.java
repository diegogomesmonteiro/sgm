/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package sgm.telas.Consulta;

import java.util.List;
import javax.swing.JOptionPane;
import sgm.dao.PessoaFisicaDAO;
import sgm.dao.PessoaJuridicaDAO;
import sgm.dominio.PessoaFisica;
import sgm.dominio.PessoaJuridica;

/**
 *
 * @author aligr
 */
public class ConsultarPJ extends javax.swing.JInternalFrame {

    private PessoaJuridicaDAO pJDAO;
    private List <PessoaJuridica> listaPJ;
    private PessoaJuridica pJ;
    
    
    public ConsultarPJ() {
        initComponents();
        this.aPJSel.removeAllItems();
        pJDAO = new PessoaJuridicaDAO();
        listaPJ = pJDAO.listar();
        for(PessoaJuridica p : listaPJ){
            this.aPJSel.addItem(p.getNome());
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
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        apjAlt = new javax.swing.JButton();
        aPJCnpj = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        aPJEnd = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        aPJNome = new javax.swing.JTextField();
        aPJNomeF = new javax.swing.JTextField();
        aPJCpf = new javax.swing.JFormattedTextField();
        apjCancelar = new javax.swing.JButton();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel6 = new javax.swing.JLabel();
        aPJSel = new javax.swing.JComboBox<>();
        jButton1 = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Pessoa Jur??dica");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("CNPJ:");

        jLabel2.setText("NOME:");

        jLabel3.setText("NOME FANTASIA:");

        apjAlt.setText("Alterar");
        apjAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apjAltActionPerformed(evt);
            }
        });

        try {
            aPJCnpj.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###/####-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        aPJCnpj.setEnabled(false);
        aPJCnpj.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aPJCnpjActionPerformed(evt);
            }
        });

        jLabel4.setText("ENDERE??O:");

        jLabel5.setText("CPF DO REPRESENTANTE LEGAL:");

        try {
            aPJCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        aPJCpf.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        aPJCpf.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aPJCpfActionPerformed(evt);
            }
        });

        apjCancelar.setText("Cancelar");
        apjCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apjCancelarActionPerformed(evt);
            }
        });

        jLabel6.setText("Selecione a Pessoa Jur??dica que deseja consultar:");

        aPJSel.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aPJSelActionPerformed(evt);
            }
        });

        jButton1.setText("Excluir");
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(86, 86, 86))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(aPJNome)
                    .addComponent(aPJNomeF)
                    .addComponent(aPJEnd)
                    .addComponent(aPJSel, javax.swing.GroupLayout.Alignment.TRAILING, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                            .addComponent(apjCancelar)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                .addComponent(aPJCpf, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(aPJCnpj, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                                .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(apjAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(jButton1)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel6)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aPJSel, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 14, Short.MAX_VALUE)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aPJCnpj, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aPJNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(20, 20, 20)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aPJNomeF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aPJEnd, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(aPJCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(apjAlt)
                    .addComponent(apjCancelar)
                    .addComponent(jButton1))
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

    private void apjAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apjAltActionPerformed
        PessoaFisicaDAO pfDAO = new PessoaFisicaDAO();
        PessoaFisica representanteLegal = pfDAO.consultar(this.aPJCpf.getText());
        pJ = new PessoaJuridica(this.aPJCnpj.getText(), this.aPJNome.getText(), this.aPJNomeF.getText(),
            this.aPJEnd.getText(), representanteLegal);
        pJDAO.alterar(pJ);
        JOptionPane.showMessageDialog(null, "Pessoa Jur??dica: \n" + pJ + "\n Altera????o realizada com sucesso!");
        this.dispose();
    }//GEN-LAST:event_apjAltActionPerformed

    private void aPJCnpjActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aPJCnpjActionPerformed

    }//GEN-LAST:event_aPJCnpjActionPerformed

    private void aPJCpfActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aPJCpfActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aPJCpfActionPerformed

    private void aPJSelActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aPJSelActionPerformed
        this.pJ = listaPJ.get(this.aPJSel.getSelectedIndex());
        this.aPJCnpj.setText(pJ.getCnpj());
        this.aPJNome.setText(pJ.getNome());
        this.aPJNomeF.setText(pJ.getNomeFantasia());
        this.aPJEnd.setText(pJ.getEndereco());
        this.aPJCpf.setText(pJ.getRepresentanteLegal().getCpf());
    }//GEN-LAST:event_aPJSelActionPerformed

    private void apjCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apjCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_apjCancelarActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {  
            pJDAO.excluir(this.aPJCnpj.getText());
            JOptionPane.showMessageDialog(null, "Pessoa Jur??dica: \n" + this.pJ + "\nExclu??da com sucesso!");
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JFormattedTextField aPJCnpj;
    private javax.swing.JFormattedTextField aPJCpf;
    private javax.swing.JTextField aPJEnd;
    private javax.swing.JTextField aPJNome;
    private javax.swing.JTextField aPJNomeF;
    private javax.swing.JComboBox<String> aPJSel;
    private javax.swing.JButton apjAlt;
    private javax.swing.JButton apjCancelar;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables
}
