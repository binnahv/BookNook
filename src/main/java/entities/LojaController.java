package entities;

import java.util.Scanner;

public class LojaController {
    private Loja loja;
    private Scanner scanner;

    public LojaController(Scanner scanner) {
        this.loja = new Loja();
        this.scanner = scanner;
    }

    public void adicionarMangasAutomaticamente() {
        loja.adicionarProduto(new Manga("Naruto", 29.90, "Masashi Kishimoto"));
        loja.adicionarProduto(new Manga("One Piece", 34.90, "Eiichiro Oda"));
        loja.adicionarProduto(new Manga("Attack on Titan", 39.90, "Hajime Isayama"));
        loja.adicionarProduto(new Livro("O Hobbit", 49.90, "J. R. R. Tolkien", 1937));
        loja.adicionarProduto(new Livro("Dom Casmurro", 24.90, "Machado de Assis", 1899));
    }

    public void exibirMenu() {
        System.out.println("----- Menu -----");
        System.out.println("1. Adicionar Produto");
        System.out.println("2. Exibir Estoque");
        System.out.println("3. Pesquisar Produto");
        System.out.println("4. Remover Produto");
        System.out.println("5. Atualizar Produto");
        System.out.println("6. Comprar Produto");
        System.out.println("0. Encerrar Programa");
    }

    public void processarOpcao(int escolha) {
        switch (escolha) {
            case 1:
                int tipoProduto;
                do {
                    System.out.println("Escolha o tipo de produto:");
                    System.out.println("1. Manga");
                    System.out.println("2. Livro");
                    System.out.println("0. Voltar ao menu principal");
                    System.out.print("Escolha uma opção: ");
                    tipoProduto = lerInteiro();

                    switch (tipoProduto) {
                        case 1:
                            loja.adicionarProduto(MangaFactory.criarProduto(scanner));
                            break;
                        case 2:
                            loja.adicionarProduto(LivroFactory.criarProduto(scanner));
                            break;
                        case 0:
                            break;
                        default:
                            System.out.println("Opção inválida. Tente novamente.");
                    }
                } while (tipoProduto != 0);
                break;
            case 2:
                loja.exibirEstoque();
                break;
            case 3:
                System.out.print("Digite o ID do produto a ser pesquisado: ");
                int idPesquisa = lerInteiro();
                Produto produtoPesquisado = loja.buscarProdutoPorId(idPesquisa);
                if (produtoPesquisado != null) {
                    System.out.println("Produto encontrado:");
                    produtoPesquisado.exibirInfo();
                } else {
                    System.out.println("Produto não encontrado.");
                }
                break;
            case 4:
                System.out.print("Digite o ID do produto a ser removido: ");
                int idRemocao = lerInteiro();
                loja.removerProduto(idRemocao);
                break;
            case 5:
                System.out.print("Digite o ID do produto a ser atualizado: ");
                int idAtualizacao = lerInteiro();
                Produto existente = loja.buscarProdutoPorId(idAtualizacao);
                if (existente == null) {
                    System.out.println("Produto não encontrado no estoque.");
                    break;
                }

                System.out.println("Informe os novos dados do produto:");
                Produto produtoAtualizado;
                if (existente instanceof Manga) {
                    produtoAtualizado = MangaFactory.criarProduto(scanner);
                } else if (existente instanceof Livro) {
                    produtoAtualizado = LivroFactory.criarProduto(scanner);
                } else {
                    System.out.println("Tipo de produto não suportado.");
                    break;
                }
                loja.atualizarProduto(idAtualizacao, produtoAtualizado);
                break;
            case 6:
                System.out.print("Digite o ID do produto a ser comprado: ");
                int idCompra = lerInteiro();
                loja.comprarProduto(idCompra);
                break;
            case 0:
                System.out.println("Encerrando o programa. Obrigado!");
                break;
            default:
                System.out.println("Opção inválida. Tente novamente.");
        }
    }

    private int lerInteiro() {
        while (!scanner.hasNextInt()) {
            System.out.print("Valor inválido. Digite um número inteiro: ");
            scanner.next();
        }
        int valor = scanner.nextInt();
        scanner.nextLine();
        return valor;
    }
}
