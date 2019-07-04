package com.dudacf26.core.temaFinal.builder;

import com.dudacf26.core.temaFinal.domain.Vendedor;

public class VendedorBuilderPattern {

	private Vendedor vendedor;
	
	public VendedorBuilderPattern() {
		this.vendedor = new Vendedor();
	}
	
	public static VendedorBuilderPattern builder() {
	    return new VendedorBuilderPattern();
    }

    public VendedorBuilderPattern nome(String nome) {
        this.vendedor.setNome(nome);
        return this;
    }

	public VendedorBuilderPattern cpf(String cpf) {
        this.vendedor.setCpf(cpf);
        return this;
    }

	public VendedorBuilderPattern salario(Float salario) {
        this.vendedor.setSalario(salario);
        return this;
    }
	
	public Vendedor listar() {
	    return this.vendedor;
    }
	
}
