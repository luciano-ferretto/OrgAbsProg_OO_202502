import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroVeiculos {
    static Scanner scan = new Scanner(System.in);
    static List<Veiculo> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("==== Bem vindo ao Controle de Frotas ====");
        String menu = """
                MENU
                Escolha uma das opções abaixo:
                1 - Cadastro de Veículo
                2 - Listar Veículos
                3 - Excluir Veículo
                4 - Pesquisar Veículos
                0 - Sair
                """;
        int opcao;
        do {
            System.out.println(menu);
            opcao = Input.scanInt("Escolha uma opção: ", scan);
            switch (opcao) {
                case 1:
                    cadastraVeiculo();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine(); // Forçar uma parada
                    break;
                case 2:
                    listaVeiculos();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine(); // Forçar uma parada
                    break;
                case 3:
                    removeVeiculo();
                    System.out.println("Presione Enter para continuar");
                    scan.nextLine();
                    break;
                case 4:
                    pesquisaVeiculo();
                    System.out.println("Presione Enter para continuar");
                    scan.nextLine();
                case 0:
                    System.out.println("Volte Sempre!!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    System.out.println("Presione Enter para continuar");
                    scan.nextLine();
                    break;
            }
        } while (opcao != 0);
    }

    private static void cadastraVeiculo() {
        System.out.println("==== Cadastrando novo veículo ====");
        String marca = Input.scanString("Digite a marca do veículo: ", scan);
        String modelo = Input.scanString("Digite o modelo do veículo: ", scan);
        String placa = Input.scanString("Digite a placa do veículo: ", scan);
        int ano = Input.scanInt("Digite o ano do veículo: ", scan);
        if (pesquisaVeiculoPlaca(placa) != null)
            System.out.println("Processo não permitido. Já existe veículo cadastrado com essa placa.");
        else {
            Veiculo veiculo = new Veiculo(marca, modelo, placa, ano);
            veiculos.add(veiculo);
            System.out.println("Veículo cadastrado com sucesso!");
        }
    }

    private static void listaVeiculos() {
        System.out.println("==== Veículos cadastrados ====");
        int i = 1;
        for (Veiculo veiculo : veiculos) {
            System.out.println(i++ + " - " + veiculo.toString());
        }
    }

    private static void removeVeiculo() {
        listaVeiculos();
        String placa = Input.scanString("Informe a placa do veículo que deve ser removido? ", scan);
        Veiculo veiculo = pesquisaVeiculoPlaca(placa);
        if (veiculo != null) {
            veiculos.remove(veiculo);
            System.out.println("Veículo removido");
        } else
            System.out.println("Veículo não encontrado com a placa informada");
    }

    private static void pesquisaVeiculo() {
        System.out.println("""
                Como você deseja pesquisar o veículo:
                1 - Por placa
                2 - Por modelo
                """);
        int tipoPesquisa = Input.scanInt("Informe sua opção: ", scan);
        switch (tipoPesquisa) {
            case 1:
                Veiculo veiculo = pesquisaVeiculoPlaca(Input.scanString("Informa a placa a ser pesquisada: ", scan));
                if (veiculo != null) {
                    System.out.println("Veículo encontrado: ");
                    System.out.println(veiculo);
                } else {
                    System.out.println("Veículo não encontrado com a placa informada.");
                }
                break;
            case 2:
                String modelo = Input.scanString("Informe o modelo a ser procurado: ", scan);
                List<Veiculo> veiculosEncontrados = pesquisaVeiculoModelo(modelo);
                if (veiculosEncontrados.isEmpty()) {
                    System.out.println("Não foi encontrado nenhum veículo com este modelo");
                } else {
                    System.out.println("Veículos encontrados: ");
                    for (Veiculo veiculo2 : veiculosEncontrados) {
                        System.out.println(veiculo2);
                    }
                }
                break;
            default:
                System.out.println("Opção inválida");
                break;
        }
    }

    private static Veiculo pesquisaVeiculoPlaca(String placa) {
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getPlaca().equalsIgnoreCase(placa))
                return veiculo;
        }
        return null;
    }

    private static List<Veiculo> pesquisaVeiculoModelo(String modelo) {
        List<Veiculo> veiculosEncontrados = new ArrayList<>();
        for (Veiculo veiculo : veiculos) {
            if (veiculo.getModelo().toLowerCase().contains(modelo.toLowerCase()))
                veiculosEncontrados.add(veiculo);
        }
        return veiculosEncontrados;
    }
}
