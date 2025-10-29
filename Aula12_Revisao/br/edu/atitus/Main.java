package br.edu.atitus;
import java.util.ArrayList;
import java.util.List;

import org.apache.commons.lang3.StringUtils;

import br.edu.atitus.interfaces.Corredor;
import br.edu.atitus.interfaces.Nadador;
import br.edu.atitus.interfaces.Voador;

public class Main {
    public static void main(String[] args) {
        
        String hello = "  hello world   ";
        String helloFormated = StringUtils.capitalize(StringUtils.trim(hello));
        System.out.println(helloFormated);


        System.out.println(" ZOO ATITUS");
        System.out.println("Número de animais (INÍCIO): " + Animal.getContador());

        // Lista "Polimórfica"
        List<Animal> zooList = new ArrayList<>();

        zooList.add(new Cachorro("Rex", 5, "Labrador"));
        zooList.add(new Golfinho("FreeWilly", 12));
        zooList.add(new Pato("Donaldo", 42, "Branco"));
        zooList.add(new Pinguim("Feet", 9, "Branco e Preto"));
        zooList.add(new Traira("Nemo", 1));
        zooList.add(new PeixeMorcego("Dory", 2));

        imprimirComportamentos(zooList);

        System.out.println("Número de animais (FINAL): " + Animal.getContador());

    }

    private static void imprimirComportamentos(List<Animal> animais) {
        System.out.println("Comportamentos: ");
        for (Animal animal : animais) {
            animal.emitirSom();
            animal.comer();
            //Verificar se o "animal" é realmente "Voador"
            if (animal instanceof Voador)
                imprimirVoo((Voador) animal);
            if (animal instanceof Nadador)    
                imprimirNado((Nadador) animal);
            if (animal instanceof Corredor)
                imprimirCorrida((Corredor) animal);
        }
    }

    private static void imprimirVoo(Voador animalVoador) {
        animalVoador.voar();
    }
    private static void imprimirNado(Nadador animalNadador) {
        animalNadador.nadar();
    }
    private static void imprimirCorrida(Corredor animalCorredor){
        animalCorredor.correr();
    }
}
