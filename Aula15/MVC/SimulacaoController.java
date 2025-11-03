package MVC;

import java.util.Scanner;

// Controller: Lida com a Interação (CLI) e delega a lógica
public class SimulacaoController {

    private final SimulacaoService simulacaoService;

    // Injeção de Dependência Manual (simulando o Spring)
    public SimulacaoController(SimulacaoService simulacaoService) {
        this.simulacaoService = simulacaoService;
    }

    public void iniciarSimulacao() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- SIMULADOR BANCÁRIO (CAMADAS) ---");
        System.out.println("Juros fixo: 5.00% a.m.");

        try {
            System.out.print("Digite o valor desejado para o empréstimo (R$): ");
            double valorEmprestimo = scanner.nextDouble();
            
            System.out.print("Digite o número de parcelas: ");
            int numParcelas = scanner.nextInt();

            // Chamada à Camada de Negócio (Service)
            Simulacao resultado = simulacaoService.simularEFinalizar(valorEmprestimo, numParcelas);

            // Apresentação do Resultado
            System.out.println("\n--- SIMULAÇÃO CONCLUÍDA ---");
            System.out.printf("Empréstimo: R$ %.2f\n", resultado.getValorEmprestimo());
            System.out.printf("Total a Pagar: R$ %.2f\n", resultado.getValorTotalPagar());
            System.out.printf("Parcelas: %d x R$ %.2f\n", resultado.getNumParcelas(), resultado.getValorParcela());
            System.out.println("---------------------------\n");
            
        } catch (IllegalArgumentException e) {
            // Tratamento de Erro de Apresentação (UI)
            System.err.println("ERRO na entrada de dados: " + e.getMessage());
        } catch (Exception e) {
            System.err.println("Ocorreu um erro inesperado.");
        } finally {
            scanner.close();
        }
    }
}