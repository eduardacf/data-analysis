package com.dudacf26.core.temaFinal.controller;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.dudacf26.core.temaFinal.domain.Cliente;
import com.dudacf26.core.temaFinal.domain.DadosArquivo;
import com.dudacf26.core.temaFinal.domain.Item;
import com.dudacf26.core.temaFinal.domain.Venda;
import com.dudacf26.core.temaFinal.domain.Vendedor;

public class Watcher {
    private List<String> rawDataList;
    private List<String> dataChunks;
    
    public Watcher(List<String> raw){
        rawDataList = raw;
        dataChunks = new ArrayList<String>();
    }
    
    public void splitData(){
        for(String rawData : rawDataList){
            dataChunks.addAll(Arrays.asList(rawData.split("(?=(001|002|003|001?|002?|003?| 001?| 002?| 003?))")));  
        }
        dataChunks.removeIf((String s)-> s.trim().isEmpty());
    }
    public List<DadosArquivo> decodeData(){
        List<DadosArquivo> reg = new ArrayList<DadosArquivo>();
        for(String datum : dataChunks){
           List<String> rawAgent = Arrays.asList(datum.split("?"));
            DadosArquivo dadosarquivo = new DadosArquivo();
            switch(rawAgent.get(0)){
                case "001":
                	dadosarquivo = new Vendedor(rawAgent.get(1),rawAgent.get(2), Float.parseFloat(rawAgent.get(3)));
                    break;
                case "002":
                	dadosarquivo = new Cliente(rawAgent.get(1),rawAgent.get(2),rawAgent.get(3));
                    break;
                case "003":
                    List<Item> items = decodeSales(rawAgent.get(2));
                    dadosarquivo = new Venda(Integer.parseInt(rawAgent.get(1)),items , rawAgent.get(3));
                    break;
                    
            }
            reg.add(dadosarquivo);
        }

        return reg;
    }
    private List<Item> decodeSales(String raw){
        List<Item> items = new ArrayList<Item>();
        List<String> rawItems = Arrays.asList(raw.replace("[", "").replace("]", "").split("(,)"));
        for(String rawItem : rawItems){
            List<String> itemData= Arrays.asList(rawItem.split("(-)"));
            items.add(new Item(Integer.parseInt(itemData.get(0)), Integer.parseInt(itemData.get(1)), Float.parseFloat(itemData.get(2))));
        }
        return items;
    }
}
