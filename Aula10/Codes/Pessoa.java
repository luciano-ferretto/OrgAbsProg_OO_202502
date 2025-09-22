public class Pessoa {
    // Esta variável pertence à classe, não a cada objeto.
    public static int contadorDePessoas = 0;

    public Pessoa() {
        // Incrementa o contador cada vez que um objeto é criado
        contadorDePessoas++;
    }
}

class Main {
    public static void main(String[] args) {
        Pessoa p1 = new Pessoa();
        Pessoa p2 = new Pessoa();
        System.out.println(Pessoa.contadorDePessoas); // Saída: 2

    }
}

