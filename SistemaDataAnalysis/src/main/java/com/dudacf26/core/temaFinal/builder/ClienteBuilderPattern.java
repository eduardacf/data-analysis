package com.dudacf26.core.temaFinal.builder;

import com.dudacf26.core.temaFinal.domain.Cliente;

public class ClienteBuilderPattern {

    private Cliente cliente;

    public ClienteBuilderPattern() {
        this.cliente = new Cliente();
    }

    public static ClienteBuilderPattern builder() {
        return new ClienteBuilderPattern();
    }

    public ClienteBuilderPattern cnpj(String cnpj) {
        this.cliente.setCpnj(cnpj);
        return this;
    }

    public ClienteBuilderPattern nome(String nome) {
        this.cliente.setNome(nome);
        return this;
    }

    public ClienteBuilderPattern areaNegocio(String areaNegocio) {
        this.cliente.setAreaNegocio(areaNegocio);
        return this;
    }

    public Cliente listar() {
        return this.cliente;
    }


}
