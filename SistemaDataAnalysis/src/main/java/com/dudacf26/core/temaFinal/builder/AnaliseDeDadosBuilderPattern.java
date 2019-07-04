package com.dudacf26.core.temaFinal.builder;

import com.dudacf26.core.temaFinal.domain.Results;
import com.dudacf26.core.temaFinal.domain.Vendedor;
import com.dudacf26.core.temaFinal.service.AnaliseDados;

public class AnaliseDeDadosBuilderPattern {

	private Results analiseDados;
	
	public AnaliseDeDadosBuilderPattern() {
		this.analiseDados = new Results();
	}
	
	public static AnaliseDeDadosBuilderPattern builder() {
        return new AnaliseDeDadosBuilderPattern();
    }
	
	public AnaliseDeDadosBuilderPattern totalClientes(int totalClientes) {
        this.analiseDados.setQuantidadeDeClientes(totalClientes);
        return this;
    }
	
	public AnaliseDeDadosBuilderPattern totalVendedores(int totalVendedores) {
        this.analiseDados.setQuantidadeDeVendedor(totalVendedores);
        return this;
    }
	
	public AnaliseDeDadosBuilderPattern idVendaMaisCara(int idVendaMaisCara) {
        this.analiseDados.setIdVendaMaisCara(idVendaMaisCara);
        return this;
    }
	
	public AnaliseDeDadosBuilderPattern vendedorComMenosVendas(Vendedor vendedorComMenosVendas) {
        this.analiseDados.setPiorVendedor(vendedorComMenosVendas);
        return this;
    }
	
	public AnaliseDados listar() {
        return this.analiseDados;
    }



}
