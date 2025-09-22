import java.util.ArrayList;
import java.util.List;

public class ExemploFinalVariavel {
    public static void main(String[] args) {
        // Variável final primitiva: seu valor não muda
        final int TAXA_JUROS = 5;
        // TAXA_JUROS = 6; // Erro de compilação!

        // Variável final de referência: a referência não muda
        final List<String> nomes = new ArrayList<>();
        nomes.add("João"); // Válido - O conteúdo da lista pode ser alterado.
        nomes = new ArrayList<>(); // Erro de compilação! - A referência não pode ser alterada.
    }
}

