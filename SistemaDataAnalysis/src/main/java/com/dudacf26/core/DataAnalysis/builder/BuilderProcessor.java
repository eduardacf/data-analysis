package com.dudacf26.core.DataAnalysis.builder;

import com.dudacf26.core.DataAnalysis.domain.*;
import org.apache.commons.lang3.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BuilderProcessor {
    private static final String SEPARADOR1 = ",";

    private static final String SEPARADOR2 = "-";

    public static Seller sellerBuilder(List<String> code) {
        return Seller.builder()
                .cpf(code.get(1))
                .name(code.get(2))
                .salary(Double.parseDouble(code.get(3)))
                .build();
    }

    public static Client clientBuilder(List<String> code) {
        return Client.builder()
                .cpnj(code.get(1))
                .name(code.get(2))
                .businessArea(code.get(3))
                .build();
    }

    public static Sale saleBuilder(List<String> code) {

        List<Item> items = new ArrayList<>();

        double totalSale = 0;

        String values = StringUtils.remove(StringUtils.remove(code.get(2), "["), "]");

        if (StringUtils.isNotBlank(values)) {

            List<String> itemList = Arrays.asList(values.split(SEPARADOR1));

            for (String value : itemList) {

                List<String> itemValues = Arrays.asList(value.split(SEPARADOR2));
                items.add(Item.builder()
                        .id(itemValues.get(0))
                        .amount(Integer.parseInt(itemValues.get(1)))
                        .price(Double.parseDouble(itemValues.get(2)))
                        .build());

                totalSale = totalSale + Double.parseDouble(itemValues.get(2));
            }
        }
        return Sale.builder()
                .idSale(code.get(1))
                .listItems(items)
                .nameSeller(code.get(3))
                .totalSale(totalSale)
                .build();
    }

}
