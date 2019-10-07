package com.dudacf26.core.DataAnalysis.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.*;
import java.util.stream.Collectors;

import static java.util.Comparator.*;

@Getter
@Setter
public class Result {

    private int amountClients;
    private int amountSellers;
    private String mostExpensiveSale;
    private String worstSeller;

}


