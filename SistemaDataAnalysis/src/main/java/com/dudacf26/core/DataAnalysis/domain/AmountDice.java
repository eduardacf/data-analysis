package com.dudacf26.core.DataAnalysis.domain;

import lombok.Builder;
import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
@Builder
public class AmountDice {

    List<Seller> sellers;
    List<Client> clients;
    List<Sale> sales;
}
