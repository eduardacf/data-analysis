package com.dudacf26.core.DataAnalysis.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

@Builder
@Getter
@Setter
public class Client {

    private String cpnj;
    private String name;
    private String businessArea;

    public static final String TYPE = "002";

}
