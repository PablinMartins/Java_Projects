package sistema_padaria;
//import java.util.Scanner;
import javax.swing.JOptionPane;

public class Sistema_principal {
	public static void main(String[] args) {
		Cadastro cadastro = new Cadastro();
		Estoque estoque = new Estoque();
		
		
		//////// CADASTRAR OS PRODUTOS /////
		Produto pao1 = new Pao(" - Pão Francês - ", 1, 1.50, "Francês");
		Produto pao2 = new Pao(" - Pão Integral - ", 2, 2.50, "Integral");
		Produto pao3 = new Pao(" - Pão Forma - ", 3, 3.50, "Forma");
			cadastro.cadastrarProduto(pao1);
			cadastro.cadastrarProduto(pao2);
			cadastro.cadastrarProduto(pao3);
			
			estoque.adicionarEstoque(pao1, 30);
			estoque.adicionarEstoque(pao2, 30);
			estoque.adicionarEstoque(pao3, 25);
			
		Produto bolo1 = new Bolo(" - Bolo de Chocolate - ", 4, 16.00, "Chocolate");
		Produto bolo2 = new Bolo(" - Bolo de Morango - ", 5, 14.00, "Morango");
		Produto bolo3 = new Bolo(" - Bolo de Cenoura - ", 6, 12.00, "Cenoura");
			cadastro.cadastrarProduto(bolo1);
			cadastro.cadastrarProduto(bolo2);
			cadastro.cadastrarProduto(bolo3);
			
			estoque.adicionarEstoque(bolo1, 10);
			estoque.adicionarEstoque(bolo2, 15);
			estoque.adicionarEstoque(bolo3, 20);
			
		Produto biscoito1 = new Biscoito(" - Biscoito de Chocolate - ", 7, 3.00, "Chocolate");
		Produto biscoito2 = new Biscoito(" - Biscoito de Baunilha - ", 8, 3.50, "Baunilha");
		Produto biscoito3 = new Biscoito(" - Biscoito de Morango - ", 9, 3.00, "Morango");
			cadastro.cadastrarProduto(biscoito1);
			cadastro.cadastrarProduto(biscoito2);
			cadastro.cadastrarProduto(biscoito3);
			
			estoque.adicionarEstoque(biscoito1, 50);
			estoque.adicionarEstoque(biscoito2, 50);
			estoque.adicionarEstoque(biscoito3, 40);
			
			// CRIACAO DO OBJETO FATURA
			Fatura fatura = new Fatura();
			
			// VARIAVEIS PARA EXIBIR FATURA
			StringBuilder carrinho = new StringBuilder();
						
			// LOOP PRINCIPAL DO PROGRAMA 
			
			boolean encerrar = false;
			do { // EXIBIR OPÇÕES PARA O USUÁRIO
				String opcao = JOptionPane.showInputDialog("Escolha uma opção:\n\n1. Comprar produto\n\n2. "
						+ "Encerrar programa\n\n3. Ver carrinho de compras\n\n4. Remover produto do carrinho\n\n");
				
				// VERIFICAR A OPÇÃO ESCOLHIDA
				switch (opcao) {
					case "1": // EXIBIR LISTA DE PRODUTOS
						
						String listaProdutos = "Produtos disponíveis: \n\n"; listaProdutos += "Código  |  Produto  |  Preço\n"; listaProdutos += 
						"------------------------------------------------------\n\n";
						
				listaProdutos+= pao1.getCodigo() + "\t" + pao1.getNome() + "\t" + " R$ " + pao1.getPreco() + "\n";
				listaProdutos+=	pao2.getCodigo() + "\t" + pao2.getNome() + "\t" + " R$ " + pao2.getPreco() + "\n";
				listaProdutos+= pao3.getCodigo() + "\t" + pao3.getNome() + "\t" + " R$ " + pao3.getPreco() + "\n";
				
				listaProdutos+= bolo1.getCodigo() + "\t" + bolo1.getNome() + "\t" + " R$ " + bolo1.getPreco() + "\n";
				listaProdutos+= bolo2.getCodigo() + "\t" + bolo2.getNome() + "\t" + " R$ " + bolo2.getPreco() + "\n";
				listaProdutos+= bolo3.getCodigo() + "\t" + bolo3.getNome() + "\t" + " R$ " + bolo3.getPreco() + "\n";
				
				listaProdutos+= biscoito1.getCodigo() + "\t" + biscoito1.getNome() + "\t" + " R$ " + biscoito1.getPreco() + "\n";
				listaProdutos+= biscoito2.getCodigo() + "\t" + biscoito2.getNome() + "\t" + " R$ " + biscoito2.getPreco() + "\n";
				listaProdutos+= biscoito3.getCodigo() + "\t" + biscoito3.getNome() + "\t" + " R$ " + biscoito3.getPreco() + "\n";
				
				///// SOLICITAR CODIGO DO PRODUTO 
				
				String codigoProduto = JOptionPane.showInputDialog(listaProdutos + "\nDigite o código do produto que deseja comprar:_____  \n\n");
				
				if (codigoProduto.equals("0")) {
                    // Encerrar compra e exibir fatura final
                    encerrar = true;
                    break;
                }
				
				// VERIFICAR O CODIGO DO PRODUTO ESCOLHIDO
				Produto produtoEscolhido = null;
					switch (codigoProduto) {
						case "1":
							produtoEscolhido = pao1;
							break;
						case "2": produtoEscolhido = pao2;
							break;
						case "3": 
							produtoEscolhido = pao3;
							break;
						case "4": 
							produtoEscolhido = bolo1;
							break;
						case "5":
							produtoEscolhido = bolo2;
							break;
						case "6":
							produtoEscolhido = bolo3;
							break;
						case "7":
							produtoEscolhido = biscoito1;
							break;
						case "8": 
							produtoEscolhido = biscoito2;
							break;
						case "9": 
							produtoEscolhido = biscoito3;
							break;
							
								default: 
									JOptionPane.showMessageDialog(null, "Código inválido\n\n");
								continue; // VOLTA PARA O INICIO DO PROGRAMA
					} 
					// SOLICITAR A QUANTIDADE DESEJADA
					String quantidadeString = JOptionPane.showInputDialog("\nDigite a quantidade desejada:_____ \n\n");
					int quantidade = Integer.parseInt(quantidadeString);
					// VERIFICAR SE TEM ESTOQUE
					int quantidadeEstoque = estoque.getQuantidadeEstoque(produtoEscolhido);
						if (quantidadeEstoque >= quantidade) {							
							
							
							
							// ATUALIZAR O ESTOQUE 
							estoque.removerEstoque(produtoEscolhido, quantidade);
							
							carrinho.append(produtoEscolhido.getCodigo() + "  -  " + quantidade + "x " + produtoEscolhido.getNome() + "  R$  " +
									produtoEscolhido.getPreco() + "  =  " + "  R4$  " + produtoEscolhido.getPreco() * quantidade + "\n");	
							
							
							JOptionPane.showMessageDialog(null, "\nProduto adicionado ao CARRINHO!\n");
						} else {
							JOptionPane.showMessageDialog(null, "Quantidade insuficiente em estoque!\n");
						} break;
							
					case "2":
						encerrar = true;
						break;
					
					case "3":
						//// EXIBIR CARRINHO DE COMPRAS
						
						double valorTotal = fatura.calcularTotal();
						carrinho.append("\nValor total do Carrinho: R$ " + valorTotal + "\n\n");
						carrinho.append(fatura.toString());
						JOptionPane.showMessageDialog(null, carrinho.toString());
						break;
						
					case "4": // Remover produto do carrinho
						
					    
						carrinho.append(fatura.toString());
					    JOptionPane.showMessageDialog(null, carrinho.toString());
					    int codigoItem = Integer.parseInt(JOptionPane.showInputDialog("Digite o código do item a ser removido: "));
					    fatura.removerItem(codigoItem);
					    break;

						default: 
							JOptionPane.showMessageDialog(null, "Opção invalida!");	
							break;
				} 
			
			
		} while(!encerrar);
					
		/// EXIBIR FATURA FINAL
			double valorTotal = fatura.calcularTotal();
	        JOptionPane.showMessageDialog(null, "Valor total do Carrinho: R$" + valorTotal + "\n\n");

	    // Encerrar o programa
	        JOptionPane.showMessageDialog(null, "Programa encerrado.");
	    }
	
}




