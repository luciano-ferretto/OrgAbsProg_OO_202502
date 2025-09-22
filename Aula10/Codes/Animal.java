// A classe Animal é abstrata e não pode ser instanciada.
// Ela obriga as subclasses a implementarem o método emitirSom().
public abstract class Animal {
    private String nome;
    public Animal(String nome) {
        this.nome = nome;
    }
    public String getNome() {
        return nome;
    }
    // Este é um método abstrato.
    // Ele não tem corpo e força as subclasses a implementá-lo.
    public abstract void emitirSom();
}

