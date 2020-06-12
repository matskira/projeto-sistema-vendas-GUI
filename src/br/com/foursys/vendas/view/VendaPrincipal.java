package br.com.foursys.vendas.view;

import br.com.foursys.vendas.controller.MenuController;
import br.com.foursys.vendas.controller.VendaController;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTable;
import javax.swing.JTextField;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class VendaPrincipal extends javax.swing.JFrame {

    VendaController controllerVenda = new VendaController(VendaPrincipal.this);

    public VendaPrincipal() {
        initComponents();
        this.controllerVenda.carregarComboCliente();
        this.controllerVenda.carregarComboFuncionario();
        this.controllerVenda.bloqueioInicial();
        setLocationRelativeTo(null);
        setVisible(true);

    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jToolBar1 = new javax.swing.JToolBar();
        jPanel4 = new javax.swing.JPanel();
        jLabel7 = new javax.swing.JLabel();
        jcbFuncionario = new javax.swing.JComboBox();
        jcbCliente = new javax.swing.JComboBox();
        jLabel3 = new javax.swing.JLabel();
        jbtIniciarVenda = new javax.swing.JButton();
        jPanel5 = new javax.swing.JPanel();
        jcbProduto = new javax.swing.JComboBox();
        jLabel4 = new javax.swing.JLabel();
        jLabel1 = new javax.swing.JLabel();
        jtfQuantidade = new javax.swing.JTextField();
        Desconto = new javax.swing.JLabel();
        jtfDesconto = new javax.swing.JTextField();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaProduto = new javax.swing.JTable();
        jbtExcluir = new javax.swing.JButton();
        jbtSalvar = new javax.swing.JButton();
        jPanel6 = new javax.swing.JPanel();
        jcbFormaPagamento = new javax.swing.JComboBox();
        jLabel5 = new javax.swing.JLabel();
        jbtIncluirFormaPagamento = new javax.swing.JButton();
        Desconto1 = new javax.swing.JLabel();
        jtfDescontoPagamento = new javax.swing.JTextField();
        jPanel7 = new javax.swing.JPanel();
        jlbValorTotal = new javax.swing.JLabel();
        jScrollPane2 = new javax.swing.JScrollPane();
        tabelaFormaPagamento = new javax.swing.JTable();
        jbtConfirmar = new javax.swing.JButton();
        jbtCancelar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jbtExcluirFormaPagamento = new javax.swing.JButton();

        jToolBar1.setRollover(true);

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Controle de Vendas");
        setResizable(false);

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Informações Cliente/Funcionário", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel4.setToolTipText("");

        jLabel7.setText("Funcionário:");

        jcbFuncionario.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione Funcionario -" }));
        jcbFuncionario.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbFuncionarioActionPerformed(evt);
            }
        });

        jcbCliente.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione Cliente -" }));
        jcbCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jcbClienteActionPerformed(evt);
            }
        });

        jLabel3.setText("Cliente:");

        jbtIniciarVenda.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/comprar.png"))); // NOI18N
        jbtIniciarVenda.setText("INICIAR VENDA");
        jbtIniciarVenda.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIniciarVendaActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
                    .addComponent(jbtIniciarVenda, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel3)
                            .addComponent(jLabel7))
                        .addGap(10, 10, 10)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jcbCliente, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                            .addComponent(jcbFuncionario, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))))
                .addContainerGap())
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbCliente, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel3))
                .addGap(13, 13, 13)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbFuncionario, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel7))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtIniciarVenda)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel5.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Produtos", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jcbProduto.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione um Produto -" }));

        jLabel4.setText("Descrição:");

        jLabel1.setText("Quantidade:");

        jtfQuantidade.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfQuantidadeActionPerformed(evt);
            }
        });

        Desconto.setText("Desconto:");

        jtfDesconto.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfDescontoActionPerformed(evt);
            }
        });

        tabelaProduto.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Descrição", "Quantidade", "Valor Unitário", "Desconto", "Valor Total"
            }
        ));
        jScrollPane1.setViewportView(tabelaProduto);

        jbtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/excluir.png"))); // NOI18N
        jbtExcluir.setText("Excluir Produto");
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        jbtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/salvar.png"))); // NOI18N
        jbtSalvar.setText("Salvar Produto");
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jScrollPane1)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel5Layout.createSequentialGroup()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addContainerGap()
                        .addComponent(jLabel4)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jcbProduto, 0, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addGap(18, 18, 18))
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addGap(217, 217, 217)
                        .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 163, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(47, 47, 47)))
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel5Layout.createSequentialGroup()
                        .addComponent(jLabel1)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, 102, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(13, 13, 13)
                        .addComponent(Desconto)
                        .addGap(18, 18, 18)
                        .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, 114, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addComponent(jbtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap())
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jcbProduto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jLabel4)
                    .addComponent(jLabel1)
                    .addComponent(jtfQuantidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(Desconto)
                    .addComponent(jtfDesconto, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 18, 18)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtSalvar)
                    .addComponent(jbtExcluir))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 112, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );

        jPanel6.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Formas de Pagamento", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N
        jPanel6.setToolTipText("");

        jcbFormaPagamento.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione Forma de Pagamento -", "Dinheiro", "Cheque", "Crédito", "Débito" }));

        jLabel5.setText("Forma de Pagamento:");

        jbtIncluirFormaPagamento.setText("INCLUIR");
        jbtIncluirFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtIncluirFormaPagamentoActionPerformed(evt);
            }
        });

        Desconto1.setText("Desconto:");

        jtfDescontoPagamento.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jtfDescontoPagamentoKeyPressed(evt);
            }
            public void keyReleased(java.awt.event.KeyEvent evt) {
                jtfDescontoPagamentoKeyReleased(evt);
            }
        });

        jPanel7.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "VALOR TOTAL", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlbValorTotal.setFont(new java.awt.Font("Tahoma", 0, 28)); // NOI18N
        jlbValorTotal.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyPressed(java.awt.event.KeyEvent evt) {
                jlbValorTotalKeyPressed(evt);
            }
        });

        javax.swing.GroupLayout jPanel7Layout = new javax.swing.GroupLayout(jPanel7);
        jPanel7.setLayout(jPanel7Layout);
        jPanel7Layout.setHorizontalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 154, Short.MAX_VALUE)
                .addContainerGap())
        );
        jPanel7Layout.setVerticalGroup(
            jPanel7Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel7Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jlbValorTotal, javax.swing.GroupLayout.DEFAULT_SIZE, 36, Short.MAX_VALUE)
                .addContainerGap())
        );

        tabelaFormaPagamento.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Forma de Pagamento"
            }
        ));
        jScrollPane2.setViewportView(tabelaFormaPagamento);

        jbtConfirmar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/venda.gif"))); // NOI18N
        jbtConfirmar.setText("Confirmar");
        jbtConfirmar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtConfirmarActionPerformed(evt);
            }
        });

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/cancelar.png"))); // NOI18N
        jbtCancelar.setText("Cancelar");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/sair.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jbtExcluirFormaPagamento.setText("EXCLUIR");
        jbtExcluirFormaPagamento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirFormaPagamentoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 569, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jLabel5)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jcbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 259, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(31, 31, 31)
                                .addComponent(Desconto1)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDescontoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 64, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel6Layout.createSequentialGroup()
                                .addComponent(jbtIncluirFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(79, 79, 79)
                                .addComponent(jbtExcluirFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, 217, javax.swing.GroupLayout.PREFERRED_SIZE)))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGap(68, 68, 68)
                        .addComponent(jbtConfirmar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                        .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(121, 121, 121)
                        .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 135, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(68, 68, 68)))
                .addContainerGap())
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jLabel5)
                            .addComponent(jcbFormaPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                            .addComponent(Desconto1)
                            .addComponent(jtfDescontoPagamento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtIncluirFormaPagamento)
                            .addComponent(jbtExcluirFormaPagamento))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                        .addComponent(jScrollPane2, javax.swing.GroupLayout.PREFERRED_SIZE, 46, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(18, 18, 18)
                        .addGroup(jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                            .addComponent(jbtCancelar)
                            .addComponent(jbtConfirmar)
                            .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
                    .addGroup(jPanel6Layout.createSequentialGroup()
                        .addComponent(jPanel7, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addGap(0, 0, Short.MAX_VALUE))))
        );

        jPanel7.getAccessibleContext().setAccessibleName("Valor Total");

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
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, 229, Short.MAX_VALUE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(3, 3, 3))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jtfQuantidadeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfQuantidadeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfQuantidadeActionPerformed

    private void jbtIncluirFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIncluirFormaPagamentoActionPerformed
        this.controllerVenda.carregarTabelaFormaPgto();
    }//GEN-LAST:event_jbtIncluirFormaPagamentoActionPerformed

    private void jtfDescontoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfDescontoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfDescontoActionPerformed

    private void jbtExcluirFormaPagamentoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirFormaPagamentoActionPerformed
        this.controllerVenda.excluirFormaDePagamento();
    }//GEN-LAST:event_jbtExcluirFormaPagamentoActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        MenuController.desbloqueiaTudo();
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jcbFuncionarioActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbFuncionarioActionPerformed
        this.controllerVenda.verificaIndex();
    }//GEN-LAST:event_jcbFuncionarioActionPerformed

    private void jcbClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jcbClienteActionPerformed
        this.controllerVenda.verificaIndex();
    }//GEN-LAST:event_jcbClienteActionPerformed

    private void jbtIniciarVendaActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtIniciarVendaActionPerformed
        this.controllerVenda.acaoBotaoIniciaVenda();
    }//GEN-LAST:event_jbtIniciarVendaActionPerformed

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        this.controllerVenda.acaoBotaoSalvar();
    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
        this.controllerVenda.excluirProduto();
    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        this.controllerVenda.acaoBotaoCancelar();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtConfirmarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtConfirmarActionPerformed
        this.controllerVenda.acaoBotaoVenda();
    }//GEN-LAST:event_jbtConfirmarActionPerformed

    private void jlbValorTotalKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jlbValorTotalKeyPressed
        // TODO add your handling code here:
    }//GEN-LAST:event_jlbValorTotalKeyPressed

    private void jtfDescontoPagamentoKeyPressed(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoPagamentoKeyPressed

    }//GEN-LAST:event_jtfDescontoPagamentoKeyPressed

    private void jtfDescontoPagamentoKeyReleased(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_jtfDescontoPagamentoKeyReleased
        this.controllerVenda.acaoDesconto();
    }//GEN-LAST:event_jtfDescontoPagamentoKeyReleased


    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel Desconto;
    private javax.swing.JLabel Desconto1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel4;
    private javax.swing.JLabel jLabel5;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JPanel jPanel7;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JScrollPane jScrollPane2;
    private javax.swing.JToolBar jToolBar1;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtConfirmar;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtExcluirFormaPagamento;
    private javax.swing.JButton jbtIncluirFormaPagamento;
    private javax.swing.JButton jbtIniciarVenda;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JComboBox jcbCliente;
    private javax.swing.JComboBox jcbFormaPagamento;
    private javax.swing.JComboBox jcbFuncionario;
    private javax.swing.JComboBox jcbProduto;
    private javax.swing.JLabel jlbValorTotal;
    private javax.swing.JTextField jtfDesconto;
    private javax.swing.JTextField jtfDescontoPagamento;
    private javax.swing.JTextField jtfQuantidade;
    private javax.swing.JTable tabelaFormaPagamento;
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

    public JButton getJbtExcluirFormaPagamento() {
        return jbtExcluirFormaPagamento;
    }

    public void setJbtExcluirFormaPagamento(JButton jbtExcluirFormaPagamento) {
        this.jbtExcluirFormaPagamento = jbtExcluirFormaPagamento;
    }

    public JButton getJbtIncluirFormaPagamento() {
        return jbtIncluirFormaPagamento;
    }

    public void setJbtIncluirFormaPagamento(JButton jbtIncluirFormaPagamento) {
        this.jbtIncluirFormaPagamento = jbtIncluirFormaPagamento;
    }

    public JButton getJbtIniciarVenda() {
        return jbtIniciarVenda;
    }

    public void setJbtIniciarVenda(JButton jbtIniciarVenda) {
        this.jbtIniciarVenda = jbtIniciarVenda;
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

    public JComboBox getJcbCliente() {
        return jcbCliente;
    }

    public void setJcbCliente(JComboBox jcbCliente) {
        this.jcbCliente = jcbCliente;
    }

    public JComboBox getJcbFormaPagamento() {
        return jcbFormaPagamento;
    }

    public void setJcbFormaPagamento(JComboBox jcbFormaPagamento) {
        this.jcbFormaPagamento = jcbFormaPagamento;
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

    public JTextField getJtfDesconto() {
        return jtfDesconto;
    }

    public void setJtfDesconto(JTextField jtfDesconto) {
        this.jtfDesconto = jtfDesconto;
    }

    public JTextField getJtfDescontoPagamento() {
        return jtfDescontoPagamento;
    }

    public void setJtfDescontoPagamento(JTextField jtfDescontoPagamento) {
        this.jtfDescontoPagamento = jtfDescontoPagamento;
    }

    public JTextField getJtfQuantidade() {
        return jtfQuantidade;
    }

    public void setJtfQuantidade(JTextField jtfQuantidade) {
        this.jtfQuantidade = jtfQuantidade;
    }

    public JTable getTabelaFormaPagamento() {
        return tabelaFormaPagamento;
    }

    public void setTabelaFormaPagamento(JTable tabelaFormaPagamento) {
        this.tabelaFormaPagamento = tabelaFormaPagamento;
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
}
