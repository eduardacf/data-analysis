package com.dudacf26.core.DataAnalysis.processor;

import com.dudacf26.core.DataAnalysis.builder.BuilderProcessor;
import com.dudacf26.core.DataAnalysis.domain.Client;
import com.dudacf26.core.DataAnalysis.domain.AmountDice;
import com.dudacf26.core.DataAnalysis.domain.Sale;
import com.dudacf26.core.DataAnalysis.domain.Seller;
import com.dudacf26.core.DataAnalysis.exception.FileError;
import com.dudacf26.core.DataAnalysis.exception.LineError;
import lombok.extern.slf4j.Slf4j;
import org.apache.camel.Exchange;
import org.apache.camel.Processor;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

@Slf4j
public class FileProcessor implements Processor {

    public static final int CODE_SIZE = 4;
    public static final int CODE_POSITION = 0;

    @Autowired
    private Client client;

    @Autowired
    private Seller seller;

    @Autowired
    private Sale sale;

    @Autowired
    private BuilderProcessor builderProcessor;

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

                String SEPARATOR = String.valueOf(line.charAt(3));

                List<String> code = Arrays.asList(line.split(SEPARATOR));
                checkCodeType(line, sellers, clients, sales, code);
            }

            buildQuantities(exchange, sellers, clients, sales);

        } catch (IOException e) {
            log.error("Error: \n", e);
            throw new FileError("\nFile Error\n");
        }

    }

    private void checkCodeType(String linha, List<Seller> sellers, List<Client> clients, List<Sale> sales, List<String> code) {
        if (code != null && code.size() == CODE_SIZE && StringUtils.isNotBlank(code.get(CODE_POSITION))) {
            if (code.get(CODE_POSITION).equals(seller.TYPE)) {
                sellers.add(builderProcessor.sellerBuilder(code));
            } else if (code.get(CODE_POSITION).equals(client.TYPE)) {
                clients.add(builderProcessor.clientBuilder(code));
            } else if (code.get(CODE_POSITION).equals(sale.TYPE)) {
                sales.add(builderProcessor.saleBuilder(code));
            }

        } else {
            log.error("Error parsing line\n", linha);
            throw new LineError("\nAn error occurred parsing a file line\n");

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


