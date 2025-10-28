public class Golfinho extends Mamifero implements Nadador{

    public Golfinho(String nome, int idade) {
        super(nome, idade, false);
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() +  " está assoviando");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " está comendo peixinhos");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " está nadando em mar aberto");
    }

    
    
    
}
