/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.foursys.vendas.controller;

import br.com.foursys.vendas.model.Estoque;
import br.com.foursys.vendas.util.Mensagem;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.time.Clock;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.JOptionPane;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;

/**
 *
 * @author mpoda
 */
public class ProdutosEmFaltaController {

    Estoque estoque = new Estoque();
    EstoqueController controllerEstoque = new EstoqueController();
    List<Estoque> listaEstoque = new ArrayList<Estoque>();
    public static final String fileName = "C:/Teste/relatorioProdutosEmFalta.xls";

    public  void gerarExcel() {
        HSSFWorkbook workbook = new HSSFWorkbook();

        HSSFSheet sheetProdutos = workbook.createSheet("Produtos");
        int rownum = 0;
        Row row = sheetProdutos.createRow(0);
        Row row1 = sheetProdutos.createRow(0);
        
        row1.createCell(0).setCellValue("Descrição");

        row1.createCell(1).setCellValue("Fornecedor");

        row1.createCell(2).setCellValue("Qtd mín");

        row1.createCell(3).setCellValue("Contato");
        
        rownum = 2;
        
        try {
            listaEstoque = controllerEstoque.buscarEstoques();
        } catch (Exception ex) {
            Logger.getLogger(ProdutosEmFaltaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        for (Estoque estoque1 : listaEstoque) {
            if (Objects.equals(estoque1.getQuantidadeEstoque(), estoque1.getQuantidadeMinima())) {
                row = sheetProdutos.createRow(rownum++);
                int cellnum = 0;
                Cell cellDescricao = row.createCell(cellnum++);
                cellDescricao.setCellValue(estoque1.getProdutoIdProduto().getDescricao());
                Cell cellFornecedor = row.createCell(cellnum++);
                cellFornecedor.setCellValue(estoque1.getProdutoIdProduto().getFornecedorIdFornecedor().getPessoaJuridicaIdPessoaJuridica().getRazaoSocial());
                Cell cellQtdMinEstoque = row.createCell(cellnum++);
                cellQtdMinEstoque.setCellValue(estoque1.getQuantidadeMinima());
                Cell cellContato = row.createCell(cellnum++);
                cellContato.setCellValue(estoque1.getProdutoIdProduto().getFornecedorIdFornecedor().getContato());

            } else {
                
            }

        }
        try {
            FileOutputStream out = new FileOutputStream(new File(ProdutosEmFaltaController.fileName));
            workbook.write(out);
            out.close();
            JOptionPane.showMessageDialog(null, Mensagem.excelGeradoComSucesso);

        } catch (FileNotFoundException e) {
            JOptionPane.showMessageDialog(null, Mensagem.excelFileNotFound);
            e.printStackTrace();
        } catch (IOException e) {
            JOptionPane.showMessageDialog(null, Mensagem.excelFileNotCreated);
            e.printStackTrace();
        }

    }
    
    public void listandoProdutosEmFalta(){
        try {
            List<Estoque> listaEstoqueFalta = new ArrayList<Estoque>();
            listaEstoque = controllerEstoque.buscarEstoques();
            for (Estoque estoques : listaEstoque) {
                if (estoques.getQuantidadeEstoque() <= estoques.getQuantidadeMinima()) {
                    System.out.println(estoques.getProdutoIdProduto().getDescricao());
                }
            }
            
        } catch (Exception ex) {
            Logger.getLogger(ProdutosEmFaltaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }
    
    public static void main(String[] args) {
        new ProdutosEmFaltaController().listandoProdutosEmFalta();
    }
}
