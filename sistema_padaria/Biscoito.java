package sistema_padaria;

public class Biscoito extends Produto {
	private String modelo;
	
	public Biscoito(String nome, int codigo, double preco, String modelo) {
		super(nome, codigo, preco);
		this.modelo = modelo;
	}
	
	public String getModelo() {
		return modelo;
	}

}
