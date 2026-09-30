package entities;

import java.util.Scanner;

public class LivroFactory {
    public static Produto criarProduto(Scanner scanner) {
        System.out.print("Digite o nome do Livro: ");
        String nome = scanner.nextLine();

        System.out.print("Digite o preço do Livro: ");
        double preco = scanner.nextDouble();
        scanner.nextLine();

        System.out.print("Digite o nome do autor: ");
        String autor = scanner.nextLine();

        System.out.print("Qual o ano de edição: ");
        int ano = scanner.nextInt();
        scanner.nextLine();

        return new Livro(nome, preco, autor, ano);
    }
}
