// A classe Mamifero é uma subclasse abstrata de Animal.
// Como ela não é concreta NÃO é obrigada a fornecer 
//    uma implementação para o método emitirSom().
public abstract class Mamifero extends Animal {
    public Mamifero(String nome) {
        super(nome);
    }
}

