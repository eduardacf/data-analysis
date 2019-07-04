package com.dudacf26.core.temaFinal.service;


import com.dudacf26.core.temaFinal.builder.AnaliseDeDadosBuilderPattern;
import com.dudacf26.core.temaFinal.domain.DadosArquivo;
import com.dudacf26.core.temaFinal.domain.Results;
import com.dudacf26.core.temaFinal.domain.Vendedor;
import org.springframework.stereotype.Service;
import java.util.List;

@Service
public class AnaliseDados {
    public Results analisar (List<DadosArquivo> arquivo) {
        int totalCliente = getQuantidadeDeClientes(arquivo);
        int totalVendedores = getQuantidadeDeVendedor(arquivo);
        int idVendaMaisCara = getIdVendaMaisCara(arquivo);
        Vendedor vendedorComMenosVendas = getVendedorComMenosVendas(arquivo);

        Results analiseDados = AnaliseDeDadosBuilderPattern.builder().totalClientes(totalCliente)
                .totalVendedores(totalVendedores).idVendaMaisCara(idVendaMaisCara)
                .vendedorComMenosVendas(vendedorComMenosVendas).listar();

        return analiseDados;
    }

    /* Aqui vária os metodos necessários*/
}
