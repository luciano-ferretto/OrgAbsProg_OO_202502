public class ExemploFinalMetodo {
    
}

class Veiculo {
    public final void ligar() {
        System.out.println("O veículo ligou.");
    }
}

class Carro extends Veiculo {
     public void ligar() { // Erro de compilação!
         System.out.println("O carro ligou.");
     }
}


