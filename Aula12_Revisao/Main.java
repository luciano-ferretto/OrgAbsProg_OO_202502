import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {

        System.out.println("ZOO ATITUS");
        System.out.println("Número de animais (INÍCIO): " + Animal.getContador());

        // Lista "Polimórfica"
        List<Animal> zooList = new ArrayList<>();

        zooList.add(new Cachorro("Rex", 5));
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
            //imprimirVoo(animal);
            //imprimirNado(animal);
            //imprimirCorrida(animal);
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
