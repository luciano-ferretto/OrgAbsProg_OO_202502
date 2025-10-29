package br.edu.atitus;
public class PeixeMorcego extends Peixe {

    public PeixeMorcego(String nome, int idade) {
        super(nome, idade, "Salgada");
    }

    @Override
    public void emitirSom() {
        System.out.println(getNome() + " está borbulhando");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " está comendo pesquenas algas");
    }
    
    
}
