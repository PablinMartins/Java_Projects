package sistema_padaria;
import java.util.ArrayList;

public class Fatura {
	private ArrayList<Produto> listaProdutosComprados;
	private ArrayList<Integer> listaQuantidadesCompradas;
	
	public Fatura() {
		listaProdutosComprados = new ArrayList<>();
		listaQuantidadesCompradas = new ArrayList<>();
	
	}
	
	public void adicionarProduto(Produto produto, int quantidade) {
		listaProdutosComprados.add(produto);
		listaQuantidadesCompradas.add(quantidade);
	}
	
		public double calcularTotal() {
			double total = 0.0;
			for (int i = 0; i < listaProdutosComprados.size(); i++) {
				Produto produto = listaProdutosComprados.get(i);
				int quantidade = listaQuantidadesCompradas.get(i);
				
				total += produto.getPreco() * quantidade;
				}
			return total;
		}

		public ArrayList<Produto> getListaProdutosComprados() {
			return listaProdutosComprados;
		}

		public void setListaProdutosComprados(ArrayList<Produto> listaProdutosComprados) {
			this.listaProdutosComprados = listaProdutosComprados;
		}

		public ArrayList<Integer> getListaQuantidadesCompradas() {
			return listaQuantidadesCompradas;
		}

		public void setListaQuantidadesCompradas(ArrayList<Integer> listaQuantidadesCompradas) {
			this.listaQuantidadesCompradas = listaQuantidadesCompradas;
		}
}
