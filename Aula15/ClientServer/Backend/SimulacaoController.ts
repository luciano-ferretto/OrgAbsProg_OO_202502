import { Request, Response } from 'express';
import { SimulacaoService } from './SimulacaoService';

// Interfaces para tipagem da requisição e resposta
interface SimulacaoRequest {
    valorEmprestimo: number;
    numParcelas: number;
}

// Controller: Lida com requisições HTTP e delega a lógica
export class SimulacaoController {

    private service: SimulacaoService;

    // Injeção de Dependência via Constructor
    constructor(service: SimulacaoService) {
        this.service = service;
    }

    // Método que lida com a requisição POST /simular
    // (Simulando o que seria o @PostMapping no Spring)
    public simularEmprestimo = (req: Request, res: Response) => {
        // 1. Recebimento e Validação de Entrada HTTP
        const { valorEmprestimo, numParcelas } = req.body as SimulacaoRequest;

        if (typeof valorEmprestimo !== 'number' || typeof numParcelas !== 'number') {
            // Resposta de erro da Camada de Apresentação
            return res.status(400).json({ error: "Dados inválidos. Esperado valorEmprestimo e numParcelas como números." });
        }

        try {
            // 2. Chamada à Camada de Negócio (Service)
            const resultado = this.service.simularEFinalizar(valorEmprestimo, numParcelas);

            // 3. Resposta HTTP (JSON) - A "View" da API REST
            return res.status(200).json({
                mensagem: "Simulação concluída com sucesso e salva.",
                data: {
                    emprestimo: resultado.getValorEmprestimo(),
                    parcelas: resultado.getNumParcelas(),
                    valorParcela: resultado.getValorParcela(),
                    totalPagar: resultado.getValorTotalPagar(),
                    taxaJuros: resultado.getTaxaJuros() * 100 // em %
                }
            });

        } catch (error: any) {
            // 4. Tratamento de Erro vindo do Service (Camada de Negócio)
            return res.status(400).json({ error: error.message || "Erro desconhecido ao simular." });
        }
    }
}