import express, { Application, json } from 'express';
import cors from 'cors';
import { SimulacaoRepository } from './SimulacaoRepository';
import { SimulacaoService } from './SimulacaoService'; // Renomeado
import { SimulacaoController } from './SimulacaoController'; // Renomeado

const app: Application = express();
const port = 3000;

// Configuração do CORS: Permite requisições de qualquer origem (necessário para o index.html)
app.use(cors()); 

// Middleware para que o Express entenda JSON no corpo da requisição
app.use(json()); 

// --- Configuração das Camadas (Injeção de Dependência Manual) ---

// 1. Data/Repository
const repository = new SimulacaoRepository();

// 2. Business/Service: Recebe o Repository
const service = new SimulacaoService(repository); // Usando o novo nome

// 3. Presentation/Controller: Recebe o Service
const controller = new SimulacaoController(service); // Usando o novo nome

// --- Definição das Rotas da API REST ---

// Rota POST para simulação
app.post('/simular', controller.simularEmprestimo);

// --- Inicialização do Servidor ---

app.listen(port, () => {
    console.log(`\n=================================================`);
    console.log(`  APISample (Simulador) rodando em http://localhost:${port}`);
    console.log(`  CONTROLLER: SimulacaoController.ts`);
    console.log(`  SERVICE: SimulacaoService.ts`);
    console.log(`=================================================`);
});