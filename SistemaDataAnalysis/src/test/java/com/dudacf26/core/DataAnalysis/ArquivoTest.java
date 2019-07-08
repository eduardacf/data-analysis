package com.dudacf26.core.DataAnalysis;

import com.dudacf26.core.DataAnalysis.domain.*;
import com.dudacf26.core.DataAnalysis.factory.ArquivoFactory;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;
@RunWith(SpringRunner.class)
@SpringBootTest

public class ArquivoTest {
    @Autowired
    private ArquivoFactory arqFactory;

    @Test
    public void verificarArquivosSemNenhumDado() {
        Arquivo arquivo = new Arquivo();
        Vendedor piorVendedor = arquivo.verificarPiorVendedor();
        int quantidadeClientes = arquivo.verificarQuantosClientesExistem();
        int quantidadeVendedores = arquivo.verificarQuantosVendedoresExistem();
        int idVendaMaisCara = arquivo.verificarVendaMaisCara();
        assertNull(piorVendedor);
        assertEquals(quantidadeClientes, 0);
        assertEquals(quantidadeVendedores, 0);

    }
}
