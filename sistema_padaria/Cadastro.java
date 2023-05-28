package sistema_padaria;
import java.util.ArrayList;


public class Cadastro {
	private ArrayList<Produto> listaProdutos;
	
	public Cadastro() {
		listaProdutos = new ArrayList<>();
	}
	
	public void cadastrarProduto(Produto produto) {
		listaProdutos.add(produto);
	}
	
	public void exibirProdutosDisponiveis() {
		System.out.println("=== Produtos Disponíveis ===");
			for (Produto produto : listaProdutos) {
				System.out.println("Código: " + produto.getCodigo() + " - Produto: " + produto.getNome() + " - Preço: " + produto.getPreco());
					}
	}
	
	public Produto buscarProduto(int codigo) {
			for (Produto produto : listaProdutos) {
					if (produto.getCodigo() == codigo) {
						return produto;
					}
				}
			return null;
	}
}
