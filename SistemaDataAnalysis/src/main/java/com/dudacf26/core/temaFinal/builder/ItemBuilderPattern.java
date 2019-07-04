package com.dudacf26.core.temaFinal.builder;

import com.dudacf26.core.temaFinal.domain.Item;

public class ItemBuilderPattern {

	private Item item;

	public ItemBuilderPattern() {
		this.item = new Item();
	}
	
	public static ItemBuilderPattern builder() {
        return new ItemBuilderPattern();
    }
	
	public ItemBuilderPattern idItem(int idItem) {
        this.item.setId(idItem);
        return this;
    }
	
	public ItemBuilderPattern quantidade(int quantidade) {
        this.item.setQuantidade(quantidade);
        return this;
    }
	
	public ItemBuilderPattern preco(Double preco) {
        this.item.setPreco(preco);
        return this;
    }
	
	public Item listar() {
        return this.item;
    }
	

}
