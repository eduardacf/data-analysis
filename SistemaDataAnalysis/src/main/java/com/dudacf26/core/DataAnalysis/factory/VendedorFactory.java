package com.dudacf26.core.DataAnalysis.factory;

import com.dudacf26.core.DataAnalysis.domain.Vendedor;
import org.springframework.stereotype.Component;

@Component
public class VendedorFactory {

    private static final int COLUNA_CPF = 1;
    private static final int COLUNA_NOME = 2;
    private static final int COLUNA_SALARIO = 3;

    public Vendedor adicionarNoNovoArquivo(String[] linhaArquivo){
        String cpf = linhaArquivo[COLUNA_CPF];
        String nome =  linhaArquivo[COLUNA_NOME];
        Double salario = Double.parseDouble(linhaArquivo[COLUNA_SALARIO]);

        return new Vendedor(nome,cpf, salario);
    }
}
