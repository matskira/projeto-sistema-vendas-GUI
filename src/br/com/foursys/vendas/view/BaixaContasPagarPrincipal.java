package br.com.foursys.vendas.view;

import br.com.foursys.vendas.controller.BaixaContasPagarController;
import br.com.foursys.vendas.controller.MenuController;
import javax.swing.JButton;
import javax.swing.JTable;

/**
 *
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class BaixaContasPagarPrincipal extends javax.swing.JFrame {

    BaixaContasPagarController controllerContasPagar = new BaixaContasPagarController(BaixaContasPagarPrincipal.this);

    public BaixaContasPagarPrincipal() {
        initComponents();
        this.controllerContasPagar.listarContasPagar();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel5 = new javax.swing.JPanel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaContasPagar = new javax.swing.JTable();
        jbtConfirmarRecibo = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Contas a Pagar");

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Contas a Pagar", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel5.setToolTipText("");

        tabelaContasPagar.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Funcionário", "Fornecedor", "Número da Compra", "Valor Total", "Data de Vencimento"
            }
        ));
        tabelaContasPagar.setToolTipText("");
        jScrollPane1.setViewportView(tabelaContasPagar);

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

        jbtConfirmarRecibo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/comprar.png"))); // NOI18N
        jbtConfirmarRecibo.setText("Confirmar Pagamento");
        jbtConfirmarRecibo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarReciboActionPerformed(evt);
            }
        });

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/cancelar.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(40, 40, 40)
                .addComponent(jbtConfirmarRecibo, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(85, 85, 85)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(73, Short.MAX_VALUE))
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtConfirmarRecibo)
                    .addComponent(jbtCancelar))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtConfirmarReciboActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarReciboActionPerformed
        this.controllerContasPagar.confirmarPagamento();
    }//GEN-LAST:event_jbtConfirmarReciboActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        dispose();
        MenuController.desbloqueiaTudo();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JPanel jPanel5;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtConfirmarRecibo;
    private javax.swing.JTable tabelaContasPagar;
    // End of variables declaration//GEN-END:variables

    public JButton getJbtCancelar() {
        return jbtCancelar;
    }

    public void setJbtCancelar(JButton jbtCancelar) {
        this.jbtCancelar = jbtCancelar;
    }

    public JButton getJbtConfirmarRecibo() {
        return jbtConfirmarRecibo;
    }

    public void setJbtConfirmarRecibo(JButton jbtConfirmarRecibo) {
        this.jbtConfirmarRecibo = jbtConfirmarRecibo;
    }

    public JTable getTabelaContasPagar() {
        return tabelaContasPagar;
    }

    public void setTabelaContasPagar(JTable tabelaContasPagar) {
        this.tabelaContasPagar = tabelaContasPagar;
    }

}
