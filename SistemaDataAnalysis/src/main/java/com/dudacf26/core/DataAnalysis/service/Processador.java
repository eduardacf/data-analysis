package com.dudacf26.core.DataAnalysis.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;

@Component
public class Processador {

    @Autowired
    private ProcessadorService processadorService;

    @Scheduled(initialDelayString = "${app.job.interval}", fixedRateString = "#{${app.job.interval} * 1000}")
    public void executar(){
        try {
            System.out.println("Procurando arquivos .dat para comparação :_");
            this.processadorService.processarArquivosAguardandoProcessamento();
        }
        catch (Exception e){
            System.out.println("Erro" + e.getMessage());
        }
    }
}
