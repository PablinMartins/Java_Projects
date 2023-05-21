package loja_suprimentos;

import java.util.ArrayList;

class Fatura {
    private ArrayList<Item> itens;
    private double valorTotal;

    public Fatura() {
        this.itens = new ArrayList<>();
        this.valorTotal = 0.0;
    }

    public void adicionarItem(Item item) {
        itens.add(item);
        valorTotal += item.getValorTotal();
    }

    public double calcularTotal() {
        return valorTotal;
    }

    public ArrayList<Item> getItens() {
        return itens;
    }
}