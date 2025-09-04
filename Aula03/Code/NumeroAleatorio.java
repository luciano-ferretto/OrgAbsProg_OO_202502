import java.util.Random;

public class NumeroAleatorio {
    public static void main(String[] args) {
        Random gerador = new Random();
        int numeroGerado = gerador.nextInt(10);
        numeroGerado = 2;
        switch (numeroGerado) {
            case 1:
                System.out.println("Um");
                break;
            case 2:
                System.out.println("Dois");
                break;
            case 3:
                System.out.println("Três");
                break;
            default:
                System.out.println("Maior que três");
                break;
        }
    }
}
