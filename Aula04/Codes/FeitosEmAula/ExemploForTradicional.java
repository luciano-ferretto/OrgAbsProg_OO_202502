package FeitosEmAula;

public class ExemploForTradicional {
    public static void main(String[] args) {
        for (int i = 0; i <= 100; i++){
            double raiz = Math.sqrt(i);
            System.out.println("Raiz de " + i + " é " + raiz);
        }
        int i;
        for (i = 100; i >= 1; i = i -5){
             double raiz = Math.sqrt(i);
            System.out.println("Raiz de " + i + " é " + raiz);
        }
        System.out.println(i);
    }
}
