// A classe Cachorro é uma subclasse concreta de Mamifero.
// Ela é obrigada a fornecer uma implementação para o método emitirSom().
public class Cachorro extends Mamifero {
    public Cachorro(String nome) {
        // Chama o construtor da superclasse Animal
        super(nome);
    }
    // Sobrescreve o método abstrato, fornecendo uma implementação.
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " late: Au au!");
    }
}

