import java.time.LocalDate;

public class Aplicacao {
    public static void main(String[] args) {
        Integer numInteger = 1001; //Cria um objeto Integer (ex. @11) com o value=1001,
                                    // e a variável recebe essa referência (@11)
                                    // numInteger ==> Imutável -- Objeto não muda --
        
        numInteger = 2222; //Como numInteger é Imutável, 
                            //cria-se um novo Objeto Integer (ex. @22) com o value=2222, 
                            // e a variável recebe essa referência (@22)
                            
                            //O objeto anterior (@11) fica órfão,
                            // e é destruído com o Garbage Collector


        Veiculo focus; //Declara uma variável "focus" do tipo "Veiculo"
        focus = new Veiculo();   //invoca o método construtor "Veiculo()"
                                //atribuo um novo objeto (veículo) para variável "focus"
        
        //focus.marca = "Ford";
        focus.setMarca("Ford");
        //focus.modelo = "Focus";
        focus.setModelo("Focus");
        //focus.placa = "ABC-1234";
        focus.setPlaca("ABC-1234");
        //focus.ano = 2018;
        focus.setAno(2018);

        int tempoUsoFocus = focus.calculaTempoUso();
        System.out.println("Tempo de uso do " + focus.getModelo() + ": " + tempoUsoFocus);


        Veiculo newFocus = focus.cloneMe();
        newFocus.ano = 2024;


        Veiculo corolla = new Veiculo();
        corolla.marca = "Toyota";
        corolla.modelo = "Corolla";
        corolla.placa = "ABC-4321";
        corolla.ano = 2022;

        Veiculo newCorolla = corolla;
        newCorolla.ano = 2025;

        corolla.calculaTempoUso(2030);
        newCorolla.calculaTempoUso(2030);


        Veiculo fusca = new Veiculo("Volkswagem", "Fusca", "DEF-9999", 1995);
        fusca.setMarca("Volks");
        System.out.println(fusca.getMarca());

    }
}
