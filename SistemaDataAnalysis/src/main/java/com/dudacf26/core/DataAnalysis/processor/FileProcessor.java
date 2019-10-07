package com.dudacf26.core.DataAnalysis.processor;

import com.dudacf26.core.DataAnalysis.builder.BuilderProcessor;
import com.dudacf26.core.DataAnalysis.domain.Client;
import com.dudacf26.core.DataAnalysis.domain.AmountDice;
import com.dudacf26.core.DataAnalysis.domain.Sale;
import com.dudacf26.core.DataAnalysis.domain.Seller;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class FileProcessor implements Processor {

    private static final String SEPARADOR = "ç";

    @Autowired
    private Client client;

    @Autowired
    private Seller seller;

    @Autowired
    private Sale sale;

    @Autowired
    private BuilderProcessor builderProcessor;

    private static final Logger LOG = LoggerFactory.getLogger(FileProcessor.class);

    @Override
    public void process(Exchange exchange) {
        InputStream is = null;
        String line = null;
        BufferedReader reading = null;

        List<Seller> sellers = new ArrayList<>();
        List<Client> clients = new ArrayList<>();
        List<Sale> sales = new ArrayList<>();

        try {
            is = (InputStream) exchange.getIn().getBody();
            reading = new BufferedReader(new InputStreamReader(is));

            while ((line = reading.readLine()) != null) {
                List<String> code = Arrays.asList(line.split(SEPARADOR));
                checkCodeType(line, sellers, clients, sales, code);
            }

            buildQuantities(exchange, sellers, clients, sales);

        } catch (IOException e) {
            LOG.error("Error: \n", e);
        }

    }

    private void checkCodeType(String linha, List<Seller> sellers, List<Client> clients, List<Sale> sales, List<String> code) {
        if (code != null && code.size() == 4 && StringUtils.isNotBlank(code.get(0))) {
            if (code.get(0).equals(seller.TYPE)) {
                sellers.add(builderProcessor.sellerBuilder(code));
            } else if (code.get(0).equals(client.TYPE)) {
                clients.add(builderProcessor.clientBuilder(code));
            } else if (code.get(0).equals(sale.TYPE)) {
                sales.add(builderProcessor.saleBuilder(code));
            }
        } else {
            LOG.error("Error parsing line\n", linha);

        }
    }

    private void buildQuantities(Exchange exchange, List<Seller> sellers, List<Client> clients, List<Sale> sales) {
        AmountDice amount = AmountDice.builder()
                .sellers(sellers)
                .clients(clients)
                .sales(sales).build();
        exchange.getIn().setBody(amount);
    }
}


