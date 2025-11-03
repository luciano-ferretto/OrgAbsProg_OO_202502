import { format } from 'date-fns'; // Biblioteca Node.js para formatação de data

export class Simulacao {
    private readonly dataSimulacao: Date;
    private readonly valorEmprestimo: number;
    private readonly numParcelas: number;
    private readonly taxaJuros: number;
    private valorParcela: number = 0;
    private valorTotalPagar: number = 0;

    constructor(valorEmprestimo: number, numParcelas: number, taxaJuros: number) {
        this.dataSimulacao = new Date();
        this.valorEmprestimo = valorEmprestimo;
        this.numParcelas = numParcelas;
        this.taxaJuros = taxaJuros;
    }

    // Getters
    public getValorEmprestimo(): number { return this.valorEmprestimo; }
    public getNumParcelas(): number { return this.numParcelas; }
    public getTaxaJuros(): number { return this.taxaJuros; }
    public getValorParcela(): number { return this.valorParcela; }
    public getValorTotalPagar(): number { return this.valorTotalPagar; }

    // Setters
    public setValorParcela(valorParcela: number): void { this.valorParcela = valorParcela; }
    public setValorTotalPagar(valorTotalPagar: number): void { this.valorTotalPagar = valorTotalPagar; }

    // Método para representação em String (para salvar no arquivo)
    public toString(): string {
        const dataFormatada = format(this.dataSimulacao, 'dd/MM/yyyy HH:mm:ss');
        return `
            Data: ${dataFormatada}
            Empréstimo: R$ ${this.valorEmprestimo.toFixed(2)}, Parcelas: ${this.numParcelas}, Taxa: ${(this.taxaJuros * 100).toFixed(2)}%
            Valor Parcela: R$ ${this.valorParcela.toFixed(2)}, Total Pago: R$ ${this.valorTotalPagar.toFixed(2)}
        `;
    }
}