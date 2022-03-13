package sgm.telas.Consulta;

import java.util.List;
import javax.swing.JOptionPane;
import sgm.dao.PessoaFisicaDAO;
import sgm.dominio.PessoaFisica;

public class ConsultarPFisica extends javax.swing.JInternalFrame {

    private List <PessoaFisica> pessoas;
    private PessoaFisicaDAO pfDAO;
    private PessoaFisica pessoa;
    
    public ConsultarPFisica() {
        initComponents();
        this.apfSelPF.removeAllItems();
        this.apfCPF.setEnabled(false);
        this.pfDAO = new PessoaFisicaDAO();
        this.pessoas = pfDAO.listar();
        for(PessoaFisica pf : pessoas){
        this.apfSelPF.addItem(pf.getNome());            
        }
    }

    /** This method is called from within the constructor to
     * initialize the form.
     * WARNING: Do NOT modify this code. The content of this method is
     * always regenerated by the Form Editor.
     */
    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel3 = new javax.swing.JLabel();
        apfAlt = new javax.swing.JButton();
        apfCPF = new javax.swing.JFormattedTextField();
        jLabel4 = new javax.swing.JLabel();
        jLabel5 = new javax.swing.JLabel();
        apfRG = new javax.swing.JTextField();
        apfEndereco = new javax.swing.JTextField();
        apfDDN = new javax.swing.JFormattedTextField();
        apfNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        apfCancelar = new javax.swing.JButton();
        jButton1 = new javax.swing.JButton();
        apfSelPF = new javax.swing.JComboBox<>();
        jSeparator1 = new javax.swing.JSeparator();
        jLabel7 = new javax.swing.JLabel();
        apfSexo = new javax.swing.JTextField();

        setClosable(true);
        setIconifiable(true);
        setMaximizable(true);
        setResizable(true);
        setTitle("Consultar Pessoa Física");

        jPanel1.setBackground(new java.awt.Color(204, 204, 255));

        jLabel1.setText("CPF:");

        jLabel2.setText("RG:");

        jLabel3.setText("NOME:");

        apfAlt.setText("Alterar");
        apfAlt.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apfAltActionPerformed(evt);
            }
        });

        try {
            apfCPF.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        apfCPF.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apfCPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apfCPFActionPerformed(evt);
            }
        });

        jLabel4.setText("SEXO:");

        jLabel5.setText("DATA DE NASCIMENTO");

        apfRG.setHorizontalAlignment(javax.swing.JTextField.CENTER);

        apfEndereco.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apfEndereco.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apfEnderecoActionPerformed(evt);
            }
        });

        try {
            apfDDN.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }
        apfDDN.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apfDDN.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apfDDNActionPerformed(evt);
            }
        });

        apfNome.setHorizontalAlignment(javax.swing.JTextField.CENTER);
        apfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apfNomeActionPerformed(evt);
            }
        });

        jLabel6.setText("ENDEREÇO:");

        apfCancelar.setText("Cancelar");
        apfCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apfCancelarActionPerformed(evt);
            }
        });

        jButton1.setText("Excluir");
        jButton1.setFocusable(false);
        jButton1.setHorizontalTextPosition(javax.swing.SwingConstants.CENTER);
        jButton1.setVerticalTextPosition(javax.swing.SwingConstants.BOTTOM);
        jButton1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jButton1ActionPerformed(evt);
            }
        });

        apfSelPF.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                apfSelPFActionPerformed(evt);
            }
        });

        jLabel7.setText("Selecione aqui qual Pessoa Física deseja consultar:");

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jSeparator1, javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel7)
                .addGap(81, 81, 81))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apfNome)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                        .addGap(0, 176, Short.MAX_VALUE)
                        .addComponent(apfCancelar)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                        .addComponent(apfAlt, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jButton1))
                    .addComponent(apfSelPF, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jLabel1, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apfCPF, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, 250, Short.MAX_VALUE)
                            .addComponent(jLabel4, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apfRG, javax.swing.GroupLayout.Alignment.LEADING))
                        .addGap(0, 0, Short.MAX_VALUE))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(apfSexo)
                            .addComponent(apfDDN, javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel5, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(apfEndereco)
                            .addGroup(jPanel1Layout.createSequentialGroup()
                                .addComponent(jLabel6)
                                .addGap(0, 0, Short.MAX_VALUE)))))
                .addContainerGap())
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel7)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(apfSelPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22)
                .addComponent(jSeparator1, javax.swing.GroupLayout.PREFERRED_SIZE, 10, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(13, 13, 13)
                .addComponent(jLabel1)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apfCPF, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apfRG, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel3)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(apfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jLabel4)
                .addGap(1, 1, 1)
                .addComponent(apfSexo, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel6)
                    .addComponent(jLabel5))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(apfEndereco, javax.swing.GroupLayout.DEFAULT_SIZE, 48, Short.MAX_VALUE)
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addComponent(apfDDN, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(apfAlt)
                        .addComponent(apfCancelar))
                    .addComponent(jButton1, javax.swing.GroupLayout.Alignment.TRAILING))
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
            .addComponent(jPanel1, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void apfAltActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apfAltActionPerformed
        pessoa = new PessoaFisica(this.apfCPF.getText(), this.apfNome.getText(), this.apfRG.getText(),
        this.apfEndereco.getText(), this.apfSexo.getText(), this.apfDDN.getText());
        pfDAO.alterar(this.pessoa);
        JOptionPane.showMessageDialog(null, "Pessoa Física: \n" + this.pessoa + "\n Alteração realizada com sucesso!");
        this.dispose();
    }//GEN-LAST:event_apfAltActionPerformed

    private void apfCPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apfCPFActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apfCPFActionPerformed

    private void apfEnderecoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apfEnderecoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apfEnderecoActionPerformed

    private void apfDDNActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apfDDNActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apfDDNActionPerformed

    private void apfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_apfNomeActionPerformed

    private void apfCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apfCancelarActionPerformed
        this.dispose();
    }//GEN-LAST:event_apfCancelarActionPerformed

    private void apfSelPFActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_apfSelPFActionPerformed
        this.pessoa = pessoas.get(this.apfSelPF.getSelectedIndex());
        this.apfCPF.setText(this.pessoa.getCpf());
        this.apfNome.setText(this.pessoa.getNome());
        this.apfRG.setText(this.pessoa.getRg());
        this.apfSexo.setText(this.pessoa.getSexo());
        this.apfDDN.setText(this.pessoa.getDataNascimento());
        this.apfEndereco.setText(this.pessoa.getEndereco());
    }//GEN-LAST:event_apfSelPFActionPerformed

    private void jButton1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jButton1ActionPerformed
        try {  
            this.pfDAO.excluir(this.apfCPF.getText());
            JOptionPane.showMessageDialog(null, "Pessoa Física: \n" + this.pessoa + "\n Excluída com sucesso!");
            this.dispose();
        } catch (Exception ex) {
            ex.printStackTrace();
            JOptionPane.showMessageDialog(null, ex.getMessage());
            this.dispose();
        }
    }//GEN-LAST:event_jButton1ActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JButton apfAlt;
    private javax.swing.JFormattedTextField apfCPF;
    private javax.swing.JButton apfCancelar;
    private javax.swing.JFormattedTextField apfDDN;
    private javax.swing.JTextField apfEndereco;
    private javax.swing.JTextField apfNome;
    private javax.swing.JTextField apfRG;
    private javax.swing.JComboBox<String> apfSelPF;
    private javax.swing.JTextField apfSexo;
    private javax.swing.JButton jButton1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JSeparator jSeparator1;
    // End of variables declaration//GEN-END:variables

}