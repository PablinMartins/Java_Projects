package sistema_padaria;

public class Pao extends Produto {
		
		private String tipo;
		
		public Pao(String nome, int codigo, double preco, String tipo) {
			super(nome, codigo, preco);
			this.tipo = tipo;
		}
		
		public String getTipo() {
			return tipo;
		}
	
}
