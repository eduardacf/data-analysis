package com.dudacf26.core.temaFinal.domain;

public class Vendedor extends DadosArquivo {

	private int id;
	private String nome;
	private String cpf;
	private Float salario;

	public Vendedor() {
	}

	public Vendedor(String nome, String cpf, Float salario) {
		this.nome = nome;
		this.cpf = cpf;
		this.salario = salario;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public double getSalario() {
		return salario;
	}

	public void setSalario(Float salario) {
		this.salario = salario;
	}

	@Override
	public String toString() {
		return "Dados vendedor:" + "\nID:" + id + "\nNome:" + nome + "\nCPF:" + cpf + "\nSalario:" + salario + "";
	}

}
