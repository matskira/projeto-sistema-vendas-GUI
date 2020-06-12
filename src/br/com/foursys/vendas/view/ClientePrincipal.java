package br.com.foursys.vendas.view;

import br.com.foursys.vendas.controller.ClienteController;
import br.com.foursys.vendas.controller.MenuController;
import javax.swing.ButtonGroup;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFormattedTextField;
import javax.swing.JLabel;
import javax.swing.JRadioButton;
import javax.swing.JTable;
import javax.swing.JTextField;
import javax.swing.text.DefaultFormatterFactory;
import javax.swing.text.MaskFormatter;

/*
 *@author's: Equipe 4 "Diego, we have a problem!"
 */
public class ClientePrincipal extends javax.swing.JFrame {

    ClienteController controller = new ClienteController(ClientePrincipal.this);

    public ClientePrincipal() {
        initComponents();
        setLocationRelativeTo(null);
        setResizable(false);
        this.controller.listarClientes();
        this.controller.carregarComboCidade();
        this.controller.carregarComboEstado();
        this.controller.bloqueioInicial();
        setVisible(true);
    }

    @SuppressWarnings("unchecked")
    // <editor-fold defaultstate="collapsed" desc="Generated Code">//GEN-BEGIN:initComponents
    private void initComponents() {

        buttonGroup1 = new javax.swing.ButtonGroup();
        jPanel4 = new javax.swing.JPanel();
        jlbCpf = new javax.swing.JLabel();
        jlbNome = new javax.swing.JLabel();
        jtfNome = new javax.swing.JTextField();
        jLabel6 = new javax.swing.JLabel();
        jLabel7 = new javax.swing.JLabel();
        jtfNumero = new javax.swing.JTextField();
        jLabel9 = new javax.swing.JLabel();
        jtfBairro = new javax.swing.JTextField();
        jLabel10 = new javax.swing.JLabel();
        jLabel13 = new javax.swing.JLabel();
        jtfEmail = new javax.swing.JTextField();
        jLabel14 = new javax.swing.JLabel();
        jLabel15 = new javax.swing.JLabel();
        jtfCelular = new javax.swing.JFormattedTextField();
        jtfEndereco = new javax.swing.JTextField();
        jtfTelefone = new javax.swing.JFormattedTextField();
        jlbRg = new javax.swing.JLabel();
        jLabel8 = new javax.swing.JLabel();
        jlbDataNascimento = new javax.swing.JLabel();
        jtfDataNascimento = new javax.swing.JFormattedTextField();
        jtfRg = new javax.swing.JFormattedTextField();
        jtfCpf = new javax.swing.JFormattedTextField();
        jLabel11 = new javax.swing.JLabel();
        jcbEstado = new javax.swing.JComboBox();
        jtfCep = new javax.swing.JFormattedTextField();
        jcbCidade = new javax.swing.JComboBox();
        jLabel2 = new javax.swing.JLabel();
        jrbFisico = new javax.swing.JRadioButton();
        jrbJuridico = new javax.swing.JRadioButton();
        jLabel3 = new javax.swing.JLabel();
        jtfComplemento = new javax.swing.JTextField();
        jPanel3 = new javax.swing.JPanel();
        jLabel1 = new javax.swing.JLabel();
        jtfPesquisarNome = new javax.swing.JTextField();
        jPanel6 = new javax.swing.JPanel();
        jLabel17 = new javax.swing.JLabel();
        jScrollPane1 = new javax.swing.JScrollPane();
        tabelaCliente = new javax.swing.JTable();
        jPanel5 = new javax.swing.JPanel();
        jbtCancelar = new javax.swing.JButton();
        jbtSalvar = new javax.swing.JButton();
        jbtExcluir = new javax.swing.JButton();
        jbtAlterar = new javax.swing.JButton();
        jbtSair = new javax.swing.JButton();
        jbtNovo = new javax.swing.JButton();

        setDefaultCloseOperation(javax.swing.WindowConstants.DO_NOTHING_ON_CLOSE);
        setTitle("Cadastro de Cliente");

        jPanel4.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Dados do Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jlbCpf.setText("CPF:");

        jlbNome.setText("Nome:");

        jtfNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNomeActionPerformed(evt);
            }
        });

        jLabel6.setText("End:");

        jLabel7.setText("Número:");

        jtfNumero.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfNumeroActionPerformed(evt);
            }
        });

        jLabel9.setText("Bairro:");

        jLabel10.setText("Cidade:");

        jLabel13.setText("E-mail:");

        jtfEmail.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfEmailActionPerformed(evt);
            }
        });

        jLabel14.setText("Telefone:");

        jLabel15.setText("Celular:");

        try {
            jtfCelular.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) #####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jtfTelefone.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("(##) ####-####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jlbRg.setText("RG:");

        jLabel8.setText("UF:");

        jlbDataNascimento.setText("Data Nascimento:");

        try {
            jtfDataNascimento.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##/##/####")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jtfRg.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("##.###.###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        try {
            jtfCpf.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("###.###.###-##")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jLabel11.setText("CEP:");

        jcbEstado.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione Estado -" }));

        try {
            jtfCep.setFormatterFactory(new javax.swing.text.DefaultFormatterFactory(new javax.swing.text.MaskFormatter("#####-###")));
        } catch (java.text.ParseException ex) {
            ex.printStackTrace();
        }

        jcbCidade.setModel(new javax.swing.DefaultComboBoxModel(new String[] { "- Selecione Cidade -" }));

        jLabel2.setText("Tipo Pessoa:");

        buttonGroup1.add(jrbFisico);
        jrbFisico.setText("Fisico");
        jrbFisico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbFisicoActionPerformed(evt);
            }
        });

        buttonGroup1.add(jrbJuridico);
        jrbJuridico.setText("Juridico");
        jrbJuridico.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jrbJuridicoActionPerformed(evt);
            }
        });

        jLabel3.setText("Complemento:");

        jtfComplemento.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfComplementoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel4Layout = new javax.swing.GroupLayout(jPanel4);
        jPanel4.setLayout(jPanel4Layout);
        jPanel4Layout.setHorizontalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel2)
                            .addComponent(jlbNome))
                        .addGap(27, 27, 27)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jrbFisico)
                                .addGap(11, 11, 11)
                                .addComponent(jrbJuridico)
                                .addGap(18, 18, 18)
                                .addComponent(jlbCpf)
                                .addGap(39, 39, 39)
                                .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, 160, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                                .addComponent(jlbRg)
                                .addGap(8, 8, 8))
                            .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, 416, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, 35, Short.MAX_VALUE)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addComponent(jlbDataNascimento)
                                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                .addComponent(jtfDataNascimento))
                            .addComponent(jtfRg, javax.swing.GroupLayout.PREFERRED_SIZE, 182, javax.swing.GroupLayout.PREFERRED_SIZE))
                        .addContainerGap())
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel6)
                            .addComponent(jLabel9)
                            .addComponent(jLabel11)
                            .addComponent(jLabel15))
                        .addGap(51, 51, 51)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING, false)
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jtfCelular, javax.swing.GroupLayout.DEFAULT_SIZE, 169, Short.MAX_VALUE)
                                .addGap(18, 18, 18)
                                .addComponent(jLabel13)
                                .addGap(18, 18, 18)
                                .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, 395, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(jPanel4Layout.createSequentialGroup()
                                .addComponent(jtfCep)
                                .addGap(28, 28, 28)
                                .addComponent(jLabel8)
                                .addGap(24, 24, 24)
                                .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, 125, javax.swing.GroupLayout.PREFERRED_SIZE)
                                .addGap(17, 17, 17)
                                .addComponent(jLabel14)
                                .addGap(18, 18, 18)
                                .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, 148, javax.swing.GroupLayout.PREFERRED_SIZE))
                            .addGroup(javax.swing.GroupLayout.Alignment.TRAILING, jPanel4Layout.createSequentialGroup()
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                                    .addComponent(jtfBairro)
                                    .addComponent(jtfEndereco))
                                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.TRAILING, false)
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addGap(14, 14, 14)
                                        .addComponent(jLabel10)
                                        .addGap(18, 18, 18)
                                        .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, 309, javax.swing.GroupLayout.PREFERRED_SIZE))
                                    .addGroup(jPanel4Layout.createSequentialGroup()
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel3)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfComplemento)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                                        .addComponent(jLabel7, javax.swing.GroupLayout.PREFERRED_SIZE, 59, javax.swing.GroupLayout.PREFERRED_SIZE)
                                        .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                                        .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, 92, javax.swing.GroupLayout.PREFERRED_SIZE))))))))
        );
        jPanel4Layout.setVerticalGroup(
            jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel4Layout.createSequentialGroup()
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel2)
                    .addComponent(jrbFisico)
                    .addComponent(jrbJuridico)
                    .addComponent(jlbCpf)
                    .addComponent(jtfCpf, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbRg)
                    .addComponent(jtfRg, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jtfNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbDataNascimento)
                    .addComponent(jtfDataNascimento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jlbNome))
                .addGap(10, 10, 10)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfEndereco, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel3)
                        .addComponent(jtfComplemento, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfNumero, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel7))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel6)))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfBairro, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbCidade, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel9)
                            .addComponent(jLabel10))))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addComponent(jtfCep, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jcbEstado, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jtfTelefone, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                            .addComponent(jLabel11)
                            .addComponent(jLabel8)
                            .addComponent(jLabel14))))
                .addGap(11, 11, 11)
                .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                    .addGroup(jPanel4Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                        .addComponent(jtfEmail, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                        .addComponent(jLabel13)
                        .addComponent(jtfCelular, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                    .addGroup(jPanel4Layout.createSequentialGroup()
                        .addGap(3, 3, 3)
                        .addComponent(jLabel15))))
        );

        jPanel3.setBorder(javax.swing.BorderFactory.createTitledBorder(null, "Buscar Cliente", javax.swing.border.TitledBorder.DEFAULT_JUSTIFICATION, javax.swing.border.TitledBorder.DEFAULT_POSITION, new java.awt.Font("Tahoma", 1, 11))); // NOI18N

        jLabel1.setText("Nome:");

        jtfPesquisarNome.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jtfPesquisarNomeActionPerformed(evt);
            }
        });
        jtfPesquisarNome.addKeyListener(new java.awt.event.KeyAdapter() {
            public void keyReleased(java.awt.event.KeyEvent evt) {
                acaoPreencher(evt);
            }
        });

        javax.swing.GroupLayout jPanel3Layout = new javax.swing.GroupLayout(jPanel3);
        jPanel3.setLayout(jPanel3Layout);
        jPanel3Layout.setHorizontalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addComponent(jLabel1, javax.swing.GroupLayout.PREFERRED_SIZE, 42, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.UNRELATED)
                .addComponent(jtfPesquisarNome)
                .addContainerGap())
        );
        jPanel3Layout.setVerticalGroup(
            jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel3Layout.createSequentialGroup()
                .addContainerGap()
                .addGroup(jPanel3Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jLabel1)
                    .addComponent(jtfPesquisarNome, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addContainerGap(13, Short.MAX_VALUE))
        );

        jPanel6.setBackground(new java.awt.Color(204, 204, 204));
        jPanel6.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED, null, new java.awt.Color(204, 204, 204), null, new java.awt.Color(204, 204, 204)));

        jLabel17.setFont(new java.awt.Font("Tahoma", 1, 12)); // NOI18N
        jLabel17.setText("Clientes Cadastrados");

        javax.swing.GroupLayout jPanel6Layout = new javax.swing.GroupLayout(jPanel6);
        jPanel6.setLayout(jPanel6Layout);
        jPanel6Layout.setHorizontalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel6Layout.createSequentialGroup()
                .addGap(298, 298, 298)
                .addComponent(jLabel17)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel6Layout.setVerticalGroup(
            jPanel6Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jLabel17, javax.swing.GroupLayout.Alignment.TRAILING)
        );

        tabelaCliente.setModel(new javax.swing.table.DefaultTableModel(
            new Object [][] {

            },
            new String [] {
                "Nome", "Cidade", "Celular", "e-mail"
            }
        ));
        jScrollPane1.setViewportView(tabelaCliente);

        jPanel5.setBorder(javax.swing.BorderFactory.createBevelBorder(javax.swing.border.BevelBorder.RAISED));

        jbtCancelar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/cancelar.png"))); // NOI18N
        jbtCancelar.setText("CANCELAR");
        jbtCancelar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtCancelarActionPerformed(evt);
            }
        });

        jbtSalvar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/salvar.png"))); // NOI18N
        jbtSalvar.setText("SALVAR CLIENTE");
        jbtSalvar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSalvarActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout jPanel5Layout = new javax.swing.GroupLayout(jPanel5);
        jPanel5.setLayout(jPanel5Layout);
        jPanel5Layout.setHorizontalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addGap(23, 23, 23)
                .addComponent(jbtSalvar, javax.swing.GroupLayout.PREFERRED_SIZE, 338, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtCancelar, javax.swing.GroupLayout.PREFERRED_SIZE, 323, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE))
        );
        jPanel5Layout.setVerticalGroup(
            jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(jPanel5Layout.createSequentialGroup()
                .addContainerGap(javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addGroup(jPanel5Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtCancelar)
                    .addComponent(jbtSalvar))
                .addGap(11, 11, 11))
        );

        jbtExcluir.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/excluir.png"))); // NOI18N
        jbtExcluir.setText("Excluir");
        jbtExcluir.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtExcluirActionPerformed(evt);
            }
        });

        jbtAlterar.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/alterar.png"))); // NOI18N
        jbtAlterar.setText("Alterar");
        jbtAlterar.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtAlterarActionPerformed(evt);
            }
        });

        jbtSair.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/sair.png"))); // NOI18N
        jbtSair.setText("Sair");
        jbtSair.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtSairActionPerformed(evt);
            }
        });

        jbtNovo.setIcon(new javax.swing.ImageIcon(getClass().getResource("/br/com/foursys/vendas/img/clientes.png"))); // NOI18N
        jbtNovo.setText("Novo");
        jbtNovo.addActionListener(new java.awt.event.ActionListener() {
            public void actionPerformed(java.awt.event.ActionEvent evt) {
                jbtNovoActionPerformed(evt);
            }
        });

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(8, 8, 8)
                .addComponent(jbtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 161, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 168, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
                .addComponent(jbtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 169, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(18, 18, 18)
                .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 176, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addContainerGap())
            .addGroup(layout.createSequentialGroup()
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(0, 0, Short.MAX_VALUE))
            .addComponent(jPanel3, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel5, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jPanel6, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
            .addComponent(jScrollPane1)
        );
        layout.setVerticalGroup(
            layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGroup(layout.createSequentialGroup()
                .addGap(9, 9, 9)
                .addGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.BASELINE)
                    .addComponent(jbtNovo, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtAlterar, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtExcluir, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE)
                    .addComponent(jbtSair, javax.swing.GroupLayout.PREFERRED_SIZE, 39, javax.swing.GroupLayout.PREFERRED_SIZE))
                .addGap(18, 21, Short.MAX_VALUE)
                .addComponent(jPanel3, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel4, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addGap(1, 1, 1)
                .addComponent(jPanel5, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jPanel6, javax.swing.GroupLayout.PREFERRED_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.PREFERRED_SIZE)
                .addPreferredGap(javax.swing.LayoutStyle.ComponentPlacement.RELATED)
                .addComponent(jScrollPane1, javax.swing.GroupLayout.PREFERRED_SIZE, 162, javax.swing.GroupLayout.PREFERRED_SIZE))
        );

        pack();
    }// </editor-fold>//GEN-END:initComponents

    private void jbtNovoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtNovoActionPerformed
        this.controller.acaoBotaoNovo();
    }//GEN-LAST:event_jbtNovoActionPerformed

    private void jbtAlterarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtAlterarActionPerformed
        this.controller.alterarCliente();
    }//GEN-LAST:event_jbtAlterarActionPerformed

    private void jbtExcluirActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtExcluirActionPerformed
        this.controller.excluirCliente();
    }//GEN-LAST:event_jbtExcluirActionPerformed

    private void jbtSairActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSairActionPerformed
       MenuController.desbloqueiaTudo();
        dispose();
    }//GEN-LAST:event_jbtSairActionPerformed

    private void jbtCancelarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtCancelarActionPerformed
        this.controller.acaoBotaoCancelar();
    }//GEN-LAST:event_jbtCancelarActionPerformed

    private void jbtSalvarActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jbtSalvarActionPerformed
        this.controller.acaoBotaoSalvar();
    }//GEN-LAST:event_jbtSalvarActionPerformed

    private void acaoPreencher(java.awt.event.KeyEvent evt) {//GEN-FIRST:event_acaoPreencher

    }//GEN-LAST:event_acaoPreencher

    private void jtfPesquisarNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfPesquisarNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfPesquisarNomeActionPerformed

    private void jrbJuridicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbJuridicoActionPerformed
        this.controller.mascaraCnpj();
        this.controller.mascaraInscricaoEstadual();
        this.controller.mascaraJuridica();
    }//GEN-LAST:event_jrbJuridicoActionPerformed

    private void jrbFisicoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jrbFisicoActionPerformed
        this.controller.mascaraCpf();
        this.controller.mascaraRg();
        this.controller.mascaraFisica();


    }//GEN-LAST:event_jrbFisicoActionPerformed

    private void jtfEmailActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfEmailActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfEmailActionPerformed

    private void jtfNumeroActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNumeroActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNumeroActionPerformed

    private void jtfNomeActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfNomeActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfNomeActionPerformed

    private void jtfComplementoActionPerformed(java.awt.event.ActionEvent evt) {//GEN-FIRST:event_jtfComplementoActionPerformed
        // TODO add your handling code here:
    }//GEN-LAST:event_jtfComplementoActionPerformed

    // Variables declaration - do not modify//GEN-BEGIN:variables
    private javax.swing.ButtonGroup buttonGroup1;
    private javax.swing.JLabel jLabel1;
    private javax.swing.JLabel jLabel10;
    private javax.swing.JLabel jLabel11;
    private javax.swing.JLabel jLabel13;
    private javax.swing.JLabel jLabel14;
    private javax.swing.JLabel jLabel15;
    private javax.swing.JLabel jLabel17;
    private javax.swing.JLabel jLabel2;
    private javax.swing.JLabel jLabel3;
    private javax.swing.JLabel jLabel6;
    private javax.swing.JLabel jLabel7;
    private javax.swing.JLabel jLabel8;
    private javax.swing.JLabel jLabel9;
    private javax.swing.JPanel jPanel3;
    private javax.swing.JPanel jPanel4;
    private javax.swing.JPanel jPanel5;
    private javax.swing.JPanel jPanel6;
    private javax.swing.JScrollPane jScrollPane1;
    private javax.swing.JButton jbtAlterar;
    private javax.swing.JButton jbtCancelar;
    private javax.swing.JButton jbtExcluir;
    private javax.swing.JButton jbtNovo;
    private javax.swing.JButton jbtSair;
    private javax.swing.JButton jbtSalvar;
    private javax.swing.JComboBox jcbCidade;
    private javax.swing.JComboBox jcbEstado;
    private javax.swing.JLabel jlbCpf;
    private javax.swing.JLabel jlbDataNascimento;
    private javax.swing.JLabel jlbNome;
    private javax.swing.JLabel jlbRg;
    private javax.swing.JRadioButton jrbFisico;
    private javax.swing.JRadioButton jrbJuridico;
    private javax.swing.JTextField jtfBairro;
    private javax.swing.JFormattedTextField jtfCelular;
    private javax.swing.JFormattedTextField jtfCep;
    private javax.swing.JTextField jtfComplemento;
    private javax.swing.JFormattedTextField jtfCpf;
    private javax.swing.JFormattedTextField jtfDataNascimento;
    private javax.swing.JTextField jtfEmail;
    private javax.swing.JTextField jtfEndereco;
    private javax.swing.JTextField jtfNome;
    private javax.swing.JTextField jtfNumero;
    private javax.swing.JTextField jtfPesquisarNome;
    private javax.swing.JFormattedTextField jtfRg;
    private javax.swing.JFormattedTextField jtfTelefone;
    private javax.swing.JTable tabelaCliente;
    // End of variables declaration//GEN-END:variables

    public JButton getJbtAlterar() {
        return jbtAlterar;
    }

    public void setJbtAlterar(JButton jbtAlterar) {
        this.jbtAlterar = jbtAlterar;
    }

    public JButton getJbtCancelar() {
        return jbtCancelar;
    }

    public void setJbtCancelar(JButton jbtCancelar) {
        this.jbtCancelar = jbtCancelar;
    }

    public JButton getJbtExcluir() {
        return jbtExcluir;
    }

    public void setJbtExcluir(JButton jbtExcluir) {
        this.jbtExcluir = jbtExcluir;
    }

    public JButton getJbtNovo() {
        return jbtNovo;
    }

    public void setJbtNovo(JButton jbtNovo) {
        this.jbtNovo = jbtNovo;
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

    public JComboBox getJcbCidade() {
        return jcbCidade;
    }

    public void setJcbCidade(JComboBox jcbCidade) {
        this.jcbCidade = jcbCidade;
    }

    public JComboBox getJcbEstado() {
        return jcbEstado;
    }

    public void setJcbEstado(JComboBox jcbEstado) {
        this.jcbEstado = jcbEstado;
    }

    public JTextField getJtfBairro() {
        return jtfBairro;
    }

    public void setJtfBairro(JTextField jtfBairro) {
        this.jtfBairro = jtfBairro;
    }

    public JFormattedTextField getJtfCelular() {
        return jtfCelular;
    }

    public void setJtfCelular(JFormattedTextField jtfCelular) {
        this.jtfCelular = jtfCelular;
    }

    public JFormattedTextField getJtfCep() {
        return jtfCep;
    }

    public void setJtfCep(JFormattedTextField jtfCep) {
        this.jtfCep = jtfCep;
    }

    public JFormattedTextField getJtfCpf() {
        return jtfCpf;
    }

    public void setJtfCpf(JFormattedTextField jtfCpf) {
        this.jtfCpf = jtfCpf;
    }

    public JFormattedTextField getJtfDataNascimento() {
        return jtfDataNascimento;
    }

    public void setJtfDataNascimento(JFormattedTextField jtfDataNascimento) {
        this.jtfDataNascimento = jtfDataNascimento;
    }

    public JTextField getJtfEmail() {
        return jtfEmail;
    }

    public void setJtfEmail(JTextField jtfEmail) {
        this.jtfEmail = jtfEmail;
    }

    public JTextField getJtfEndereco() {
        return jtfEndereco;
    }

    public void setJtfEndereco(JTextField jtfEndereco) {
        this.jtfEndereco = jtfEndereco;
    }

    public JLabel getJlbNome() {
        return jlbNome;
    }

    public void setJlbNome(JLabel jlbNome) {
        this.jlbNome = jlbNome;
    }

    public JTextField getJtfNome() {
        return jtfNome;
    }

    public void setJtfNome(JTextField jtfNome) {
        this.jtfNome = jtfNome;
    }

    public JTextField getJtfNumero() {
        return jtfNumero;
    }

    public void setJtfNumero(JTextField jtfNumero) {
        this.jtfNumero = jtfNumero;
    }

    public JTextField getJtfPesquisarNome() {
        return jtfPesquisarNome;
    }

    public void setJtfPesquisarNome(JTextField jtfPesquisarNome) {
        this.jtfPesquisarNome = jtfPesquisarNome;
    }

    public JFormattedTextField getJtfRg() {
        return jtfRg;
    }

    public void setJtfRg(JFormattedTextField jtfRg) {
        this.jtfRg = jtfRg;
    }

    public JFormattedTextField getJtfTelefone() {
        return jtfTelefone;
    }

    public void setJtfTelefone(JFormattedTextField jtfTelefone) {
        this.jtfTelefone = jtfTelefone;
    }

    public JTable getTabelaCliente() {
        return tabelaCliente;
    }

    public void setTabelaCliente(JTable tabelaCliente) {
        this.tabelaCliente = tabelaCliente;
    }

    public JRadioButton getJrbFisico() {
        return jrbFisico;
    }

    public void setJrbFisico(JRadioButton jrbFisico) {
        this.jrbFisico = jrbFisico;
    }

    public JRadioButton getJrbJuridico() {
        return jrbJuridico;
    }

    public void setJrbJuridico(JRadioButton jrbJuridico) {
        this.jrbJuridico = jrbJuridico;
    }

    public ButtonGroup getButtonGroup1() {
        return buttonGroup1;
    }

    public void setButtonGroup1(ButtonGroup buttonGroup1) {
        this.buttonGroup1 = buttonGroup1;
    }

    public JLabel getJlbCpf() {
        return jlbCpf;
    }

    public void setJlbCpf(JLabel jlbCpf) {
        this.jlbCpf = jlbCpf;
    }

    public JLabel getJlbDataNascimento() {
        return jlbDataNascimento;
    }

    public void setJlbDataNascimento(JLabel jlbDataNascimento) {
        this.jlbDataNascimento = jlbDataNascimento;
    }

    public JLabel getJlbRg() {
        return jlbRg;
    }

    public void setJlbRg(JLabel jlbRg) {
        this.jlbRg = jlbRg;
    }

    public JTextField getJtfComplemento() {
        return jtfComplemento;
    }

    public void setJtfComplemento(JTextField jtfComplemento) {
        this.jtfComplemento = jtfComplemento;
    }

    public void mascaraCnpj() {
        try {
            jtfCpf.setValue(null);
            MaskFormatter cnpj = new MaskFormatter("##.###.###/####-##");
            jtfCpf.setFormatterFactory(
                    new DefaultFormatterFactory(cnpj));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

    public void mascaraInscricaoEstadual() {

        try {
            jtfRg.setValue(null);
            MaskFormatter cnpj = new MaskFormatter("###.###.###.###");
            jtfRg.setFormatterFactory(
                    new DefaultFormatterFactory(cnpj));
        } catch (Exception ex) {
            ex.printStackTrace();
        }
    }

}
