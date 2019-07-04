package com.dudacf26.core.temaFinal.controller;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.PrintWriter;
import java.io.UnsupportedEncodingException;
import java.util.logging.Logger;

import com.dudacf26.core.temaFinal.domain.Results;

public class Writer {
	private Results results;

	public Writer(Results results) {
		this.results = results;
	}

	public void saveResults() throws UnsupportedEncodingException {
		PrintWriter writer;
		try {
			File currentDirFile = new File(".");
			String path = currentDirFile.getAbsolutePath();
			writer = new PrintWriter(path + "\\data\\out\\done.dat", "UTF-8");
			writer.println("Clientes: " + results.getQuantidadeDeClientes());
			writer.println("Vendedores: " + results.getQuantidadeDeVendedor());
			writer.println("Id da Venda mais cara: " + results.getIdVendaMaisCara());
			writer.println("Pior Vendedor: " + results.getPiorVendedor());
			writer.close();
		} catch (FileNotFoundException ex) {
			System.out.println("Erro!");
		}
	}
}
