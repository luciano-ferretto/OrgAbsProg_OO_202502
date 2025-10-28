import java.util.ArrayList;
import java.util.List;

public class Teste {
    private static void imprimeLivros(List<Livro> livros){
        for (Livro livro : livros) {
            System.out.println(livro.toString());
        }
    }

    public static void main(String[] args) {
        
        


        String a = "Teste";
        LivroDigital ld = new LivroDigital(
            "Titulo",
            "Autor",
            2000,
            450,
            "pdf",
            4.5);
        
        LivroFisico lf = new LivroFisico();
        lf.setTitulo("Titulo2");
        lf.setAutor("Autor2");
        lf.setNumeroExemplares(3);
        lf.setDimensoes("30 x 20");



        List<Livro> livros = new ArrayList<>();

        livros.add(ld);
        livros.add(lf);

        imprimeLivros(livros);

        //System.out.println(ld.toString());
        //System.out.println(lf.toString());
    }
}
