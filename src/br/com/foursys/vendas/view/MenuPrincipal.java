package br.com.foursys.vendas.view;

import br.com.foursys.vendas.controller.MenuController;
import br.com.foursys.vendas.controller.ProdutosEmFaltaController;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
/*
 *@author's: Equipe 4 "Diego, we have a problem!"
 */

public class MenuPrincipal extends javax.swing.JFrame {

    MenuController controllerMenu = new MenuController(MenuPrincipal.this);

    public MenuPrincipal(String login) {
        initComponents();
        setExtendedState(MAXIMIZED_BOTH);
        setVisible(true);
        setResizable(false);
        this.getJblUsuario().setText(login);
    }

    public JLabel getJblUsuario() {
        return jblUsuario;
    }

    public void setJblUsuario(JLabel jblUsuario) {
        this.jblUsuario = jblUsuario;
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        jPanel1 = new javax.swing.JPanel();
        jbtCliente = new javax.swing.JButton();
        jbtFornecedor = new javax.swing.JButton();
        jbtVendas = new javax.swing.JButton();
        jbtCompras = new javax.swing.JButton();
        jbtFuncionarios = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jbtProdutos = new javax.swing.JButton();
        jPanel2 = new javax.swing.JPanel();
        jLabel2 = new javax.swing.JLabel();
        jblUsuario = new javax.swing.JLabel();
        jMenuBar1 = new javax.swing.JMenuBar();
        jmCadastro = new javax.swing.JMenu();
        jMenuItem4 = new javax.swing.JMenuItem();
        jMenuItem5 = new javax.swing.JMenuItem();
        jMenuItem6 = new javax.swing.JMenuItem();
        jMenuItem7 = new javax.swing.JMenuItem();
        jmEstoque = new javax.swing.JMenu();
        jMenu10 = new javax.swing.JMenu();
        jMenuItem15 = new javax.swing.JMenuItem();
        jMenuItem8 = new javax.swing.JMenuItem();
        jMenuItem9 = new javax.swing.JMenuItem();
        jmVendas = new javax.swing.JMenu();
        jMenuItem10 = new javax.swing.JMenuItem();
        jMenuItem12 = new javax.swing.JMenuItem();
        jmCompras = new javax.swing.JMenu();
        jMenuItem3 = new javax.swing.JMenuItem();
        jMenuItem11 = new javax.swing.JMenuItem();
        jmSistema = new javax.swing.JMenu();
        jMenuItem2 = new javax.swing.JMenuItem();
        jSeparator1 = new javax.swing.JPopupMenu.Separator();
        jMenuItem16 = new javax.swing.JMenuItem();
        jMenuItem1 = new javax.swing.JMenuItem();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Sistema Comercial de Vendas");

        jbtCliente.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/clientes.png"))); // NOI18N
        jbtCliente.setText("Clientes");
        jbtCliente.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtClienteActionPerformed(evt);
            }
        });

        jbtFornecedor.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/fornecedor.png"))); // NOI18N
        jbtFornecedor.setText("Fornecedor");
        jbtFornecedor.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFornecedorActionPerformed(evt);
            }
        });

        jbtVendas.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/venda.gif"))); // NOI18N
        jbtVendas.setText("Vendas");
        jbtVendas.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtVendasActionPerformed(evt);
            }
        });

        jbtCompras.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/compras (1).png"))); // NOI18N
        jbtCompras.setText("Compras");
        jbtCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtComprasActionPerformed(evt);
            }
        });

        jbtFuncionarios.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/funcionario.png"))); // NOI18N
        jbtFuncionarios.setText("Funcionários");
        jbtFuncionarios.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtFuncionariosActionPerformed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/sair.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jbtProdutos.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/estoque.png"))); // NOI18N
        jbtProdutos.setText("Produtos");
        jbtProdutos.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtProdutosActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jbtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(10, 10, 10)
                .addComponent(jbtCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 171, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jbtSair)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel1Layout.createSequentialGroup()
                .addGroup(jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCliente, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtFornecedor, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtVendas, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtCompras, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtFuncionarios, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtProdutos, javax.swing.GroupLayout.PREFERRED_SIZE, 70, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(15, Short.MAX_VALUE))
        );

        jLabel2.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N
        jLabel2.setText("Usuário:");

        jblUsuario.setFont(new java.awt.Font("Tahoma", 0, 14)); // NOI18N

        javax.swing.GroupLayout jPanel2Layout = new javax.swing.GroupLayout(jPanel2);
        jPanel2.setLayout(jPanel2Layout);
        jPanel2Layout.setHorizontalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel2)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jblUsuario, javax.swing.GroupLayout.PREFERRED_SIZE, 333, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(742, Short.MAX_VALUE))
        );
        jPanel2Layout.setVerticalGroup(
            jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel2Layout.createSequentialGroup()
                .addGap(0, 7, Short.MAX_VALUE)
                .addGroup(jPanel2Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addComponent(jblUsuario, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                    .addComponent(jLabel2, javax.swing.GroupLayout.Alignment.TRAILING, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)))
        );

        jmCadastro.setText("Cadastro");
        jmCadastro.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmCadastroActionPerformed(evt);
            }
        });

        jMenuItem4.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F2, 0));
        jMenuItem4.setText("Clientes");
        jMenuItem4.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem4ActionPerformed(evt);
            }
        });
        jmCadastro.add(jMenuItem4);

        jMenuItem5.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F3, 0));
        jMenuItem5.setText("Fornecedores");
        jMenuItem5.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem5ActionPerformed(evt);
            }
        });
        jmCadastro.add(jMenuItem5);

        jMenuItem6.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F4, 0));
        jMenuItem6.setText("Produtos");
        jMenuItem6.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem6ActionPerformed(evt);
            }
        });
        jmCadastro.add(jMenuItem6);

        jMenuItem7.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F5, 0));
        jMenuItem7.setText("Funcionários");
        jMenuItem7.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem7ActionPerformed(evt);
            }
        });
        jmCadastro.add(jMenuItem7);

        jMenuBar1.add(jmCadastro);

        jmEstoque.setText("Estoque");

        jMenu10.setText("Controle de Estoque");

        jMenuItem15.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F7, 0));
        jMenuItem15.setText("Entrada de Estoque");
        jMenuItem15.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem15ActionPerformed(evt);
            }
        });
        jMenu10.add(jMenuItem15);

        jmEstoque.add(jMenu10);

        jMenuItem8.setText("Consultar Estoque");
        jMenuItem8.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem8ActionPerformed(evt);
            }
        });
        jmEstoque.add(jMenuItem8);

        jMenuItem9.setText("Produtos em Falta");
        jMenuItem9.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem9ActionPerformed(evt);
            }
        });
        jmEstoque.add(jMenuItem9);

        jMenuBar1.add(jmEstoque);

        jmVendas.setText("Vendas");

        jMenuItem10.setAccelerator(javax.swing.KeyStroke.getKeyStroke(java.awt.event.KeyEvent.VK_F6, 0));
        jMenuItem10.setText("Efetuar Venda");
        jMenuItem10.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem10ActionPerformed(evt);
            }
        });
        jmVendas.add(jMenuItem10);

        jMenuItem12.setText("Consultar Venda");
        jMenuItem12.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem12ActionPerformed(evt);
            }
        });
        jmVendas.add(jMenuItem12);

        jMenuBar1.add(jmVendas);

        jmCompras.setText("Compras");
        jmCompras.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jmComprasActionPerformed(evt);
            }
        });

        jMenuItem3.setText("Efetuar Compra");
        jMenuItem3.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem3ActionPerformed(evt);
            }
        });
        jmCompras.add(jMenuItem3);

        jMenuItem11.setText("Consultar Compra");
        jMenuItem11.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem11ActionPerformed(evt);
            }
        });
        jmCompras.add(jMenuItem11);

        jMenuBar1.add(jmCompras);

        jmSistema.setText("Sistema");

        jMenuItem2.setText("Sobre");
        jMenuItem2.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem2ActionPerformed(evt);
            }
        });
        jmSistema.add(jMenuItem2);
        jmSistema.add(jSeparator1);

        jMenuItem16.setText("Logout");
        jMenuItem16.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem16ActionPerformed(evt);
            }
        });
        jmSistema.add(jMenuItem16);

        jMenuItem1.setText("Sair");
        jMenuItem1.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jMenuItem1ActionPerformed(evt);
            }
        });
        jmSistema.add(jMenuItem1);

        jMenuBar1.add(jmSistema);

        setJMenuBar(jMenuBar1);

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, layout.createSequentialGroup()
                .addComponent(jPanel1, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 289, Short.MAX_VALUE)
                .addComponent(jPanel2, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtClienteActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtClienteActionPerformed
        new ClientePrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jbtClienteActionPerformed

    private void jbtFornecedorActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFornecedorActionPerformed
        new FornecedorPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jbtFornecedorActionPerformed

    private void jbtVendasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtVendasActionPerformed
        new VendaPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jbtVendasActionPerformed

    private void jbtComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtComprasActionPerformed
        new CompraPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jbtComprasActionPerformed

    private void jbtFuncionariosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtFuncionariosActionPerformed
        new FuncionarioPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jbtFuncionariosActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
        this.controllerMenu.acaoBotaoSair();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jMenuItem4ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem4ActionPerformed
        new ClientePrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem4ActionPerformed

    private void jMenuItem5ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem5ActionPerformed
        new FornecedorPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem5ActionPerformed

    private void jmCadastroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmCadastroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jmCadastroActionPerformed

    private void jMenuItem6ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem6ActionPerformed
        new ProdutoPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem6ActionPerformed

    private void jMenuItem10ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem10ActionPerformed
        new VendaPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem10ActionPerformed

    private void jbtProdutosActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtProdutosActionPerformed
        new ProdutoPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jbtProdutosActionPerformed

    private void jMenuItem7ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem7ActionPerformed
        new FuncionarioPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem7ActionPerformed

    private void jMenuItem15ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem15ActionPerformed
        new EstoquePrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem15ActionPerformed

    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem1ActionPerformed
        this.controllerMenu.acaoBotaoSair();
    }//GEN-LAST:event_jMenuItem1ActionPerformed

    private void jMenuItem16ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem16ActionPerformed
        this.controllerMenu.acaoBotaoLogout();
        dispose();
        new LoginPrincipal();
    }//GEN-LAST:event_jMenuItem16ActionPerformed

    private void jMenuItem2ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem2ActionPerformed
        new SobreEquipe();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem2ActionPerformed

    private void jmComprasActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jmComprasActionPerformed

    }//GEN-LAST:event_jmComprasActionPerformed

    private void jMenuItem3ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem3ActionPerformed
        new CompraPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem3ActionPerformed

    private void jMenuItem11ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem11ActionPerformed
        new BaixaContasPagarPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem11ActionPerformed

    private void jMenuItem12ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem12ActionPerformed
        new BaixaContasReceberPrincipal();
        this.controllerMenu.bloqueiaTudo();
    }//GEN-LAST:event_jMenuItem12ActionPerformed

    private void jMenuItem8ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem8ActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jMenuItem8ActionPerformed

    private void jMenuItem9ActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jMenuItem9ActionPerformed
        new ProdutosEmFaltaController().gerarExcel();
    }//GEN-LAST:event_jMenuItem9ActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.JLabel jLabel2;
    private javax.swing.JMenu jMenu10;
    private javax.swing.JMenuBar jMenuBar1;
    private javax.swing.JMenuItem jMenuItem1;
    private javax.swing.JMenuItem jMenuItem10;
    private javax.swing.JMenuItem jMenuItem11;
    private javax.swing.JMenuItem jMenuItem12;
    private javax.swing.JMenuItem jMenuItem15;
    private javax.swing.JMenuItem jMenuItem16;
    private javax.swing.JMenuItem jMenuItem2;
    private javax.swing.JMenuItem jMenuItem3;
    private javax.swing.JMenuItem jMenuItem4;
    private javax.swing.JMenuItem jMenuItem5;
    private javax.swing.JMenuItem jMenuItem6;
    private javax.swing.JMenuItem jMenuItem7;
    private javax.swing.JMenuItem jMenuItem8;
    private javax.swing.JMenuItem jMenuItem9;
    private javax.swing.JPanel jPanel1;
    private javax.swing.JPanel jPanel2;
    private javax.swing.JPopupMenu.Separator jSeparator1;
    private javax.swing.JLabel jblUsuario;
    private javax.swing.JButton jbtCliente;
    private javax.swing.JButton jbtCompras;
    private javax.swing.JButton jbtFornecedor;
    private javax.swing.JButton jbtFuncionarios;
    private javax.swing.JButton jbtProdutos;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtVendas;
    private javax.swing.JMenu jmCadastro;
    private javax.swing.JMenu jmCompras;
    private javax.swing.JMenu jmEstoque;
    private javax.swing.JMenu jmSistema;
    private javax.swing.JMenu jmVendas;
    // End of variables declaration//GEN-END:variables

    public MenuController getControllerMenu() {
        return controllerMenu;
    }

    public void setControllerMenu(MenuController controllerMenu) {
        this.controllerMenu = controllerMenu;
    }

    public JLabel getjLabel2() {
        return jLabel2;
    }

    public void setjLabel2(JLabel jLabel2) {
        this.jLabel2 = jLabel2;
    }

    public JMenu getJmCadastro() {
        return jmCadastro;
    }

    public void setJmCadastro(JMenu jmCadastro) {
        this.jmCadastro = jmCadastro;
    }

    public JMenu getJmCompras() {
        return jmCompras;
    }

    public void setJmCompras(JMenu jmCompras) {
        this.jmCompras = jmCompras;
    }

    public JMenu getJmEstoque() {
        return jmEstoque;
    }

    public void setJmEstoque(JMenu jmEstoque) {
        this.jmEstoque = jmEstoque;
    }

    public JMenu getJmSistema() {
        return jmSistema;
    }

    public void setJmSistema(JMenu jmSistema) {
        this.jmSistema = jmSistema;
    }

    public JMenu getJmVendas() {
        return jmVendas;
    }

    public void setJmVendas(JMenu jmVendas) {
        this.jmVendas = jmVendas;
    }
    
    public JButton getJbtCliente() {
        return jbtCliente;
    }

    public void setJbtCliente(JButton jbtCliente) {
        this.jbtCliente = jbtCliente;
    }

    public JButton getJbtCompras() {
        return jbtCompras;
    }

    public void setJbtCompras(JButton jbtCompras) {
        this.jbtCompras = jbtCompras;
    }

    public JButton getJbtFornecedor() {
        return jbtFornecedor;
    }

    public void setJbtFornecedor(JButton jbtFornecedor) {
        this.jbtFornecedor = jbtFornecedor;
    }

    public JButton getJbtFuncionarios() {
        return jbtFuncionarios;
    }

    public void setJbtFuncionarios(JButton jbtFuncionarios) {
        this.jbtFuncionarios = jbtFuncionarios;
    }

    public JButton getJbtProdutos() {
        return jbtProdutos;
    }

    public void setJbtProdutos(JButton jbtProdutos) {
        this.jbtProdutos = jbtProdutos;
    }

    public JButton getJbtSair() {
        return jbtSair;
    }

    public void setJbtSair(JButton jbtSair) {
        this.jbtSair = jbtSair;
    }

    public JButton getJbtVendas() {
        return jbtVendas;
    }

    public void setJbtVendas(JButton jbtVendas) {
        this.jbtVendas = jbtVendas;
    }
}
