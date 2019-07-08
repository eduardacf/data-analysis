package com.dudacf26.core.DataAnalysis.service;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
public class DiretorioService {
    @Value("${app.data.directory.in}")
    private String path_entrada;

    @Value("${app.data.directory.out}")
    private String path_saida;

    @Value("${app.data.file.extension.reader}")
    private String extensao_leitura;

    @Value("${app.data.file.extension.write}")
    private String extensao_devolucao;


    public String getExtensao_leitura() {
        return this.extensao_leitura;
    }
    public String getPath_entrada() {
        return this.path_entrada;
    }
    public String getPath_saida() {
        return this.path_saida;
    }

    public Boolean verificarSeCaminhoExiste(final File path) {
        File diretorio = new File(String.valueOf(path));
        return this.verificarSeCaminhoExiste(diretorio);
    }

    public List<File> verificarArquivosAguardandoProcessamento() {
        return this.obterArquivos(this.path_entrada, this.extensao_leitura);
    }

    public void processarArquivoSaida(List<String> dados, String nome) {
        if (!this.verificarSeCaminhoExiste(new File(this.path_saida))) {
            this.criarDiretorio(this.path_entrada);
        }
    }

    public List<File> obterArquivos(final String diretorio, final String arquivoExtensao) {
        File diretorioArquivos = new File(diretorio);

        if (!this.verificarSeDiretorioExiste(diretorioArquivos)) {
            this.criarDiretorio(diretorio);
            return new ArrayList<File>();
        }

        List<File> arquivos = Arrays.stream(diretorioArquivos.listFiles())
                .filter(arquivo -> arquivo.toString().endsWith(arquivoExtensao))
                .collect(Collectors.toList());

        return arquivos;
    }

    private Boolean verificarSeDiretorioExiste(final File diretorio) {
        Boolean result = diretorio.exists();
        if (!result) {
            System.out.println("Diretório não encontrado!");
        }
        return result;
    }

    private Boolean criarDiretorio(final String path) {
        File diretorio = new File(path);
        return this.criarDiretorio(diretorio);
    }

    private Boolean criarDiretorio(final File diretorio) {
        Boolean result = diretorio.mkdirs();
        if (result) {
            System.out.println("Diretório criado com sucesso!");
        } else {
            System.out.println("não é possível criar o diretório");
        }
        return result;
    }
}
