package sgm.telas.Consulta;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import sgm.dao.ContratoDAO;
import sgm.dao.MercadoDAO;
import sgm.dao.PessoaFisicaDAO;
import sgm.dao.PessoaJuridicaDAO;
import sgm.dao.PrefeituraDAO;
import sgm.dominio.Contrato;
import sgm.dominio.Mercado;
import sgm.dominio.Pessoa;
import sgm.dominio.PessoaFisica;
import sgm.dominio.PessoaJuridica;
import sgm.dominio.Prefeitura;
/**
 *
 * @author aligr
 */
public class ConsultaDetalhadaContrato extends javax.swing.JInternalFrame {
      private ContratoDAO contratoDAO;
      private Contrato contrato;
      
    
    
    public ConsultaDetalhadaContrato(int idContrato) {
        initComponents();
        contratoDAO = new ContratoDAO();
        this.contrato = contratoDAO.consultar(idContrato);
        this.aCID.setText(Integer.toString(idContrato));
        this.aCMer.setText(contrato.getMercado().getNome());
        this.aCLoc.setText(contrato.getLocatario().getNome());
        this.aCBox.setText(Integer.toString(contrato.getBox()));
        this.aCDDI.setText(contrato.getDataInicio());
        this.aCDDF.setText(contrato.getDataFim());
        this.aCVDA.setText(Double.toString(contrato.getValorDoAluguel()));      
    }


    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        aCAlterar = new javax.swing.JButton();
        jLabel4 = new javax.swing.JLabel();
        aCBox = new javax.swing.JTextField();
        jLabel5 = new javax.swing.JLabel();
        aCVDA = new javax.swing.JTextField();
        aCDDI = new javax.swing.JFormattedTextField();
        jLabel6 = new javax.swing.JLabel();
        aCDDF = new javax.swing.JFormattedTextField();
        jLabel7 = new javax.swing.JLabel();
        aCExcluir = new javax.swing.JButton();
        aCLoc = new javax.swing.JTextField();
        aCMer = new javax.swing.JTextField();
        aCID = new javax.swing.JTextField();
        jLabel2 = new javax.swing.JLabel();
        aCCanc = new javax.swing.JButton();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consulta Detalhada de Contrato");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("LOCATARIO:");

        jLabel3.setText("MERCADO:");

        aCAlterar.setText("Alterar");
        aCAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCAlterarActionPerformed(evt);
            }
        });

        jLabel4.setText("NÚMERO DO BOX:");

        jLabel5.setText("VALOR DO ALUGUEL:");

        try {
            aCDDI.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        aCDDI.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCDDIActionPerformed(evt);
            }
        });

        jLabel6.setText("DATA DO INICIO:");

        try {
            aCDDF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        aCDDF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCDDFActionPerformed(evt);
            }
        });

        jLabel7.setText("DATA DO FIM:");

        aCExcluir.setText("Excluir");
        aCExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCExcluirActionPerformed(evt);
            }
        });

        aCLoc.setEnabled(false);

        aCMer.setEnabled(false);

        aCID.setEnabled(false);

        jLabel2.setText("Nº do Contrato:");

        aCCanc.setText("Cancelar");
        aCCanc.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                aCCancActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addComponent(jLabel3)
                        .addComponent(aCVDA)
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                                .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING)
                                .addGroup(jPanel1Layout.createSequentialGroup()
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(aCBox, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addComponent(jLabel4))
                                    .addGap(18, 18, 18)
                                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                        .addComponent(jLabel6)
                                        .addComponent(aCDDI, javax.swing.GroupLayout.PREFERRED_SIZE, 98, javax.swing.GroupLayout.PREFERRED_SIZE))))
                            .addGap(18, 18, 18)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(aCDDF, javax.swing.GroupLayout.PREFERRED_SIZE, 100, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel7))
                            .addGap(11, 11, 11))
                        .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                            .addComponent(aCCanc)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                            .addComponent(aCAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(aCExcluir))
                        .addComponent(jLabel1)
                        .addComponent(aCMer)
                        .addComponent(aCLoc))
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                        .addComponent(aCID, javax.swing.GroupLayout.Alignment.LEADING)
                        .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(12, 12, 12)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aCID, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aCLoc, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jLabel3)
                .addGap(4, 4, 4)
                .addComponent(aCMer, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel6, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 14, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aCBox, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aCDDI, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(aCDDF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jLabel5)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(aCVDA, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 61, Short.MAX_VALUE)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(aCAlterar)
                    .addComponent(aCExcluir)
                    .addComponent(aCCanc))
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

    private void aCAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCAlterarActionPerformed
        int idContrato = contrato.getIdContrato();
        Pessoa locatario = contrato.getLocatario();
        Mercado mercado = contrato.getMercado();
        int box = Integer.parseInt(this.aCBox.getText());
        String dataInicio = this.aCDDI.getText();
        String dataFim = this.aCDDF.getText();
        Double valorAluguel = Double.parseDouble(this.aCVDA.getText());
        if(contrato.getBox() != box && contratoDAO.isAlugado(mercado, box, dataInicio)){
            JOptionPane.showMessageDialog(null, "Box indispoível para locação.");
            return;
        }
        Contrato contratoAlterado = new Contrato(idContrato, locatario, mercado,
                box, dataInicio, dataFim, valorAluguel);
        try {
            contratoDAO.alterar(contratoAlterado);
            JOptionPane.showMessageDialog(null, "Contrato: \n" + contratoAlterado + "\n Cadastrado com sucesso!");
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
        }
        this.dispose();
    }//GEN-LAST:event_aCAlterarActionPerformed

    private void aCDDIActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCDDIActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aCDDIActionPerformed

    private void aCDDFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCDDFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_aCDDFActionPerformed

    private void aCCancActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCCancActionPerformed
        this.dispose();
    }//GEN-LAST:event_aCCancActionPerformed

    private void aCExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_aCExcluirActionPerformed
        try {  
            contratoDAO.excluir(Integer.parseInt(this.aCID.getText()));
            JOptionPane.showMessageDialog(null, "Contrato: \n" + this.contrato + "\n Excluído com sucesso!");
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
            this.dispose();
        }
    }//GEN-LAST:event_aCExcluirActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton aCAlterar;
    private javax.swing.JTextField aCBox;
    private javax.swing.JButton aCCanc;
    private javax.swing.JFormattedTextField aCDDF;
    private javax.swing.JFormattedTextField aCDDI;
    private javax.swing.JButton aCExcluir;
    private javax.swing.JTextField aCID;
    private javax.swing.JTextField aCLoc;
    private javax.swing.JTextField aCMer;
    private javax.swing.JTextField aCVDA;
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    // End of variables declaration//GEN-END:variables
}
