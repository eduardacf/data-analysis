package com.dudacf26.core.temaFinal.config;

import com.dudacf26.core.temaFinal.service.AnaliseDados;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class DataConfig {

    @Autowired
    private AnaliseDados analiseDadosService;

    /*Aqui viria os metodos de processamento, criação de diretorio e remoção do arquivo do outro diretorio*/
}
