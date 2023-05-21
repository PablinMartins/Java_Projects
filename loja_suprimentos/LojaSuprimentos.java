package loja_suprimentos;

import java.util.Scanner;

public class LojaSuprimentos {
    public static void main(String[] args) {
        
        Produto produto1 = new Produto("Caneta", 1, 1.5);
        Produto produto2 = new Produto("Caderno", 2, 5.0);
        Produto produto3 = new Produto("Borracha", 3, 0.8);

        Fatura fatura = new Fatura();
        Scanner scanner = new Scanner(System.in);
        int opcao;

        do {
            System.out.println("Menu:");
            System.out.println("1 - Comprar");
            System.out.println("2 - Ver Fatura");
            System.out.println("3 - Encerrar Programa");
            System.out.print("Digite a opção desejada: ");
            opcao = scanner.nextInt();

            switch (opcao) {
                case 1:
                    System.out.println("Produtos disponíveis:");
                    System.out.println("Código | Nome | Preço");
                    System.out.println("-------|------|------");
                    System.out.println(produto1.getCodigo() + " | " + produto1.getNome() + " | " + produto1.getPreco());
                    System.out.println(produto2.getCodigo() + " | " + produto2.getNome() + " | " + produto2.getPreco());
                    System.out.println(produto3.getCodigo() + " | " + produto3.getNome() + " | " + produto3.getPreco());

                    System.out.print("Digite o código do produto desejado: ");
                    int codigoProduto = scanner.nextInt();
                    System.out.print("Digite a quantidade comprada: ");
                    int quantidade = scanner.nextInt();

                    Produto produtoSelecionado = null;
                    if (codigoProduto == produto1.getCodigo()) {
                        produtoSelecionado = produto1;
                    } else if (codigoProduto == produto2.getCodigo()) {
                        produtoSelecionado = produto2;
                    } else if (codigoProduto == produto3.getCodigo()) {
                        produtoSelecionado = produto3;
                    }

                    if (produtoSelecionado != null) {
                        Item item = new Item(produtoSelecionado, quantidade);
                        fatura.adicionarItem(item);
                        System.out.println("Item adicionado à fatura.");
                    } else {
                        System.out.println("Código de produto inválido.");
                    }
                    break;

                case 2:
                    System.out.println("Fatura:");
                    System.out.println("Produto | Quantidade | Valor Total");
                    System.out.println("--------|------------|------------");
                    for (Item item : fatura.getItens()) {
                        System.out.println(item.getProduto().getNome() + " | " +
                                item.getQuantidade() + " | " +
                                item.getValorTotal());
                    }
                    System.out.println("Valor Total: " + fatura.calcularTotal());
                    break;

                case 3:
                    System.out.println("Encerrando o programa...");
                    break;

                default:
                    System.out.println("Opção inválida.");
            }
        } while (opcao != 3);

        scanner.close();
    }
}