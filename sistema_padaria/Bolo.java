package sistema_padaria;

public class Bolo extends Produto {
	
	private String sabor;
	
	public Bolo(String nome, int codigo, double preco, String sabor) {
		super(nome, codigo, preco);
		this.sabor = sabor;
	}
	
	public String getSabor() {
		return sabor;
	}
		

}
