package FeitosEmAula;

public class ExemploForEach {
    public static void main(String[] args) {
        double[] numeros = { 3, 4, 52, 56, 33, 22, 565, 33 };
        for (double d : numeros) {
            System.out.println(d);
        }

        for (int i = 0; i < numeros.length; i = i + 2) {
            System.out.println(numeros[i]);
        }

    }
}
