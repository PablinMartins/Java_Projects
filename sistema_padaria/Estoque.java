package sistema_padaria;
import java.util.HashMap;
import java.util.Map;

public class Estoque {
	private Map<Produto, Integer> estoque;
	public Estoque() {
		estoque = new HashMap<>();
	}
	
	public void adicionarEstoque(Produto produto, int quantidade) {
		estoque.put(produto, estoque.getOrDefault(produto, 0) + quantidade);
	}
	
	public void removerEstoque(Produto produto, int quantidade) {
		int quantidadeAtual = estoque.getOrDefault(produto, 0);
		if (quantidadeAtual > quantidade) {
			estoque.put(produto, quantidadeAtual - quantidade);
		} else {
			estoque.remove(produto);
		}
	}
	
	public int getQuantidadeEstoque(Produto produto) {
		return estoque.getOrDefault(produto, 0);
	}
}
