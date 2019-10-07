package com.dudacf26.core.DataAnalysis.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter

public class Seller {

    private String cpf;
    private String name;
    private Double salary;

    public static final String TYPE = "001";
}
