package MVC;

import java.io.FileWriter;
import java.io.IOException;

// Repository/DAO: Responsável pela Persistência
public class SimulacaoRepository {

    private final String nomeArquivo = "simulacoes_salvas.txt";

    public void salvar(Simulacao simulacao) {
        // Lógica de Persistência (Poderia ser um DB, mas aqui é um arquivo)
        try (FileWriter fileWriter = new FileWriter(nomeArquivo, true)) {
            fileWriter.write(simulacao.toString() + "\n---\n");
            System.out.println("SUCESSO: Simulação salva no arquivo.");
        } catch (IOException e) {
            // Tratamento de Erro de Dados
            System.err.println("ERRO na camada de DADOS: Falha ao salvar no arquivo.");
            e.printStackTrace();
        }
    }
}