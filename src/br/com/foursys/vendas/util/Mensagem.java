package br.com.foursys.vendas.util;

/**
 * @author's: Equipe 4 "Diego, we have a problem!"
 */
public class Mensagem {

    // CLIENTE
    public static String selecionaCliente = "É necessário selecionar um cliente";
    public static String clienteExcluido = "Cliente excluido com sucesso!";
    public static String erroExcluirCliente = "Erro ao excluir o cliente!";
    public static String clienteSalvo = "Cliente salvo com sucesso!";

    // FUNCIONARIO
    public static String selecionaFuncionario = "É necessário selecionar um funcionário";
    public static String funcionarioExcluido = "Funcionário excluido com sucesso!";
    public static String erroExcluirFuncionario = "Erro ao excluir o funcionário!";
    public static String funcionarioSalvo = "Funcionário salvo com sucesso!";

    // FORNECEDOR
    public static String selecionaFornecedor = "É necessário selecionar um fornecedor";
    public static String fornecedorExcluido = "Fornecedor excluido com sucesso!";
    public static String erroExcluirFornecedor = "Erro ao excluir o fornecedor!";
    public static String fornecedorSalvo = "Fornecedor salvo com sucesso.";

    // PRODUTO
    public static String selecionaEstoque = "É necessário selecionar um item de estoque";
    public static String selecionaProduto = "É necessário selecionar um produto";
    public static String estoqueExcluido = "Estoque excluido com sucesso!";
    public static String produtoExcluido = "Produto excluido com sucesso!";
    public static String erroExcluirEstoque = "Erro ao excluir o estoque!";
    public static String erroExcluirProduto = "Erro ao excluir o produto!";
    public static String produtoSalvo = "Produto salvo com sucesso.";
    public static String informaQtde = "Informe a quantidade, campo obrigatório.";
    public static String qtdeValida = "Informe uma quantidade válida!";
    public static String informeFormaPgto = "Escolha uma forma de pagamento!";
    public static String informaQtdeValida = "Informe uma quantidade válida!";

    // CADASTRO
    public static String informaCpf = "Informe o CPF, campo obrigatório.";
    public static String informaCpfValido = "Informe um CPF válido.";
    public static String informaRg = "Informe o RG, campo obrigatório.";
    public static String informaRgValido = "Informe um RG válido.";
    public static String informaNome = "Informe o nome, campo obrigatório.";
    public static String informaNomeValido = "Informe um nome válido!";
    public static String informaDataNascimento = "Informe a data de nascimento, campo obrigatório.";
    public static String informaCnpj = "Informe o CNPJ, campo obrigatório.";
    public static String informaCnpjValido = "Informe um CNPJ válido.";
//    public static String informaIe = "Informe o IE, campo obrigatório.";
    public static String informaIeValido = "Informe um IE válido.";
    public static String informaRazaoSocial = "Informe a razão social, campo obrigatório.";
    public static String informaDataFundacao = "Informe a data de fundação, campo obrigatório.";
    public static String informaTipoPessoa = "Informe se a pessoa é Jurídica ou Física, campo obrigatório.";
    public static String informaEndereco = "Informe um endereço, campo obrigatório.";
    public static String informaNumero = "Informe o número de seu endereço, campo obrigatório.";
    public static String informaNumeroValido = "Informe um número válido de seu endereço";
    public static String informaBairro = "Informe o bairro, campo obrigatório.";
    public static String informaCidade = "Informe a Cidade, campo obrigatório.";
    public static String informaCep = "Informe o CEP, campo obrigatório.";
    public static String informaEstado = "Informe o Estado, campo obrigatório.";
    public static String informaTelefone = "Informe o telefone, campo obrigatório.";
    public static String informaCelular = "Informe o celular, campo obrigatório.";
    public static String informaEmail = "Informe o E-mail, campo obrigatório.";
    public static String informaLogin = "Informe o Login, campo obrigatório.";
    public static String loginInvalido = "Login inválido!";
    public static String informaSenha = "Informe a Senha, campo obrigatório.";
    public static String senhaInvalida = "Senha inválida!";
    public static String informaDataValida = "Informe uma data válida.";
    public static String informaEmailValido = "Informe um e-mail válido.";
    public static String informaContato = "Informe o Contato, campo obrigatório.";
    public static String informaDescricao = "Informe a descrição, campo obrigatório.";
    public static String informaFornecedor = "Informe o Fornecedor, campo obrigatório.";
    public static String informaValorCusto = "Informe o valor de custo, campo obrigatório.";
    public static String informaValorCustoCorreto = "Valor de custo inválido, digite um valor válido e maior que 0";
    public static String informaValorVenda = "Informe o valor de venda, campo obrigatório.";
    public static String informaValorVendaCorreto = "Valor de venda inválido, digite um valor válido e maior que 0";
    public static String mensagemErroExcel = "Nenhum produto está em falta";
    
    // EXCLUIR
    public static String confirmaExcluir = "Confirma em excluir este registro?";
    public static String confirmaRecebimento = "Confirma que recebeu pagamento deste registro?";
    public static String confirmaPagamento = "Confirma que efetuou o pagamento deste registro?";
    public static String atencao = "Atenção";

    //COMBOS
    public static String comboCidade = "- Escolha Cidade -";
    public static String comboEstado = "- Escolha UF -";
    public static String comboFornecedor = "- Selecione um Fornecedor -";
    public static String comboProduto = "- Selecione um Produto -";
    public static String comboFuncionario = "- Selecione um Funcionário -";
    public static String comboCliente = "- Selecione um Cliente -";
    public static String comboFormaPgto = "- Selecione uma forma de pagamento -";
    public static String selecionaFormaPgto = "É necessário selecionar uma forma de pagamento!";

    // TIPO PESSOA
    public static String pessoaFisica = "F";
    public static String pessoaJuridica = "J";

    // MÁSCARAS
    public static String mascaraCelular = "(  )      -    ";
    public static String mascaraTelefone = "(  )     -    ";
    public static String mascaraCpf = "###.###.###-##";
    public static String cpf = "CPF:";
    public static String cpfZero = "000.000.000-00";
    public static String mascaraIe = "###.###.###.###";
    public static String mascaraIeSalva = "   .   .   .   ";
    public static String ie = "IE:";
    public static String ieZero = "000.000.000:";
    public static String mascaraRg = "##.###.###";
    public static String rg = "RG:";
    public static String rgZero = "00.000.000";
    public static String nome = "Nome:";
    public static String dataNascimento = "Data nascimento:";
    public static String dataFundacao = "Data fundação";
    public static String formatoData = "dd/MM/yyyy";
    public static String razaoSocial = "Razão social:";
    public static String cnpj = "CNPJ:";
    public static String mascaraCnpj = "##.###.###/####-##";
    public static String cnpjZero = "00.000.000/0000-00";
    public static String decimalFormat = "#,##0.00";
    public static String virgula = ",";
    public static String ponto = ".";
    public static String espaco = " ";
    public static String doisPontos = ":";

    // SISTEMA
    public static String sairSistema = "Encerrar Sistema?";

    // OUTROS
    public static String real = "R$";
    public static String validaEmail = "^[\\w\\.-]+@([\\w\\-]+\\.)+[A-Z]{2,4}$";
    public static String validaNome = "[a-zA-ZÁ-Ùá-ù ]+";
    public static String vazio = "";
    public static String nao = "Não";
    public static String sim = "Sim";
    public static String alterar = "ALTERAR";
    public static String salvar = "SALVAR";
    public static String excluir = "EXCLUIR";
    public static String sairDoSistema = "SAIR SISTEMA";
    public static String logout = "LOGOUT";
    public static String sobre = "SOBRE";
    public static String contasPagar = "contas_pagar";
    public static String contasReceber = "contas_receber";
    public static String cliente = "cliente";
    public static String compra = "compra";
    public static String estoque = "estoque";
    public static String fornecedor = "fornecedor";
    public static String produto = "produto";
    public static String venda = "venda";
    public static String dinheiro = "Dinheiro";
    public static String debito = "Débito";
    public static String credito = "Crédito";
    public static String cheque = "Cheque";
    public static String hifen = "-";
    public static String qtdeCadastradaInvalida = "Quantidade mínima cadastrada não pode ser maior que quantidade em estoque";

    // Produto combo
    public static String comboProdutoFornecedor = "- Selecione um produto/fornecedor -";
    public static String inserirEstoque = "Produto inserido em estoque com sucesso";
    public static String erroInserirEstoque = "Erro ao inserir Produto no estoque!";
    public static String alterarEstoque = "Estoque alterado com sucesso!";
    public static String erroAlterarEstoque = "Erro ao alterar Estoque!";
    public static String exclusaoEstoque = "Produto excluído do estoque com sucesso";
    public static String informeQtdeMin = "Informe a Quantidade Mínima corretamente!";
    public static String informeQtdeEstoque = "Informe a Quantidade em Estoque corretamente!";
    public static String erroComboProduto = "É necessário selecionar um produto-fornecedor";

    public static String erroIncluirFormaPgto = "É necessário excluir uma forma de pagamento para adicionar uma nova!";
    public static String informaDescontoValido = "Desconto inválido, informe um valor válido";

    public static String produtoSemEstoque(String produto, int quantidade) {
        return produto + " sem estoque!\n" + "A quantidade disponível deste produto é de: " + quantidade;

    }
    public static String adicioneProduto = "É necessário selecionar ao menos um produto!";
    public static String inserirCompra = "Compra efetuada com sucesso!";
    public static String erroInserirCompra = "Erro ao efetuar compra, tente novamente!";
    public static String vendaSucesso = "Compra realizada com sucesso!";
    public static String descontoMaior = "O desconto não pode ser maior que o valor do produto";

    public static String selecionaPagamento = "É necessário selecionar uma conta";
    public static String confirmadoPagamento = "Pagamento confirmado";
    public static String confirmadoRecebimento = "Recebimento confirmado";
    public static String contasReceberPago = "Registro salvo com sucesso!";
    
    //Excel
    public static String excelGeradoComSucesso = "Arquivo criado com sucesso!";
    public static String excelFileNotFound = "File Not Found!";
    public static String excelFileNotCreated="File Create Error!";
}
