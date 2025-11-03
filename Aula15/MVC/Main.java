package MVC;
public class Main {
    public static void main(String[] args) {
        
        // 1. Inicializa a Camada de Dados
        SimulacaoRepository repository = new SimulacaoRepository();
        
        // 2. Inicializa a Camada de Negócio, INJETANDO o Repository (Inversão de Controle/DI)
        SimulacaoService service = new SimulacaoService(repository);
        
        // 3. Inicializa a Camada de Apresentação, INJETANDO o Service
        SimulacaoController controller = new SimulacaoController(service);

        // 4. Inicia a Aplicação
        controller.iniciarSimulacao();
    }
}