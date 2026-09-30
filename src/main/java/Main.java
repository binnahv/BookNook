import entities.LojaController;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LojaController lojaController = new LojaController(scanner);
        lojaController.adicionarMangasAutomaticamente();

        int escolha;
        do {
            lojaController.exibirMenu();
            System.out.print("Escolha uma opção: ");
            while (!scanner.hasNextInt()) {
                System.out.print("Valor inválido. Digite um número inteiro: ");
                scanner.next();
            }
            escolha = scanner.nextInt();
            scanner.nextLine();

            lojaController.processarOpcao(escolha);
        } while (escolha != 0);

        scanner.close();
    }
}
