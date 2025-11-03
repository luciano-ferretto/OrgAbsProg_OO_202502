import { Simulacao } from './Simulacao';
import { SimulacaoRepository } from './SimulacaoRepository';

// Service: Contém as Regras de Negócio
export class SimulacaoService {

    private static readonly TAXA_JUROS_FIXA = 0.05; // 5% ao mês

    private repository: SimulacaoRepository;

    // Injeção de Dependência via Constructor
    constructor(repository: SimulacaoRepository) {
        this.repository = repository;
    }

    public simularEFinalizar(valor: number, parcelas: number): Simulacao {
        
        // 1. Validação (Regra de Negócio)
        if (valor <= 0 || parcelas <= 0) {
            throw new Error("Valor ou número de parcelas inválido.");
        }

        // 2. Criação do Modelo de Dados
        const simulacao = new Simulacao(valor, parcelas, SimulacaoService.TAXA_JUROS_FIXA);

        // 3. Lógica de Cálculo
        const valorJuros = simulacao.getValorEmprestimo() * SimulacaoService.TAXA_JUROS_FIXA * simulacao.getNumParcelas();
        const valorTotalPagar = simulacao.getValorEmprestimo() + valorJuros;
        const valorParcela = valorTotalPagar / simulacao.getNumParcelas();

        // 4. Atualiza o Modelo de Dados
        simulacao.setValorTotalPagar(valorTotalPagar);
        simulacao.setValorParcela(valorParcela);

        // 5. Coordena a Persistência
        this.repository.salvar(simulacao);
        
        return simulacao;
    }
}