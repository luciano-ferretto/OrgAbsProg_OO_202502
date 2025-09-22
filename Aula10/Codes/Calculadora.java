public class Calculadora {
    // Um método static não precisa de um objeto para ser chamado
    public static int somar(int a, int b) {
        return a + b;
    }
}

class Main {
    public static void main(String[] args) {
        int resultado = Calculadora.somar(5, 3); // Chamado diretamente pela classe
        System.out.println(resultado); // Saída: 8
    }
}

