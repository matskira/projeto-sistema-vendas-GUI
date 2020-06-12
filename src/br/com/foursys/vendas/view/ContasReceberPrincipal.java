package br.com.foursys.vendas.view;

import br.com.foursys.vendas.controller.ContasReceberController;
import br.com.foursys.vendas.controller.MenuController;
import javax.swing.JButton;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;

/**
 *
 * @author gtbrito
 */
public class ContasReceberPrincipal extends javax.swing.JFrame {

    ContasReceberController contasReceberController = new ContasReceberController(ContasReceberPrincipal.this);

    public ContasReceberPrincipal() {
        initComponents();
        this.contasReceberController.bloqueioInicial();
        setLocationRelativeTo(null);
        setVisible(true);
        setResizable(false);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jScrollPane1 = new javax.swing.JScrollPane();
        jEditorPane1 = new javax.swing.JEditorPane();
        buttonGroup1 = new javax.swing.ButtonGroup();
        buttonGroup2 = new javax.swing.ButtonGroup();
        buttonGroup3 = new javax.swing.ButtonGroup();
        jComboBox1 = new javax.swing.JComboBox();
        jPanel1 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jLabel2 = new javax.swing.JLabel();
        jLabel6 = new javax.swing.JLabel();
        jtfReceber = new javax.swing.JFormattedTextField();
        jtfVencimento = new javax.swing.JFormattedTextField();
        jPanel4 = new javax.swing.JPanel();
        jrbPagoSim = new javax.swing.JRadioButton();
        jrbPagoNao = new javax.swing.JRadioButton();
        jlbPago = new javax.swing.JLabel();
        jPanel5 = new javax.swing.JPanel();
        jLabel8 = new javax.swing.JLabel();
        jLabel10 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jlbFuncionario = new javax.swing.JLabel();
        jlbCliente = new javax.swing.JLabel();
        jlbValorTotal = new javax.swing.JLabel();
        jPanel3 = new javax.swing.JPanel();
        jrbSim = new javax.swing.JRadioButton();
        jrbNao = new javax.swing.JRadioButton();
        jlbVenceu = new javax.swing.JLabel();
        jbtConfirmar = new javax.swing.JButton();

        jScrollPane1.setViewportView(jEditorPane1);

        jComboBox1.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "Item 1", "Item 2", "Item 3", "Item 4" }));

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Contas á Receber");

        jPanel1.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        jLabel1.setText("Á receber:");

        jLabel2.setText("Vencimento:");

        jLabel6.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/21062017180125534_pagar (2) (1).png"))); // NOI18N

        try {
            jtfReceber.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jtfVencimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jPanel4.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup3.add(jrbPagoSim);
        jrbPagoSim.setText("Sim");
        jrbPagoSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbPagoSimActionPerformed(evt);
            }
        });

        buttonGroup3.add(jrbPagoNao);
        jrbPagoNao.setText("Não");

        jlbPago.setText("Pago:");

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbPago)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jrbPagoSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbPagoNao)
                .addGap(23, 23, 23))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jrbPagoSim)
                .addComponent(jrbPagoNao)
                .addComponent(jlbPago))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Descrição:", javax.swing.border.TitledBorder.CENTER, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11), new java.awt.Color(1, 1, 1))); // NOI18N
        jPanel5.setAlignmentX(1.0F);
        jPanel5.setAlignmentY(1.0F);
        jPanel5.setCursor(new java.awt.Cursor(java.awt.Cursor.CROSSHAIR_CURSOR));
        jPanel5.setFocusable(false);
        jPanel5.setName(""); // NOI18N

        jLabel8.setText("Funcionário:");

        jLabel10.setText("Cliente:");

        jLabel7.setText("Valor Total:");

        jlbFuncionario.setText("TESTEFUNCIONARIO");

        jlbCliente.setText("TESTECLIENTE");

        jlbValorTotal.setText("TESTEVALORTOTAL");

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(66, 66, 66)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jLabel10)
                    .addComponent(jLabel8)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jlbCliente)
                    .addComponent(jlbValorTotal)
                    .addComponent(jlbFuncionario))
                .addContainerGap(102, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(21, 21, 21)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jlbFuncionario)
                    .addComponent(jLabel8))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel10)
                    .addComponent(jlbCliente))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel7)
                    .addComponent(jlbValorTotal))
                .addContainerGap(19, Short.MAX_VALUE))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createEtchedBorder());

        buttonGroup2.add(jrbSim);
        jrbSim.setText("Sim");
        jrbSim.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbSimActionPerformed(evt);
            }
        });

        buttonGroup2.add(jrbNao);
        jrbNao.setText("Não");

        jlbVenceu.setText("Venceu:");

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jlbVenceu)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbSim)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jrbNao)
                .addGap(23, 23, 23))
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                .addComponent(jrbSim)
                .addComponent(jrbNao)
                .addComponent(jlbVenceu))
        );

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jLabel2)
                    .addComponent(jLabel1))
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jtfReceber, javax.swing.GroupLayout.DEFAULT_SIZE, 80, Short.MAX_VALUE)
                    .addComponent(jtfVencimento))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel6)
                .addGap(18, 18, 18)
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addGap(18, 18, 18))
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGap(59, 59, 59)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(59, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addGap(21, 21, 21)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                .addComponent(jLabel1)
                                .addComponent(jtfReceber, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                                .addComponent(jtfVencimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addComponent(jLabel2))
                            .addGap(14, 14, 14))
                        .addGroup(jPanel1Layout.createSequentialGroup()
                            .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                            .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)))
                    .addGroup(jPanel1Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel6)))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(22, 22, 22))
        );

        jbtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/salvar.png"))); // NOI18N
        jbtConfirmar.setText("Confirmar");
        jbtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addGap(158, 158, 158)
                .addComponent(jbtConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(156, 156, 156))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtConfirmar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGap(19, 19, 19))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarActionPerformed
        this.contasReceberController.acaoBotaoSalvar();
        MenuController.desbloqueiaTudo();
    }//GEN-LAST:event_jbtConfirmarActionPerformed

    private void jrbSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbSimActionPerformed

    private void jrbPagoSimActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbPagoSimActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jrbPagoSimActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.ButtonGroup buttonGroup2;
    private javax.swing.ButtonGroup buttonGroup3;
    private javax.swing.JComboBox jComboBox1;
    private javax.swing.JEditorPane jEditorPane1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JLabel jlbCliente;
    private javax.swing.JLabel jlbFuncionario;
    private javax.swing.JLabel jlbPago;
    private javax.swing.JLabel jlbValorTotal;
    private javax.swing.JLabel jlbVenceu;
    private javax.swing.JRadioButton jrbNao;
    private javax.swing.JRadioButton jrbPagoNao;
    private javax.swing.JRadioButton jrbPagoSim;
    private javax.swing.JRadioButton jrbSim;
    private javax.swing.JFormattedTextField jtfReceber;
    private javax.swing.JFormattedTextField jtfVencimento;
    // End of variables declaration//GEN-END:variables

    public ContasReceberController getContasReceberController() {
        return contasReceberController;
    }

    public void setContasReceberController(ContasReceberController contasReceberController) {
        this.contasReceberController = contasReceberController;
    }

    public JButton getJbtConfirmar() {
        return jbtConfirmar;
    }

    public void setJbtConfirmar(JButton jbtConfirmar) {
        this.jbtConfirmar = jbtConfirmar;
    }

    public JLabel getJlbCliente() {
        return jlbCliente;
    }

    public void setJlbCliente(JLabel jlbCliente) {
        this.jlbCliente = jlbCliente;
    }

    public JLabel getJlbFuncionario() {
        return jlbFuncionario;
    }

    public void setJlbFuncionario(JLabel jlbFuncionario) {
        this.jlbFuncionario = jlbFuncionario;
    }

    public JLabel getJlbPago() {
        return jlbPago;
    }

    public void setJlbPago(JLabel jlbPago) {
        this.jlbPago = jlbPago;
    }

    public JLabel getJlbValorTotal() {
        return jlbValorTotal;
    }

    public void setJlbValorTotal(JLabel jlbValorTotal) {
        this.jlbValorTotal = jlbValorTotal;
    }

    public JLabel getJlbVenceu() {
        return jlbVenceu;
    }

    public void setJlbVenceu(JLabel jlbVenceu) {
        this.jlbVenceu = jlbVenceu;
    }

    public JRadioButton getJrbNao() {
        return jrbNao;
    }

    public void setJrbNao(JRadioButton jrbNao) {
        this.jrbNao = jrbNao;
    }

    public JRadioButton getJrbPagoNao() {
        return jrbPagoNao;
    }

    public void setJrbPagoNao(JRadioButton jrbPagoNao) {
        this.jrbPagoNao = jrbPagoNao;
    }

    public JRadioButton getJrbPagoSim() {
        return jrbPagoSim;
    }

    public void setJrbPagoSim(JRadioButton jrbPagoSim) {
        this.jrbPagoSim = jrbPagoSim;
    }

    public JRadioButton getJrbSim() {
        return jrbSim;
    }

    public void setJrbSim(JRadioButton jrbSim) {
        this.jrbSim = jrbSim;
    }

    public JFormattedTextField getJtfReceber() {
        return jtfReceber;
    }

    public void setJtfReceber(JFormattedTextField jtfReceber) {
        this.jtfReceber = jtfReceber;
    }

    public JFormattedTextField getJtfVencimento() {
        return jtfVencimento;
    }

    public void setJtfVencimento(JFormattedTextField jtfVencimento) {
        this.jtfVencimento = jtfVencimento;
    }

}
