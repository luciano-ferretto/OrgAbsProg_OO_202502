import java.time.LocalDate;

public class Aplicacao {
    public static void main(String[] args) {
        Veiculo focus; //Declara uma variável "focus" do tipo "Veiculo"
        focus = new Veiculo();   //invoca o método construtor "Veiculo()"
                                //atribuo um novo objeto (veículo) para variável "focus"
        focus.marca = "Ford";
        focus.modelo = "Focus";
        focus.placa = "ABC-1234";
        focus.ano = 2018;

        int anoAtual = LocalDate.now().getYear();
        int tempoUsoFocus = focus.calculaTempoUso(anoAtual);
        System.out.println("Tempo de uso do " + focus.modelo + ": " + tempoUsoFocus);

        Veiculo corolla = new Veiculo();
        corolla.marca = "Toyota";
        corolla.modelo = "Corolla";
        corolla.placa = "ABC-4321";
        corolla.ano = 2022;

        Veiculo newCorolla = corolla;
        newCorolla.ano = 2025;

        corolla.calculaTempoUso(anoAtual);
        newCorolla.calculaTempoUso(anoAtual);

    }
}
