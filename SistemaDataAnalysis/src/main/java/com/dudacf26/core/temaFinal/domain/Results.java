package com.dudacf26.core.temaFinal.domain;

public class Results {

	private int QuantidadeDeClientes;
	private int QuantidadeDeVendedor;
	private int idVendaMaisCara;
	private Vendedor piorVendedor;


	public int getQuantidadeDeClientes() {
		return QuantidadeDeClientes;
	}

	public void setQuantidadeDeClientes(int quantidadeDeClientes) {
		QuantidadeDeClientes = quantidadeDeClientes;
	}

	public int getQuantidadeDeVendedor() {
		return QuantidadeDeVendedor;
	}

	public void setQuantidadeDeVendedor(int quantidadeDeVendedor) {
		QuantidadeDeVendedor = quantidadeDeVendedor;
	}

	public int getIdVendaMaisCara() {
		return idVendaMaisCara;
	}

	public void setIdVendaMaisCara(int idVendaMaisCara) {
		this.idVendaMaisCara = idVendaMaisCara;
	}

	public Vendedor getPiorVendedor() {
		return piorVendedor;
	}

	public void setPiorVendedor(Vendedor piorVendedor) {
		this.piorVendedor = piorVendedor;
	}

	@Override
	public String toString() {
		return "-------RELATÓRIO-------" + "\nQuantidade de clientes no arquivo de entrada: " + QuantidadeDeClientes
				+ "\nQuantidade de vendedores no arquivo de entrada:" + QuantidadeDeVendedor
				+ "\nID da venda mais cara: " + idVendaMaisCara + "\nO pior vendedor foi:" + piorVendedor + "";
	}

}
