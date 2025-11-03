import * as fs from 'fs';
import * as path from 'path';
import { Simulacao } from './Simulacao';

// Repository: Responsável pela Persistência (I/O)
export class SimulacaoRepository {

    private readonly nomeArquivo = path.join(__dirname, 'simulacoes_salvas_node.txt');

    public salvar(simulacao: Simulacao): void {
        const dadosSimulacao = simulacao.toString() + "\n---\n";

        try {
            // Usa fs.appendFileSync para adicionar ao final do arquivo de forma síncrona
            fs.appendFileSync(this.nomeArquivo, dadosSimulacao);
            console.log(`\n[REPOSITÓRIO] SUCESSO: Simulação salva em: ${this.nomeArquivo}`);
        } catch (error) {
            console.error('\n[REPOSITÓRIO] ERRO na camada de DADOS: Falha ao salvar no arquivo.', error);
            // Em uma API real, você lançaria o erro para a camada superior
        }
    }
}