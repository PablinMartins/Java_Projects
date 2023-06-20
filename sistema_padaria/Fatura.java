package sistema_padaria;

import java.util.ArrayList;
import javax.swing.JOptionPane;

public class Fatura {
    private ArrayList<ItemFatura> itensFatura;

    public Fatura() {
        itensFatura = new ArrayList<>();
    }

    public ArrayList<ItemFatura> getItensFatura() {
        return itensFatura;
    }

    public void exibirCarrinho() {
        StringBuilder mensagem = new StringBuilder("Itens no carrinho: \n");
        for (int i = 0; i < itensFatura.size(); i++) {
            ItemFatura item = itensFatura.get(i);
            mensagem.append(i + 1).append(". ").append(item.getProduto().getNome()).append(" (Código: ").append(item.getProduto().getCodigo()).append(")\n");
        }
        JOptionPane.showMessageDialog(null, mensagem.toString());
    }

    public void adicionarProduto(ItemFatura item) {
        itensFatura.add(item);
    }

    public double calcularTotal() {
        double total = 0.0;
        for (ItemFatura item : itensFatura) {
            total += item.getProduto().getPreco() * item.getQuantidade();
        }
        return total;
    }

    public void removerItem(int indice) {
        if (indice >= 0 && indice < itensFatura.size()) {
            itensFatura.remove(indice);
            JOptionPane.showMessageDialog(null, "Item removido do carrinho!!");
        } else {
            JOptionPane.showMessageDialog(null, "Item não encontrado no carrinho!!");
        }
    }
}
