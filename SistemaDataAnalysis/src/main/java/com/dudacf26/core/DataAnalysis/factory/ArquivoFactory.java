package com.dudacf26.core.DataAnalysis.factory;

import com.dudacf26.core.DataAnalysis.domain.Arquivo;
import com.dudacf26.core.DataAnalysis.domain.Cliente;
import com.dudacf26.core.DataAnalysis.domain.Vendedor;
import com.dudacf26.core.DataAnalysis.domain.Venda;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.List;

@Component
public class ArquivoFactory {
    @Autowired
    private ClienteFactory clienteFactory;

    @Autowired
    private VendedorFactory vendedorFactory;

    @Autowired
    private VendaFactory vendaFactory;

    public Arquivo adicionarNoNovoArquivo(List<String[]> arquivo) {
        if (arquivo == null || arquivo.size() == 0) {
            return null;
        }
        Arquivo result = new Arquivo();
        for (int i = 0; i < arquivo.size(); i++) {
            String[] linhaArquivo = arquivo.get(i);
            String type = linhaArquivo[0];
            if (type.equals(Cliente.TYPE)) {
                Cliente cliente = this.clienteFactory.adicionarNoNovoArquivo(linhaArquivo);
                result.adicionarCliente(cliente);
            }
            if (type.equals(Vendedor.TYPE)) {
                Vendedor vendedor = this.vendedorFactory.adicionarNoNovoArquivo(linhaArquivo);
                result.adicionarVendedor(vendedor);
            }
            if (type.equals(Venda.TYPE)) {
                Venda venda = this.vendaFactory.adicionarNoNovoArquivo(linhaArquivo);
                result.adicionarVenda(venda);
            }
        }

        return result;
    }
}
