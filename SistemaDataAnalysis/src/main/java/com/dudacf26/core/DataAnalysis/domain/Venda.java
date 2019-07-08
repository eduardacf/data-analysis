package com.dudacf26.core.DataAnalysis.domain;

import java.util.List;

public class Venda {

    public static final String TYPE = "003";
    private int idVenda;
    private List<Item> listaDeItens;
    private String NomeVendedor;

    public Venda(int idVenda, String nomeVendedor) {
        this.idVenda = idVenda;
        NomeVendedor = nomeVendedor;
    }

    public Venda(int idVenda, List<Item> listaDeItens, String nomeVendedor) {
        this.idVenda = idVenda;
        this.listaDeItens = listaDeItens;
        NomeVendedor = nomeVendedor;
    }

    public int getIdVenda() {
        return idVenda;
    }

    public void setIdVenda(int idVenda) {
        this.idVenda = idVenda;
    }

    public List<Item> getListaDeItens() {
        return listaDeItens;
    }

    public void setListaDeItens(List<Item> listaDeItens) {
        this.listaDeItens = listaDeItens;
    }

    public String getNomeVendedor() {
        return NomeVendedor;
    }

    public void setNomeVendedor(String nomeVendedor) {
        NomeVendedor = nomeVendedor;
    }

    @Override
    public String toString() {
        return "Venda:\n ID da venda:" + idVenda + "\nLista De Itens:" + listaDeItens + "\nNome do vendedor da venda:"
                + NomeVendedor + "";
    }

    public double verificarValorTotalDaVenda() {
        if (this.listaDeItens == null || this.listaDeItens.size() == 0) {
            return 0;
        }

        Double result = listaDeItens.stream().mapToDouble(p -> p.valorTotalQuantidade()).sum();

        return result;
    }
}

