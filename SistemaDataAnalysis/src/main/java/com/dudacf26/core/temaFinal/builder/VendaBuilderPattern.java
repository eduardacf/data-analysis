package com.dudacf26.core.temaFinal.builder;

import com.dudacf26.core.temaFinal.domain.Item;
import com.dudacf26.core.temaFinal.domain.Venda;

import java.util.List;

public class VendaBuilderPattern {

    private Venda venda;

    public VendaBuilderPattern() {
        this.venda = new Venda();
    }

    public static VendaBuilderPattern builder() {
        return new VendaBuilderPattern();
    }

    public VendaBuilderPattern idVenda(int idVenda) {
        this.venda.setIdVenda(idVenda);
        return this;
    }

    public VendaBuilderPattern listaItens(List<Item> listaItens) {
        this.venda.setListaDeItens(listaItens);
        return this;
    }

    public VendaBuilderPattern nomeVendedor(String vendedor) {
        this.venda.setNomeVendedor(vendedor);
        return this;
    }

    public Venda listar() {
        return this.venda;
    }


}
