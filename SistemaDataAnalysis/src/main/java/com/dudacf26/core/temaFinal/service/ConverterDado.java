package com.dudacf26.core.temaFinal.service;


import com.dudacf26.core.temaFinal.domain.DadosArquivo;

public abstract class ConverterDado {
    protected static final String SEPARADOR_DADOS = "\\?";

    public abstract DadosArquivo conversor(String data);
}
