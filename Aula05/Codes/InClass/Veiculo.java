import java.time.LocalDate;

public class Veiculo{
    String marca;
    String modelo;
    String placa;
    int ano;

    int calculaTempoUso(int anoBase){
        //int anoAtual = LocalDate.now().getYear();
        int tempoUso = anoBase - this.ano;
        return tempoUso;
    }
}