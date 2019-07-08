package com.dudacf26.core.DataAnalysis.factory;

import com.dudacf26.core.DataAnalysis.domain.Cliente;
import org.springframework.stereotype.Component;

@Component
public class ClienteFactory {
    private static final int COLUNA_CNPJ = 1;
    private static final int COLUNA_NOME = 2;
    private static final int COLUNA_AREA_ATUACAO = 3;

    public Cliente adicionarNoNovoArquivo(String[] linhaArquivo){
        String cnpj = linhaArquivo[COLUNA_CNPJ];
        String nome = linhaArquivo[COLUNA_NOME];
        String areaAtuacao = linhaArquivo[COLUNA_AREA_ATUACAO];
        return new Cliente(cnpj, nome, areaAtuacao);
    }
}
