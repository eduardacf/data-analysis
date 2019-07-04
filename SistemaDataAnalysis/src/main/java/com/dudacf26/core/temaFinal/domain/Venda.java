package com.dudacf26.core.temaFinal.domain;

import java.util.List;

public class Venda extends DadosArquivo {

	private int idVenda;
	private List<Item> listaDeItens;
	private String NomeVendedor;

	public Venda() {
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

}
