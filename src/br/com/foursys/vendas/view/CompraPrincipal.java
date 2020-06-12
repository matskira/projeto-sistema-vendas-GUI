package br.com.foursys.vendas.view;

import br.com.foursys.vendas.controller.CompraController;
import br.com.foursys.vendas.controller.MenuController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;
/*
 *@author's: Equipe 4 "Diego, we have a problem!"
 */

public class CompraPrincipal extends javax.swing.JFrame {

    CompraController controllerCompra = new CompraController(CompraPrincipal.this);

    public CompraPrincipal() {
        initComponents();
        this.controllerCompra.carregarComboFornecedor();
        this.controllerCompra.carregarComboFuncionario();
        this.controllerCompra.bloqueioInicial();
        this.controllerCompra.carregarComboFormaPgto();
        setLocationRelativeTo(null);
        setResizable(false);
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jcbFornecedor = new javax.swing.JComboBox();
        jcbFuncionario = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jbtIniciar = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jcbProduto = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfQuantidade = new javax.swing.JTextField();
        jbtSalvar = new javax.swing.JButton();
        jbtExcluir = new javax.swing.JButton();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jPanel6 = new javax.swing.JPanel();
        jcbFormaPgto = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jbtIncluirPgto = new javax.swing.JButton();
        jpValorTotal = new javax.swing.JPanel();
        jlbValorTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaPagamento = new javax.swing.JTable();
        jbtConfirmar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jbtExcluirPgto = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Compra de produtos");
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações Funcionário/Fornecedor", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel7.setText("Fornecedor:");

        jcbFornecedor.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione Fornecedor -" }));
        jcbFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFornecedorActionPerformed(evt);
            }
        });

        jcbFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione Funcionário -" }));
        jcbFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFuncionarioActionPerformed(evt);
            }
        });

        jLabel3.setText("Funcionário");

        jbtIniciar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/comprar.png"))); // NOI18N
        jbtIniciar.setText("INICIAR COMPRA");
        jbtIniciar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIniciarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addContainerGap()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(38, 38, 38)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbFornecedor, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
                    .addComponent(jbtIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(16, 16, 16)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtIniciar, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addContainerGap())
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados da Compra", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jcbProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione Produto -" }));

        jLabel4.setText("Descrição:");

        jLabel1.setText("Quantidade:");

        jtfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQuantidadeActionPerformed(evt);
            }
        });

        jbtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/salvar.png"))); // NOI18N
        jbtSalvar.setText("Salvar Produto");
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });

        jbtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/excluir.png"))); // NOI18N
        jbtExcluir.setText("Excluir Produto");
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Quantidade", "Valor unitário", "Valor total"
            }
        ));
        jScrollPane1.setViewportView(tabelaProduto);

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel4)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, 504, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jLabel1)
                .addGap(18, 18, 18)
                .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 90, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18))
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGap(155, 155, 155)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 149, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(155, 155, 155))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtExcluir)
                    .addComponent(jbtSalvar))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações de pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jcbFormaPgto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione Forma de Pagamento -" }));

        jLabel5.setText("Forma de Pagamento:");

        jbtIncluirPgto.setText("INCLUIR FORMA DE PAGAMENTO");
        jbtIncluirPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIncluirPgtoActionPerformed(evt);
            }
        });

        jpValorTotal.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Valor Total", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlbValorTotal.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N

        javax.swing.GroupLayout jpValorTotalLayout = new javax.swing.GroupLayout(jpValorTotal);
        jpValorTotal.setLayout(jpValorTotalLayout);
        jpValorTotalLayout.setHorizontalGroup(
            jpValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jpValorTotalLayout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 112, Short.MAX_VALUE)
                .addContainerGap())
        );
        jpValorTotalLayout.setVerticalGroup(
            jpValorTotalLayout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jlbValorTotal, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, 43, Short.MAX_VALUE)
        );

        tabelaPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "FORMA DE PAGAMENTO"
            }
        ));
        tabelaPagamento.setAutoscrolls(false);
        jScrollPane2.setViewportView(tabelaPagamento);

        jbtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/venda.gif"))); // NOI18N
        jbtConfirmar.setText("CONFIRMAR");
        jbtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarActionPerformed(evt);
            }
        });

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/cancelar.png"))); // NOI18N
        jbtCancelar.setText("CANCELAR");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/sair.png"))); // NOI18N
        jbtSair.setText("SAIR");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jbtExcluirPgto.setText("EXCLUIR FORMA DE PAGAMENTO");
        jbtExcluirPgto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirPgtoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel5)
                        .addGap(18, 18, 18)
                        .addComponent(jcbFormaPgto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.Alignment.LEADING, javax.swing.GroupLayout.PREFERRED_SIZE, 587, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(javax.swing.GroupLayout.Alignment.LEADING, jPanel6Layout.createSequentialGroup()
                                .addComponent(jbtIncluirPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jbtExcluirPgto, javax.swing.GroupLayout.PREFERRED_SIZE, 250, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addGap(0, 78, Short.MAX_VALUE)))
                .addGap(18, 18, 18)
                .addComponent(jpValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(49, 49, 49)
                .addComponent(jbtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 209, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(49, 49, 49)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 227, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(43, 43, 43)
                .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 218, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbFormaPgto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtIncluirPgto)
                            .addComponent(jbtExcluirPgto))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 44, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jpValorTotal, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 47, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSair, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel4, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfQuantidadeActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        MenuController.desbloqueiaTudo();
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtIniciarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIniciarActionPerformed
        this.controllerCompra.acaoBotaoIniciaVenda();
    }//GEN-LAST:event_jbtIniciarActionPerformed

    private void jcbFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFuncionarioActionPerformed
        this.controllerCompra.verificaIndex();
    }//GEN-LAST:event_jcbFuncionarioActionPerformed

    private void jcbFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFornecedorActionPerformed
        this.controllerCompra.verificaIndex();
    }//GEN-LAST:event_jcbFornecedorActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        this.controllerCompra.acaoBotaoCancelar();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        this.controllerCompra.carregarTabelaProduto();
    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jbtIncluirPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIncluirPgtoActionPerformed
        this.controllerCompra.carregarTabelaFormaPgto();
    }//GEN-LAST:event_jbtIncluirPgtoActionPerformed

    private void jbtExcluirPgtoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirPgtoActionPerformed
        this.controllerCompra.excluirFormaPgto();
    }//GEN-LAST:event_jbtExcluirPgtoActionPerformed

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
        this.controllerCompra.excluirProduto();
    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jbtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarActionPerformed
        this.controllerCompra.salvarProduto();
    }//GEN-LAST:event_jbtConfirmarActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtExcluirPgto;
    private javax.swing.JButton jbtIncluirPgto;
    private javax.swing.JButton jbtIniciar;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JComboBox jcbFormaPgto;
    private javax.swing.JComboBox jcbFornecedor;
    private javax.swing.JComboBox jcbFuncionario;
    private javax.swing.JComboBox jcbProduto;
    private javax.swing.JLabel jlbValorTotal;
    private javax.swing.JPanel jpValorTotal;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.JTable tabelaPagamento;
    private javax.swing.JTable tabelaProduto;
    // End of variables declaration//GEN-END:variables

    public JButton getJbtCancelar() {
        return jbtCancelar;
    }

    public void setJbtCancelar(JButton jbtCancelar) {
        this.jbtCancelar = jbtCancelar;
    }

    public JButton getJbtConfirmar() {
        return jbtConfirmar;
    }

    public void setJbtConfirmar(JButton jbtConfirmar) {
        this.jbtConfirmar = jbtConfirmar;
    }

    public JButton getJbtExcluir() {
        return jbtExcluir;
    }

    public void setJbtExcluir(JButton jbtExcluir) {
        this.jbtExcluir = jbtExcluir;
    }

    public JButton getJbtIncluirPgto() {
        return jbtIncluirPgto;
    }

    public void setJbtIncluirPgto(JButton jbtIncluirPgto) {
        this.jbtIncluirPgto = jbtIncluirPgto;
    }

    public JButton getJbtIniciar() {
        return jbtIniciar;
    }

    public void setJbtIniciar(JButton jbtIniciar) {
        this.jbtIniciar = jbtIniciar;
    }

    public JButton getJbtSair() {
        return jbtSair;
    }

    public void setJbtSair(JButton jbtSair) {
        this.jbtSair = jbtSair;
    }

    public JButton getJbtSalvar() {
        return jbtSalvar;
    }

    public void setJbtSalvar(JButton jbtSalvar) {
        this.jbtSalvar = jbtSalvar;
    }

    public JComboBox getJcbFormaPgto() {
        return jcbFormaPgto;
    }

    public void setJcbFormaPgto(JComboBox jcbFormaPgto) {
        this.jcbFormaPgto = jcbFormaPgto;
    }

    public JComboBox getJcbFornecedor() {
        return jcbFornecedor;
    }

    public void setJcbFornecedor(JComboBox jcbFornecedor) {
        this.jcbFornecedor = jcbFornecedor;
    }

    public JComboBox getJcbFuncionario() {
        return jcbFuncionario;
    }

    public void setJcbFuncionario(JComboBox jcbFuncionario) {
        this.jcbFuncionario = jcbFuncionario;
    }

    public JComboBox getJcbProduto() {
        return jcbProduto;
    }

    public void setJcbProduto(JComboBox jcbProduto) {
        this.jcbProduto = jcbProduto;
    }

    public JTextField getJtfQuantidade() {
        return jtfQuantidade;
    }

    public void setJtfQuantidade(JTextField jtfQuantidade) {
        this.jtfQuantidade = jtfQuantidade;
    }

    public JTable getTabelaPagamento() {
        return tabelaPagamento;
    }

    public void setTabelaPagamento(JTable tabelaPagamento) {
        this.tabelaPagamento = tabelaPagamento;
    }

    public JTable getTabelaProduto() {
        return tabelaProduto;
    }

    public void setTabelaProduto(JTable tabelaProduto) {
        this.tabelaProduto = tabelaProduto;
    }

    public JLabel getJlbValorTotal() {
        return jlbValorTotal;
    }

    public void setJlbValorTotal(JLabel jlbValorTotal) {
        this.jlbValorTotal = jlbValorTotal;
    }

    public JButton getJbtExcluirPgto() {
        return jbtExcluirPgto;
    }

    public void setJbtExcluirPgto(JButton jbtExcluirPgto) {
        this.jbtExcluirPgto = jbtExcluirPgto;
    }

}
