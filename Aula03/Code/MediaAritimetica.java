import java.util.Scanner;

public class MediaAritimetica {
    public static void main(String[] args) {
        Scanner lerTeclado = new Scanner(System.in);

        System.out.print("Digite sua nota G1: ");
        double notaG1 = lerTeclado.nextDouble();
        lerTeclado.nextLine(); //Limpar buffer teclado

        System.out.print("Digite sua nota G2: ");
        double notaG2 = lerTeclado.nextDouble();
        lerTeclado.nextLine(); //Limpar buffer teclado

        System.out.println("Digite seu nome:");
        String nome = lerTeclado.nextLine();
        

        double media = (notaG1 + notaG2) / 2;

        System.out.printf("%s, sua média é: %.2f \n", nome, media);

        if (media >= 7)
            System.out.println("Parabéns! Você está aprovado. :-)");
        else if (media >= 3)
            System.out.println("Você está em recuperação");
        else
            System.out.println("Infelizmente não foi dessa vez. :-(");

    }
}