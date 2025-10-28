import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    // Dependências
    private static Biblioteca biblioteca = new Biblioteca();
    private static Scanner scan = new Scanner(System.in);

    public static void main(String[] args) {
        scan.nextLine();
        String menu = """
                === Sistema Biblioteca ===
                Escolha uma das opções abaixo:
                1 - Adicionar Livro
                2 - Listar Acervo
                3 - Pesquisar Livro
                4 - Remover Livro
                5 - Alterar Livro
                6 - Imprimir Contagem de Livros
                7 - Pesquisar por Ano de Publicação
                8 - Mostrar Livro mais antigo, e Livro mais novo
                0 - Sair
                """;
        int opcao;
        do {
            System.out.println(menu);
            opcao = Input.scanInt("Digite sua escolha: ", scan);
            switch (opcao) {
                case 1:
                    cadastrarLivro();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 2:
                    listarAcervo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 3:
                    pesquisarLivro();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 4:
                    removerLivro();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 5:
                    atualizarLivro();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 6:
                    imprimirContagemLivros();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 7:
                    pesquisarLivroAnoPublicacao();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 8:
                    imprimirMaisAntigoMaisNovo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine();
                    break;
                case 0:
                    System.out.println("Volte Sempre!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!");
                    break;
            }
        } while (opcao != 0);
    }

    private static Livro imprimirCadastroLivro() {
        String titulo = Input.scanString("Digite o Título: ", scan);
        String autor = Input.scanString("Digite o Autor: ", scan);
        int anoPublicacao = Input.scanInt("Digite o ano de publicação: ", scan);
        int numeroPaginas = Input.scanInt("Digite o número de páginas: ", scan);
        int tipo = Input.scanInt("Qual o tipo de Livro: 1-Físico, 2-Digital", scan);
        Livro livro;
        if (tipo == 1) {
            int numeroExemplares = Input.scanInt("Informe o número de exemplares: ", scan);
            String dimensoes = Input.scanString("Informe as dimensões: ", scan);
            livro = new LivroFisico(titulo, autor, anoPublicacao, numeroPaginas, numeroExemplares, dimensoes);
        } else {
            String formatoArquivo = Input.scanString("Informe o formato do arquivo: ", scan);
            double tamanhoArquivo = Input.scanDouble("Informe o tamanho do arquivo: ", scan);
            livro = new LivroDigital(titulo, autor, anoPublicacao, numeroPaginas, formatoArquivo, tamanhoArquivo);
        }
         //= new Livro(titulo, autor, anoPublicacao, numeroPaginas);
        return livro;
    }

    private static void cadastrarLivro() {
        Livro novoLivro = imprimirCadastroLivro();
        try {
            biblioteca.adicionar(novoLivro);
            System.out.println("Livro adicionado com sucesso.");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void listarAcervo() {
        var acervo = biblioteca.pesquisar();
        // List<Livro> acervo = biblioteca.pesquisar();
        imprimirLista(acervo);
    }

    private static void pesquisarLivro() {
        String titulo = Input.scanString("Digite o título que procuras: ", scan);
        String pesquisaAutor = Input.scanString(
                "Deseja pesquiar por autor? (S/N) ", scan);
        List<Livro> livros;
        if (pesquisaAutor.toLowerCase().charAt(0) == 's') {
            String autor = Input.scanString("Digite o nome do autor: ", scan);
            livros = biblioteca.pesquisar(titulo, autor);
        } else {
            livros = biblioteca.pesquisar(titulo);
        }
        imprimirLista(livros);
    }

    private static void pesquisarLivroAnoPublicacao() {
        int anoInicial = Input.scanInt("Digite o ano inicial da pesquisa: ", scan);
        int anoFinal = Input.scanInt("Digite o ano final da pesquisa: ", scan);
        var livros = biblioteca.pesquisar(anoInicial, anoFinal);
        imprimirLista(livros);
    }

    private static void imprimirLista(List<Livro> acervo) {
        if (acervo == null || acervo.isEmpty())
            System.out.println("Nenhum Livro Encontrado");
        else {
            System.out.println("Livros Encrontrados");
            for (int i = 0; i < acervo.size(); i++) {
                System.out.println("Livro " + (i + 1) + ": " + acervo.get(i));
            }
        }
    }

    private static void removerLivro() {
        listarAcervo();
        int indice = Input.scanInt("Informe o índice do livro que deseja remover: ", scan);
        try {
            biblioteca.remover(indice - 1);
            System.out.println("Livro Removido com Sucesso");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void atualizarLivro() {
        listarAcervo();
        int indice = Input.scanInt("Informe o índice do livro que deseja atualizar: ", scan);
        Livro livro = imprimirCadastroLivro();
        try {
            biblioteca.alterar(indice - 1, livro);
            System.out.println("Livro Alterado com Sucesso");
        } catch (Exception e) {
            System.out.println("Erro: " + e.getMessage());
        }
    }

    private static void imprimirContagemLivros() {
        var acervo = biblioteca.pesquisar();
        System.out.println("Total de Livros cadastrados: " + acervo.size());
    }

    private static void imprimirMaisAntigoMaisNovo() {
        List<Livro> livros = new ArrayList<>();
        livros.add(biblioteca.pesquisarLivroMaisAntigo());
        livros.add(biblioteca.pesquisarLivroMaisNovo());
        imprimirLista(livros);
    }

}
