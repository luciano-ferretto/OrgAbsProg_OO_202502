public class ValidaPar {
    public static void main(String[] args) {
        int numero = 5;
        String resultado = (numero % 2 == 0) ? "Par" : "Ímpar";
        System.out.println("O número é " + resultado);

        System.out.println("O número é " + 
                ((numero % 2 == 0) ? "Par" : "Ímpar"));
    }
}
