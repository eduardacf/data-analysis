package com.dudacf26.core.DataAnalysis.factory;

import com.dudacf26.core.DataAnalysis.domain.Item;
import com.dudacf26.core.DataAnalysis.domain.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class VendaFactory {
    private static final int COLUNA_ITENS = 2;
    private static final int COLUNA_CODIGO = 1;
    private static final int COLUNA_VENDEDOR = 3;

    @Autowired
    private ItemFactory itemFactory;

    public Venda adicionarNoNovoArquivo(String[] linhaArquivo){
        List<Item> itens = this.itemFactory.criarItens(linhaArquivo[COLUNA_ITENS]);

        Integer codigo = Integer.parseInt(linhaArquivo[COLUNA_CODIGO]);
        String vendedor = linhaArquivo[COLUNA_VENDEDOR];

        return new Venda(codigo, itens, vendedor);
    }
}
