package com.dudacf26.core.DataAnalysis.domain;

import java.util.*;
import java.util.stream.Collectors;
import static java.util.Comparator.*;

public class Arquivo {

    public Arquivo() {
        this.clientes = new ArrayList<>();
        this.vendas = new ArrayList<>();
        this.vendedores = new ArrayList<>();
    }

    private List<Cliente> clientes;
    private List<Venda> vendas;
    private List<Vendedor> vendedores;

    public void adicionarCliente(Cliente cliente) {
        this.clientes.add(cliente);
    }

    public void adicionarVenda(Venda venda) {
        this.vendas.add(venda);
    }

    public void adicionarVendedor(Vendedor vendedor) {
        this.vendedores.add(vendedor);
    }

    private Boolean temVendas() {
        return this.vendas != null && this.vendas.size() > 0;
    }

    private Boolean temVendedores() {
        return this.vendedores != null && this.vendedores.size() > 0;
    }

    private Boolean temClientes() {
        return this.clientes != null && this.clientes.size() > 0;
    }

    public int verificarQuantosClientesExistem() {
        if (!this.temClientes()) {
            return 0;
        }
        Map<String, Long> clientesDistintos = clientes.stream()
                .collect(Collectors.groupingBy(p -> ((Cliente) p).getCpnj(), Collectors.counting()));
        return clientesDistintos.size();
    }

    public int verificarQuantosVendedoresExistem() {
        if (!this.temVendedores()) {
            return 0;
        }
        Map<String, Long> vendedoresDistintos = vendedores.stream()
                .collect(Collectors.groupingBy(p -> ((Vendedor) p).getCpf(), Collectors.counting()));

        return vendedoresDistintos.size();
    }

    public int verificarVendaMaisCara() {
        if (!this.temVendas()) {
            return 0;
        }
        Venda vendaMaisCara = vendas.stream()
                .max(comparingDouble(p -> p.verificarValorTotalDaVenda()))
                .get();
        return vendaMaisCara.getIdVenda();
    }

    public Vendedor verificarPiorVendedor() {
        if (!this.temVendedores()) {
            return null;
        }

        if (!this.temVendas()) {
            return this.vendedores.stream().findFirst().get();
        }

        Vendedor vendedorSemVenda = this.verificarVendedorSemVenda();

        if (vendedorSemVenda != null) {
            return vendedorSemVenda;
        }

        Venda vendaMaisBarata = vendas.stream()
                .min(comparingDouble(p -> p.verificarValorTotalDaVenda()))
                .get();

        Vendedor piorVendedor = this.vendedores.stream()
                .filter(x -> x.getNome() == vendaMaisBarata.getNomeVendedor())
                .findFirst()
                .get();

        return piorVendedor;
    }

    public List<String> relatorio() {
        List<String> result = new ArrayList<>();

        int quantidadeClientes = this.verificarQuantosClientesExistem();
        int quantidadeVendedores = this.verificarQuantosVendedoresExistem();
        int vendaMaisCaraId = this.verificarVendaMaisCara();

        result.add("Quantidade de clientes no arquivo de entrada: " + quantidadeClientes);
        result.add("Quantidade de vendedores no arquivo de entrada: " + quantidadeVendedores);
        result.add("ID da venda mais cara: " + vendaMaisCaraId);

        Vendedor piorVendedor = this.verificarPiorVendedor();

        if (piorVendedor != null) {
            result.add("O pior vendedor é: " + piorVendedor.getNome());
        }


        return result;
    }

    private Vendedor verificarVendedorSemVenda() {
        Set<String> nomeVendedoresComVenda = this.vendas.stream()
                .map(Venda::getNomeVendedor)
                .collect(Collectors.toSet());

        List<Vendedor> vendedoresSemVenda = this.vendedores.stream()
                .filter(vendedor -> !nomeVendedoresComVenda.contains(vendedor.getNome()))
                .collect(Collectors.toList());

        if (vendedoresSemVenda == null || vendedoresSemVenda.size() == 0) {
            return null;
        }

        return vendedoresSemVenda.stream().findFirst().get();
    }
}


