import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class CadastroVeiculos {
    static Scanner scan = new Scanner(System.in);
    static List<String> veiculos = new ArrayList<>();

    public static void main(String[] args) {
        System.out.println("==== Bem vindo ao Controle de Frotas ====");
        String menu = """
                MENU
                Escolha uma das opções abaixo:
                1 - Cadastro de Veículo
                2 - Listar Veículos
                3 - Excluir Veículo
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
                    scan.nextLine(); //Forçar uma parada
                    break;
                case 2:
                    listaVeiculos();
                    System.out.println("Pressione Enter para continuar");
                    scan.nextLine(); //Forçar uma parada
                    break;
                case 3:
                    removeVeiculo();
                    System.out.println("Presione Enter para continuar");
                    scan.nextLine();
                    break;
                case 0:
                    System.out.println("Volte Sempre!!!!");
                    break;
                default:
                    System.out.println("Opção Inválida!!!");
                    break;
            }
        } while (opcao != 0);
    }

    static void cadastraVeiculo(){
        System.out.println("==== Cadastrando novo veículo ====");
        String veiculo = Input.scanString("Digite o nome do veículo: ", scan);
        veiculos.add(veiculo);
    }

    static void listaVeiculos(){
        System.out.println("==== Veículos cadastrados ====");
        int i = 1;
        for (String veiculo : veiculos) {
            System.out.println("Veículo " + i++ + ": " + veiculo);
        }
    }

    static void removeVeiculo(){
        listaVeiculos();
        int i = Input.scanInt("Qual o veículo você quer remover? ", scan);
        veiculos.remove(--i);
        System.out.println("Veículo removido");
    }
}
