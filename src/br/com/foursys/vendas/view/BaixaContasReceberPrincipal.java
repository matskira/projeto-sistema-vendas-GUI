package br.com.foursys.vendas.view;

import br.com.foursys.vendas.controller.BaixaContasReceberController;
import br.com.foursys.vendas.controller.MenuController;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class BaixaContasReceberPrincipal extends javax.swing.JFrame {

    BaixaContasReceberController controllerContasReceber = new BaixaContasReceberController(BaixaContasReceberPrincipal.this);

    public BaixaContasReceberPrincipal() {
        initComponents();
        this.controllerContasReceber.listarContasReceber();
        setLocationRelativeTo(null);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jbtCancelar = new javax.swing.JButton();
        jbtConfirmarRecebimento = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContasReceber = new javax.swing.JTable();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Contas a Receber");

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/cancelar.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtConfirmarRecebimento.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/comprar.png"))); // NOI18N
        jbtConfirmarRecebimento.setText("Confirmar Recebimento");
        jbtConfirmarRecebimento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarRecebimentoActionPerformed(evt);
            }
        });

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contas a Receber", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel5.setToolTipText("");

        tabelaContasReceber.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Cliente", "Funcionário", "Número da Venda", "Valor Total", "Data de Vencimento"
            }
        ));
        tabelaContasReceber.setToolTipText("");
        jScrollPane1.setViewportView(tabelaContasReceber);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jScrollPane1)
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addComponent(jScrollPane1, javax.swing.GroupLayout.DEFAULT_SIZE, 135, Short.MAX_VALUE)
                .addContainerGap())
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jbtConfirmarRecebimento, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(74, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtConfirmarRecebimento)
                    .addComponent(jbtCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.getAccessibleContext().setAccessibleName("");

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        dispose();
        MenuController.desbloqueiaTudo();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtConfirmarRecebimentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarRecebimentoActionPerformed
        this.controllerContasReceber.confirmarRecebimento();
    }//GEN-LAST:event_jbtConfirmarRecebimentoActionPerformed


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtConfirmarRecebimento;
    private javax.swing.JTable tabelaContasReceber;
    // End of variables declaration//GEN-END:variables

    public BaixaContasReceberController getControllerContasReceber() {
        return controllerContasReceber;
    }

    public void setControllerContasReceber(BaixaContasReceberController controllerContasReceber) {
        this.controllerContasReceber = controllerContasReceber;
    }

    public JButton getJbtConfirmarRecebimento() {
        return jbtConfirmarRecebimento;
    }

    public void setJbtConfirmarRecebimento(JButton jbtConfirmarRecebimento) {
        this.jbtConfirmarRecebimento = jbtConfirmarRecebimento;
    }

    public JTable getTabelaContasReceber() {
        return tabelaContasReceber;
    }

    public void setTabelaContasReceber(JTable tabelaContasReceber) {
        this.tabelaContasReceber = tabelaContasReceber;
    }

}
