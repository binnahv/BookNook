# BookNook

 Aplicação de console em Java para gerenciar o estoque de uma loja que vende **livros** e **mangás**. O programa inicia com alguns produtos cadastrados e oferece um menu para incluir, listar, pesquisar, atualizar, remover e comprar itens.

## Objetivo e finalidade

O projeto serve como atividade prática de **programação orientada a objetos**: modelar produtos com herança, centralizar regras de estoque em uma classe de domínio e isolar a interação com o usuário (menu e leitura do teclado) em um controlador.

Na prática, o usuário opera a loja pelo terminal: consulta o estoque, altera o catálogo e registra uma compra (o item sai do estoque).

## Detalhes técnicos

| Conceito | Onde aparece |
| --- | --- |
| Classe abstrata | `Produto` define dados comuns (`nome`, `preço`, `id`) e o método `exibirInfo()` |
| Herança | `Livro` e `Manga` estendem `Produto` e especializam a exibição |
| Encapsulamento | Atributos privados e acesso por getters/setters |
| Padrão Factory | `LivroFactory` e `MangaFactory` leem dados do `Scanner` e devolvem um `Produto` |
| Composição | `Loja` guarda uma `List<Produto>`; `LojaController` usa `Loja` + `Scanner` |
| Identificadores | Cada produto recebe um ID sequencial em `Loja.gerarProximoId()` no construtor de `Produto` |

Fluxo de execução:

1. `Main` cria o `Scanner` e o `LojaController`.
2. `adicionarMangasAutomaticamente()` popula o estoque inicial (3 mangás e 2 livros).
3. O menu permanece ativo até a opção `0`.
4. Cada opção chama métodos de `Loja` (adicionar, listar, buscar, remover, atualizar, comprar).

Estrutura de pastas (padrão Maven):

```
src/main/java/Main.java
src/main/java/entities/
  Produto.java
  Livro.java
  Manga.java
  LivroFactory.java
  MangaFactory.java
  Loja.java
  LojaController.java
```

Não há banco de dados nem interface gráfica: o estado vive só na memória enquanto o programa está aberto.

## Como compilar e executar

Requisito: **JDK 11** ou superior (`javac` e `java` no PATH).

Na pasta do projeto:

```bash
javac -d out $(find src/main/java -name '*.java')
java -cp out Main
```

Com Maven:

```bash
mvn -q compile
java -cp target/classes Main
```

No Replit, o arquivo `.replit` continua compilando todos os `.java` encontrados no repositório.

## Como testar

Ao abrir o programa, escolha **2 (Exibir Estoque)**. Devem aparecer IDs **1 a 5** (Naruto, One Piece, Attack on Titan, O Hobbit, Dom Casmurro).

Sugestão de percurso:

1. **Pesquisar (3)** — informe o ID `1` e confira os dados de Naruto.
2. **Adicionar (1)** — tipo Mangá, preencha nome, preço e autor; volte com `0` e liste o estoque de novo. O novo item deve ter ID `6`.
3. **Atualizar (5)** — use um ID existente; o programa pede os dados novamente e mantém o mesmo ID.
4. **Comprar (6)** — informe um ID; a mensagem de sucesso deve aparecer e o item some da listagem.
5. **Remover (4)** — igual à compra no efeito (sai do estoque), útil para baixa sem “venda”.
6. **ID inexistente** — pesquisar/remover/comprar com `999` deve informar que não encontrou.
7. **Encerrar (0)** — fecha o programa.

Para um teste rápido sem digitar o menu interativo, você pode enviar as opções pela entrada padrão (exemplo: listar e sair):

```bash
printf '2\n0\n' | java -cp out Main
```

## Menu

| Opção | Ação |
| --- | --- |
| 1 | Adicionar mangá ou livro |
| 2 | Listar estoque |
| 3 | Pesquisar por ID |
| 4 | Remover por ID |
| 5 | Atualizar dados (mantém o ID) |
| 6 | Comprar (remove do estoque) |
| 0 | Sair |
Project updated.