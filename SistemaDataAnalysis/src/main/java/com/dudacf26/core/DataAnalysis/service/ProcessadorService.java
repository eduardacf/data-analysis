package com.dudacf26.core.DataAnalysis.service;

import com.dudacf26.core.DataAnalysis.domain.Arquivo;
import com.dudacf26.core.DataAnalysis.factory.ArquivoFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProcessadorService {
    @Autowired
    private DiretorioService diretorioService;

    @Autowired
    private ArquivoFactory arquivoFactory;

    private String separador = "ç";

    public void processarArquivosAguardandoProcessamento() {
        List<File> arquivos = this.diretorioService.verificarArquivosAguardandoProcessamento();
        arquivos.parallelStream().forEach(file -> {
            try {
                processarArquivo(file);
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }

    private void processarArquivo(File file) throws IOException {
        List<String[]> arquivo = this.converterArquivo(file);
        Arquivo arquivoDominio = this.arquivoFactory.adicionarNoNovoArquivo(arquivo);
        List<String> relatorio = arquivoDominio.relatorio();
        this.diretorioService.processarArquivoSaida(relatorio, file.getName());
        this.excluirArquivo(file);
    }

    private List<String[]> converterArquivo(File file) throws IOException {
        String nomeArquivo = file.getName();
        String caminhoArquivo = file.getPath().replace(nomeArquivo, "");
        Path path = Paths.get(caminhoArquivo, nomeArquivo);
        List<String[]> result = Files.lines(path)
                .filter(p -> p != null)
                .map(p -> p.split(this.separador))
                .collect(Collectors.toList());
        return result;
    }

    private void excluirArquivo(File file) {
        file.delete();
    }
}
