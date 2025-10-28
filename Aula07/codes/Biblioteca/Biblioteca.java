import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Biblioteca {
    public static final int ANO_PUBLICACAO_MINIMO = 1900;

    private List<Livro> acervo;
    
    public Biblioteca() {
        this.acervo = new ArrayList<>();
    }

    private void validarLivro(Livro livro, int indice) throws Exception {
        if (livro == null)
            throw new Exception("Livro não pode ser nulo");

        livro.setTitulo(livro.getTitulo().trim());
        if (livro.getTitulo() == null || livro.getTitulo().isEmpty())
            throw new Exception("Título não pode ser em branco");
        
        livro.setAutor(livro.getAutor().trim());
        if (livro.getAutor() == null || livro.getAutor().isEmpty())
            throw new Exception("Autor não pode ser em branco");
        
        int anoAtual = LocalDate.now().getYear();
        if (livro.getAnoPublicacao() < ANO_PUBLICACAO_MINIMO
                || livro.getAnoPublicacao() > anoAtual)
            throw new Exception("Ano de publicação deve estar entre 1900 e o ano atual");

        if (livro.getNumeroPaginas() <= 0)
            throw new Exception("Número de páginas deve ser maior que zero");

        int i = 0;
        for (Livro l : acervo) {
            if (indice != i
                    && l.getTitulo().equalsIgnoreCase(livro.getTitulo()) 
                    && l.getAutor().equalsIgnoreCase(livro.getAutor())
                    && l.getAnoPublicacao() == livro.getAnoPublicacao())
                throw new Exception("Já existe livro cadastrado com este Título, Autor e Ano de Publicação");
            i++;
        }
    }

    public Livro adicionar(Livro livro) throws Exception{
        validarLivro(livro, -1);
        acervo.add(livro);
        return livro;
    }

    public Livro alterar(int indice, Livro livro) throws Exception {
        validarLivro(livro, indice);
        acervo.set(indice, livro);
        return livro;
    }

    public List<Livro> pesquisar() {
        return acervo;
    }

    public List<Livro> pesquisar(String titulo){
        return pesquisar(titulo, null);
    }

    public List<Livro> pesquisar(String titulo, String autor) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getTitulo().toLowerCase().contains(titulo.toLowerCase())){
                if (autor == null || 
                        livro.getAutor().toLowerCase().contains(autor.toLowerCase()))
                    livrosEncontrados.add(livro);
            }
        }
        return livrosEncontrados;
    }

    public List<Livro> pesquisar(int anoInicial, int anoFinal) {
        List<Livro> livrosEncontrados = new ArrayList<>();
        for (Livro livro : acervo) {
            if (livro.getAnoPublicacao() >= anoInicial && livro.getAnoPublicacao() <= anoFinal)
                livrosEncontrados.add(livro);
        }
        return livrosEncontrados;
    }

    public void remover(int indice) throws Exception {
        if (indice < 0 || indice >= acervo.size())
            throw new Exception("Índice não encontrado");
        
        acervo.remove(indice);
    }

    public Livro pesquisarLivroMaisAntigo() {
        Livro livro =null;
        for (Livro l : acervo) {
            if (livro == null)
                livro = l;
            else {
                if (l.getAnoPublicacao() <= livro.getAnoPublicacao())
                    livro = l;
            }
        }
        return livro;
    }

    public Livro pesquisarLivroMaisNovo() {
        Livro livro =null;
        for (Livro l : acervo) {
            if (livro == null)
                livro = l;
            else {
                if (l.getAnoPublicacao() >= livro.getAnoPublicacao())
                    livro = l;
            }
        }
        return livro;
    }
}
