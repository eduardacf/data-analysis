package com.dudacf26.core.DataAnalysis.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class Sale {

    private String idSale;
    private List<Item> listItems;
    private String nameSeller;
    private Double totalSale;

    public static final String TYPE = "003";

}

