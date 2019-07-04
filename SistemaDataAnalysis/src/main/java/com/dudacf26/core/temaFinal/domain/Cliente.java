package com.dudacf26.core.temaFinal.domain;

public class Cliente extends DadosArquivo {
	private String cpnj;
	private String nome;
	private String areaNegocio;

	public Cliente() {
	}

	public Cliente(String cpnj, String nome, String areaNegocio) {
		super();
		this.cpnj = cpnj;
		this.nome = nome;
		this.areaNegocio = areaNegocio;
	}

	public String getCpnj() {
		return cpnj;
	}

	public void setCpnj(String cpnj) {
		this.cpnj = cpnj;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAreaNegocio() {
		return areaNegocio;
	}

	public void setAreaNegocio(String areaNegocio) {
		this.areaNegocio = areaNegocio;
	}

	@Override
	public String toString() {
		return "Dados Cliente:\n" + "\nCNPJ:" + cpnj + "\nNome:" + nome + "\nArea de Negocio:" + areaNegocio + "";
	}

}
