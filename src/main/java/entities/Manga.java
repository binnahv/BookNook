package entities;

public class Manga extends Produto {
    private String autor;

    public Manga(String nome, double preco, String autor) {
        super(nome, preco);
        this.autor = autor;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Manga: " + getNome() + ", Autor: " + autor
                + ", Preço: R$" + getPreco() + ", ID: " + getId());
    }
}
