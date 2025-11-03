package monolitico;
import java.util.Scanner;
import java.io.FileWriter;
import java.io.IOException;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class SimuladorEmprestimoMonolitico {

    // CAMADA DE NEGÓCIO - A regra está misturada aqui (Juros fixos)
    private static final double TAXA_JUROS_FIXA = 0.05; // 5% ao mês

    public static void main(String[] args) {
        
        // 1. CAMADA DE APRESENTAÇÃO (Interface de Usuário - CLI)
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("--- BEM-VINDO AO SISTEMA DE SIMULAÇÃO BANCÁRIA LEGADO ---");
        System.out.println("Taxa de Juros Fixa: " + (TAXA_JUROS_FIXA * 100) + "% ao mês.");

        double valorEmprestimo = 0;
        int numParcelas = 0;

        // Solicita o valor do empréstimo
        System.out.print("Digite o valor desejado para o empréstimo (R$): ");
        if (scanner.hasNextDouble()) {
            valorEmprestimo = scanner.nextDouble();
        } else {
            System.err.println("Valor inválido. Encerrando.");
            scanner.close();
            return;
        }

        // Solicita o número de parcelas
        System.out.print("Digite o número de parcelas: ");
        if (scanner.hasNextInt()) {
            numParcelas = scanner.nextInt();
        } else {
            System.err.println("Número de parcelas inválido. Encerrando.");
            scanner.close();
            return;
        }
        
        scanner.close(); // Fecha o Scanner

        // -----------------------------------------------------

        // 2. CAMADA DE NEGÓCIO (Lógica de Cálculo)
        
        // Regra de Negócio: Calcula o valor total a ser pago
        double valorJuros = valorEmprestimo * TAXA_JUROS_FIXA * numParcelas;
        double valorTotalPagar = valorEmprestimo + valorJuros;
        
        // Regra de Negócio: Calcula o valor da parcela
        double valorParcela = valorTotalPagar / numParcelas;

        // 3. CAMADA DE APRESENTAÇÃO (Exibição do Resultado)
        System.out.println("\n--- RESULTADO DA SIMULAÇÃO ---");
        System.out.printf("Valor do Empréstimo: R$ %.2f\n", valorEmprestimo);
        System.out.printf("Juros Total: R$ %.2f\n", valorJuros);
        System.out.printf("Total a Pagar: R$ %.2f\n", valorTotalPagar);
        System.out.printf("Você pagará %d parcelas de R$ %.2f\n", numParcelas, valorParcela);
        System.out.println("------------------------------\n");
        
        // -----------------------------------------------------

        // 4. CAMADA DE DADOS/PERSISTÊNCIA (Salvar a Simulação em Arquivo)
        
        String nomeArquivo = "simulacao_emprestimo.txt";
        String timestamp = LocalDateTime.now().format(DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss"));
        
        String dadosSimulacao = String.format(
            "SIMULAÇÃO - %s\n" +
            "------------------------------\n" +
            "Empréstimo: R$ %.2f\n" +
            "Parcelas: %d\n" +
            "Juros/mês: %.2f%%\n" +
            "Valor da Parcela: R$ %.2f\n" +
            "Total Pago: R$ %.2f\n",
            timestamp, valorEmprestimo, numParcelas, TAXA_JUROS_FIXA * 100, valorParcela, valorTotalPagar
        );

        try (FileWriter fileWriter = new FileWriter(nomeArquivo, true)) {
            fileWriter.write(dadosSimulacao + "\n");
            System.out.println("SUCESSO: Simulação salva em: " + nomeArquivo);
        } catch (IOException e) {
            // Tratamento de erro (misturado com a lógica principal)
            System.err.println("ERRO ao salvar a simulação: " + e.getMessage());
        }
    }
}