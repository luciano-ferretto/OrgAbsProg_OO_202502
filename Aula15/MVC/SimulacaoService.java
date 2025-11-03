package MVC;
// Service: Contém as Regras de Negócio e Orquestração
public class SimulacaoService {

    // A regra de negócio (Taxa) é definida aqui
    private static final double TAXA_JUROS_FIXA = 0.05; // 5% ao mês

    private final SimulacaoRepository repository;

    // Injeção de Dependência Manual (simulando o Spring)
    public SimulacaoService(SimulacaoRepository repository) {
        this.repository = repository;
    }

    // Regra principal: Executa o cálculo e coordena a persistência
    public Simulacao simularEFinalizar(double valor, int parcelas) {
        
        // 1. Validação (Regra de Negócio)
        if (valor <= 0 || parcelas <= 0) {
            throw new IllegalArgumentException("Valor ou número de parcelas inválido.");
        }

        // 2. Criação do Modelo de Dados
        Simulacao simulacao = new Simulacao(valor, parcelas, TAXA_JUROS_FIXA);

        // 3. Lógica de Cálculo
        double valorJuros = simulacao.getValorEmprestimo() * TAXA_JUROS_FIXA * simulacao.getNumParcelas();
        double valorTotalPagar = simulacao.getValorEmprestimo() + valorJuros;
        double valorParcela = valorTotalPagar / simulacao.getNumParcelas();

        // 4. Atualiza o Modelo de Dados
        simulacao.setValorTotalPagar(valorTotalPagar);
        simulacao.setValorParcela(valorParcela);

        // 5. Coordena a Persistência (chama a Camada de Dados)
        repository.salvar(simulacao);
        
        return simulacao;
    }
}