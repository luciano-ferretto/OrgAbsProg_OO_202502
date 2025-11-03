package MVC;

import java.time.LocalDateTime;

// Model: Entidade que representa os dados
public class Simulacao {
    private final LocalDateTime dataSimulacao;
    private final double valorEmprestimo;
    private final int numParcelas;
    private final double taxaJuros;
    private double valorParcela;
    private double valorTotalPagar;

    public Simulacao(double valorEmprestimo, int numParcelas, double taxaJuros) {
        this.dataSimulacao = LocalDateTime.now();
        this.valorEmprestimo = valorEmprestimo;
        this.numParcelas = numParcelas;
        this.taxaJuros = taxaJuros;
    }

    // Getters e Setters (Omissos por brevidade, mas essenciais em produção)
    public double getValorEmprestimo() { return valorEmprestimo; }
    public int getNumParcelas() { return numParcelas; }
    public double getTaxaJuros() { return taxaJuros; }
    public double getValorParcela() { return valorParcela; }
    public double getValorTotalPagar() { return valorTotalPagar; }
    public LocalDateTime getDataSimulacao() { return dataSimulacao; }

    public void setValorParcela(double valorParcela) { this.valorParcela = valorParcela; }
    public void setValorTotalPagar(double valorTotalPagar) { this.valorTotalPagar = valorTotalPagar; }

    @Override
    public String toString() {
        return String.format(
            "Data: %s\nEmpréstimo: R$ %.2f, Parcelas: %d, Taxa: %.2f%%\n" +
            "Valor Parcela: R$ %.2f, Total Pago: R$ %.2f\n",
            dataSimulacao.format(java.time.format.DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss")),
            valorEmprestimo, numParcelas, taxaJuros * 100, valorParcela, valorTotalPagar
        );
    }
}