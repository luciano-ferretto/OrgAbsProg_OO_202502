package br.edu.atitus;

import br.edu.atitus.interfaces.Corredor;
import br.edu.atitus.interfaces.Nadador;

public class Cachorro extends Mamifero implements Nadador,Corredor{

    private String raca;

    public Cachorro(String nome, int idade, String raca) {
        super(nome, idade, true);
        this.raca = raca;
    }

    
    @Override
    public void emitirSom() {
        System.out.println(getNome() + " está latindo");
    }

    @Override
    public void comer() {
        System.out.println(getNome() + " está comendo sua ração");
    }

    @Override
    public void correr() {
        System.out.println(getNome() + " está correndo atrás da bolinha");
    }

    @Override
    public void nadar() {
        System.out.println(getNome() + " está nadando estilo cachorrinho");
    }


    public String getRaca() {
        return raca;
    }
    
}
