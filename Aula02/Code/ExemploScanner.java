import java.util.Scanner;

public class ExemploScanner {
    public static void main(String[] args) {
        //Declara uma variável do tipo Scanner com o nome lerTeclado
        // - Atribui-se um novo objeto Scanner com entrada=teclado
        Scanner lerTeclado = new Scanner(System.in);

        System.out.println("Digite seu nome: ");
        String nome = lerTeclado.nextLine();
        System.out.println("Digite sua idade: ");
        int idade = 0;
        try {
            idade = lerTeclado.nextInt();
        } catch (Exception e) {
            System.out.println("Valor Inválido");
        }
        System.out.println(nome + " - " + idade);



    }
}
