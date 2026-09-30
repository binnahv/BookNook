package entities;

public class Livro extends Produto {
    private String autor;
    private int ano;

    public Livro(String nome, double preco, String autor, int ano) {
        super(nome, preco);
        this.autor = autor;
        this.ano = ano;
    }

    @Override
    public void exibirInfo() {
        System.out.println("Livro: " + getNome() + ", Autor: " + autor + ", Ano: " + ano
                + ", Preço: R$" + getPreco() + ", ID: " + getId());
    }
}
