package com.dudacf26.core.DataAnalysis;

import com.dudacf26.core.DataAnalysis.service.DiretorioService;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

@RunWith(SpringRunner.class)
@SpringBootTest
public class DiretorioServiceTest {

    @Autowired
    private DiretorioService dirService;

    @Test
    public void verificarSeDiretorioEntradaExiste() {
        String path_entrada = this.dirService.getPath_entrada();
        Assert.assertNotNull(path_entrada);
        Assert.assertTrue(this.dirService.verificarSeCaminhoExiste(new File(path_entrada)));
    }


    @Test
    public void verificaSeValidaUmDiretorioQueNaoExiste() {
        Boolean result = this.dirService.verificarSeCaminhoExiste(new File("o:/testandoaqui"));
        Assert.assertFalse(result);
    }

    @Test
    public void verificaSeValidaUmDiretorioQueExiste() {
        Boolean result = this.dirService.verificarSeCaminhoExiste(new File("c:/bin"));
        Assert.assertTrue(result);
    }

    private void verificaSeCriaDiretorio(String rep, String arquivo, String Extensao) throws IOException {
        FileWriter arq = new FileWriter(rep + "/" + arquivo + Extensao);
        arq.close();
    }
}