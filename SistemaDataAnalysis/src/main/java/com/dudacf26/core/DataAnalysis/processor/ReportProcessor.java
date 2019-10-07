package com.dudacf26.core.DataAnalysis.processor;

import com.dudacf26.core.DataAnalysis.domain.AmountDice;
import com.dudacf26.core.DataAnalysis.domain.Result;
import com.dudacf26.core.DataAnalysis.domain.Sale;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.util.Comparator;

public class ReportProcessor implements Processor {

    private static final Logger LOG = LoggerFactory.getLogger(ReportProcessor.class);

    @Override
    public void process(Exchange exchange) {

        if (exchange.getIn().getBody() != null && exchange.getIn().getBody() instanceof AmountDice) {

            AmountDice result = (AmountDice) exchange.getIn().getBody();
            Sale saleMoreExpensive = calculateMoreExpensive(result);
            Sale saleCheapest = calculateSaleCheapest(result);

            Result report = new Result();
            report.setAmountClients(result.getClients().size());
            report.setAmountSellers(result.getSellers().size());
            report.setMostExpensiveSale(saleMoreExpensive != null ? saleMoreExpensive.getIdSale() : null);
            report.setWorstSeller(saleCheapest != null ? saleCheapest.getNameSeller() : null);

            exchange.getIn().setBody(report);
        } else {
            String message = "Error to create report - Report empty";
            LOG.error(message);
            exchange.getIn().setBody(message);
        }
    }

    private Sale calculateSaleCheapest(AmountDice result) {
        Sale saleCheapest = result.getSales().stream()
                .min(Comparator.comparing(Sale::getTotalSale)).orElse(null);
        return saleCheapest;
    }

    private Sale calculateMoreExpensive(AmountDice result) {
        Sale saleMoreExpensive = result.getSales().stream()
                .max(Comparator.comparing(Sale::getTotalSale)).orElse(null);
        return saleMoreExpensive;
    }
}
