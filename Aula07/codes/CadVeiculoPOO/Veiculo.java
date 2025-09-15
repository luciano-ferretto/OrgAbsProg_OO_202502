import java.time.LocalDate;

public class Veiculo {
    private String marca;
    private String modelo;
    private String placa;
    private int ano;

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getModelo() {
        return modelo.toUpperCase();
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public int getAno() {
        return ano;
    }

    public void setAno(int ano) {
            this.ano = ano;
    }

    // Declarando de forma explícita o método construtor default
    public Veiculo() {

    }

    public Veiculo(String marca, String modelo, String placa, int ano) {
        this.marca = marca;
        this.modelo = modelo;
        this.placa = placa; 
        this.ano = ano;
    }

    public int calculaTempoUso() {
        int anoAtual = LocalDate.now().getYear();
        // int tempoUso = this.calculaTempoUso(anoAtual);
        return this.calculaTempoUso(anoAtual);
    }

    public int calculaTempoUso(int anoBase) {
        int tempoUso = anoBase - this.ano - 1;
        return tempoUso;
    }

    public Veiculo cloneMe() {
        Veiculo novoVeiculo = new Veiculo();
        novoVeiculo.marca = this.marca;
        novoVeiculo.modelo = this.modelo;
        novoVeiculo.placa = this.placa;
        novoVeiculo.ano = this.ano;
        return novoVeiculo;
    }

    public String toString() {
        return "Veículo [Marca = '" + marca 
                            + "'', Modelo = '" + modelo 
                            + "'', Placa = '" + placa 
                            + "'', Ano = '" + ano
                + "'']";
    }

}