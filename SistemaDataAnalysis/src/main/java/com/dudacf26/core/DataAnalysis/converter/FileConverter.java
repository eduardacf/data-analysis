package com.dudacf26.core.DataAnalysis.converter;

import com.dudacf26.core.DataAnalysis.domain.Result;
import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;

@Component
public class FileConverter implements Converter<Result, String> {

    @Override
    public String convert(Result result) {
        StringBuilder builder = new StringBuilder();
        if (result != null) {
            builder.append("### Relatório ###");
            builder.append("\n");
            builder.append("Quantidade de clientes no arquivo de entrada: ");
            builder.append(result.getAmountClients());
            builder.append("\n");
            builder.append("Quantidade de vendedores no arquivo de entrada: ");
            builder.append(result.getAmountSellers());
            builder.append("\n");
            builder.append("ID da venda mais cara: ");
            builder.append(result.getMostExpensiveSale());
            builder.append("\n");
            builder.append("Pior vendedor: ");
            builder.append(result.getWorstSeller());
            builder.append("\n");
            return builder.toString();
        }
        return "Empty report\n";
    }

}

