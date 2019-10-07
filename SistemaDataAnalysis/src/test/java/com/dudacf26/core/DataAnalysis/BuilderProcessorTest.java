package com.dudacf26.core.DataAnalysis;

import com.dudacf26.core.DataAnalysis.builder.BuilderProcessor;
import com.dudacf26.core.DataAnalysis.domain.Client;
import com.dudacf26.core.DataAnalysis.domain.Sale;
import com.dudacf26.core.DataAnalysis.domain.Seller;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.Arrays;
import java.util.List;

import static org.junit.Assert.assertEquals;

public class BuilderProcessorTest {

    @Autowired
    private BuilderProcessor builderProcessor;

    private static final String SEPARADOR = "ç";

    private List<String> checkCode(String line) {
        return Arrays.asList(line.split(SEPARADOR));
    }

    @Test
    public void clientBuilderTest(){
        String line = "002ç2345675433444345çEduardoPereiraçRural";
        Client client = builderProcessor.clientBuilder(checkCode(line));

        assertEquals(client.getCpnj(), "2345675433444345");
        assertEquals(client.getName(), "EduardoPereira");
        assertEquals(client.getBusinessArea(), "Rural");
    }

    @Test
    public void sellerBuilderTest(){
        String line = "001ç1234567891234çDudaç50000";
        Seller seller = builderProcessor.sellerBuilder(checkCode(line));

        assertEquals(seller.getCpf(), "1234567891234");
        assertEquals(seller.getName(), "Duda");
        assertEquals(seller.getSalary(), Double.valueOf("50000"));
    }

    @Test
    public void saleBuilderTest(){
        String line = "003ç08ç[1-10-100,2-30-2.50,3-40-3.10]çRenato";
        Sale sale = builderProcessor.saleBuilder(checkCode(line));

        assertEquals(sale.getIdSale(), "08");
        assertEquals(sale.getNameSeller(), "Renato");
        assertEquals(sale.getTotalSale(), Double.valueOf("105.6"));
    }

}
